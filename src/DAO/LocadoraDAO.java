package DAO;

import DTO.LocadoraDTO;
import DTO.LocalizacaoDTO;
import DTO.VeiculoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LocadoraDAO {
    Connection con;
    PreparedStatement stm;
    ResultSet res;
    int idMaximo = -1;
    ArrayList<LocadoraDTO> lista = new ArrayList<>();
    ArrayList<VeiculoDTO> listaVeiculo = new ArrayList<>();
   
    
public ResultSet autenticar(LocadoraDTO locadora){
        String sql = "select * FROM locadora where usuario = ? and senha = ?";
        con = new ConexaoDAO().conexao();
        try {
            stm = con.prepareStatement(sql);
     
            stm.setString(1, locadora.getUsuario());
            stm.setString(2, locadora.getSenha());
            
            res = stm.executeQuery();
            
            return res;
  
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Autenticar:" + e);
            
            return null;
        }
    }
public int maiorIdLocadora(){
    String sql = "select * from locadora where id=(select max(id) from locadora)";
    con = new ConexaoDAO().conexao();
     try {
            stm = con.prepareStatement(sql);
            res = stm.executeQuery();
            
            res.next();
            
            idMaximo = res.getInt("id");
            stm.close();
            
           }catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, "FuncionarioDAO Pesquisar:" + e);
                
          
        }
     return idMaximo;
}

