package com.navi.backend.utils;

import com.navi.backend.reports.*;
import com.navi.backend.tokens.*;

import java.net.FileNameMap;
import java.util.ArrayList;

public class ParserMethods {

    public static ArrayList<Symbol> symbols(ArrayList<Token> tokens, int index, int indexF){
        ArrayList<Symbol> symbols = new ArrayList<>();

        for (int i = index; i < indexF; i++) {
            if(i+2 < tokens.size()){
                Token token = tokens.get(i);
                Token tokenAfter = tokens.get(i+1);
                Token tokenValue = tokens.get(i+2);

                if(token.getType() == TokenType.IDENTIFIER && tokenAfter.getType() == TokenType.ASSIGNMENT){
                    symbols.removeIf(symbol -> token.getLexeme().equals(symbol.getName()));
                    if(tokenValue.getLexeme().equals("[") || tokenValue.getLexeme().equals("{")){
                        arrayOrDic(tokens,symbols,token,i+2);
                    }
                    else symbols.add(new Symbol(token.getLexeme(),tokenValue.getType().getType(),tokenValue.getLexeme(), token.getRow(),token.getColumn()));
                }
                else if(token.getLexeme().equals("def") && tokenAfter.getType()==TokenType.IDENTIFIER){
                    searchReturn(tokens,symbols,tokenAfter,i);
                    param(tokens,symbols,i);
                }
            }
        }
        return symbols;
    }
    public static void arrayOrDic(ArrayList<Token> tokens, ArrayList<Symbol> symbols, Token token, int i){
        Token aux1 = tokens.get(i);
        StringBuilder value = new StringBuilder();
        String end,type;
        if(aux1.getLexeme().equals("[")) {
            end = "]";
            type = "Arreglo";
        }
        else {
            end = "}";
            type = "Diccionario";
        }
        for (int j = 0; j < tokens.size()-i; j++) {
            if(i+j < tokens.size()){
                Token aux2 = tokens.get(i+j);
                if(aux2.getLexeme().equals(end)){
                    value.append(end);
                    break;
                }
                if(aux2.getLexeme().equals(",")) value.append(", ");
                else value.append(aux2.getLexeme());
            }
        }
        symbols.add(new Symbol(token.getLexeme(),type,value.toString(),token.getRow(),token.getColumn()));
    }
    public static void param(ArrayList<Token> tokens,ArrayList<Symbol> symbols,int i){
        for (int j = 0; j < tokens.size()-i; j++) {
            if(i+j+3 < tokens.size()){
                Token aux = tokens.get(i+j+3);
                if(aux.getLexeme().equals(")")){
                    break;
                }
                if(aux.getType()==TokenType.IDENTIFIER) symbols.add(new Symbol(aux.getLexeme(),"Parametro","Indefinido",aux.getRow(),aux.getColumn()));
            }
        }
    }
    public static int indents(ArrayList<Token> tokens,int i){
        int auxIndents = 1;
        int indents = 1;
        for (int j = 0; j < tokens.size()-i ; j++) {
            if(i+j+1 < tokens.size()){
                Token token = tokens.get(i+j);
                if(token.getType() == TokenType.INDENT){
                    i = i+j+1;
                    break;
                }
            }
        }
        for (int j = 0; j < tokens.size()-i ; j++) {
            if(i+j < tokens.size()){
                Token token = tokens.get(i+j);
                if(token.getType() == TokenType.INDENT){
                    auxIndents++;
                    indents++;
                }
                if(token.getType() == TokenType.DEDENT) auxIndents--;
                if(auxIndents==0) break;
            }
        }
        return indents;
    }
    public static void searchReturn(ArrayList<Token> tokens,ArrayList<Symbol> symbols,Token token,int i){
        boolean found = false;
        int indents = indents(tokens,i);
        for (int j = 0; j < tokens.size()-i ; j++) {
            if(i+j+1 < tokens.size()){
                Token auxToken = tokens.get(i+j);
                Token value = tokens.get(i+j+1);
                if(indents == 1 && auxToken.getLexeme().equals("return")){
                    symbols.removeIf(symbol -> token.getLexeme().equals(symbol.getName()));
                    symbols.add(new Symbol(token.getLexeme(),"Función",value.getLexeme(),token.getRow(),token.getColumn()));
                    found = true;
                    break;
                }
                if(auxToken.getType() == TokenType.DEDENT) indents--;

                if(indents==0) break;
            }
        }
        if(!found){
            symbols.removeIf(symbol -> token.getLexeme().equals(symbol.getName()));
            symbols.add(new Symbol(token.getLexeme(),"Función","--",token.getRow(),token.getColumn()));
        }
    }
    public static ArrayList<Block> blocks(ArrayList<Token> tokens){
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < tokens.size() ; i++) {
            Token token = tokens.get(i);
            if(isBlock(tokens,i)){
                StringBuilder name = new StringBuilder();
                int index = 0;
                for (int j = 0; j < tokens.size()-i; j++) {
                    Token aux = tokens.get(i+j);
                    if(i+j < tokens.size()){

                        if(aux.getType()==TokenType.KEYWORD) name.append(" ").append(aux.getLexeme()).append(" ");
                        else if(aux.getLexeme().equals(",")) name.append(aux.getLexeme()).append(" ");
                        else name.append(aux.getLexeme());

                        if(aux.getLexeme().equals(":")){
                            index = i+j+2;
                            break;
                        }
                    }
                }
                Block block = new Block(name.toString(),indents(tokens,i),index,token.getRow(),token.getColumn());
                searchEndBlock(tokens,block,i);
                blocks.add(block);
            }
        }
        return blocks;
    }
    public static boolean isBlock(ArrayList<Token> tokens,int i){
        Token token = tokens.get(i);
        if(token.getLexeme().equals("if") || token.getLexeme().equals("else")){
            for (int j = 0; j < tokens.size()-i; j++) {
                if(i+j+1 < tokens.size()){
                    Token aux = tokens.get(i+j+1);
                    if(aux.getLexeme().equals(":")) return true;
                    if(aux.getType()==TokenType.LINEBREAK) return false;
                }
            }
        }
        return token.getLexeme().equals("def") || token.getLexeme().equals("elif") ||
                token.getLexeme().equals("for") || token.getLexeme().equals("while");
    }
    public static void searchEndBlock(ArrayList<Token> tokens,Block block,int i){
        int indents = indents(tokens,i);
        for (int j = 0; j < tokens.size()-i ; j++) {
            if(i+j < tokens.size()){
                Token auxToken = tokens.get(i+j);
                if(auxToken.getType() == TokenType.DEDENT) indents--;

                if(indents==0) {
                    block.setIndexF(i+j);
                    break;
                }
            }
        }
    }

    public static ArrayList<Instruction> instructions(ArrayList<Token> tokens, int index, int indexF){
        ArrayList<Instruction> instructions = new ArrayList<>();
        StringBuilder body = new StringBuilder();
        for (int i = index; i < indexF; i++) {
            Token token = tokens.get(i);

            if(token.getType()==TokenType.LINEBREAK){
                instructions.add(new Instruction(token.getRow(),body.toString(),token.getColumn()));
                body = new StringBuilder();
            }
            else if(token.getType()!=TokenType.INDENT && token.getType()!=TokenType.DEDENT){
                if(token.getType()==TokenType.KEYWORD) body.append(" ").append(token.getLexeme()).append(" ");
                else if(token.getLexeme().equals(",")) body.append(token.getLexeme()).append(" ");
                else body.append(token.getLexeme());
            }
        }
        return instructions;
    }
    public static ArrayList<Function> functions(ArrayList<Token> tokens){
        ArrayList<Function> functions = new ArrayList<>();
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < tokens.size(); i++) {
            if(i+1 < tokens.size()){
                Token token =  tokens.get(i);
                Token tokenAfter = tokens.get(i+1);
                if(token.getLexeme().equals("def")){
                    functions.removeIf(fun -> tokenAfter.getLexeme().equals(fun.getName()));
                    functions.add(new Function(tokenAfter.getLexeme()));
                }
            }
        }
        for (int i = 0; i < tokens.size(); i++) {
            if(i-1 > 0 && i+1 < tokens.size()){
                Token tokenBefore = tokens.get(i-1);
                Token token = tokens.get(i);
                Token tokenAfter = tokens.get(i+1);
                if(!tokenBefore.getLexeme().equals("def") && token.getType() == TokenType.IDENTIFIER && tokenAfter.getLexeme().equals("(")){
                    for (Function auxF : functions) {
                        if (token.getLexeme().equals(auxF.getName())) {
                            auxF.addReference();
                        }
                    }
                }
            }
        }
        return functions;
    }
}
