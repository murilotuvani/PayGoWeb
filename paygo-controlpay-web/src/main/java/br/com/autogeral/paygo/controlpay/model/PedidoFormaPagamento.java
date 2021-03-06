/*
 * The MIT License
 *
 * Copyright 2019 kaique.mota.
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
package br.com.autogeral.paygo.controlpay.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author kaique.mota
 */
public class PedidoFormaPagamento {

    @SerializedName(value ="id",alternate = {"Id"})
    private int id;
    @SerializedName(value = "quantidadeMaximaParcelas", alternate = {"QuantidadeMaximaParcelas"})
    private int quantidadeMaximaParcelas;
    @SerializedName(value ="formaPagamento",alternate = {"FormaPagamento"})
    private FormaPagamento formaPagamento;
    private String adquirentePadrao;
    @SerializedName(value="adquirente",alternate = {"Adquirente"})
    private String adquirente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeMaximaParcelas() {
        return quantidadeMaximaParcelas;
    }

    public void setQuantidadeMaximaParcelas(int quantidadeMaximaParcelas) {
        this.quantidadeMaximaParcelas = quantidadeMaximaParcelas;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getAdquirentePadrao() {
        return adquirentePadrao;
    }

    public void setAdquirentePadrao(String adquirentePadrao) {
        this.adquirentePadrao = adquirentePadrao;
    }

    public String getAdquirente() {
        return adquirente;
    }

    public void setAdquirente(String adquirente) {
        this.adquirente = adquirente;
    }

}
