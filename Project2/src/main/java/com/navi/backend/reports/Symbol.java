package com.navi.backend.reports;

import com.navi.backend.tokens.TokenType;
import lombok.*;

@Getter @Setter @ToString
public class Symbol {
    private String name;
    private String type;
    private String value;
    private int row,column;

    public Symbol(String name, String type, String value, int row, int column) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.row = row+1;
        this.column = column+1;
    }
}
