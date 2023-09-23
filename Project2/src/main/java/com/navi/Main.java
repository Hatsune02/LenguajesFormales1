package com.navi;

import com.navi.backend.lexer.*;

public class Main {
    public static void main(String[] args) {
        String text = """
                hola
                amigos
                soy
                yo""";

        Analyzer analyzer = new Analyzer(text);
        analyzer.analyze();

        for(Token token: analyzer.getTokens()){
            System.out.println(token.toString());
        }
    }
}