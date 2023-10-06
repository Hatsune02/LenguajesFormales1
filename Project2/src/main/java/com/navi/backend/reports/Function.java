package com.navi.backend.reports;

import lombok.*;

@Getter @Setter @ToString
public class Function {
    private String name;
    private int references = 0;
    private String params;

    public Function(String name) {
        this.name = name;
    }
    public void addReference(){
        references++;
    }
}
