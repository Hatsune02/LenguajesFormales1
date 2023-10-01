package com.navi.backend.tokens;

import lombok.*;

@Getter @Setter
public class Token {
    private TokenType type;
    private final String lexeme;
    private final int row, column, index;
    public Token(TokenType type, String lexeme, int row, int column, int index){
        this.type = type;
        this.lexeme = lexeme;
        this.row = row;
        this.column = column;
        this.index = index;
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
