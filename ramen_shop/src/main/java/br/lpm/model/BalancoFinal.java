package br.lpm.model;

import java.util.List;

public class BalancoFinal {
    private final List<Pedido> pedidosConcluidos;

    public BalancoFinal(List<Pedido> pedidosConcluidos) {
        this.pedidosConcluidos = pedidosConcluidos;
    }

    public void exibirBalanco() {
        double receitaTotal = pedidosConcluidos
                             .stream()
                             .mapToDouble(Pedido::calcularPrecoTotal)
                             .sum();
        int quantidadePedidos = pedidosConcluidos.size();
        double ticketMedio = quantidadePedidos > 0 ? receitaTotal / quantidadePedidos : 0;

        System.out.println("Quantidade de pedidos: " + quantidadePedidos);
        System.out.println("Receita total: R$ " + String.format("%.2f", receitaTotal));
        System.out.println("Ticket médio: R$ " + String.format("%.2f", ticketMedio));
    }
}