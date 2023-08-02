package backend;

import java.util.ArrayList;

public class analizerr {
    ArrayList<Token> tokens = new ArrayList<>();
    String text;
    public analizerr(String text){
        this.text = text + "\n";
    }
    public void analize(){
        System.out.println(s0(tokens,new StringBuilder(),0,0,0).toString());
    }
    public ArrayList<Token> s0(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column){
        if(index >= text.length()) return tokens;
        char character = text.charAt(index);
        if(isSpaceTab(character)) return s0(tokens, new StringBuilder(),index+1,row,column+1);
        if(isLineBreak(character)) return s0(tokens, new StringBuilder(),index+1,row+1,0);
        if(possibleIdentifier(lexeme.toString(), character)) return sPossibleIdentifier(tokens, lexeme.append(character), index+1, row, column+1, column);
        if(possibleArithmetic(lexeme.toString(), character)) return sPossibleArithmetic(tokens, lexeme.append(character), index+1, row, column+1, column);
        if((isCompare(character))) return sPossibleComparison(tokens, lexeme.append(character), index+1, row, column+1, column);
        if(possibleConstant(character)) return sPossibleNumber(tokens, lexeme.append(character), index+1, row, column+1, column);
        if(possibleString(character)) return sPossibleString(tokens, lexeme.append(character), index+1, row, column+1, column);
        if(isComment(character)) return sPossibleComment(tokens, lexeme.append(character), index+1, row, column+1, column);
        if(isOther(character)) return sPossibleOthers(tokens, lexeme.append(character), index, row, column, column);
        else return sError(tokens, lexeme.append(character), index+1, row, column+1, column);
        }
    public ArrayList<Token> sPossibleIdentifier(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        char character = text.charAt(index);
        if(possibleIdentifier(lexeme.toString(),character)) return sPossibleIdentifier(tokens, lexeme.append(character), index+1, row, column+1,initialColumn);
        if(isDelimiter(character)){
            tokens.add(new Token(TokenType.IDENTIFIER, lexeme.toString(), row, initialColumn));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character), index+1, row, column+1, column);
    }
    public ArrayList<Token> sPossibleArithmetic(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        char character = text.charAt(index);
        if(possibleArithmetic(lexeme.toString(),character)){
            tokens.add(new Token(TokenType.ARITHMETIC,lexeme.append(character).toString(),row,initialColumn));
            return s0(tokens,new StringBuilder(),index+1,row,column);
        }
        if(character == '='){
            tokens.add(new Token(TokenType.ASSIGNMENT,lexeme.append(character).toString(),row,initialColumn));
            return s0(tokens,new StringBuilder(),index+1,row,column);
        }
        tokens.add(new Token(TokenType.ARITHMETIC,lexeme.toString(),row,initialColumn));
        return s0(tokens, new StringBuilder(),index,row,column);
    }
    public ArrayList<Token> sPossibleComparison(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        char character = text.charAt(index);
        if(possibleCompare(lexeme.toString(),character)){
            tokens.add(new Token(TokenType.COMPARASION,lexeme.append(character).toString(),row,initialColumn));
            return s0(tokens,new StringBuilder(),index+1,row,column);
        }
        if(lexeme.toString().equals("=")){
            tokens.add(new Token(TokenType.ASSIGNMENT,lexeme.toString(),row,initialColumn));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        tokens.add(new Token(TokenType.COMPARASION,lexeme.toString(),row,initialColumn));
        return s0(tokens, new StringBuilder(),index,row,column);
    }
    public ArrayList<Token> sPossibleNumber(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        char character = text.charAt(index);
        if(isNumber(character))return sPossibleNumber(tokens, lexeme.append(character), index+1, row, column+1, initialColumn);
        if(isPoint(character))return sPossibleDecimal(tokens, lexeme.append(character), index+1,row,column+1,initialColumn);
        if(isDelimiter(character)){
            tokens.add(new Token(TokenType.CONSTANT, lexeme.toString(), row, initialColumn));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character), index+1, row, column+1, column);
    }
    public ArrayList<Token> sPossibleDecimal(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column,int initialColumn){
        char character = text.charAt(index);
        if(isNumber(character)) return sPossibleDecimal(tokens,lexeme.append(character),index+1,row,column+1,initialColumn);
        if(isDelimiter(character)){
            tokens.add(new Token(TokenType.CONSTANT, lexeme.toString(), row, initialColumn));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        //if(isPoint(character)) return sError(tokens,lexeme.append(character),index,row,column,initialColumn);
        return sError(tokens,lexeme.append(character),index,row,column,initialColumn);
    }
    public ArrayList <Token> sPossibleString(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        char character = text.charAt(index);
        if(lexeme.charAt(0)==(char)34 && character==(char)34 || lexeme.charAt(0)==(char)39 && character==(char)39){//comillas " 34 y comilla ' 39
            tokens.add(new Token(TokenType.CONSTANT,lexeme.append(character).toString(),row,initialColumn));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        if(isLineBreak(character)) return sError(tokens,new StringBuilder(),index,row,column,initialColumn);
        return sPossibleString(tokens,lexeme.append(character),index+1,row,column+1,initialColumn);
    }
    public ArrayList<Token> sPossibleComment(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        char character = text.charAt(index);
        if(isLineBreak(character)) {
            tokens.add(new Token(TokenType.COMMENT,lexeme.toString(),row,initialColumn));
            return s0(tokens,new StringBuilder(),index,row,column);
        }
        return sPossibleComment(tokens,lexeme.append(character),index+1,row,column+1,initialColumn);
    }
    public ArrayList<Token> sPossibleOthers(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        tokens.add(new Token(TokenType.OTHERS, lexeme.toString(),row,initialColumn));
        return s0(tokens, new StringBuilder(),index+1,row,column+1);
    }
    public ArrayList<Token> sError(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn){
        char character = text.charAt(index);
        if(isDelimiter(character)){
            tokens.add(new Token(TokenType.ERROR,lexeme.toString(),row,initialColumn));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character),index+1,row,column+1, initialColumn);
    }

    //METODOS PARA FILTRAR LOS CARACTERES
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
    public static boolean isPoint(char a){
        return a=='.';
    }
    public static boolean isDelimiter(char a){
        return isSpaceTab(a) || isLineBreak(a) ||isComment(a) || isArithmetic(a) ||isCompare(a) ||
                isOther(a)|| possibleString(a);
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
    public static boolean possibleString(char letter){
        //(char)34 es comillas "  y (char)39 es comilla '
        return letter == (char) 34 || letter == (char) 39;
    }
}
