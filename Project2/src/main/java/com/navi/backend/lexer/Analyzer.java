package com.navi.backend.lexer;

import com.navi.backend.tokens.*;
import java.util.ArrayList;
import static com.navi.backend.utils.LexerMethods.*;

public class Analyzer {
    private final ArrayList<Token> tokens = new ArrayList<>();
    String text;
    int indents = 0 ,tabs = 0;

    public Analyzer(String text){
        this.text = text + "\n\n";
    }
    public void analyze(){
        s0(tokens,new StringBuilder(),0,0,0);
    }
    public ArrayList<Token> s0(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column){
        if(index >= text.length()) return tokens;
        char character = text.charAt(index);

        if(isSpace(character)) return sSpace(tokens, index,row,column,column,index);
        if(isTab(character)) return sIndent(tokens, index,row,column,column,index);
        if(isLineBreak(character)) return sLineBreak(tokens,index,row,column,index);
        if(possibleIdentifier(lexeme.toString(), character)) return sPossibleIdentifier(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(possibleArithmetic(lexeme.toString(), character)) return sPossibleArithmetic(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if((isCompare(character))) return sPossibleComparison(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(possibleConstant(character)) return sPossibleNumber(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(possibleString(character)) return sPossibleString(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(isComment(character)) return sPossibleComment(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(isOther(character)||isPoint(character)) return sPossibleOthers(tokens, lexeme.append(character), index, row, column, column, index);
        else return sError(tokens, lexeme.append(character), index+1, row, column+1, column, index);
    }
    public ArrayList<Token> sLineBreak(ArrayList<Token> tokens, int index, int row, int column, int tokenIndex){
        if(index==0) return s0(tokens, new StringBuilder(),index+1,row+1,0);

        char before = text.charAt(index-1);
        if(!isLineBreak(before)) tokens.add(new Token(TokenType.LINEBREAK, "\\n",row,column,tokenIndex));
        if((index+1)<text.length()){
            char after = text.charAt(index+1);

            tabs=0;
            if(!isTab(after) && !isTabAfter(text,index+1)){
                for (int i = 0; i < indents; i++) {
                    tokens.add(new Token(TokenType.DEDENT,"",row+1,0,tokenIndex));
                }
                indents = 0;
            }
        }
        return s0(tokens, new StringBuilder(),index+1,row+1,0);
    }
    public ArrayList<Token> sSpace(ArrayList<Token> tokens, int index, int row, int column, int initialColumn, int tokenIndex){
        if(isTabAfter(text,index)) return sIndent(tokens, index+3,row,column,initialColumn,tokenIndex);
        else return s0(tokens, new StringBuilder(),index+1,row,column+1);

    }
    public ArrayList<Token> sIndent(ArrayList<Token> tokens, int index, int row, int column, int initialColumn, int tokenIndex){
        char after = text.charAt(index);

        if(tabs==indents){
            indents++;
            tabs++;
            tokens.add(new Token(TokenType.INDENT, "\\t",row,initialColumn,tokenIndex));
        }
        else if(tabs<indents){
            tabs++;
        }
        if(!isTab(after) && !isTabAfter(text, index+1)){
            int dedent = indents - tabs;
            for (int i = 0; i < dedent; i++) {
                tokens.add(new Token(TokenType.DEDENT,"",row,initialColumn+4,tokenIndex));
            }
            indents = indents - dedent;
        }
        return s0(tokens,new StringBuilder(),index+1,row,column+4);
    }
    public ArrayList<Token> sPossibleIdentifier(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(possibleIdentifier(lexeme.toString(),character)) return sPossibleIdentifier(tokens, lexeme.append(character), index+1, row, column+1,initialColumn, tokenIndex);
        if(isDelimiter(character)){
            if(isKeyWord(lexeme.toString())) {
                //if(isLogic(lexeme.toString())) tokens.add(new Token(TokenType.LOGIC, lexeme.toString(), row, initialColumn, tokenIndex));
                if(isBoolean(lexeme.toString())) tokens.add(new Token(TokenType.BOOLEAN, lexeme.toString(), row, initialColumn, tokenIndex));
                else tokens.add(new Token(TokenType.KEYWORD, lexeme.toString(), row, initialColumn, tokenIndex));
            }
            else tokens.add(new Token(TokenType.IDENTIFIER, lexeme.toString(), row, initialColumn, tokenIndex));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character), index+1, row, column+1, column, tokenIndex);
    }
    public ArrayList<Token> sPossibleArithmetic(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(possibleArithmetic(lexeme.toString(),character)){
            tokens.add(new Token(TokenType.ARITHMETIC,lexeme.append(character).toString(),row,initialColumn, tokenIndex));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        if(character == '='){
            tokens.add(new Token(TokenType.ASSIGNMENT,lexeme.append(character).toString(),row,initialColumn, tokenIndex));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        tokens.add(new Token(TokenType.ARITHMETIC,lexeme.toString(),row,initialColumn, tokenIndex));
        return s0(tokens, new StringBuilder(),index,row,column);
    }
    public ArrayList<Token> sPossibleComparison(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex)   {
        char character = text.charAt(index);
        if(possibleCompare(lexeme.toString(),character)){
            tokens.add(new Token(TokenType.COMPARASION,lexeme.append(character).toString(),row,initialColumn, tokenIndex));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        if(lexeme.toString().equals("=")){
            tokens.add(new Token(TokenType.ASSIGNMENT,lexeme.toString(),row,initialColumn, tokenIndex));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        tokens.add(new Token(TokenType.COMPARASION,lexeme.toString(),row,initialColumn, tokenIndex));
        return s0(tokens, new StringBuilder(),index,row,column);
    }
    public ArrayList<Token> sPossibleNumber(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isNumber(character))return sPossibleNumber(tokens, lexeme.append(character), index+1, row, column+1, initialColumn, tokenIndex);
        if(isPoint(character))return sPossibleDecimal(tokens, lexeme.append(character), index+1,row,column+1,initialColumn, tokenIndex);
        if(isDelimiter(character)){
            tokens.add(new Token(TokenType.INT, lexeme.toString(), row, initialColumn, tokenIndex));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character), index+1, row, column+1, initialColumn, tokenIndex);
    }
    public ArrayList<Token> sPossibleDecimal(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column,int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isNumber(character)) return sPossibleDecimal(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
        if(isDelimiterWithoutPoint(character)){
            tokens.add(new Token(TokenType.INT, lexeme.toString(), row, initialColumn, tokenIndex));
            //tokens.add(new Token(TokenType.DECIMAL, lexeme.toString(), row, initialColumn, tokenIndex));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
    }
    public ArrayList<Token> sPossibleString(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(lexeme.charAt(0)==(char)34 && character==(char)34 || lexeme.charAt(0)==(char)39 && character==(char)39){//comillas " 34 y comilla ' 39
            tokens.add(new Token(TokenType.STRING,lexeme.append(character).toString(),row,initialColumn, tokenIndex));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        if(isLineBreak(character)) return sError(tokens,lexeme,index,row,column,initialColumn, tokenIndex);
        return sPossibleString(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
    }
    public ArrayList<Token> sPossibleComment(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isLineBreak(character)) {
            tokens.add(new Token(TokenType.COMMENT,lexeme.toString(),row,initialColumn, tokenIndex));
            return s0(tokens,new StringBuilder(),index,row,column);
        }
        return sPossibleComment(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
    }
    public ArrayList<Token> sPossibleOthers(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        tokens.add(new Token(TokenType.OTHERS, lexeme.toString(),row,initialColumn, tokenIndex));
        return s0(tokens, new StringBuilder(),index+1,row,column+1);
    }
    public ArrayList<Token> sError(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isDelimiterWithoutPoint(character)){
            tokens.add(new Token(TokenType.ERROR,lexeme.toString(),row,initialColumn, tokenIndex));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character),index+1,row,column+1, initialColumn, tokenIndex);
    }

    public ArrayList<Token> getTokens() {return tokens;}
}
