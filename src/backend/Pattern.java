package backend;

public enum Pattern {
    IDENTIFIER("_?[a-zA-z]+_?\\w*"), ARITHMETIC("(\\/\\/)?(\\*\\*)?|[-+*\\/%]? "), COMPARASION("[!><]=?|(==)"),
    ASSIGNMENT("[0-9]+"), KEYWORD(""), CONSTANT("Constante"), LOGIC(""),
    INT("[0-9]+"), DECIMAL("[0-9]+\\.[0-9]+"), STRING("\".[^\"]+\"|'.[^']+'"),
    COMMENT("#.*"), OTHERS("[\\[\\]\\(\\)\\{\\}]"), ERROR("No tiene");
    private String regEx;

    private Pattern(String regEx){
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }

    public void setRegEx(String regEx) {this.regEx = regEx;}
}
