//import Conexao.Conexao;
//import javax.sql.RowSetInternal;

import DAO.DAOalerta;
import DAO.DAOlogin;
//import DAO.DAOrequisicao;
//import DAO.DAOlogin;
//import DAO.DAOubs;
import entidade.login;
import entidade.alerta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import entidade.login;
//import entidade.requsinfcao;
//import entidade.ubs;
import java.util.Scanner;

import Conexao.Conexao;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        try{
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu email");
        String x = sc.next();
        System.out.println("Digite a senha");
        String y = sc.next();
        if(validarLogin(x, y)){
            System.out.println("login efetuado"+"\n");

            System.out.println("Esocolha a opcao desejada"+"\n");
            System.out.println("1 - Para Consultar a caderneta de vacinas "+"\n");
            System.out.println("2 - Para ver as proximas vacinas "+"\n");
            System.out.println("3 - Para consultar vacinas obrigatorias em outros paises"+"\n");
            System.out.println("4 - Para consultar pontos de aplicação de vacinas"+"\n");
            System.out.println("5 - Para cadastrar/consultar dependentes"+"\n");
            System.out.println("6 - Para consultar vacinas e seu tratamento"+"\n");
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    
                    break;
                case 2:
                DAOalerta alerta = new DAOalerta();
                for (alerta scanner : DAOalerta.consultaAlertas()) {
                    System.out.println(scanner.getNomeVacina() + scanner.getDataProx());
                }

            
                default:
                    break;
            }
            }else{
            System.out.println("login não encontrado");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }






        //login u = new login();
       /*  u.setNome("Mauricio");
        u.setSenha("pao");
        u.setEmail("Maurico123@gmail.com");
        u.setCpf("458.564.565-78");
        u.setDataNasc("14/12/189");
*
        new insert().CadastrarUsuario(u);*/
    /*u.setId(1);
    u.setNome("Ronaldo");

    new DAOlogin().AtualizarCadastro(u);*/

   

    /*for (ubs c: DAOubs.getUbs()){
        System.out.println("endereco " + c.getEndereco() + "Cep" + c.getCep());
        }
    }*/
   

    
    
}
private static boolean validarLogin(String email, String senha) throws SQLException{
            String sql = "select * from login where email = ? and senha = ? ";
            PreparedStatement ps = null;
            ResultSet scan = null;
            try{
                ps = Conexao.openDatabase().prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, senha);
                scan = ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return scan.next();
    }
}


