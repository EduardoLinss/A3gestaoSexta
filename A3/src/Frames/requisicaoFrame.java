package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.DAOrequisicao;

import entidade.requsicao;

public class requisicaoFrame extends JFrame {
    

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

    add(infos, BorderLayout.NORTH);
    add(btnVoltar, BorderLayout.SOUTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
    }
}
