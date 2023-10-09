package com.navi.backend.reports;

import lombok.*;

@Getter @Setter @ToString
public class Block {
    private String name;
    private int indents,index,row,column,indexF;

    public Block(String name, int indents, int index, int row, int column) {
        this.name = name;
        this.indents = indents;
        this.index = index;
        this.row = row;
        this.column = column;
    }
}
