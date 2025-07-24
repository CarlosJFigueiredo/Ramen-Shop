package br.lpm.model;

import br.lpm.enums.Proteina;

public abstract class Ramen implements Pedido {
    private double precoBase;
    private String tamanho;
    private Proteina proteina;

    public Ramen(Proteina proteina, String tamanho) {
        this.proteina = proteina;
        this.tamanho = tamanho;
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ramen ").append(tamanho)
          .append(", Proteina: ").append(proteina.getNome()).append(" | ");
        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return precoBase + proteina.getPreco();
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public Proteina getProteina() {
        return proteina;
    }
}