package com.navi.backend.lexer;

import lombok.*;

@Getter @Setter
public class Token {
    private TokenType type;
    private final String lexeme;
    private Pattern regEx;
    private final int row, column, index;
    public Token(TokenType type, String lexeme, int row, int column, int index, Pattern regEx){
        this.type = type;
        this.lexeme = lexeme;
        this.row = row;
        this.column = column;
        this.index = index;
        this.regEx = regEx;
    }


    @Override
    public String toString() {
        return type.getType() +
                ", lexema: " + lexeme +
                ", línea: " + (row+1) +
                ", columna: " + (column+1) +
                '\n';
    }
}
