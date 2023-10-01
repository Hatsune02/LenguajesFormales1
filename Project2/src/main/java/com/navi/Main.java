package com.navi;

import com.navi.backend.lexer.*;
import com.navi.backend.tokens.Token;
import com.navi.backend.tokens.TokenType;

public class Main {
    public static void main(String[] args) {
        String text = """
                hola
                    amigos
                        soy
                    yo
                xd""";

        Analyzer analyzer = new Analyzer(text);
        analyzer.analyze();

        for(Token token: analyzer.getTokens()){
            System.out.println(token.toString());
        }

        System.out.println(TokenType.LINEBREAK.getType());
    }
}