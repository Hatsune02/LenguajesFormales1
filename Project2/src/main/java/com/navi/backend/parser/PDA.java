package com.navi.backend.parser;

import com.navi.backend.tokens.*;
import java.util.*;

public class PDA {
    private static PDA automaton;
    private String error;
    ArrayList<Token> tokens;
    private PDAState q0;
    private PDA(){
        error = "";
        q0 = new PDAState();
        PDAState q1 = new PDAState();
        PDAState q2 = new PDAState();
        PDAState q3 = new PDAState();
        q3.setEnd();
        q0.addTransition(TokenType.EPSILON.toString(), TokenType.EPSILON.toString(), TokenType.$.toString(), q1);

        q1.addTransition(TokenType.EPSILON.toString(), TokenType.EPSILON.toString(), "S", q2);

        for(TokenType tk: TokenType.values()){
            if(!tk.equals(TokenType.$) && !tk.equals(TokenType.EPSILON)
                    && !tk.equals(TokenType.COMMENT) && !tk.equals(TokenType.ERROR)){
                q2.addTransition(tk.toString(), tk.toString(), q2, true);
            }
        }

        q2.addTransition(TokenType.$.toString(), TokenType.$.toString(), q3, true);

        // FILA INSTRUCTION <I>
        q2.addTransition(TokenType.$.toString(),"I", q2);
        String auxPush = TokenType.IDENTIFIER + ";A;" + TokenType.LINEBREAK + ";I";
        q2.addTransition(TokenType.IDENTIFIER.toString(),"I",auxPush, q2);
        q2.addTransition("if","I","Con;I", q2);
        q2.addTransition("for","I","For;I", q2);
        q2.addTransition("while","I","While;I", q2);
        q2.addTransition("def","I","Fun;I", q2);
        q2.addTransition(TokenType.DEDENT.toString(),"I", q2);
        q2.addTransition("return","I", q2);
        q2.addTransition("break","I", q2);

        // FILA AUX <A>
        q2.addTransition("(","A","(;Es;)", q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"A","Assign", q2);
        q2.addTransition(",","A","Assign", q2);

        // FILA ASSIGN <Assign>
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"Assign","AssignP;E;Assigns;OT", q2);
        q2.addTransition(",","Assign","AssignP;E;Assigns;OT", q2);

