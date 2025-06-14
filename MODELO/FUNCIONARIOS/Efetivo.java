//A classe Efetivo é uma classe concreta que é subclasse de Docente

package MODELO.FUNCIONARIOS;
import ARMAZENAMENTO.ConstantesDoSistema;

public class Efetivo extends Docente //o extends indica o mecanismo de heranca
{
    /*Como a classe Efetivo, uma classe concreta, estende da Docente
    ela herda os atributos e metodos de Docente*/
    //Os atributos herdados: nome, codigo, salario, nivel, titulacao

    protected String area; //Novo atributo em relacao à classe Docente

    //Construtores
    public Efetivo()
    {
        super(); //reutilizacao do construtor da SuperClasse Docente
        this.area = "INDEFINIDA";
    }

    public Efetivo(String nome, String codigo, double salario, String nivel, String titulacao, String area)
    {
        super(nome, codigo, salario, nivel, titulacao); //reutilizacao do construtor com parametros da SuperClasse Docente
        this.area = area;
    }

    @Override //Sobrescrita do metodo calcularSalarios()
    public double calcularSalarios()
    {
        return (salario + salario*ConstantesDoSistema.getAdicionalDocenteEfetivo(nivel) + ConstantesDoSistema.ADICIONAL_EFETIVO); 
        //salario + (5% ou 10% ou 20%) do salario de acordo com o nivel + 5% do salario do profissional Docente Efetivo
    }

    @Override //Sobrescrita do metodo exibir()
    public void exibir()
    {
        super.exibir(); //Invoco o metodo exibir da superclasse (Docente)
        System.out.println("AREA: "+area);
    }

    @Override
    public String getTipo()
    {
        return "Docente Efetivo"; 
    }

    //Setter e Getter
    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
 }
