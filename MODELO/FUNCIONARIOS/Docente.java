//A classe abaixo é referente aos Docentes, sendo necessaria ser abstrata (nao pode ser instanciada)
//Pelo diagrama, a classe Docente é classe filha da classe Funcionario

package MODELO.FUNCIONARIOS;


public abstract class Docente extends Funcionario //herda a classe funcionario
{
    //Definicao dos atributos, além dos ja herdados da classe Funcionario (codigo, nome, salario, nivel)
    protected String titulacao;

    //Definicao dos construtores
    
    public Docente() //Sem parametros
    {
        super(); //reuso do construtor da Superclasse Funcionario
        this.titulacao = "INDEFINIDO";
    }

    public Docente(String nome, String codigo, double salario, String nivel, String titulacao)
    {
        super(nome, codigo, salario, nivel); //reuso do construtor da Superclasse Funcionario
        this.titulacao = titulacao;
    }

    @Override
    public abstract double calcularSalarios(); //Nao definiremos a priori, apenas nas classes filhas

    //Getters e setters
    public void setTitulacao(String titulacao)
    {
        this.titulacao = titulacao;
    }

    public String getTitulacao()
    {
        return titulacao;
    }

    @Override //Sobrescrita do metodo exibir --> polimorfismo
    public void exibir()
    {
        super.exibir();
        System.out.println("TITULACAO: "+titulacao);
    }

}