        //FILA ASSIGNS <Assigns>
        q2.addTransition(TokenType.LINEBREAK.toString(),"Assigns", q2);
        auxPush = TokenType.ASSIGNMENT + ";E;Assigns";
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"Assigns",auxPush, q2);
        q2.addTransition("if","Assign", q2);

        //FILA ASSIGN PRIMA <AssignP>
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"AssignP",TokenType.ASSIGNMENT.toString(), q2);
        auxPush = ",;"+TokenType.IDENTIFIER+";AssignP;E";
        q2.addTransition(",","AssignP",auxPush, q2);

        //FILA TERNARY OPERATOR <OT>
        q2.addTransition(TokenType.LINEBREAK.toString(),"OT",q2);
        q2.addTransition("if","OT","if;Comp;else;E", q2);

        //FILA CONDITIONAL <Con>
        auxPush = "if;Comp;:;" + TokenType.LINEBREAK + ";B;Elif;Else";
        q2.addTransition("if","Con",auxPush, q2);

        //FILA ELSE IF <Elif>
        q2.addTransition(TokenType.$.toString(),"Elif", q2);
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Elif", q2);
        q2.addTransition("if","Elif", q2);
        q2.addTransition("else","Elif", q2);
        auxPush = "elif;Comp;:;"+TokenType.LINEBREAK+";B";
        q2.addTransition("elif","Elif",auxPush, q2);
        q2.addTransition("for","Elif", q2);
        q2.addTransition("while","Elif", q2);
        q2.addTransition("def","Elif", q2);
        q2.addTransition(TokenType.DEDENT.toString(),"Elif", q2);
        q2.addTransition("return","Elif", q2);
        q2.addTransition("break","Elif", q2);

        //FILA ELSE <Else>
        q2.addTransition(TokenType.$.toString(),"Else", q2);
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Else", q2);
        q2.addTransition("if","Else", q2);
        auxPush = "else;:;"+TokenType.LINEBREAK+";B";
        q2.addTransition("else","Else",auxPush, q2);
        q2.addTransition("for","Else", q2);
        q2.addTransition("while","Else", q2);
        q2.addTransition("def","Else", q2);
        q2.addTransition(TokenType.DEDENT.toString(),"Else", q2);
        q2.addTransition("return","Else", q2);
        q2.addTransition("break","Else", q2);

        //FILA COMPARISON <Comp>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Comp","Ep;CompP", q2);
        q2.addTransition("(","Comp","Ep;CompP", q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"Comp","Ep;CompP", q2);
        q2.addTransition("-","Comp","Ep;CompP", q2);
        q2.addTransition(TokenType.STRING.toString(),"Comp","Ep;CompP", q2);
        q2.addTransition(TokenType.INT.toString(),"Comp","Ep;CompP", q2);
        q2.addTransition(TokenType.DECIMAL.toString(),"Comp","Ep;CompP", q2);

        //FILA COMPARISON PRIMA <CompP>
        q2.addTransition("else","CompP", q2);
        q2.addTransition(":","CompP", q2);
        auxPush = TokenType.COMPARASION + "Ep;CompP";
        q2.addTransition(TokenType.COMPARASION.toString(),"CompP",auxPush, q2);

        //FILA FOR <For>
        auxPush = "for;"+TokenType.IDENTIFIER + ";in;[;Es;];:;"+TokenType.LINEBREAK+";B;Else";
        q2.addTransition("for","For",auxPush, q2);

        //FILA WHILE <While>
        auxPush = "while;Comp;:;"+TokenType.LINEBREAK+";B";
        q2.addTransition("while","While",auxPush, q2);

        //FILA FUNCTION <Fun>
        auxPush = "def;"+TokenType.IDENTIFIER + ";(;Ps;);:;"+TokenType.LINEBREAK+";B";
        q2.addTransition("def","Fun",auxPush, q2);

        //FILA PARAMETERS <Ps>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Ps","P", q2);
        q2.addTransition(")","Ps","P", q2);
        q2.addTransition("*","Ps","*;args", q2);

        //FILA PARAMETER <P>
        auxPush = TokenType.IDENTIFIER+";PP";
        q2.addTransition(TokenType.IDENTIFIER.toString(),"P",auxPush, q2);

        //FILA PARAMETER PRIMA <PP>
        q2.addTransition(")","PP", q2);
        auxPush = ",;"+TokenType.IDENTIFIER+";PP";
        q2.addTransition(",","PP",auxPush, q2);

        //FILA CODE BLOCK <B>
        auxPush = TokenType.INDENT+";C;"+TokenType.DEDENT;
        q2.addTransition(TokenType.INDENT.toString(),"B",auxPush, q2);

        //FILA BODY BLOCK <C>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"C","I;CP", q2);
        q2.addTransition("if","C","I;CP", q2);
        q2.addTransition("for","C","I;CP", q2);
        q2.addTransition("while","C","I;CP", q2);
        q2.addTransition("def","C","I;CP", q2);
        q2.addTransition(TokenType.DEDENT.toString(),"C","I;CP", q2);
        q2.addTransition("return","C","I;CP", q2);
        q2.addTransition("break","C","I;CP", q2);

        //FILA BODY BLOCK PRIMA <CP>
        q2.addTransition(TokenType.DEDENT.toString(),"CP", q2);
        auxPush = "return;E;"+TokenType.LINEBREAK;
        q2.addTransition("return","CP",auxPush, q2);
        auxPush = "break;"+TokenType.LINEBREAK;
        q2.addTransition("break","CP",auxPush, q2);

        //FILA EXPRESSIONS <Es>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Es","E;EsP", q2);
        q2.addTransition("(","Es","E;EsP", q2);
        q2.addTransition(")","Es", q2);
        q2.addTransition("[","Es","E;EsP", q2);
        q2.addTransition("]","Es", q2);
        q2.addTransition("not","Es","E;EsP", q2);
        q2.addTransition("{","Es","E;EsP", q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"Es","E;EsP", q2);
        q2.addTransition("-","Es","E;EsP", q2);
        q2.addTransition(TokenType.STRING.toString(),"Es","E;EsP", q2);
        q2.addTransition(TokenType.INT.toString(),"Es","E;EsP", q2);
        q2.addTransition(TokenType.DECIMAL.toString(),"Es","E;EsP", q2);

        //FILA EXPRESSIONS PRIMA <EsP>
        q2.addTransition(")","EsP", q2);
        q2.addTransition(",","EsP",",;E;EsP", q2);
        q2.addTransition("]","EsP", q2);

        //FILA BODY DICTIONARY <CD>
        auxPush = TokenType.IDENTIFIER+";:;E;CDP";
        q2.addTransition(TokenType.IDENTIFIER.toString(),"CD",auxPush, q2);
        q2.addTransition("}","CD", q2);

        //FILA BODY DICTIONARY PRIMA <CDP>
        auxPush = ",;"+TokenType.IDENTIFIER+";:;E;CDP";
        q2.addTransition(TokenType.IDENTIFIER.toString(),"CDP",auxPush, q2);
        q2.addTransition("}","CDP", q2);

        //FILA EXPRESSION <E>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"E","EP", q2);
        q2.addTransition("(","E","EP", q2);
        q2.addTransition("[","E","EP", q2);
        q2.addTransition("not","E","not;EP", q2);
        q2.addTransition("{","E","EP", q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"E","EP", q2);
        q2.addTransition("-","E","EP", q2);
        q2.addTransition(TokenType.STRING.toString(),"E","EP", q2);
        q2.addTransition(TokenType.INT.toString(),"E","EP", q2);
        q2.addTransition(TokenType.DECIMAL.toString(),"E","EP", q2);

        //FILA EXPRESSION PRIMA <EP>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"EP","Ep", q2);
        q2.addTransition("(","EP","Ep", q2);
        q2.addTransition("[","EP","[;Es;]", q2);
        q2.addTransition("{","EP","{;CD;}", q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"EP","Ep", q2);
        q2.addTransition("-","EP","Ep", q2);
        q2.addTransition(TokenType.STRING.toString(),"EP","Ep", q2);
        q2.addTransition(TokenType.INT.toString(),"EP","Ep", q2);
        q2.addTransition(TokenType.DECIMAL.toString(),"EP","Ep", q2);

        //FILA CALL FUNCTION <L>
        q2.addTransition(TokenType.LINEBREAK.toString(),"L",q2);
        q2.addTransition("(","L","(;Es;)",q2);
        q2.addTransition(")","L",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"L",q2);
        q2.addTransition(",","L",q2);
        q2.addTransition("if","L",q2);
        q2.addTransition("else","L",q2);
        q2.addTransition(":","L",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"L",q2);
        q2.addTransition("]","L",q2);
        q2.addTransition("}","L",q2);

        //FILA PRIMARY EXPRESSION <Ep>
        auxPush = TokenType.IDENTIFIER + ";L";
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Ep",auxPush, q2);
        q2.addTransition("(","Ep","O",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"Ep",TokenType.BOOLEAN.toString(),q2);
        q2.addTransition("-","Ep","O",q2);
        q2.addTransition(TokenType.STRING.toString(), "Ep","O",q2);
        q2.addTransition(TokenType.INT.toString(), "Ep","O",q2);
        q2.addTransition(TokenType.DECIMAL.toString(), "Ep","O",q2);

        //FILA OPERATION <O>
        q2.addTransition("(", "O","MD;OP",q2);
        q2.addTransition("-", "O","MD;OP",q2);
        q2.addTransition(TokenType.STRING.toString(), "O","MD;OP",q2);
        q2.addTransition(TokenType.INT.toString(), "O","MD;OP",q2);
        q2.addTransition(TokenType.DECIMAL.toString(), "O","MD;OP",q2);

        //FILA OPERATION PRIMA <OP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"OP",q2);
        q2.addTransition(")","OP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"OP",q2);
        q2.addTransition(",","OP",q2);
        q2.addTransition("if","OP",q2);
        q2.addTransition("else","OP",q2);
        q2.addTransition(":","OP",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"OP",q2);
        q2.addTransition("]","OP",q2);
        q2.addTransition("}","OP",q2);
        q2.addTransition("+","OP","+;MD;OP", q2);
        q2.addTransition("-","OP","-;MD;OP", q2);

        //FILA MULTIPLICATION DIVISION <MD>
        q2.addTransition("(", "MD","Exp;MDP",q2);
        q2.addTransition("-", "MD","Exp;MDP",q2);
        q2.addTransition(TokenType.STRING.toString(), "MD","Exp;MDP",q2);
        q2.addTransition(TokenType.INT.toString(), "MD","Exp;MDP",q2);
        q2.addTransition(TokenType.DECIMAL.toString(), "MD","Exp;MDP",q2);

        //FILA MULTIPLICATION DIVISION PRIMA <MDP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"MDP",q2);
        q2.addTransition(")","MDP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"MDP",q2);
        q2.addTransition(",","MDP",q2);
        q2.addTransition("if","MDP",q2);
        q2.addTransition("else","MDP",q2);
        q2.addTransition(":","MDP",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"MDP",q2);
        q2.addTransition("*","MDP","*;Exp;MDP", q2);
        q2.addTransition("]","MDP",q2);
        q2.addTransition("}","MDP",q2);
        q2.addTransition("+","MDP", q2);
        q2.addTransition("-","MDP", q2);
        q2.addTransition("/","MDP","/;Exp;MDP", q2);
        q2.addTransition("//","MDP","//;Exp;MDP", q2);
        q2.addTransition("%","MDP","%;Exp;MDP", q2);

        //FILA EXPONENT <Exp>
        q2.addTransition("(", "Exp","First;ExpP",q2);
        q2.addTransition("-", "Exp","First;ExpP",q2);
        q2.addTransition(TokenType.STRING.toString(), "Exp","First;ExpP",q2);
        q2.addTransition(TokenType.INT.toString(), "Exp","First;ExpP",q2);
        q2.addTransition(TokenType.DECIMAL.toString(), "Exp","First;ExpP",q2);

        //FILA EXPONENT PRIMA <ExpP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"ExpP",q2);
        q2.addTransition(")","ExpP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"ExpP",q2);
        q2.addTransition(",","ExpP",q2);
        q2.addTransition("if","ExpP",q2);
        q2.addTransition("else","ExpP",q2);
        q2.addTransition(":","ExpP",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"ExpP",q2);
        q2.addTransition("*","ExpP", q2);
        q2.addTransition("]","ExpP",q2);
        q2.addTransition("}","ExpP",q2);
        q2.addTransition("+","ExpP", q2);
        q2.addTransition("-","ExpP", q2);
        q2.addTransition("/","ExpP", q2);
        q2.addTransition("//","ExpP", q2);
        q2.addTransition("%","ExpP", q2);
        q2.addTransition("**","ExpP","**;First;ExpP", q2);

        //FILA FIRST <First>
        q2.addTransition("(", "First","(;O;)",q2);
        q2.addTransition("-", "First","-;Num",q2);
        q2.addTransition(TokenType.STRING.toString(), "First",TokenType.STRING.toString(),q2);
        q2.addTransition(TokenType.INT.toString(), "First","Num",q2);
        q2.addTransition(TokenType.DECIMAL.toString(), "First","Num",q2);

        //FILA NUMBER <Num>
        q2.addTransition(TokenType.INT.toString(), "Num",TokenType.INT.toString(),q2);
        q2.addTransition(TokenType.DECIMAL.toString(), "Num",TokenType.DECIMAL.toString(),q2);

    }

    public static PDA getAutomaton(ArrayList<Token> tokens){
        if(automaton == null){
            automaton = new PDA();
        }
        automaton.setTokens(tokens);
        return automaton;
    }

    private void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.tokens.add(new Token(TokenType.$, "$", 0,0,0));
    }

    public String getError() {
        return error;
    }

    public void analyze(){
        Stack<String> stack = new Stack<String>();
        error = "";
        int index = 0;
        PDAState aux, aux1;
        aux = q0;
        while(index < tokens.size()){
            aux1 = aux.getState(TokenType.EPSILON.toString(), stack);
            if(aux1 == null){
                Token tk = tokens.get(index);
                aux1 = aux.getState(tk.getType().toString(), stack);
                if(aux1 == null){
                    //String valid = aux.getValidInputs();
                    tk = tokens.get(index - 1);
                    error = "Error ln:"  + tk.getRow() + " col:"+tk.getColumn()+" "+tk.getLexeme(); //+"\nSe esperaba " + valid;
                    break;
                }
                else if(aux1.move()){
                    index++;

                }

            }
            if(stack.empty()){
                break;
            }else{
                //System.out.println(stack);
            }


            /*
            if(index == tokens.size()){
                if(!aux1.isEndState()){
                    Token tk = tokens.get(index - 2);
                    //String valid = aux.getValidInputs();
                    error = "Error ln:"  + tk.getRow() + " col:"+tk.getColumn() + " "+ tk.getLexeme();//+"\nSe esperaba " + valid;
                    break;
                }
            }
            */
            aux = aux1;
        }
    }
}
