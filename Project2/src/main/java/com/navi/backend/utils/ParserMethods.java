package com.navi.backend.utils;

import com.navi.backend.reports.*;
import com.navi.backend.tokens.*;

import java.util.ArrayList;

public class ParserMethods {

    public static ArrayList<Symbol> symbols(ArrayList<Token> tokens, int index, int indexF){
        ArrayList<Symbol> symbols = new ArrayList<>();

        for (int i = index; i < indexF; i++) {
            if(i==0){
                Token token = tokens.get(i);
                Token tokenAfter = tokens.get(i+1);
                if(token.getType() == TokenType.IDENTIFIER && !tokenAfter.getLexeme().equals("(")){
                    i = analyzeLine(tokens,symbols,i);
                }
                else if(token.getLexeme().equals("def") && tokenAfter.getType()==TokenType.IDENTIFIER){
                    searchReturn(tokens,symbols,tokenAfter,i);
                    param(tokens,symbols,i);
                }
            }
            if(i+1 < tokens.size() && i-1 > index){
                Token tokenBefore = tokens.get(i-1);
                Token token = tokens.get(i);
                Token tokenAfter = tokens.get(i+1);
                if(!tokenBefore.getLexeme().equals("return") && token.getType() == TokenType.IDENTIFIER && !tokenAfter.getLexeme().equals("(")){
                    i = analyzeLine(tokens,symbols,i);
                }
                else if(token.getLexeme().equals("def") && tokenAfter.getType()==TokenType.IDENTIFIER){
                    searchReturn(tokens,symbols,tokenAfter,i);
                    param(tokens,symbols,i);
                }
            }


        }
        return symbols;
    }
    public static int analyzeLine(ArrayList<Token> tokens, ArrayList<Symbol> symbols, int i){
        ArrayList<Token> line = new ArrayList<>();
        for (int j = i; j < tokens.size(); j++) {
            Token aux = tokens.get(j);
            if(aux.getType() != TokenType.LINEBREAK) line.add(aux);
            else break;
        }
        findSymbols(line,symbols);
        return i + line.size();
    }
    public static void findSymbols(ArrayList<Token> line, ArrayList<Symbol> symbols){
        StringBuilder value = new StringBuilder();
        var tokensId = new ArrayList<Token>();
        var tokensValue = new ArrayList<Token>();
        var values = new ArrayList<Values>();
        int indexAssign = 0;
        boolean isAssign = false;

        tokensId.add(line.get(0));
        for (int j = 1; j < line.size(); j++) {
            Token aux = line.get(j);
            if(j+1 < line.size()){
                Token auxAfter = line.get(j+1);
                if(aux.getLexeme().equals(",") && auxAfter.getType()==TokenType.IDENTIFIER){
                    tokensId.add(auxAfter);
                }
            }
            if(aux.getType()==TokenType.ASSIGNMENT){
                isAssign = true;
                indexAssign = j;
                break;
            }
        }
        int functions = 0;
        int arrays = 0;
        int dictionaries = 0;
        Token assign = line.get(indexAssign);
        for (int i = indexAssign+1; i < line.size(); i++) {
            Token aux = line.get(i);
            String l = aux.getLexeme();
            if(isAssign){
                if(aux.getType()==TokenType.ASSIGNMENT){
                    tokensValue = new ArrayList<>();
                    value = new StringBuilder();
                }
                if(l.equals("(")) functions++;
                if(l.equals("[")) arrays++;
                if(l.equals("{")) dictionaries++;

                if(l.equals(")")) functions--;
                if(l.equals("]")) arrays--;
                if(l.equals("}")) dictionaries--;

                if(aux.getLexeme().equals(",") && (functions==0 && arrays==0 && dictionaries==0)){
                    values.add(new Values(tokensValue, assign));
                    tokensValue = new ArrayList<>();
                    value = new StringBuilder();
                }
                else {
                    tokensValue.add(aux);
                    value.append(aux.getLexeme());
                }
            }
            else break;
        }
        values.add(new Values(tokensValue,assign));
        if(tokensId.size() == values.size()){
            for (int i = 0; i < values.size(); i++) {
                Token id = tokensId.get(i);
                Values v = values.get(i);
                v.viewToken(id);
                symbols.add(new Symbol(id.getLexeme(),v.getType(),v.getValue(), id.getRow(), id.getColumn()));
            }
        }
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
                    StringBuilder val = new StringBuilder();
                    for (int k = i+j+1; k < tokens.size(); k++) {
                        Token token1 = tokens.get(k);
                        if (token1.getType()!=TokenType.LINEBREAK){
                            if(token1.getType()!= TokenType.COMMENT) val.append(token1.getLexeme());
                        }
                        else break;
                    }
                    symbols.removeIf(symbol -> token.getLexeme().equals(symbol.getName()));
                    symbols.add(new Symbol(token.getLexeme(),"Función",val.toString(),token.getRow(),token.getColumn()));
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
                            index = i+j+1;
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
        Token first = tokens.get(index);
        for (int i = index; i < indexF; i++) {
            Token token = tokens.get(i);

            if(token.getType()==TokenType.LINEBREAK){
                instructions.add(new Instruction(first.getRow(),body.toString(),first.getColumn()));
                body = new StringBuilder();
                if(i+1 < indexF) first = tokens.get(i+1);
            }
            else if(token.getType()!=TokenType.INDENT && token.getType()!=TokenType.DEDENT && token.getType()!=TokenType.COMMENT){
                if(token.getType()==TokenType.KEYWORD) {
                    if(body.isEmpty()) body.append(token.getLexeme()).append(" ");
                    else body.append(" ").append(token.getLexeme()).append(" ");
                }
                else if(token.getLexeme().equals(",")) body.append(token.getLexeme()).append(" ");
                else body.append(token.getLexeme());
            }
        }
        return instructions;
    }
    public static ArrayList<Function> functions(ArrayList<Token> tokens){
        ArrayList<Function> functions = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            if(i+3 < tokens.size()){
                Token token =  tokens.get(i);
                Token tokenId = tokens.get(i+1);
                if(token.getLexeme().equals("def")){
                    functions.removeIf(fun -> tokenId.getLexeme().equals(fun.getName()));
                    Function fun = new Function(tokenId.getLexeme(),tokenId.getRow());
                    fun.setParams(param(tokens,i+3));
                    functions.add(fun);
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
    public static String param(ArrayList<Token> tokens,int i){
        StringBuilder param = new StringBuilder();
        for (int j = i; j < tokens.size()-i; j++) {
            Token aux = tokens.get(j);
            if(aux.getLexeme().equals(")")){
                break;
            }
            param.append(aux.getLexeme());
        }
        return param.toString();
    }
}
