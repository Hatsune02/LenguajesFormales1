package com.navi.backend.utils;

import com.navi.backend.lexer.Token;
import com.navi.backend.lexer.TokenType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LexerMethods {
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
    public static boolean isSpace(char a){
        return a==(char)32;
    }
    public static boolean isTab(char a){
        return a==(char)9;
    }
    public static boolean isTabAfter(String text,int index){
        try{
            char character = text.charAt(index);
            char next1 = text.charAt(index+1);
            char next2 = text.charAt(index+2);
            char next3 = text.charAt(index+3);
            return isSpace(character) && isSpace(next1) && isSpace(next2) && isSpace(next3);
        }catch (Exception e){
            return false;
        }
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
    public static ArrayList<Token> filterArrayList(TokenType type, ArrayList<Token> tokens){
        return  (ArrayList<Token>) tokens.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
