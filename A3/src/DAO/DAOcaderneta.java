package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import entidade.caderneta;
import entidade.dependentes;

public class DAOcaderneta {
       public void CadastraDependentes(caderneta caderneta){
        String sql = "insert into caderneta (NomeVacina, dataAplic, dose, local, cidade) values (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {

            if (ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, caderneta.getNome());
            ps.setString(2, caderneta.getDataAplic());
            ps.setString(3, caderneta.getDose());
            ps.setString(4, caderneta.getLocal());
            ps.setString(5, caderneta.getCidade());
            

            ps.execute();
            ps.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    public void AtualizaDependentes(caderneta caderneta){
        String sql = "update caderneta SET NomeVacina=?, dataAplic=?, dose=?, local=?, cidade = ?  WHERE id = ?";

        PreparedStatement ps=null;

        try{
            if (ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
            ps.setString(1, caderneta.getNome());
            ps.setString(2, caderneta.getDataAplic());
            ps.setString(3, caderneta.getDose());
            ps.setString(4, caderneta.getLocal());
            ps.setString(5, caderneta.getCidade());
            
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

         public static List<caderneta> consultaCaderneta() throws Exception{
        List <caderneta> list = new ArrayList<caderneta>();
        
        String sql = "select * from caderneta";

       PreparedStatement ps = null;
       ResultSet scann = null;
        try{
            if(ps == null){
                ps = Conexao.openDatabase().prepareStatement(sql);
                scann = ps.executeQuery();
                while (scann.next()) {
                    caderneta caderneta = new caderneta(0, sql, sql, sql);
                    caderneta.setNome(scann.getString("NomeVacina"));
                    caderneta.setDataAplic(scann.getString("dataAplic"));
                    caderneta.setDose(scann.getString("dose"));
                    caderneta.setLocal(scann.getString("local"));
                    caderneta.setCidade(scann.getString("cidade"));
                    list.add(caderneta);
                   
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ps.close();
        }
        return list;
    }
}
