package Frames.requisicao;

import javax.swing.*;

import Conexao.Conexao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DAOrequisicao;

import entidade.requsicao;

public class requisicaoFrame extends JFrame {
    JTextField tfpesquisa;

    public void iniciarReq(){
         JPanel infos = new JPanel();

           
           
           for (requsicao u : DAOrequisicao.getRequsicaos()) {
            infos.setLayout(new GridLayout(0, 2, 5, 5));
            infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
            infos.add(new JLabel("Pais"));
            infos.add(new JLabel(u.getnomePais()));
            infos.add(new JLabel("Vacinas necessárias"));
            infos.add(new JLabel(u.getVacinas()));

            Component[] labels = infos.getComponents();
            for (int i = 0; i < labels.length; i++) {
                labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));

        }
    
            
        }
  
    JButton btnVoltar = new JButton("Voltar");
    btnVoltar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           
         
         dispose();
            
        }
        
    });

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
 
    buttonsPanel.add(btnVoltar);
   

    //add(botaoDePesquisa, BorderLayout.SOUTH);
    add(infos, BorderLayout.NORTH);
    add(buttonsPanel, BorderLayout.SOUTH);
    //add(btnVoltar, BorderLayout.SOUTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
    }

    
    /*private static boolean pesquisar(String pesquisa) throws SQLException{
            String sql = "select * from requisicao where NomePais= ? ";
            PreparedStatement ps = null;
            ResultSet scan = null;
            try{
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, pesquisa);
                //ps.setString(2, password);
                scan = ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return scan.next();
    }*/

    
}
