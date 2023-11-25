package Frames;

import javax.swing.*;

import DAO.DAOdependentes;
import entidade.dependentes;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;

public class MenuDependentes extends JFrame {

    JTextField nome;
    JTextField cpf;
    JTextField idade;
    public void cadastra(){

       
        JLabel lbnome = new JLabel("Nome");
        nome = new JTextField();
       nome.setBounds(20, 20, 20, 20);

        JLabel lbcpf = new JLabel("Cpf");
        cpf = new JTextField();

        JLabel lbidade = new JLabel("idade");

        idade = new JTextField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.setBounds(100, 300, 300, 100);
        formPanel.add(lbnome);
        formPanel.add(nome);
        formPanel.add(lbcpf);
        formPanel.add(cpf);
        formPanel.add(lbidade);
        formPanel.add(idade);

        JButton cadastrar = new JButton("Cadastrar");

        cadastrar.addActionListener(new ActionListener() {

            @Override
            
            public void actionPerformed(ActionEvent e) {
           
            DAOdependentes pessoas = new DAOdependentes();
            
            String nomes = nome.getText();
            String cpfs = cpf.getText();
            String idades = idade.getText();
        
            pessoas.CadastraDependentess(nomes, cpfs, idades);

      
        }
        });

        add(formPanel, BorderLayout.NORTH);
        add(cadastrar, BorderLayout.SOUTH);


        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    public void consultaDependentes(){
            JPanel infos = new JPanel();
           
  
        try {
            
            for (dependentes u : DAOdependentes.consultaDependentes()) {
                infos.setLayout(new GridLayout(5, 2, 5, 5));
               infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                infos.add(new JLabel("Nome"));
                infos.add(new JLabel(u.getNome()));
                infos.add(new JLabel("Cpf"));
                infos.add(new JLabel(u.getCpf()));
                infos.add(new JLabel("Idade"));
                infos.add(new JLabel(u.getIdade()));

                
               
                Component[] labels = infos.getComponents();
                for (int i = 0; i < labels.length; i++) {
                    labels[i].setFont(new Font("Arial", Font.BOLD, 18));
                   
               }
                
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        //add(infos, BorderLayout.NORTH );
        add(infos);
       

        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}