/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author guilh
 */
public class VeiculoDTO {
    private static int count = 0;
    private int id = 0;
    private int id_locadora;
    private String marca;
    private String modelo;
    private String ano;
    private String acessorios;
    private String preco;
    private String categoria;
    
    public VeiculoDTO(){}

    public VeiculoDTO(String marca, String modelo, String ano, String acessorios, String preco, String categoria) {
        id = count++;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.acessorios = acessorios;
        this.preco = preco;
        this.categoria = categoria;
    }

    /**
     * @return the count
     */
    public static int getCount() {
        return count;
    }

    /**
     * @param aCount the count to set
     */
    public static void setCount(int aCount) {
        count = aCount;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_locadora
     */
    public int getId_locadora() {
        return id_locadora;
    }

    /**
     * @param id_locadora the id_locadora to set
     */
    public void setId_locadora(int id_locadora) {
        this.id_locadora = id_locadora;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the acessorios
     */
    public String getAcessorios() {
        return acessorios;
    }

    /**
     * @param acessorios the acessorios to set
     */
    public void setAcessorios(String acessorios) {
        this.acessorios = acessorios;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}