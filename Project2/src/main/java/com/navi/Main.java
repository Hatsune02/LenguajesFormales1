package com.navi;

import com.navi.backend.lexer.*;
import com.navi.backend.parser.PDA;
import com.navi.backend.reports.*;
import com.navi.backend.tokens.Token;
import com.navi.backend.utils.ParserMethods;
import com.navi.frontend.DashBoard;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DashBoard.initUI();
        //test(); //0,232,200
    }
    public static void test(){
        String text = """
                    a=1
                    def         mostrar():
                        b = -3
                        z = 1
                    """;

        Analyzer analyzer = new Analyzer(text);
        analyzer.analyze();
        ArrayList<Token> tokens = analyzer.getTokens();
        for(Token token: tokens) {
            System.out.println(token.toString());
        }

        for(Symbol xd : ParserMethods.symbols(tokens,0,tokens.size())){
            System.out.println(xd.toString());
        }
        ArrayList<Block>blocks = ParserMethods.blocks(tokens);
        for(Block block:blocks){
            System.out.println(block.toString());
            for(Symbol xd : ParserMethods.symbols(tokens,block.getIndex(),block.getIndexF())){
                System.out.println(xd.toString());
            }
        }
        System.out.println("");
        ArrayList<Instruction> instructions = ParserMethods.instructions(tokens,0,tokens.size());
        for(Instruction instruction:instructions){
            System.out.println(instruction.toString());
        }
        /*
        System.out.println("");
        for(Block block:blocks){
            for(Instruction instruction:ParserMethods.instructions(tokens,block.getIndex(),block.getIndexF())){
                System.out.println(instruction.toString());
            }
            System.out.println("");
        }

        System.out.println("Cantidad de funciones: " + ParserMethods.functions(tokens).size());
        for(Function fun : ParserMethods.functions(tokens)){
            System.out.println(fun.toString());
        }*/

        PDA pda = PDA.getAutomaton(analyzer.getTokens());
        //pda.analyze(0);
        if(pda.getError().isEmpty())System.out.println("NO HAY ERROR");
        else System.out.println(pda.getError());;
    }
}