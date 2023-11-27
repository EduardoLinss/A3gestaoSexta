package Frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Frames.dependentes.dependentesFrames;
import Frames.requisicao.requisicaoFramePesquisa;



public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    public void iniciar (){

        JPanel info = new JPanel();
        info.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel menuInfo = new JLabel("Menu", SwingConstants.CENTER);
        menuInfo.setFont(mainFont);

        JButton btnUbs = new JButton("Consultar UBS'S");
       btnUbs.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              ubsFrame inicaUbs = new ubsFrame();

              inicaUbs.iniciarUbs();
              dispose();

            } 
        });

        JButton btnrequisicao = new JButton("Vacinas em outros paises");
        btnrequisicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               /*  requisicaoFrame inicaReq = new requisicaoFrame();
                inicaReq.iniciarReq();*/

                requisicaoFramePesquisa chama = new requisicaoFramePesquisa();
                chama.pesquisar();
                dispose();
                
            }
            
        });

        JButton btnAlerta = new JButton("Próximas vácinas");
        btnAlerta.setBounds(10, 10, 10, 10);
        btnAlerta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              alertaFrame iniciaAlerta = new alertaFrame();
              iniciaAlerta.iniciaAlerta();
              dispose();
            }
            
        });

        JButton btnDependentes = new JButton("Dependentes");
        btnDependentes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dependentesFrames iniciaDependentes = new dependentesFrames();
                iniciaDependentes.iniciaDependentes();
                dispose();
            }
            
        });

        JButton btnCaderneta = new JButton("Caderneta");
        btnCaderneta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            cadernetaFrame botaoCaderneta = new cadernetaFrame();
            botaoCaderneta.Caderneta();
            }

        });
    
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());      
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
       
        buttonsPanel.setBounds(10, 10, 30, 30);
        buttonsPanel.add(btnUbs);
        buttonsPanel.add(btnrequisicao);
        buttonsPanel.add(btnAlerta);
        buttonsPanel.add(btnDependentes);
        buttonsPanel.add(btnCaderneta);
      
        add(info, BorderLayout.NORTH);
        add(buttonsPanel, BoxLayout.X_AXIS);

        setTitle("dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 550);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}
