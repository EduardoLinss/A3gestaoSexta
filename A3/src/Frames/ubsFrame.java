package Frames;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import DAO.DAOubs;
import entidade.ubs;

public class ubsFrame extends JFrame {
   // final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);

    public void iniciarUbs(){
         JPanel infos = new JPanel();
       // ubs ubs = new ubs();
      // DAOubs ubs = new DAOubs();

       for (ubs u : DAOubs.getUbs()) {
        infos.setLayout(new GridLayout(0, 4, 5, 5));
        infos.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        infos.add(new JLabel("Endereco"));
        infos.add(new JLabel(u.getEndereco()));
        infos.add(new JLabel("cep"));
        infos.add(new JLabel(u.getCep()));

        Component[] labels = infos.getComponents();
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));

       }
        
    }   

    add(infos, BorderLayout.NORTH);
    
     setTitle("dashboard");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setSize(1100, 650);
    setLocationRelativeTo(null);
    setVisible(true);
}


}
