package com.navi.backend.reports;

import lombok.*;

@Getter @Setter @ToString
public class Instruction {
    private int row,column;
    private String body;

    public Instruction(int row, String body,int column) {
        this.row = row;
        this.body = body;
        this.column = column;
    }
}
