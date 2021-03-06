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
package br.com.autogeral.paygo.controlpay.model;

import com.google.gson.annotations.SerializedName;

/**
 * 03/06/2019 15:34:45
 *
 * @author Murilo Moraes Tuvani
 */
public class Pessoa {
    @SerializedName(value = "key", alternate = {"Key"})
    private String key ;
    @SerializedName(value = "Id", alternate = {"id"})
    private int id;
    @SerializedName(value = "pessoaIds", alternate = {"PessoaIds"})
    private String pessoaIds;
    @SerializedName(value = "pessoaJuridica", alternate = {"PessoaJuridica"})
    private String pessoaJuridica;
    @SerializedName(value = "nomeRazaoSocial", alternate = {"NomeRazaoSocial"})
    private String nomeRazaoSocial;
    @SerializedName(value = "sobrenomeNomeFantasia", alternate = {"SobrenomeNomeFantasia"})
    private String sobrenomeNomeFantasia;
    @SerializedName(value = "cpfCnpj", alternate = {"CpfCnpj"})
    private String cpfCnpj;
    @SerializedName(value = "cpfCnpjFormat", alternate = {"CpfCnpjFormat"})
    private String cpfCnpjFormat;
    @SerializedName(value = "email", alternate = {"Email"})
    private String email;
    @SerializedName(value = "telefone1", alternate = {"Telefone1"})
    private String telefone1;
    @SerializedName(value = "telefone2", alternate = {"Telefone2"})
    private String telefone2;
    @SerializedName(value = "foto", alternate = {"Foto"})
    private String foto;
    @SerializedName(value = "fotoNome", alternate = {"FotoNome"})
    private String fotoNome;
    @SerializedName(value = "fotoBase64", alternate = {"FotoBase64"})
    private String fotoBase64;
    @SerializedName(value = "fotoThumbnail", alternate = {"FotoThumbnail"})
    private String fotoThumbnail;
    @SerializedName(value = "endereco", alternate = {"Endereco"})
    private Endereco endereco;
    private PessoaStatus pessoaStatus ;

   
    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getPessoaIds() {
        return pessoaIds;
    }

    public void setPessoaIds(String pessoaIds) {
        this.pessoaIds = pessoaIds;
    }

    public String getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(String pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getSobrenomeNomeFantasia() {
        return sobrenomeNomeFantasia;
    }

    public void setSobrenomeNomeFantasia(String sobrenomeNomeFantasia) {
        this.sobrenomeNomeFantasia = sobrenomeNomeFantasia;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpjFormat() {
        return cpfCnpjFormat;
    }

    public void setCpfCnpjFormat(String cpfCnpjFormat) {
        this.cpfCnpjFormat = cpfCnpjFormat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFotoNome() {
        return fotoNome;
    }

    public void setFotoNome(String fotoNome) {
        this.fotoNome = fotoNome;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFotoThumbnail() {
        return fotoThumbnail;
    }

    public void setFotoThumbnail(String fotoThumbnail) {
        this.fotoThumbnail = fotoThumbnail;
    }

    public PessoaStatus getPessoaStatus() {
        return pessoaStatus;
    }

    public void setPessoaStatus(PessoaStatus pessoaStatus) {
        this.pessoaStatus = pessoaStatus;
    }

    void setId(String PESSOA_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
