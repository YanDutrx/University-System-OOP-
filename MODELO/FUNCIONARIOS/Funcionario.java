
package MODELO.FUNCIONARIOS;

    public abstract class Funcionario 
    {
    // Definindo, a priori, os atributos
    protected String nome; // Sao protected para membros da mesma classe terem acesso
    protected String codigo;
    protected double salario;
    protected String nivel;

    //Construtores (Sem parametros e Com parametros)

    public Funcionario() //Sem parametros
    {
        this.nome = "INDEFINIDO";
        this.codigo = "INDEFINIDO";
        this.salario = 0.0;
        this.nivel = "INDEFINIDO";
    }

    public Funcionario(String nome, String codigo, double salario, String nivel) //Com parametros
    {
        this.nome = nome;
        this.codigo = codigo;
        this.salario = salario;
        this.nivel = nivel;
    }

    //Implementaremos o metodo para facilitar o @Override em mecanismo de heranca e polimorfismo
    public void exibir() {
        System.out.println("NOME: " +nome);
        System.out.println("CODIGO: "+codigo);
        System.out.println("SALARIO: R$ "+calcularSalarios());
        System.out.println("NIVEL: "+nivel);
    }
    
    

    //Metodos abstratos
    public abstract double calcularSalarios(); // forca que apareça nas classes filhas
    public abstract String getTipo(); 

    // getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
