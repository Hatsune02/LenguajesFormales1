package com.navi.backend.lexer;

public enum TokenType {
    IDENTIFIER("Identificador"), ARITHMETIC("Aritmético"), COMPARASION("Comparación"),
    ASSIGNMENT("Asignación"), KEYWORD("Palabra Clave"), CONSTANT("Constante"),
    INT("Número Entero"), DECIMAL("Número Decimal"), STRING("Cadena"),
    COMMENT("Comentario"), OTHERS("Otro"), ERROR("Error"), LOGIC("Lógico"),
    LINEBREAK("Salto de linea"), INDENT("Identación"), DEDENT("Des-identación");
    private final String type;

    private TokenType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
