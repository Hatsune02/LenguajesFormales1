package com.navi.backend.reports;

import com.navi.backend.tokens.Token;
import com.navi.backend.tokens.TokenType;
import lombok.*;

import java.util.ArrayList;

@Getter @Setter @ToString
public class Values {
    private ArrayList<Token> tokensValue;
    private Token assign;
    private String value;
    private String type = "";

    public Values(ArrayList<Token> tokensValue, Token assign) {
        this.tokensValue = tokensValue;
        this.assign = assign;
        type(assign);
        value();
    }
    private void type(Token assign){
        if (tokensValue != null){
            if(assign != null){
                if(assign.getLexeme().equals("=")){
                    Token aux = tokensValue.get(0);
                    if(tokensValue.size()==1){
                        if(aux.getType()==TokenType.INT) type = "Número";
                        if(aux.getType()==TokenType.STRING) type = "Cadena";
                        if(aux.getType()==TokenType.IDENTIFIER) type = "Desconocido";
                        if(aux.getType()==TokenType.BOOLEAN) type = "Booleano";
                    }
                    else{
                        if(aux.getLexeme().equals("[") || aux.getLexeme().equals("{")){
                            if(aux.getLexeme().equals("[")){
                                type = "Arreglo";
                            }
                            else{
                                type = "Diccionario";
                            }
                        }
                        else{
                            boolean num=false,str=false,bool=false;
                            for(Token v: tokensValue){
                                if(v.getType()==TokenType.COMPARASION || v.getLexeme().equals("and") || v.getLexeme().equals("or") || v.getLexeme().equals("not")|| v.getLexeme().equals("is")) {
                                    this.type = "Boleano";
                                    break;
                                }
                                if(v.getType()==TokenType.INT) if(!num) num = true;
                                if(v.getType()==TokenType.STRING) if(!str) str = true;
                                if(v.getType()==TokenType.BOOLEAN) bool = true;
                            }
                            if(type.isEmpty()){
                                if(num && !str && !bool) type = "Número";
                                else if(str && !bool) type = "Cadena";
                                else if(bool) type = "Booleano";
                                else type = "Desconocido";
                            }
                        }
                    }
                }
                else type = "Desconocido";
            }

            else type = "Desconocido";
        }
        else type = "Desconocido";
    }
    private void value(){
        StringBuilder value = new StringBuilder();
        for (Token aux2 : tokensValue) {
            if (aux2.getType()!=TokenType.COMPARASION && aux2.getType()!=TokenType.LINEBREAK) {
                if (aux2.getLexeme().equals(",")) value.append(", ");
                else value.append(aux2.getLexeme());
            }
        }
        this.value = value.toString();
    }
    public void viewToken(Token token){
        String lexeme = assign.getLexeme();
        if(!lexeme.equals("=")){
            value = token.getLexeme() + lexeme.charAt(0) + value;
        }
    }
}