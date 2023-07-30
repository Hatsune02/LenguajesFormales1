package backend;

import java.util.ArrayList;

public class Analizer {
    private ArrayList<Token> tokens;
    public void analize(String text){
        text = text + "\n";
        int row = 1, initialRow = 0;
        int column = 1, initialColumn=0;
        int tokenType = 0;
        /* 0 = no hay tipo
           1 = puede ser identificador
           2 = puede ser aritmetico
           3 = puede ser comparacion
           4 = puede ser constante
           5 = puede ser cadena
           6 = puede ser comentario
           7 = puede ser otro
        */
        String lexem="";
        boolean decimal = false, quotationMarks = false, quotationMark = false;
        for (int i = 0; i < text.length(); i++) {
            char charA = text.charAt(i);
            if(tokenType == 0){
                //espacio o tabulacion
                if(isSpaceTab(charA)){
                    column++;
                }
                //salto de linea
                else if(isLineBreak(charA)){
                    row++;
                }
                else {
                    tokenType = assignTokenType(lexem, charA);
                    lexem = lexem + charA;
                    initialColumn = column;
                    column++;
                    if(tokenType==7){
                        Token token1 = new Token(TokenType.OTHERS,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                    else if(tokenType==8){
                        Token token1 = new Token(TokenType.ERROR,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                }
            }
            else if(tokenType == 1){
                if(possibleIdentifier(lexem, charA)){
                    lexem = lexem+charA;
                    column++;
                }
                else if(isSpaceTab(charA)){
                    Token token1 = new Token(TokenType.IDENTIFIER, lexem, row, initialColumn);
                    column++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else if(isLineBreak(charA)){
                    Token token1 = new Token(TokenType.IDENTIFIER, lexem, row, initialColumn);
                    column=1;
                    row++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else {
                    Token token1 = new Token(TokenType.IDENTIFIER, lexem, initialRow, column);
                    lexem = String.valueOf(charA);
                    tokenType = assignTokenType(lexem,charA);
                    initialColumn = column;
                    column++;
                    System.out.println(token1.getLexem());
                    if(tokenType==7){
                        Token token2 = new Token(TokenType.OTHERS,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token2.getLexem());
                    }
                    else if(tokenType==8){
                        Token token2 = new Token(TokenType.ERROR,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token2.getLexem());
                    }
                }
            }
            else if(tokenType == 2){
                if(possibleArithmetic(lexem, charA)){
                    lexem = lexem + charA;
                    Token token1 = new Token(TokenType.ARITHMETIC,lexem,row,initialColumn);
                    column++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else if(charA == '='){
                    lexem = lexem+charA;
                    Token token1 = new Token(TokenType.ASSIGNMENT,lexem,row,initialColumn);
                    column++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else if(isSpaceTab(charA)){
                    Token token1 = new Token(TokenType.ARITHMETIC,lexem,row,initialColumn);
                    column++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else if(isLineBreak(charA)){
                    Token token1 = new Token(TokenType.ARITHMETIC,lexem,row,initialColumn);
                    column=1;
                    row++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else{
                    Token token1 = new Token(TokenType.ARITHMETIC,lexem,row,initialColumn);
                    lexem = String.valueOf(charA);
                    tokenType = assignTokenType(lexem,charA);
                    initialColumn = column;
                    column++;
                    System.out.println(token1.getLexem());
                    if(tokenType==7){
                        Token token2 = new Token(TokenType.OTHERS,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token2.getLexem());
                    }
                    else if(tokenType==8){
                        Token token2 = new Token(TokenType.ERROR,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token2.getLexem());
                    }
                }
            }
            else if(tokenType == 3){
                if(possibleCompare(lexem, charA)){
                    lexem = lexem + charA;
                    Token token1 = new Token(TokenType.COMPARASION,lexem,row,initialColumn);
                    column++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else if(isSpaceTab(charA)){
                    Token token1;
                    if(lexem.equals("=")){
                        token1 = new Token(TokenType.ASSIGNMENT, lexem, row, initialColumn);
                    }
                    else {
                        token1 = new Token(TokenType.COMPARASION, lexem, row, initialColumn);
                    }
                    System.out.println(token1.getLexem());
                    column++;
                    lexem = "";
                    tokenType = 0;
                }
                else if(isLineBreak(charA)){
                    Token token1;
                    if(lexem.equals("=")){
                        token1 = new Token(TokenType.ASSIGNMENT, lexem, row, initialColumn);
                    }
                    else {
                        token1 = new Token(TokenType.COMPARASION, lexem, row, initialColumn);
                    }
                    column=1;
                    row++;
                    lexem = "";
                    tokenType = 0;
                    System.out.println(token1.getLexem());
                }
                else{
                    Token token1;
                    if(lexem.equals("=")){
                        token1 = new Token(TokenType.ASSIGNMENT, lexem, row, initialColumn);
                    }
                    else {
                        token1 = new Token(TokenType.COMPARASION, lexem, row, initialColumn);
                    }
                    lexem = String.valueOf(charA);
                    tokenType = assignTokenType(lexem,charA);
                    initialColumn = column;
                    column++;
                    System.out.println(token1.getLexem());
                    if(tokenType==7){
                        Token token2 = new Token(TokenType.OTHERS,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token2.getLexem());
                    }
                    else if(tokenType==8){
                        Token token2 = new Token(TokenType.ERROR,lexem,row,initialColumn);
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token2.getLexem());
                    }
                }
            }
            else if(tokenType == 4){
                if(isNumber(charA)){
                    lexem = lexem+charA;
                    column++;
                }
                else if(isPoint(charA)){
                    if(!decimal){
                        decimal = true;
                        lexem = lexem+charA;
                        column++;
                    }
                    else{
                        Token token1;
                        if(isPoint(text.charAt(i-1))){
                            lexem = lexem.substring(0, lexem.length()-1);
                            decimal = false;
                            token1 = new Token(TokenType.CONSTANT, lexem, row, initialColumn);
                            Token token2 = new Token(TokenType.ERROR, ".", row, initialColumn);
                            lexem = "";
                            tokenType = 0;
                            column++;
                            System.out.println(token1.getLexem());
                            System.out.println(token2.getLexem());
                        }
                        else {
                            token1 = new Token(TokenType.CONSTANT, lexem, initialRow, column);
                            decimal = false;
                            lexem = String.valueOf(charA);
                            tokenType = assignTokenType(lexem,charA);
                            initialColumn = column;
                            column++;
                            System.out.println(token1.getLexem());
                            if(tokenType==7){
                                Token token2 = new Token(TokenType.OTHERS,lexem,row,initialColumn);
                                lexem = "";
                                tokenType = 0;
                                System.out.println(token2.getLexem());
                            }
                            else if(tokenType==8){
                                Token token2 = new Token(TokenType.ERROR,lexem,row,initialColumn);
                                lexem = "";
                                tokenType = 0;
                                System.out.println(token2.getLexem());
                            }
                        }
                    }
                }
                else if(isSpaceTab(charA)){
                    Token token1;
                    if(isPoint(text.charAt(i-1))){
                        lexem = lexem.substring(0, lexem.length()-1);
                        decimal = false;
                        token1 = new Token(TokenType.CONSTANT, lexem, row, initialColumn);
                        Token token2 = new Token(TokenType.ERROR, ".", row, initialColumn);
                        column++;
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                        System.out.println(token2.getLexem());
                    }
                    else {
                        token1 = new Token(TokenType.CONSTANT, lexem, row, initialColumn);
                        column++;
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                }
                else if(isLineBreak(charA)){
                    Token token1;
                    if(isPoint(text.charAt(i-1))){
                        lexem = lexem.substring(0, lexem.length()-1);
                        decimal = false;
                        token1 = new Token(TokenType.CONSTANT, lexem, row, initialColumn);
                        Token token2 = new Token(TokenType.ERROR, ".", row, initialColumn);
                        column++;
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                        System.out.println(token2.getLexem());
                    }
                    else {
                        token1 = new Token(TokenType.CONSTANT, lexem, row, initialColumn);
                        decimal = false;
                        column=1;
                        row++;
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                }
                else {
                    Token token1;
                    if(isPoint(text.charAt(i-1))){
                        lexem = lexem.substring(0, lexem.length()-1);
                        decimal = false;
                        token1 = new Token(TokenType.CONSTANT, lexem, row, initialColumn);
                        Token token2 = new Token(TokenType.ERROR, ".", row, initialColumn);
                        column++;
                        lexem = "";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                        System.out.println(token2.getLexem());
                    }
                    else{
                        token1 = new Token(TokenType.CONSTANT, lexem, initialRow, column);
                        decimal = false;
                        lexem = String.valueOf(charA);
                        tokenType = assignTokenType(lexem,charA);
                        initialColumn = column;
                        column++;
                        System.out.println(token1.getLexem());
                        if(tokenType==7){
                            Token token2 = new Token(TokenType.OTHERS,lexem,row,initialColumn);
                            lexem = "";
                            tokenType = 0;
                            System.out.println(token2.getLexem());
                        }
                        else if(tokenType==8){
                            Token token2 = new Token(TokenType.ERROR,lexem,row,initialColumn);
                            lexem = "";
                            tokenType = 0;
                            System.out.println(token2.getLexem());
                        }
                    }
                }
            }
            else if(tokenType == 5){
                if(text.charAt(i-1) == (char)34){
                    quotationMarks = true;
                }
                else if(text.charAt(i-1) == (char)39){
                    quotationMark = true;
                }
                if(quotationMarks){
                    if(charA==(char)34){
                        lexem = lexem+charA;
                        Token token1 = new Token(TokenType.CONSTANT, lexem, row,initialColumn);
                        quotationMarks=false;
                        column++;
                        lexem="";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                    else if(isLineBreak(charA)){
                        lexem = lexem+charA;
                        Token token1 = new Token(TokenType.CONSTANT, lexem, row,initialColumn);
                        quotationMarks=false;
                        column=1;
                        row++;
                        lexem="";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                    else {
                        lexem = lexem+charA;
                        column++;
                    }
                }
                else if(quotationMark){
                    if(charA==(char)39){
                        lexem = lexem+charA;
                        Token token1 = new Token(TokenType.CONSTANT, lexem, row,initialColumn);
                        quotationMark=false;
                        column++;
                        lexem="";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                    else if(isLineBreak(charA)){
                        lexem = lexem+charA;
                        Token token1 = new Token(TokenType.CONSTANT, lexem, row,initialColumn);
                        quotationMark=false;
                        column=1;
                        row++;
                        lexem="";
                        tokenType = 0;
                        System.out.println(token1.getLexem());
                    }
                    else {
                        lexem = lexem+charA;
                        column++;
                    }
                }
            }
            else if(tokenType == 6){
                Token token1;
                if(isLineBreak(charA)){
                    token1 = new Token(TokenType.COMMENT,lexem,row,initialColumn);
                    lexem="";
                    System.out.println(token1.getLexem());
                }
                else{
                    lexem = lexem + charA;
                }
            }
        }
    }

    public static boolean isLetter(char letter){
        return letter >= (char)65 && letter <= (char)90 || letter >= (char)97 && letter <= (char)122;
    }

    public static boolean isNumber(char number){
        return number >= (char)48 && number <= (char)57;
    }

    public static boolean isArithmetic(char ar){
        return ar=='+' || ar=='-' ||ar=='*' || ar=='/' ||ar=='%';
    }

    public static boolean isCompare(char c){
        return c== '='|| c=='!' || c=='>' ||c=='<';
    }

    public static boolean isAssign(char a){
        return a=='=';
    }

    public static boolean isPoint(char a){
        return a=='.';
    }

    public static boolean isComment(char a){
        return a=='#';
    }

    public static boolean isOther(char a){
        return a=='('|| a==')'|| a=='{'|| a=='}'|| a=='['|| a==']'|| a==','|| a==';'|| a==':';
    }

    public static boolean isSpaceTab(char a){
        return a==(char)9 || a==(char)32;
    }

    public static boolean isLineBreak(char a){
        return a==(char)10;
    }

    public static boolean possibleIdentifier(String lexem, char letter){
        if(lexem.equals("")){
            return letter == (char) 95 || isLetter(letter);
        }
        else{
            return letter == (char) 95 || isLetter(letter) || isNumber(letter);
        }
    }

    public static boolean possibleArithmetic(String lexem, char letter){
        return switch (lexem) {
            case "" -> isArithmetic(letter);
            case "*" -> letter == '*';
            case "/" -> letter == '/';
            default -> false;
        };
    }

    public static boolean possibleCompare(String lexem, char letter){
        return switch (lexem) {
            case "" -> isCompare(letter);
            case "=", "!", ">", "<" -> letter == '=';
            default -> false;
        };
    }

    public static boolean possibleConstant(char letter){
        return isNumber(letter);
    }

    public static boolean possibleChain(char letter){
        //(char)34 es comillas "  y (char)39 es comilla '
        return letter == (char) 34 || letter == (char) 39;
    }

    public static int assignTokenType(String lexem, char charA){
        if(possibleIdentifier(lexem, charA)){
            return 1;
        }
        else if(possibleArithmetic(lexem, charA)){
            return 2;
        }
        else if(isCompare(charA)){
            return 3;
        }
        else if(possibleConstant(charA)){
            return 4;
        }
        else if(possibleChain(charA)){
            return 5;
        }
        else if(isComment(charA)){
            return 6;
        }
        else if(isOther(charA)){
            return 7;
        }
        else{
            return 8;
        }
    }
}
