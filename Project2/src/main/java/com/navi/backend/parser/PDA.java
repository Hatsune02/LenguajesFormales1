package com.navi.backend.parser;

import com.navi.backend.reports.Block;
import com.navi.backend.tokens.*;
import com.navi.backend.utils.LexerMethods;
import com.navi.backend.utils.ParserMethods;

import java.util.*;

public class PDA {
    private static PDA automaton;
    private StringBuilder error;
    ArrayList<Token> tokens;
    private PDAState q0;
    private PDA(ArrayList<Token> tokens){
        setTokens(tokens);
        error = new StringBuilder();
        q0 = new PDAState();
        PDAState q1 = new PDAState();
        PDAState q2 = new PDAState();
        PDAState q3 = new PDAState();
        q3.setEnd();
        q0.addTransition(TokenType.EPSILON.toString(), TokenType.EPSILON.toString(), TokenType.$.toString(), q1);

        q1.addTransition(TokenType.EPSILON.toString(), TokenType.EPSILON.toString(), "S", q2);

        for(TokenType tk: TokenType.values()){
            if(!tk.equals(TokenType.$) && !tk.equals(TokenType.EPSILON)
                    && !tk.equals(TokenType.COMMENT) && !tk.equals(TokenType.ERROR)
                    && !tk.equals(TokenType.KEYWORD) && !tk.equals(TokenType.OTHERS)
                    && !tk.equals(TokenType.ARITHMETIC)){
                q2.addTransition(tk.toString(), tk.toString(), q2, true);
            }
        }
        for(Token token:tokens){
            if(token.getType()==TokenType.KEYWORD || token.getType()== TokenType.OTHERS || token.getType()==TokenType.ARITHMETIC){
                q2.addTransition(token.getLexeme(),token.getLexeme(),q2,true);
            }
        }

        q2.addTransition(TokenType.$.toString(), TokenType.$.toString(), q3, true);

        addTransitions(q2);
    }

    public static PDA getAutomaton(ArrayList<Token> tokens){
        /*if(automaton == null){
            automaton = new PDA(tokens);
        }*/
        automaton = new PDA(tokens);
        //automaton.setTokens(tokens);
        return automaton;
    }

