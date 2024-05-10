import java.util.ArrayList;
import java.util.List;

import Individuos.Funcionario;

public class Cadastro {
    private static List <Funcionario> listaFuncionarios = new ArrayList<>();
    public static Object getListaFuncionarios;


    public static void cadastrar(Funcionario funcionario){
        listaFuncionarios.add(funcionario);
    }

    public static Funcionario buscar(String matricula){

        for (Funcionario funcionarioTemporario : listaFuncionarios){

            if (funcionarioTemporario.getMatricula() == matricula) {
                return funcionarioTemporario;
            }
        }
        return null;
    }
    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

}