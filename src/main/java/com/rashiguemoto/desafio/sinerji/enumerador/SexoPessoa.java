package com.rashiguemoto.desafio.sinerji.enumerador;

public enum SexoPessoa {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private final String descricao;

    SexoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SexoPessoa fromString(String text) {
        for (SexoPessoa s : SexoPessoa.values()) {
            if (s.descricao.equalsIgnoreCase(text)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Sexo inválido: " + text);
    }
}
