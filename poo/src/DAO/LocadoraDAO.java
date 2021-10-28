/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LocadoraDTO;
import DTO.LocalizacaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author guilh
 */
public class LocadoraDAO {
    Connection con;
    PreparedStatement stm;
    ResultSet res;
    ArrayList<LocadoraDTO> lista = new ArrayList<>();
    private static int idGeral = 3;
    
    
    
    public void cadastrarLocadora(LocadoraDTO locadora){
        idGeral++;
        String sql = "insert into locadora (id, nome, cnpj, telefone) VALUES(?,?,?,?)";
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, idGeral);
            stm.setString(2, locadora.getNome());
            stm.setString(3, locadora.getCnpj());
            stm.setString(4, locadora.getTelefone());
            
            stm.execute();
            stm.close();
            
            cadastrarLocalizacao(locadora.getLocalizacao());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Cadastrar Locadora" + e);
        }
    }
    
        public void cadastrarLocalizacao(LocalizacaoDTO localizacao){
     
        String sql = "insert into localizacao (id, id_locadora, endereco, bairro, cidade, estado) VALUES(?,?,?,?,?,?)";
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, idGeral);
            stm.setInt(2, idGeral);
            stm.setString(3, localizacao.getEndereco());
            stm.setString(4, localizacao.getBairro());
            stm.setString(5, localizacao.getCidade());
            stm.setString(6, localizacao.getEstado());
            
            stm.execute();
            stm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Cadastrar localizacao" + e);
        }
    }
        
    public ArrayList<LocadoraDTO> PesquisarLocadora() {
        String sql = "select * FROM locadora";
        con = new ConexaoDAO().conexao();
        try {
            stm = con.prepareStatement(sql);
            res = stm.executeQuery();
            
            while(res.next()) {
                LocadoraDTO locadora = new LocadoraDTO();
                locadora.setId(res.getInt("id"));
                locadora.setNome(res.getString("nome"));
                locadora.setCnpj(res.getString("cnpj"));
                locadora.setTelefone(res.getString("telefone"));
                locadora.setLocalizacao(buscarLocalizacao(locadora.getId()));
                
                lista.add(locadora);
           }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Pesquisar:" + e);
            
        }
        return lista;
    }
    
    public LocalizacaoDTO buscarLocalizacao(int id){
        String sql = "select * FROM localizacao WHERE id_locadora = id";
        con = new ConexaoDAO().conexao();
        LocalizacaoDTO localizacao = new LocalizacaoDTO();
        
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            

            rs.next();
            
            localizacao.setId(rs.getInt("id"));
            localizacao.setEndereco(rs.getString("endereco"));
            localizacao.setBairro(rs.getString("bairro"));
            localizacao.setCidade(rs.getString("cidade"));
            localizacao.setEstado(rs.getString("estado"));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Buscar Localizacao" + e);
        }
        
        return localizacao;
    }
}

