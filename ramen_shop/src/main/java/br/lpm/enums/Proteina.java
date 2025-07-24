package br.lpm.enums;

public enum Proteina {
    VEGANO("Vegano", 3.90),
    PORCO("Porco", 5.90),
    BOI("Boi", 7.90);

    private final String nome;
    private final double preco;

    Proteina(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public static Proteina fromString(String nome) {
        for (Proteina p : Proteina.values()) {
            if (p.nome.equalsIgnoreCase(nome)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Proteína inválida: " + nome);
    }
}
