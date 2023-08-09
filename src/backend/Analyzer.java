package backend;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Analyzer {
    private ArrayList<Token> tokens = new ArrayList<>();
    String text;
    public Analyzer(String text){
        this.text = text + "\n";
    }
    public void analyze(){
        s0(tokens,new StringBuilder(),0,0,0);
    }
    public ArrayList<Token> s0(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column){
        if(index >= text.length()) return tokens;
        char character = text.charAt(index);
        if(isSpaceTab(character)) return s0(tokens, new StringBuilder(),index+1,row,column+1);
        if(isLineBreak(character)) return s0(tokens, new StringBuilder(),index+1,row+1,0);
        if(possibleIdentifier(lexeme.toString(), character)) return sPossibleIdentifier(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(possibleArithmetic(lexeme.toString(), character)) return sPossibleArithmetic(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if((isCompare(character))) return sPossibleComparison(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(possibleConstant(character)) return sPossibleNumber(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(possibleString(character)) return sPossibleString(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(isComment(character)) return sPossibleComment(tokens, lexeme.append(character), index+1, row, column+1, column, index);
        if(isOther(character)||isPoint(character)) return sPossibleOthers(tokens, lexeme.append(character), index, row, column, column, index);
        else return sError(tokens, lexeme.append(character), index+1, row, column+1, column, index);
    }
    public ArrayList<Token> sPossibleIdentifier(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(possibleIdentifier(lexeme.toString(),character)) return sPossibleIdentifier(tokens, lexeme.append(character), index+1, row, column+1,initialColumn, tokenIndex);
        if(isDelimiter(character)){
            if(isKeyWord(lexeme.toString())) {
                tokens.add(new Token(TokenType.KEYWORD, lexeme.toString(), row, initialColumn, tokenIndex, Pattern.KEYWORD));
                if(isLogic(lexeme.toString())) tokens.add(new Token(TokenType.LOGIC, lexeme.toString(), row, initialColumn, tokenIndex, Pattern.LOGIC));
            }
            else tokens.add(new Token(TokenType.IDENTIFIER, lexeme.toString(), row, initialColumn, tokenIndex, Pattern.IDENTIFIER));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character), index+1, row, column+1, column, tokenIndex);
    }
    public ArrayList<Token> sPossibleArithmetic(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(possibleArithmetic(lexeme.toString(),character)){
            tokens.add(new Token(TokenType.ARITHMETIC,lexeme.append(character).toString(),row,initialColumn, tokenIndex,Pattern.ARITHMETIC));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        if(character == '='){
            tokens.add(new Token(TokenType.ASSIGNMENT,lexeme.append(character).toString(),row,initialColumn, tokenIndex,Pattern.ASSIGNMENT));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        tokens.add(new Token(TokenType.ARITHMETIC,lexeme.toString(),row,initialColumn, tokenIndex,Pattern.ARITHMETIC));
        return s0(tokens, new StringBuilder(),index,row,column);
    }
    public ArrayList<Token> sPossibleComparison(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(possibleCompare(lexeme.toString(),character)){
            tokens.add(new Token(TokenType.COMPARASION,lexeme.append(character).toString(),row,initialColumn, tokenIndex,Pattern.COMPARASION));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        if(lexeme.toString().equals("=")){
            tokens.add(new Token(TokenType.ASSIGNMENT,lexeme.toString(),row,initialColumn, tokenIndex,Pattern.ASSIGNMENT));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        tokens.add(new Token(TokenType.COMPARASION,lexeme.toString(),row,initialColumn, tokenIndex,Pattern.COMPARASION));
        return s0(tokens, new StringBuilder(),index,row,column);
    }
    public ArrayList<Token> sPossibleNumber(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isNumber(character))return sPossibleNumber(tokens, lexeme.append(character), index+1, row, column+1, initialColumn, tokenIndex);
        if(isPoint(character))return sPossibleDecimal(tokens, lexeme.append(character), index+1,row,column+1,initialColumn, tokenIndex);
        if(isDelimiter(character)){
            tokens.add(new Token(TokenType.INT, lexeme.toString(), row, initialColumn, tokenIndex,Pattern.INT));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character), index+1, row, column+1, initialColumn, tokenIndex);
    }
    public ArrayList<Token> sPossibleDecimal(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column,int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isNumber(character)) return sPossibleDecimal(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
        if(isDelimiterWithoutPoint(character)){
            tokens.add(new Token(TokenType.DECIMAL, lexeme.toString(), row, initialColumn, tokenIndex,Pattern.DECIMAL));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sErrorDecimal(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
    }
    public ArrayList <Token> sPossibleString(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(lexeme.charAt(0)==(char)34 && character==(char)34 || lexeme.charAt(0)==(char)39 && character==(char)39){//comillas " 34 y comilla ' 39
            tokens.add(new Token(TokenType.STRING,lexeme.append(character).toString(),row,initialColumn, tokenIndex,Pattern.STRING));
            return s0(tokens,new StringBuilder(),index+1,row,column+1);
        }
        if(isLineBreak(character)) return sError(tokens,lexeme,index,row,column,initialColumn, tokenIndex);
        return sPossibleString(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
    }
    public ArrayList<Token> sPossibleComment(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isLineBreak(character)) {
            tokens.add(new Token(TokenType.COMMENT,lexeme.toString(),row,initialColumn, tokenIndex,Pattern.COMMENT));
            return s0(tokens,new StringBuilder(),index,row,column);
        }
        return sPossibleComment(tokens,lexeme.append(character),index+1,row,column+1,initialColumn, tokenIndex);
    }
    public ArrayList<Token> sPossibleOthers(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        tokens.add(new Token(TokenType.OTHERS, lexeme.toString(),row,initialColumn, tokenIndex,Pattern.OTHERS));
        return s0(tokens, new StringBuilder(),index+1,row,column+1);
    }
    public ArrayList<Token> sError(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isDelimiter(character)){
            tokens.add(new Token(TokenType.ERROR,lexeme.toString(),row,initialColumn, tokenIndex,Pattern.ERROR));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sError(tokens, lexeme.append(character),index+1,row,column+1, initialColumn, tokenIndex);
    }
    public ArrayList<Token> sErrorDecimal(ArrayList<Token> tokens, StringBuilder lexeme, int index, int row, int column, int initialColumn, int tokenIndex){
        char character = text.charAt(index);
        if(isDelimiterWithoutPoint(character)){
            tokens.add(new Token(TokenType.ERROR,lexeme.toString(),row,initialColumn, tokenIndex,Pattern.ERROR));
            return s0(tokens, new StringBuilder(),index,row,column);
        }
        return sErrorDecimal(tokens, lexeme.append(character),index+1,row,column+1, initialColumn, tokenIndex);
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
                isOther(a)|| possibleString(a) || isPoint(a);
    }
    public static boolean isDelimiterWithoutPoint(char a){
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
    public static boolean possibleIdentifier(String lexeme, char letter){
        if(lexeme.equals("")){
            return letter == (char) 95 || isLetter(letter);
        }
        else{
            return letter == (char) 95 || isLetter(letter) || isNumber(letter);
        }
    }
    public static boolean possibleArithmetic(String lexeme, char letter){
        return switch (lexeme) {
            case "" -> isArithmetic(letter);
            case "*" -> letter == '*';
            case "/" -> letter == '/';
            default -> false;
        };
    }
    public static boolean possibleCompare(String lexeme, char letter){
        return switch (lexeme) {
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
    public static boolean isKeyWord(String lexeme){
        String[] keyWords = {"and", "as" , "assert" , "break" , "class" , "continue" , "def" ,
                "del" , "elif" , "else" , "except" , "False" , "finally" , "for" , "from" , "global" ,
                "if" , "import" , "in" , "is" , "lambda" , "None" , "nonlocal" , "not" , "or" , "pass" ,
                "raise" , "return" , "True" , "try" , "while" , "with" , "yield"};
        for (String keyWord : keyWords) {if (lexeme.equals(keyWord)) return true;}
        return false;
    }
    public static boolean isLogic(String lexeme){
        String[] keyWords = {"and", "or","not","True","False"};
        for (String keyWord : keyWords) {if (lexeme.equals(keyWord)) return true;}
        return false;
    }
    public ArrayList<Token> getTokens() {return tokens;}
    public ArrayList<Token> filterArrayList(TokenType type){
        return  (ArrayList<Token>) tokens.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
