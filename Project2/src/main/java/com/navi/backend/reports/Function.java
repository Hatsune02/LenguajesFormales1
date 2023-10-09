package com.navi.backend.reports;

import lombok.*;

@Getter @Setter @ToString
public class Function {
    private String name;
    private int references = 0;
    private String params;
    private int row;

    public Function(String name, int row) {
        this.name = name;
        this.row = row;
    }
    public void addReference(){
        references++;
    }
}
