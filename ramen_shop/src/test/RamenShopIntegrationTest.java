import br.lpm.factories.RamenFactory;
import br.lpm.model.BalancoFinal;
import br.lpm.model.Pedido;
import br.lpm.singleton.ListaDeEspera;
import br.lpm.types.AcrescimoChilli;
import br.lpm.types.AcrescimoProteinaExtra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RamenShopIntegrationTest {
    @Test
    void testSistemaCompleto() {
        // Criar pedidos usando a factory e decorators
        Pedido pedido1 = RamenFactory.criarRamen("pequeno", "Vegano");
        pedido1 = new AcrescimoProteinaExtra(pedido1);
        pedido1 = new AcrescimoChilli(pedido1);

        Pedido pedido2 = RamenFactory.criarRamen("medio", "Boi");

        // Adicionar à lista de espera (Singleton)
        ListaDeEspera listaDeEspera = ListaDeEspera.getInstance();
        listaDeEspera.limparPedidos();
        listaDeEspera.adicionarPedido(pedido1);
        listaDeEspera.adicionarPedido(pedido2);

        // Verificar a lista de espera
        assertEquals(2, listaDeEspera.getPedidosEmFila().size());

        // Processar pedidos
        listaDeEspera.processarPedidos();

        // Verificar pedidos concluídos
        assertEquals(2, listaDeEspera.getPedidosConcluidos().size());

        // Balanço final
        BalancoFinal balanco = new BalancoFinal(listaDeEspera.getPedidosConcluidos());
        // Receita esperada: (pequeno vegano 13.80 + proteina extra 4.00 + chilli 2.50) + (medio boi 20.80)
        double receitaEsperada = (13.80 + 4.00 + 2.50) + 20.80;
        assertEquals(receitaEsperada, listaDeEspera.getPedidosConcluidos()
                .stream().mapToDouble(Pedido::calcularPrecoTotal).sum(), 0.01);
        assertEquals(2, listaDeEspera.getPedidosConcluidos().size());
        assertEquals(receitaEsperada / 2, listaDeEspera.getPedidosConcluidos()
                .stream().mapToDouble(Pedido::calcularPrecoTotal).average().orElse(0.0), 0.01);
    }
}