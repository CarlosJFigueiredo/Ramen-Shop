Ramen Shop - Sistema de Pedidos
Descrição do Projeto
O Ramen Shop é um sistema de gerenciamento de pedidos para uma loja de ramen, desenvolvido em Java. O sistema permite:

Criar pedidos personalizados com diferentes tamanhos, proteínas, acréscimos e bebidas
Processar pedidos e notificar clientes quando estiverem prontos
Gerar um balanço financeiro com o total de vendas
Funcionalidades Principais
Fazer Pedido:

Selecionar tamanho do ramen (Pequeno, Médio, Grande)
Escolher proteína (Vegano, Boi, Porco)
Adicionar acréscimos (Proteína Extra, Chilli, Creme de Alho, etc.)
Selecionar bebidas (Refrigerante, Chá Oolong, Chá Preto)
Processar Pedido:

Marcar pedidos como prontos
Notificar clientes automaticamente
Balanço Financeiro:

Visualizar total de vendas
Ver histórico de pedidos concluídos
Tecnologias e Padrões Utilizados
Padrão Factory: Para criação de pedidos (PedidoFactory)
Padrão Decorator: Para adicionar acréscimos e bebidas aos pedidos
Padrão Observer: Para notificar clientes quando pedidos estão prontos (Subject, Observer, Cozinha, Cliente)
Singleton: Para gerenciar a lista de pedidos e o balanço financeiro (ListaPedidos, Balanco)
