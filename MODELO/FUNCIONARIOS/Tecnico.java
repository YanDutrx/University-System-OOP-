package MODELO.FUNCIONARIOS;
import ARMAZENAMENTO.ConstantesDoSistema;

public class Tecnico extends Funcionario //Mecanismo de heranca com a notacao "extends"
{
    //Herda os mesmos atributos de Funcionario (nome, codigo, salario e nivel)
    //definiremos um novo atributo, requerido pelo exercicio: funcao do tecnico
    protected String funcao;

    //Criacao de Construtores
    public Tecnico()
    {
        super(); //Retoma o construtor da Superclasse
        this.funcao = "INDEFINIDO";
    }

    public Tecnico(String nome, String codigo, double salario, String nivel, String funcao)
    {
        super(nome, codigo, salario, nivel); //Utiliza o construtor da Superclasse
        this.funcao = funcao;
    }

    //Sobrescrita(@Override) do metodo exibir
    @Override
    public void exibir()
    {
        super.exibir(); //Reaproveitamento: chama o codigo da Superclasse
        System.out.println("FUNCAO: "+funcao); //Adiciona uma informacao escrita
    }

    @Override //Sobrescrita do metodo calcularSalarios()
    public double calcularSalarios()
    {
       return (salario + salario*ConstantesDoSistema.getAdicionalTecnico(nivel)); 
       //Salario total = salario_base + adicional_do_nivel (10% ou 20%) em cima do salario base ==> salario_total = salario_base + salario*bonus_nivel
    }

    @Override //Sobrescrita do metodo (polimorfismo) herdado da super
    public String getTipo() //Getter para recuperarmos a informação do tipo de funcionario, que retorna uma String
    {
        return "Tecnico";
    }
}