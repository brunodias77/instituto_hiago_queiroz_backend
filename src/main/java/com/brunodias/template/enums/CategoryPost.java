package com.brunodias.template.enums;

public enum CategoryPost {
    TAMPINHAS_ACAO("Tampinhas de Ação"),
    TEMPOS_DOURADOS("Tempos Dourados"),
    EDUCACAO("Educação"),
    SAUDE("Saúde"),
    MEIO_AMBIENTE("Meio Ambiente"),
    DIREITOS_HUMANOS("Direitos Humanos"),
    CULTURA("Cultura"),
    VOLUNTARIADO("Voluntariado");

    private final String descricao;

    // Construtor
    CategoryPost(String descricao) {
        this.descricao = descricao;
    }

    // Método para obter a descrição
    public String getDescricao() {
        return descricao;
    }

    // Método para obter uma descrição amigável (opcional)
    @Override
    public String toString() {
        return descricao;
    }
}
