package com.navi.backend.tokens;

public enum TokenType {
    IDENTIFIER("Identificador"), ARITHMETIC("Aritmético"), COMPARASION("Comparación"),
    ASSIGNMENT("Asignación"), KEYWORD("Palabra Clave"), CONSTANT("Constante"),BOOLEAN("Boolean"),
    INT("Número Entero"), DECIMAL("Número Decimal"), STRING("Cadena"),
    COMMENT("Comentario"), OTHERS("Otro"), ERROR("Error"), LOGIC("Lógico"),
    LINEBREAK("Salto de linea"), INDENT("Identación"), DEDENT("Des-identación"),
    EPSILON("epsilon"), $("$");
    private final String type;

    TokenType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
