package backend;

public class Token {
    private TokenType type;
    private final String lexem;
    private final int row, column, index;
    public Token(TokenType type, String lexeme, int row, int column, int index){
        this.type = type;
        this.lexem = lexeme;
        this.row = row;
        this.column = column;
        this.index = index;
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

    public int getIndex() {return index;}

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", lexem='" + lexem + '\'' +
                ", row=" + (row+1) +
                ", column=" + (column+1) +
                '}'+'\n';
    }
}
