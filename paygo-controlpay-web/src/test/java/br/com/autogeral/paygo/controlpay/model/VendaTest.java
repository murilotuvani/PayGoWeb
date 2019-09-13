package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendaTest {

    private static final int FORMA_PAGAMENTO_ID = 21;
    private static final int PEDIDO_ID = 0;
    private static final String TERMINAL_ID = "898";
    private static final String REFERENCIA = "null";
    private static final boolean AGURDAR_TEF_INICIAR_TRANSACAO = true;
    private static final String PARCELAMENTO_ADMIN = "null";
    private static final int QUANTIDADE_PARCELAS = 1;
    private static final String ADQUIRENTE = "";
    private static final double VALOR_TOTAL_VENDIDO = 400;
    private static final boolean AGUARDAR_CLIENTE_INICIAR_IMPRESSAO = true;
    private static final int IMPRESSORA_ID = 0;
    private static final String CONTEUDO = "null";
    //produto venda
    private static final int ITEM_PRODDUTO_ID = 2508;
    private static final int ID = 0;
    private static final String NOME = "null";
    private static final String QUANTIDADE = "1";
    private static final String VALOR = "1,00";
    private transient int itemProdutoId;

    @Test
    public void test01_serialize() {
        Venda instance = new Venda();

        instance.setTerminalId(TERMINAL_ID);
        instance.setAdquirente(ADQUIRENTE);
        instance.setFormaPagamentoId(FORMA_PAGAMENTO_ID);
        instance.setQuantidadeParcelas(QUANTIDADE_PARCELAS);

        ProdutoVenda pv = new ProdutoVenda();
        pv.setValor(VALOR);
        pv.setQuantidade(QUANTIDADE);
        instance.getProdutosVendidos().add(pv);

        String expResult = "{\n"
                + "  \"formaPagamentoId\": 21,\n"
                + "  \"pedidoId\": 0,\n"
                + "  \"terminalId\": \"898\",\n"
                + "  \"referencia\": null,\n"
                + "  \"aguardarTefIniciarTransacao\": true,\n"
                + "  \"parcelamentoAdmin\": null,\n"
                + "  \"quantidadeParcelas\": 1,\n"
                + "  \"adquirente\": \"\",\n"
                + "  \"produtosVendidos\": [\n"
                + "    {\n"
                + "      \"id\": 0,\n"
                + "      \"nome\": null,\n"
                + "      \"quantidade\": \"1\",\n"
                + "      \"valor\": \"1,00\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"aguardarClienteIniciarImpressao\": true,\n"
                + "  \"impressoraId\": 0,\n"
                + "  \"conteudo\": null\n"
                + "}";
        
        
        String result = WsHelper.getGson().toJson(instance);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    @Test
    public void test_parse() {
        String toParse = 
                "  \"formaPagamentoId\": 21,\n"
                + "  \"pedidoId\": 0,\n"
                + "  \"terminalId\": \"898\",\n"
                + "  \"referencia\": null,\n"
                + "  \"aguardarTefIniciarTransacao\": true,\n"
                + "  \"parcelamentoAdmin\": null,\n"
                + "  \"quantidadeParcelas\": 1,\n"
                + "  \"adquirente\": \"\",\n"
                + "  \"produtosVendidos\": [\n"
                + "    {\n"
                + "      \"id\": 0,\n"
                + "      \"nome\": null,\n"
                + "      \"quantidade\": \"1\",\n"
                + "      \"valor\": \"1,00\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"aguardarClienteIniciarImpressao\": true,\n"
                + "  \"impressoraId\": 0,\n"
                + "  \"conteudo\": null\n"
                + "}";

        Venda venda = WsHelper.unmarshal(toParse, Venda.class);
        testVenda(venda);
        assertEquals(toParse, venda);

    }

    private void testVenda(Venda venda) {
        Produto produto = new Produto();
        assertNotNull(venda);

        assertEquals(FORMA_PAGAMENTO_ID, venda.getFormaPagamentoId());
        assertEquals(PEDIDO_ID, venda.getPedidoId());
        assertEquals(TERMINAL_ID, venda.getTerminalId());
        assertEquals(REFERENCIA, venda.getReferencia());
        assertEquals(AGURDAR_TEF_INICIAR_TRANSACAO, venda.isAguardarTefIniciarTransacao());
        assertEquals(PARCELAMENTO_ADMIN, venda.getParcelamentoAdmin());
        assertEquals(QUANTIDADE_PARCELAS, venda.getQuantidadeParcelas());
        assertEquals(ADQUIRENTE, venda.getAdquirente());
        assertEquals(ID, produto.getId());
        assertEquals(NOME,produto.getNome());
        assertEquals(QUANTIDADE, produto.getQuantidade());
        assertEquals(VALOR, produto.getValor());
        assertEquals(AGUARDAR_CLIENTE_INICIAR_IMPRESSAO, venda.isAguardarClienteIniciarImpressao());
        assertEquals(IMPRESSORA_ID, venda.getImpressoraId());
        assertEquals(CONTEUDO, venda.getConteudo());
    }

}
