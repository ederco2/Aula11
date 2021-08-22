import model.Diretor;
import model.Funcionario;
import repository.DiretorRepository;
import repository.FuncionarioRepository;
import service.DiretorService;
import service.FuncionarioService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String comando;
        comando="12";
        System.out.println("Comando: "+comando.substring(0,1));
        if (comando.substring(0,1).equals("1")) {
            System.out.println("Entrou no insert...");
            //---INSERT DIRETOR
            Funcionario funcionario = new Funcionario(1, "Eder Cabral", "04371939937", 1200.00);
            FuncionarioService service = new FuncionarioService();
            service.save(funcionario);

            //--INSERT DIRETOR
            Diretor diretor = new Diretor(1, "Oliveira & Cabral", "0033928933", 4500.00, 1200.00);
            DiretorService service1 = new DiretorService();
            service1.save(diretor);

            if (comando.substring(1, 2) == "11") {
                //--UPDATE FUNCIONARIOS
                funcionario.setNome(funcionario.getNome() + " - alterado");
                funcionario.setSalario(funcionario.getSalario() + 400.00);
                service.update(funcionario);


                //--UPDATE DIRETOR
                diretor.setNome(diretor.getNome() + " - alterado");
                diretor.setSalario(diretor.getSalario() + 350.00);
                service1.update(diretor);
            }
            //--SELECT Funcionarios/Diretor--------------------------------------
            FuncionarioRepository repository = new FuncionarioRepository();
            //repository.findAll();
            repository.findById(1);

            //--SELECT Diretor--------------------------------------
            DiretorRepository repository1 = new DiretorRepository();
           // repository1.findAll();
            repository1.findById(1);
        }

    }
}