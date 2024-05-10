package Individuos;

public class Estagiario extends Funcionario{
    private Float hrsTrabalho;
    private String supervisor;

    public Estagiario(){}

    public Estagiario(String nome, String matricula, float salario, float hrsTrabalho, String supervisor) {
        super(nome, matricula, salario);
        this.hrsTrabalho = hrsTrabalho;
        this.supervisor = supervisor;
    }


    public Float getHrsTrabalho() {
        return hrsTrabalho;
    }
    public void setHrsTrabalho(Float horasDeTrabalho) {
        this.hrsTrabalho = horasDeTrabalho;
    }


    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    @Override
    public String toString() {
        System.out.println("\n--ESTAGIARIO--");
        return super.toString() + "\nHoras de Trabalho: " + hrsTrabalho + "\nSupervisor: " + supervisor;
    }


    @Override
    public String trabalhar() {
        return "\nO estagiario " + getNome() + " esta aprendendo a trabalhar!";
    }

    @Override
    public String relatarProgresso() {
        return "\nO estagiario " + getNome() + " esta indo bem no trabalho, sob a supervisao do " + supervisor + ".\n----------";
    }

    @Override
    public float calcularSalario() {
        return getSalario() * hrsTrabalho;
    }
}