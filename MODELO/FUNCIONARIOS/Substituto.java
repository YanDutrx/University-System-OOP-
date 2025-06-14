//A classe substituto, pelo diagrama, é uma subclasse de Docente

package MODELO.FUNCIONARIOS;
import ARMAZENAMENTO.ConstantesDoSistema;


public class Substituto extends Docente //Mecanismo de heranca
{
    //Incorpora os atributos definidos em DOcente
    protected int cargaHoraria; //Atributo "novo" - exclusivo da classe

    //Construtores
    public Substituto()
    {
        super(); //reutilizacao do construtor da SuperClasse
        this.cargaHoraria = 0;
    }

    public Substituto(String nome, String codigo, double salario, String nivel, String titulacao, int cargaHoraria)
    {
        super(nome, codigo, salario, nivel, titulacao); //reutilizacao do construtor da Superclasse
        this.cargaHoraria = cargaHoraria;
    }

    //Metodos do exercicio

    @Override
    public void exibir() //Polimorfismo
    {
        super.exibir();
        System.out.println("Carga Horaria: "+cargaHoraria);
    }

    @Override
    public double calcularSalarios()
    {
        return (salario + salario*ConstantesDoSistema.getAdicionalDocenteSubstituto(nivel));
        //retorna o salario base + (5% ou 10%) do salario base
    }

    @Override
    public String getTipo()
    {
        return "Docente Substituto";
    }

    //Setter e Getter
    public void setCargaHoraria(int cargaHoraria)
    {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria()
    {
        return cargaHoraria;
    }


}