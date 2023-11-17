package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexao.Conexao;
import entidade.dependentes;

public class DAOdependentes {
    
    public void CadastraDependentes(dependentes dependentes){
        String sql = "insert into dependentes (nome, cpf, idade) values (?, ?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, dependentes.getNome());
            ps.setString(2, dependentes.getCpf());
            ps.setString(3, dependentes.getIdade());
            

            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void AtualizaDependentes(dependentes dependentes){
        String sql = "update dependentes SET nome=?, cpf=?, idade=?  WHERE id = ?";

        PreparedStatement ps=null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, dependentes.getNome());
                ps.setString(2, dependentes.getCpf());
                ps.setString(3, dependentes.getCpf());
                ps.setInt(2, dependentes.getId());
                ps.execute();
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    public void DeletaDependentes(dependentes dependentes){
        String sql = "Delete from dependentes Where id =?";

        PreparedStatement  ps = null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setInt(1, dependentes.getId());
                ps.execute();
                ps.close();
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
}
