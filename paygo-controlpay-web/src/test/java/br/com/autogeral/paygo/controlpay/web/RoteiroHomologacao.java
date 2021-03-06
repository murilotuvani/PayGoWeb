/*
 * The MIT License
 *
 * Copyright 2019 Murilo Moraes Tuvani.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.autogeral.paygo.controlpay.web;
//import br.com.autogeral.paygo.controlpay.model.AuxiliarTeste;

import br.com.autogeral.paygo.controlpay.impressao.IntencaoImpressao;
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.model.LoginResultado;
import br.com.autogeral.paygo.controlpay.model.Pedido;
import br.com.autogeral.paygo.controlpay.model.Venda;
import br.com.autogeral.paygo.controlpay.web.operacional.LoginLogin;
import br.com.autogeral.paygo.controlpay.web.operacional.TerminalGetByPessoaId;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import br.com.autogeral.paygo.controlpay.web.transacional.VendaVender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 07/06/2019 22:12:24
 *
 * @author Murilo Moraes Tuvani
 */
public class RoteiroHomologacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String key = "tgy8LUCZhHpwwKtEyB5t%2bAmWo9ayJrBLaHC4qUWSUkdDX%2fy35tDDoko8rasNz6QrPDvXPtZH4a4RRU1uyd4C0Z96NaqOu%2bjNh%2fxTr%2f6A%2fJQ%3d";
            String terminal = "900";
            String cpfCnpj = "05437537000137";
            String senha = "autogeral";
            String servidor = "https://apidemo.gate2all.com.br";
            String senhaTecnica = "314159";
            ControlPayConfig config = new ControlPayConfig(key, servidor, terminal, cpfCnpj, senha, senhaTecnica);

            IntencaoImpressao ii = new IntencaoImpressao(config);
            LoginLogin ll = new LoginLogin(config);
            LoginResultado loginData = ll.autenticar();
            if (loginData.getHttpStatus() == 200) {
                TerminalGetByPessoaId lgb = new TerminalGetByPessoaId(config);
                Data terminais = lgb.execute(loginData);
                System.out.println("Status HTTP : " + terminais.getHttpStatus());
                if (terminais.getHttpStatus() == 200 && !terminais.getTerminais().isEmpty()) {
                    int terminalId = terminais.getTerminais().get(3).getId();
                    Venda venda = new Venda();
                    venda.setTerminalId(Integer.toString(terminalId));
                    venda.setAdquirente("cielo");
                    venda.setReferencia("REF 1234");
//                    venda.setPedidoId(2775);
                    venda.setFormaPagamentoId(21);
                    venda.setQuantidadeParcelas(1);
                    venda.setValorTotalVendido(100);
                    venda.setConteudo("@");
                    VendaVender vv = new VendaVender(config);
                    Data vendaData = vv.vender(venda);

//                  Data imprimi = ii.impri(venda);

                    /* List<String> listaComprovantes = new ArrayList<>();

                data.getIntencoesVendas().stream().forEach(intencaoVenda -> {
                    intencaoVenda.getPagamentosExternos().stream().forEach(pagamento -> listaComprovantes.add(pagamento.getComprovanteAdquirente()
                    ));
                });*/
                    System.out.println("Terminal Verdadeiro " + venda.getTerminalId());

                    if (vendaData != null && vendaData.getIntencaoVenda() != null) {
                        IntencaoVenda iv = vendaData.getIntencaoVenda();
                        IntencaoVendaGet ivg = new IntencaoVendaGet(config);
                        IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(iv);
                        vendaData = ivg.get(ivp);

                        //Pegando dados para a classe auxiliar.
                        List<String> listaComprovantes = new ArrayList<>();

                        vendaData.getIntencoesVendas().stream().forEach(intencaoVenda -> {
                            intencaoVenda.getPagamentosExternos().stream().forEach(pagamento -> listaComprovantes.add(pagamento.getComprovanteAdquirente()
                            ));
                        });

                        System.out.println(listaComprovantes);

                        listaComprovantes.forEach((s) -> {
                            if (venda.getConteudo() != null) {
                                String concat = venda.getConteudo().concat("\n" + s);

                            } else {
                                venda.setConteudo(s);
                            }
                        });
                        System.out.println(venda.getConteudo());
                        Data imprimi = ii.impri(venda);
                    }

                }
            } else {
                System.out.println("Nao conseguiu se logar");
            }

        } catch (IOException ex) {
            Logger.getLogger(RoteiroHomologacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
