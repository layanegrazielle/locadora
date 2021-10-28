/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class LocadoraDTO {
    private String nome;
    private String cnpj;
    private String telefone;
    private int id;
    private LocalizacaoDTO localizacao;
    private ArrayList<VeiculoDTO> veiculos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    public LocalizacaoDTO getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoDTO localizacao) {
        this.localizacao = localizacao;
    }

    public ArrayList<VeiculoDTO> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<VeiculoDTO> veiculos) {
        this.veiculos = veiculos;
    }
}
