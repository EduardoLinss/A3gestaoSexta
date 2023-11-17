package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import entidade.requsicao;

public class DAOrequisicao {
    

    /**
     * @return
     */
    public static List<requsicao> getRequsicaos(){
        List <requsicao> dados = new ArrayList<requsicao>();
        String sql = "select * from requisicao";

       PreparedStatement ps = null;
       ResultSet scann = null;
  
       try{
        if(ps == null){
            ps = Conexao.openDatabase().prepareStatement(sql);
            scann = ps.executeQuery();
            while (scann.next()) {
                requsicao requsicao = new requsicao(0, sql, sql);
                requsicao.setId(scann.getInt("id_pais"));
                requsicao.setnomePais(scann.getString("NomePais"));
                requsicao.setVacinas(scann.getString("vacinas"));

                dados.add(requsicao);
            }
        }
       }catch (SQLException e){
            e.printStackTrace();
       }finally{
        try{
            if (scann != null){
                scann.close();
            }
            if (ps != null){
                ps.close();
            }
            
        }catch(SQLException e){
        e.printStackTrace();
       }
       }
       return dados;
    }

}