    private void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.tokens.add(new Token(TokenType.$, "$", 0,0,0));
    }

    public String getError() {
        return error.toString();
    }

    public void analyze(int start){
        Stack<String> stack = new Stack<String>();
        int index = start;
        PDAState aux, aux1;
        aux = q0;
        while(index < tokens.size()){
            if(aux==null){
                break;
            }
            aux1 = aux.getState(TokenType.EPSILON.toString(), stack);
            if(aux1 == null){
                Token token = tokens.get(index);
                if(token.getType()==TokenType.KEYWORD || token.getType()== TokenType.OTHERS || token.getType()==TokenType.ARITHMETIC){
                    aux1 = aux.getState(token.getLexeme(), stack);
                }
                else aux1 = aux.getState(token.getType().toString(), stack);
                System.out.println(token.getType().toString() + " " + token.getLexeme() + " linea " + (token.getRow()+1));
                System.out.println(stack);

                if(aux1 == null){
                    error.append("Error linea: ").append(token.getRow()+1).append(" columna: ").append(token.getColumn()+1).append(" ").append(token.getLexeme()).append("\n");
                    stack = resetStack();
                    index = errorControl(index);
                    token = tokens.get(index);
                    if(token.getType()==TokenType.KEYWORD || token.getType()== TokenType.OTHERS || token.getType()==TokenType.ARITHMETIC){
                        aux1 = aux.getState(token.getLexeme(), stack);
                    }
                    else aux1 = aux.getState(token.getType().toString(), stack);

                }
                else if(aux1.move()){
                    if(index+1< tokens.size() && index-1 > 0){
                        Token tokenA = tokens.get(index+1);
                        Token tokenB = tokens.get(index-1);
                        if(token.getType()==TokenType.STRING){
                            if(tokenB.getLexeme().equals("-")){
                                error.append("Error linea: ").append(tokenB.getRow()+1).append(" columna: ").append(tokenB.getColumn()+1).append(" ").append(tokenB.getLexeme()).append("\n");
                                stack = resetStack();
                                index = errorControl(index);
                                token = tokens.get(index);
                                if(token.getType()==TokenType.KEYWORD || token.getType()== TokenType.OTHERS || token.getType()==TokenType.ARITHMETIC){
                                    aux1 = aux.getState(token.getLexeme(), stack);
                                }
                                else aux1 = aux.getState(token.getType().toString(), stack);
                                index--;
                            }
                            else if(tokenA.getLexeme().equals("-")){
                                error.append("Error linea: ").append(tokenA.getRow()+1).append(" columna: ").append(tokenA.getColumn()+1).append(" ").append(tokenA.getLexeme()).append("\n");
                                stack = resetStack();
                                index = errorControl(index);
                                token = tokens.get(index);
                                if(token.getType()==TokenType.KEYWORD || token.getType()== TokenType.OTHERS || token.getType()==TokenType.ARITHMETIC){
                                    aux1 = aux.getState(token.getLexeme(), stack);
                                }
                                else aux1 = aux.getState(token.getType().toString(), stack);
                                index--;
                            }


                        }
                    }
                    index++;
                }

            }
            if(stack.empty()){
                break;
            }
            aux = aux1;
        }
    }

    private int errorControl(int index){
        Token token;
        for (int i = index; i < tokens.size(); i++) {
            token = tokens.get(i);
            if(token.getType() == TokenType.LINEBREAK || token.getType() == TokenType.DEDENT){
                if(i+1 < tokens.size()) return i+1;
                else return i;
            }
        }
        return index;
    }

    private Stack<String> resetStack(){
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push("I");
        return stack;
    }

    private void addTransitions(PDAState q2){
        //FILA S
        q2.addTransition(TokenType.$.toString(),"S", "I", q2);
        q2.addTransition(TokenType.IDENTIFIER.toString(),"S","I", q2);
        q2.addTransition("if","S","I", q2);
        q2.addTransition("for","S","I", q2);
        q2.addTransition("while","S","I", q2);
        q2.addTransition("def","S","I", q2);

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
        q2.addTransition("if","Assigns", q2);

        //FILA ASSIGN PRIMA <AssignP>
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"AssignP",TokenType.ASSIGNMENT.toString(), q2);
        auxPush = ",;"+TokenType.IDENTIFIER+";AssignP;E;,";
        q2.addTransition(",","AssignP",auxPush, q2);

        //FILA TERNARY OPERATOR <OT>
        q2.addTransition(TokenType.LINEBREAK.toString(),"OT",q2);
        q2.addTransition("if","OT","if;O;else;E", q2);

        //FILA CONDITIONAL <Con>
        auxPush = "if;O;:;" + TokenType.LINEBREAK + ";B;Elif;Else";
        q2.addTransition("if","Con",auxPush, q2);

        //FILA ELSE IF <Elif>
        q2.addTransition(TokenType.$.toString(),"Elif", q2);
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Elif", q2);
        q2.addTransition("if","Elif", q2);
        q2.addTransition("else","Elif", q2);
        auxPush = "elif;O;:;"+TokenType.LINEBREAK+";B";
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

        //FILA FOR <For>
        q2.addTransition("for","For","for;O;ForP", q2);

        //FILA FOR PRIMA <ForP>
        auxPush = "in;Arr;:;"+TokenType.LINEBREAK+";B;Else";
        q2.addTransition("not","ForP","not;"+auxPush, q2);
        q2.addTransition("in","ForP",auxPush, q2);

        //FILA WHILE <While>
        auxPush = "while;O;:;"+TokenType.LINEBREAK+";B";
        q2.addTransition("while","While",auxPush, q2);

        //FILA FUNCTION <Fun>
        auxPush = "def;"+TokenType.IDENTIFIER + ";(;Ps;);:;"+TokenType.LINEBREAK+";B";
        q2.addTransition("def","Fun",auxPush, q2);

        //FILA PARAMETERS <Ps>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Ps","P", q2);
        q2.addTransition(")","Ps", q2);
        q2.addTransition("*","Ps","*;"+TokenType.IDENTIFIER, q2);

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
        q2.addTransition("not","Es","E;EsP", q2);
        q2.addTransition("[","Es","E;EsP", q2);
        q2.addTransition("]","Es", q2);
        q2.addTransition("{","Es","E;EsP", q2);
        q2.addTransition("-","Es","E;EsP", q2);
        q2.addTransition(TokenType.INT.toString(),"Es","E;EsP", q2);
        q2.addTransition(TokenType.STRING.toString(),"Es","E;EsP", q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"Es","E;EsP", q2);

        //FILA EXPRESSIONS PRIMA <EsP>
        q2.addTransition(")","EsP", q2);
        q2.addTransition(",","EsP",",;E;EsP", q2);
        q2.addTransition("]","EsP", q2);

        //FILA BODY DICTIONARY <CD>
        auxPush = TokenType.STRING+";:;E;CDP";
        q2.addTransition(TokenType.STRING.toString(),"CD",auxPush, q2);
        q2.addTransition("}","CD", q2);

        //FILA BODY DICTIONARY PRIMA <CDP>
        auxPush = ",;"+TokenType.STRING+";:;E;CDP";
        q2.addTransition(",","CDP",auxPush, q2);
        q2.addTransition("}","CDP", q2);

        //FILA EXPRESSION <E>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"E","O;Ef", q2);
        q2.addTransition("(","E","O;Ef", q2);
        q2.addTransition("not","E","O;Ef", q2);
        q2.addTransition("[","E","[;Es;]", q2);
        q2.addTransition("{","E","{;CD;}", q2);
        q2.addTransition("-","E","O;Ef", q2);
        q2.addTransition(TokenType.INT.toString(),"E","O;Ef", q2);
        q2.addTransition(TokenType.STRING.toString(),"E","O;Ef", q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"E","O;Ef", q2);

        //FILA EXPRESSION FOR <Ef>
        q2.addTransition(TokenType.LINEBREAK.toString(),"Ef", q2);
        q2.addTransition(")","Ef", q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"Ef", q2);
        q2.addTransition(",","Ef", q2);
        q2.addTransition("if","Ef", q2);
        q2.addTransition("not","Ef","not;in;Arr", q2);
        q2.addTransition("in","Ef","in;Arr", q2);
        q2.addTransition("]","Ef", q2);
        q2.addTransition("}","Ef", q2);

        //FILA ARRAYS <Arr>
        auxPush = TokenType.IDENTIFIER + ";L";
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Arr",auxPush, q2);
        q2.addTransition("[","Arr","[;Es;]", q2);

        //FILA OPERATION <O>
        q2.addTransition(TokenType.IDENTIFIER.toString(), "O","Oc;OP",q2);
        q2.addTransition("(", "O","Oc;OP",q2);
        q2.addTransition("not", "O","Oc;OP",q2);
        q2.addTransition("-", "O","Oc;OP",q2);
        q2.addTransition(TokenType.INT.toString(), "O","Oc;OP",q2);
        q2.addTransition(TokenType.STRING.toString(), "O","Oc;OP",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(), "O","Oc;OP",q2);

        //FILA OPERATION PRIMA <OP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"OP",q2);
        q2.addTransition(")","OP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"OP",q2);
        q2.addTransition(",","OP",q2);
        q2.addTransition("if","OP",q2);
        q2.addTransition("else","OP",q2);
        q2.addTransition(":","OP",q2);
        q2.addTransition("not","OP",q2);
        q2.addTransition("in","OP",q2);
        q2.addTransition("]","OP",q2);
        q2.addTransition("}","OP",q2);
        auxPush = TokenType.LOGIC + ";Oc;OP";
        q2.addTransition(TokenType.LOGIC.toString(),"OP",auxPush,q2);
        q2.addTransition("and","OP","and;Oc;OP",q2);
        q2.addTransition("or","OP","or;Oc;OP",q2);
        q2.addTransition("is","OP","is;Oc;OP",q2);

        //FILA OPERATION COMPARISON <Oc>
        q2.addTransition(TokenType.IDENTIFIER.toString(), "Oc","SR;OcP",q2);
        q2.addTransition("(", "Oc","SR;OcP",q2);
        q2.addTransition("not", "Oc","SR;OcP",q2);
        q2.addTransition("-", "Oc","SR;OcP",q2);
        q2.addTransition(TokenType.INT.toString(), "Oc","SR;OcP",q2);
        q2.addTransition(TokenType.STRING.toString(), "Oc","SR;OcP",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(), "Oc","SR;OcP",q2);

        //FILA OPERATION COMPARISON PRIMA <OcP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"OcP",q2);
        q2.addTransition(")","OcP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"OcP",q2);
        q2.addTransition(",","OcP",q2);
        q2.addTransition("if","OcP",q2);
        q2.addTransition("else","OcP",q2);
        q2.addTransition(":","OcP",q2);
        q2.addTransition("not","OcP",q2);
        q2.addTransition("in","OcP",q2);
        q2.addTransition("]","OcP",q2);
        q2.addTransition("}","OcP",q2);
        q2.addTransition(TokenType.LOGIC.toString(),"OcP",q2);
        q2.addTransition("and","OcP",q2);
        q2.addTransition("or","OcP",q2);
        q2.addTransition("is","OcP",q2);
        auxPush = TokenType.COMPARASION + ";SR;OcP";
        q2.addTransition(TokenType.COMPARASION.toString(),"OcP",auxPush,q2);

        //FILA ADDITION SUBTRACTION <SR>
        q2.addTransition(TokenType.IDENTIFIER.toString(), "SR","MD;SRP",q2);
        q2.addTransition("(", "SR","MD;SRP",q2);
        q2.addTransition("not", "SR","MD;SRP",q2);
        q2.addTransition("-", "SR","MD;SRP",q2);
        q2.addTransition(TokenType.INT.toString(), "SR","MD;SRP",q2);
        q2.addTransition(TokenType.STRING.toString(), "SR","MD;SRP",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(), "SR","MD;SRP",q2);

        //FILA ADDITION SUBTRACTION PRIMA <SRP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"SRP",q2);
        q2.addTransition(")","SRP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"SRP",q2);
        q2.addTransition(",","SRP",q2);
        q2.addTransition("if","SRP",q2);
        q2.addTransition("else","SRP",q2);
        q2.addTransition(":","SRP",q2);
        q2.addTransition("not","SRP",q2);
        q2.addTransition("in","SRP",q2);
        q2.addTransition("]","SRP",q2);
        q2.addTransition("}","SRP",q2);
        q2.addTransition(TokenType.LOGIC.toString(),"SRP",q2);
        q2.addTransition("and","SRP",q2);
        q2.addTransition("or","SRP",q2);
        q2.addTransition("is","SRP",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"SRP",q2);
        auxPush = TokenType.COMPARASION + ";SR;OcP";
        q2.addTransition("+","SRP","+;MD;SRP", q2);
        q2.addTransition("-","SRP","-;MD;SRP", q2);

        //FILA MULTIPLICATION DIVISION <MD>
        q2.addTransition(TokenType.IDENTIFIER.toString(), "MD","Exp;MDP",q2);
        q2.addTransition("(", "MD","Exp;MDP",q2);
        q2.addTransition("not", "MD","Exp;MDP",q2);
        q2.addTransition("-", "MD","Exp;MDP",q2);
        q2.addTransition(TokenType.INT.toString(), "MD","Exp;MDP",q2);
        q2.addTransition(TokenType.STRING.toString(), "MD","Exp;MDP",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(), "MD","Exp;MDP",q2);

        //FILA MULTIPLICATION DIVISION PRIMA <MDP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"MDP",q2);
        q2.addTransition(")","MDP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"MDP",q2);
        q2.addTransition(",","MDP",q2);
        q2.addTransition("if","MDP",q2);
        q2.addTransition("else","MDP",q2);
        q2.addTransition(":","MDP",q2);
        q2.addTransition("not","MDP",q2);
        q2.addTransition("in","MDP",q2);
        q2.addTransition("]","MDP",q2);
        q2.addTransition("}","MDP",q2);
        q2.addTransition(TokenType.LOGIC.toString(),"MDP",q2);
        q2.addTransition("and","MDP",q2);
        q2.addTransition("or","MDP",q2);
        q2.addTransition("is","MDP",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"MDP",q2);
        q2.addTransition("+","MDP", q2);
        q2.addTransition("-","MDP", q2);
        q2.addTransition("*","MDP","*;Exp;MDP", q2);
        q2.addTransition("/","MDP","/;Exp;MDP", q2);
        q2.addTransition("//","MDP","//;Exp;MDP", q2);
        q2.addTransition("%","MDP","%;Exp;MDP", q2);

        //FILA EXPONENT <Exp>
        q2.addTransition(TokenType.IDENTIFIER.toString(), "Exp","First;ExpP",q2);
        q2.addTransition("not", "Exp","First;ExpP",q2);
        q2.addTransition("(", "Exp","First;ExpP",q2);
        q2.addTransition("-", "Exp","First;ExpP",q2);
        q2.addTransition(TokenType.INT.toString(), "Exp","First;ExpP",q2);
        q2.addTransition(TokenType.STRING.toString(), "Exp","First;ExpP",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(), "Exp","First;ExpP",q2);

        //FILA EXPONENT PRIMA <ExpP>
        q2.addTransition(TokenType.LINEBREAK.toString(),"ExpP",q2);
        q2.addTransition(")","ExpP",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"ExpP",q2);
        q2.addTransition(",","ExpP",q2);
        q2.addTransition("if","ExpP",q2);
        q2.addTransition("else","ExpP",q2);
        q2.addTransition(":","ExpP",q2);
        q2.addTransition("not","ExpP",q2);
        q2.addTransition("in","ExpP",q2);
        q2.addTransition("]","ExpP",q2);
        q2.addTransition("}","ExpP",q2);
        q2.addTransition(TokenType.LOGIC.toString(),"ExpP",q2);
        q2.addTransition("and","ExpP",q2);
        q2.addTransition("or","ExpP",q2);
        q2.addTransition("is","ExpP",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"ExpP",q2);
        q2.addTransition("+","ExpP", q2);
        q2.addTransition("-","ExpP", q2);
        q2.addTransition("*","ExpP", q2);
        q2.addTransition("/","ExpP", q2);
        q2.addTransition("//","ExpP", q2);
        q2.addTransition("%","ExpP", q2);
        q2.addTransition("**","ExpP","**;First;ExpP", q2);

        //FILA FIRST <First>
        q2.addTransition(TokenType.IDENTIFIER.toString(), "First","Ec",q2);
        q2.addTransition("(", "First","Ec",q2);
        q2.addTransition("not", "First","not;Ec",q2);
        q2.addTransition("-", "First","Ec",q2);
        q2.addTransition(TokenType.INT.toString(), "First","Ec",q2);
        q2.addTransition(TokenType.STRING.toString(), "First","Ec",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(), "First","Ec",q2);

        //FILA EXPRESSION JOIN <Ec>
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Ec","Ep", q2);
        q2.addTransition("(","Ec","(;O;)",q2);

        q2.addTransition("-","Ec","Ep",q2);
        q2.addTransition(TokenType.INT.toString(), "Ec","Ep",q2);
        q2.addTransition(TokenType.STRING.toString(), "Ec","Ep",q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"Ec","Ep",q2);

        //FILA CALL FUNCTION <L>
        q2.addTransition(TokenType.LINEBREAK.toString(),"L",q2);
        q2.addTransition("(","L","(;Es;)",q2);
        q2.addTransition(")","L",q2);
        q2.addTransition(TokenType.ASSIGNMENT.toString(),"L",q2);
        q2.addTransition(",","L",q2);
        q2.addTransition("if","L",q2);
        q2.addTransition("else","L",q2);
        q2.addTransition(":","L",q2);
        q2.addTransition("not","L",q2);
        q2.addTransition("in","L",q2);
        q2.addTransition("]","L",q2);
        q2.addTransition("}","L",q2);
        q2.addTransition(TokenType.LOGIC.toString(),"L",q2);
        q2.addTransition("and","L",q2);
        q2.addTransition("or","L",q2);
        q2.addTransition("is","L",q2);
        q2.addTransition(TokenType.COMPARASION.toString(),"L",q2);
        q2.addTransition("+","L", q2);
        q2.addTransition("-","L", q2);
        q2.addTransition("*","L", q2);
        q2.addTransition("/","L", q2);
        q2.addTransition("//","L", q2);
        q2.addTransition("%","L", q2);
        q2.addTransition("**","L", q2);

        //FILA PRIMITIVE EXPRESSION <Ep>
        auxPush = TokenType.IDENTIFIER + ";L";
        q2.addTransition(TokenType.IDENTIFIER.toString(),"Ep",auxPush, q2);
        auxPush = "-;"+TokenType.INT;
        q2.addTransition("-","Ep",auxPush,q2);
        q2.addTransition(TokenType.INT.toString(), "Ep",TokenType.INT.toString(),q2);
        q2.addTransition(TokenType.STRING.toString(), "Ep",TokenType.STRING.toString(),q2);
        q2.addTransition(TokenType.BOOLEAN.toString(),"Ep",TokenType.BOOLEAN.toString(),q2);
    }
}