public int maiorIdVeiculo(){
    String sql = "select * from veiculo where id=(select max(id) from veiculo)";
    con = new ConexaoDAO().conexao();
     try {
            stm = con.prepareStatement(sql);
            res = stm.executeQuery();
            
            res.next();
            
            idMaximo = res.getInt("id");
            stm.close();
            
           }catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Maior id veiculo:" + e);
          
        }
     return idMaximo;
}
    public void cadastrarLocadora(LocadoraDTO locadora, LocalizacaoDTO localizacao){
        
        String sql = "insert into locadora (id, usuario, senha, nome, cnpj, telefone,endereco, bairro, cidade, estado) VALUES(?,?,?,?,?,?,?,?,?,?)";
        con = new ConexaoDAO().conexao();
      
        try {
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, locadora.getId());
            stm.setString(2, locadora.getUsuario());
            stm.setString(3, locadora.getSenha());
            stm.setString(4, locadora.getNome());
            stm.setString(5, locadora.getCnpj());
            stm.setString(6, locadora.getTelefone());
            stm.setString(7, localizacao.getEndereco());
            stm.setString(8, localizacao.getBairro());
            stm.setString(9, localizacao.getCidade());
            stm.setString(10, localizacao.getEstado());
            
            stm.execute();
            stm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Cadastrar Locadora" + e);
        }
    }
    public void cadastrarVeiculo(int idLocadora, VeiculoDTO veiculo){
        String sql = "insert into veiculo (id, id_locadora, marca, modelo, ano, acessorios, preco, categoria) values (?,?,?,?,?,?,?,?)";
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, veiculo.getId());
            stm.setInt(2, idLocadora);
            stm.setString(3, veiculo.getMarca());
            stm.setString(4, veiculo.getModelo());
            stm.setString(5, veiculo.getAno());
            stm.setString(6, veiculo.getAcessorios());
            stm.setString(7, veiculo.getPreco());
            stm.setString(8, veiculo.getCategoria());
            
            stm.execute();
            stm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Cadastrar Veiculo" + e);
        }
    }
    public ArrayList<VeiculoDTO> PesquisarVeiculoLocadora(int idLocadora) {
        String sql = "select * FROM veiculo where id_locadora = ?";
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, idLocadora);
            res = stm.executeQuery();
            
            while(res.next()) {
                VeiculoDTO veiculo = new VeiculoDTO();
                veiculo.setId(res.getInt("id"));
                veiculo.setId_locadora(res.getInt("id_locadora"));
                veiculo.setMarca(res.getString("marca"));
                veiculo.setModelo(res.getString("modelo"));
                veiculo.setAno(res.getString("ano"));
                veiculo.setAcessorios(res.getString("acessorios"));
                veiculo.setCategoria(res.getString("categoria"));
                veiculo.setPreco(res.getString("preco"));
                
                listaVeiculo.add(veiculo);
           }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Pesquisar:" + e);
            
        }
      return listaVeiculo;
    }
    public ArrayList<VeiculoDTO> listarVeiculos() {
        String sql = "select * FROM veiculo";
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
            res = stm.executeQuery();
            
            while(res.next()) {
                VeiculoDTO veiculo = new VeiculoDTO();
                veiculo.setId(res.getInt("id"));
                veiculo.setId_locadora(res.getInt("id_locadora"));
                veiculo.setMarca(res.getString("marca"));
                veiculo.setModelo(res.getString("modelo"));
                veiculo.setAno(res.getString("ano"));
                veiculo.setAcessorios(res.getString("acessorios"));
                veiculo.setCategoria(res.getString("categoria"));
                veiculo.setPreco(res.getString("preco"));
                
                listaVeiculo.add(veiculo);
           }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Pesquisar:" + e);
            
        }
      return listaVeiculo;
    }
    public LocadoraDTO encontrarLocadora(int idLocadora) {
        String sql = "select * FROM locadora where id = ?";
        con = new ConexaoDAO().conexao();
        LocadoraDTO locadora = new LocadoraDTO();
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, idLocadora);
            res = stm.executeQuery();
            
            res.next();
            
            LocalizacaoDTO localizacao = new LocalizacaoDTO();
            locadora.setId(res.getInt("id"));
            locadora.setNome(res.getString("nome"));
            locadora.setCnpj(res.getString("cnpj"));
            locadora.setTelefone(res.getString("telefone"));
            localizacao.setEndereco(res.getString("endereco"));
            localizacao.setBairro(res.getString("bairro"));
            localizacao.setCidade(res.getString("cidade"));
            localizacao.setEstado(res.getString("estado"));
            locadora.setLocalizacao(localizacao);
                
   
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Pesquisar Locadora:" + e);
            
        }
        return locadora;
    }
    public VeiculoDTO buscarVeiculo(int id){
        String sql = "select * FROM veiculo where id = ?";
        con = new ConexaoDAO().conexao();
        VeiculoDTO veiculo = new VeiculoDTO();
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            res = stm.executeQuery();
            res.next();
            veiculo.setId(res.getInt("id"));
            veiculo.setId_locadora(res.getInt("id_locadora"));
            veiculo.setMarca(res.getString("marca"));
            veiculo.setModelo(res.getString("modelo"));
            veiculo.setAno(res.getString("ano"));
            veiculo.setAcessorios(res.getString("acessorios"));
            veiculo.setCategoria(res.getString("categoria"));
            veiculo.setPreco(res.getString("preco"));
               
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Buscar Veiculo:" + e);
            
        }
      return veiculo;
    }
    public void editarVeiculo(VeiculoDTO veiculo){
        String sql = "update veiculo set marca = ?, modelo = ?, ano = ?, acessorios = ?, preco = ?, categoria = ? where id = ?";
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
           
            stm.setString(1, veiculo.getMarca());
            stm.setString(2, veiculo.getModelo());
            stm.setString(3, veiculo.getAno());
            stm.setString(4, veiculo.getAcessorios());
            stm.setString(5, veiculo.getPreco());
            stm.setString(6, veiculo.getCategoria());
            stm.setInt(7, veiculo.getId());
            
            stm.execute();
            stm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Editar Veiculo" + e);
        }
    }
    public void deletarVeiculo(int id){
        String sql = "delete FROM veiculo where id = ?";
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, id);
           
            stm.execute();
            stm.close();
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Buscar Veiculo:" + e);
            
        }
 
    }
    public ArrayList<VeiculoDTO> fitrarPorVeiculoLocadora(int idLocadora, String coluna, String pesquisa){
        String sql = String.format("select * FROM veiculo where id_locadora = ? and %s like ?", coluna);
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, idLocadora);
            stm.setString(2, "%"+pesquisa+"%");
            
            res = stm.executeQuery();
            
            while(res.next()) {
                VeiculoDTO veiculo = new VeiculoDTO();
                veiculo.setId(res.getInt("id"));
                veiculo.setId_locadora(res.getInt("id_locadora"));
                veiculo.setMarca(res.getString("marca"));
                veiculo.setModelo(res.getString("modelo"));
                veiculo.setAno(res.getString("ano"));
                veiculo.setAcessorios(res.getString("acessorios"));
                veiculo.setCategoria(res.getString("categoria"));
                veiculo.setPreco(res.getString("preco"));
                
                listaVeiculo.add(veiculo);
           }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Pesquisar:" + e);
            
        }
      return listaVeiculo;
    }
    public ArrayList<LocadoraDTO> fitrarPorLocadora(String coluna, String pesquisa){
        String sql = String.format("select * FROM locadora where %s like ?", coluna);
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);

            stm.setString(1, "%"+pesquisa+"%");
            
            res = stm.executeQuery();
            
            while(res.next()) {
                LocadoraDTO locadora = new LocadoraDTO();
                LocalizacaoDTO localizacao = new LocalizacaoDTO();
                locadora.setId(res.getInt("id"));
                locadora.setNome(res.getString("nome"));
                locadora.setCnpj(res.getString("cnpj"));
                locadora.setTelefone(res.getString("telefone"));
                localizacao.setEndereco(res.getString("endereco"));
                localizacao.setBairro(res.getString("bairro"));
                localizacao.setCidade(res.getString("cidade"));
                localizacao.setEstado(res.getString("estado"));
                locadora.setLocalizacao(localizacao);
                locadora.setVeiculos(PesquisarVeiculoLocadora(locadora.getId()));
                
                if(locadora.getVeiculos().size() > 0){
                    lista.add(locadora);
                }
           }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Buscar Locadoras:" + e);
            
        }
      return lista;
    }
    public ArrayList<VeiculoDTO> fitrarPorVeiculo(String coluna, String pesquisa){
        String sql = String.format("select * FROM veiculo where %s like ?", coluna);
        con = new ConexaoDAO().conexao();
        
        try {
            stm = con.prepareStatement(sql);
           
            stm.setString(1, "%"+pesquisa+"%");
            
            res = stm.executeQuery();
            
            while(res.next()) {
                VeiculoDTO veiculo = new VeiculoDTO();
                veiculo.setId(res.getInt("id"));
                veiculo.setId_locadora(res.getInt("id_locadora"));
                veiculo.setMarca(res.getString("marca"));
                veiculo.setModelo(res.getString("modelo"));
                veiculo.setAno(res.getString("ano"));
                veiculo.setAcessorios(res.getString("acessorios"));
                veiculo.setCategoria(res.getString("categoria"));
                veiculo.setPreco(res.getString("preco"));
                
                listaVeiculo.add(veiculo);
           }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "FuncionarioDAO Pesquisar:" + e);
            
        }
      return listaVeiculo;
    }
}
