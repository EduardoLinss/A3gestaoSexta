//import Conexao.Conexao;
//import javax.sql.RowSetInternal;

import DAO.DAOalerta;
import DAO.DAOdependentes;
import DAO.DAOlogin;
import DAO.DAOrequisicao;
import DAO.DAOubs;
import DAO.DAOvacinas;
import entidade.dependentes;
import entidade.vacinas;
//import DAO.DAOrequisicao;
//import DAO.DAOlogin;
//import DAO.DAOubs;
import entidade.login;
import entidade.alerta;
import entidade.requsicao;
import entidade.ubs;
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
                case 3:
                DAOrequisicao requisicao = new DAOrequisicao();
                for(requsicao scanner : DAOrequisicao.getRequsicaos()){
                    System.out.println(scanner.getnomePais() + scanner.getVacinas());
                }
                case 4:
                //DAOubs ubs = new DAOubs();
                for (ubs scanner : DAOubs.getUbs()) {
                    System.out.println(scanner.getEndereco() + scanner.getCep());
                }
                case 5:
                DAOdependentes dependentes = new DAOdependentes();
                dependentes u = new dependentes();

                System.out.println("1 - Para ver dependentes"+"\n");
                System.out.println("2 - Para cadastrar dependentes");
                int escolhaDependentes = sc.nextInt();

                switch (escolhaDependentes) {
                    case 1:
                        for (dependentes scanner : DAOdependentes.consultaDependentes()) {
                            System.out.println(scanner.getNome()+scanner.getCpf()+scanner.getIdade());
                        }
                        break;
                    case 2 :
                    

                    System.out.println("Digite o nome");
                    String nome = sc.next();
                    System.out.println("Digite o cpf ");
                    String cpf = sc.next();
                    System.out.println("Digite a idade");
                    String idade = sc.next();
                    
                    u.setNome(nome);
                    u.setCpf(cpf);
                    u.setIdade(idade);

                    dependentes.CadastraDependentes(u);
                
                    default:
                        break;
                }
                case 6:
                DAOvacinas vacinas = new DAOvacinas();
                for (vacinas scanner : DAOvacinas.getVacinas()) {
                    System.out.println(scanner.getNomeVacina()+ scanner.getTratamento());
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


