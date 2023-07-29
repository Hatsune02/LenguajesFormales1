package backend;

public class Token {
    private TokenType type;
    private String lexem;
    private int row, column;

    public Token(TokenType type, String lexem, int row, int column){
        this.type = type;
        this.lexem = lexem;
        this.row = row;
        this.column = column;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexem() {
        return lexem;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
