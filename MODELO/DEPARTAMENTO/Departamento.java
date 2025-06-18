package MODELO.DEPARTAMENTO; //Observe pelo diagrama de classes que departamento possui um vetor de funcionarios

/**
 *
 * @author yanma
 */

import MODELO.FUNCIONARIOS.Efetivo;
import MODELO.FUNCIONARIOS.Funcionario;
import MODELO.FUNCIONARIOS.Substituto;
import MODELO.FUNCIONARIOS.Tecnico;

public class Departamento
{
    private String nome;
    private String codigo;
    private Funcionario[] funcionarios; //Atributo que define que teremos um vetor de ponteiros do tipo Funcionario
    private int contador; //Variavel auxiliar que conta os elementos inseridos no vetor e armazena qual a proxima posicao disponivel para insercao
    private int MAXIMO; //Nos diz qual o maximo de elementos do tipo Funcionario o nosso vetor de ponteiros pode ter

    //Construtores

    public Departamento() //Sem parametros
    {
        this.codigo = "INEXISTENTE";
        this.nome = "VAZIO";
        this.MAXIMO = 50; //definimos uma quantidade padrao de funcionarios, valor decidido arbitrariamente
        funcionarios = new Funcionario[MAXIMO]; //criacao do vetor de ponteiros do tipo Funcionario
        this.contador = 0; //inicializacao da variavel contador
    }
    
    public Departamento(String nome, String codigo)
    {
        this.nome = nome;
        this.codigo = codigo;
        this.MAXIMO = 50; //definicao do maximo de elementos
        funcionarios = new Funcionario[MAXIMO]; //Criacao do vetor de ponteiros do tipo funcionario
        this.contador = 0; //Inicializacao da variavel contador
    }

    public Departamento(String nome, String codigo, int MAXIMO) ///com parametros
    {
        this.nome = nome;
        this.codigo = codigo;
        this.MAXIMO = MAXIMO; //definicao do maximo de elementos
        funcionarios = new Funcionario[MAXIMO]; //Criacao do vetor de ponteiros do tipo funcionario
        this.contador = 0; //Inicializacao da variavel contador
    }

    //Metodos

    //Adicao e remocao de funcionarios (Generico)

    public void adicionaFuncionario (Funcionario funcionario)
    {
        if (contador < MAXIMO) //So permito que adicione caso nao tenha o maximo de funcionarios armazenados
        {
            funcionarios[contador++] = funcionario; //polimorfismo
            //Ja aproveito e incremento a variavel contador (incrementacao a posteriori)
            System.out.println("SUCESSO AO ADICIONAR O FUNCIONARIO\n");
            return; //finalizo o metodo, ja que ja adicionei o funcionario
        }
        System.out.println("ERRO! DEPARTAMENTO NA CAPACIDADE MAXIMA DE FUNCIONARIOS!");
    }

    //Adiciona funcionario especifico (Docente, tecnico ou Substituto)

    //Comecando com adicionar tecnico
    public void adicionaFuncionarioTecnico(Tecnico tecnico)
    {
        if (contador < MAXIMO)
            adicionaFuncionario(tecnico); //Polimorfismo, visto que tecnico extends de funcionario
    }

    //Metodo para adicionar professor Docente
    public void adicionaFuncionarioDocenteEfetivo(Efetivo efetivo)
    {
        if (contador < MAXIMO)
            adicionaFuncionario(efetivo); //Polimorfismo: efetivo extends docente, e docente extends funcionario

    }

    public void adicionaFuncionarioDocenteSubstituto(Substituto substituto)
    {
        if (contador < MAXIMO)
            adicionaFuncionario(substituto); //Polimorfismo: substituto extends docente, e docente extends funcionario
    }

    //Remocao de funcionarios
    public void removeFuncionario(String codigo) //Nossa chave de busca para remocao sera o codigo de cada funcionario
    {
        if (contador > 0) //Procuro apenas se ha algum funcionario inserido no departamento
        {
            //Nao usaremos for each, visto que precisamos do indice para remocao do elemento (que sera o indice i)
            for (int i = 0; i < contador; i++)
            {
                if (funcionarios[i].getCodigo().equals(codigo)) //Se encontrei o funcionario a ser removido
                {
                    for (int j = i; j < contador - 1; j++) //Iremos mover os elementos do vetor para a esquerda
                    //j vai ate contador - 1, pois tiramos um elemento do vetor
                    {
                        funcionarios[j] = funcionarios[j + 1]; //Move os elementos para a esquerda (ocupando a posicao que foi "removida")
                    }

                    funcionarios[contador] = null; //Atualizo a ultima posicao do vetor, devido à movimentacao para a esquerda
                    contador--; //Atualizo a quantidade de elementos no departamento
                    System.out.println("REMOCAO BEM SUCEDIDA!");
                    return; 
                }
            }
            System.out.println("FALHA NA REMOCAO! FUNCIONARIO NAO ENCONTRADO");
            return;
        }
        System.out.println("ERRO! NAO HA NENHUM FUNCIONARIO NO DEPARTAMENTO");
    }

    //Busca de funcionarios

    //Metodo para buscar funcionarios pelo codigo

    public Funcionario BuscaFuncionarioPorCodigo(String codigo) //Retorna um ponteiro do tipo Funcionario
    {
        if (contador > 0) //So procuro no array se tiver funcionario --> evita custo computacional
        {
            for (Funcionario func: funcionarios) //for each --> for (tipo elemento: vetor_ou_colecao)
            {
                if (func != null && func.getCodigo().equals(codigo)) //se o codigo do funcionario for igual ao codigo procurado
                {
                    return func; //retorno o ponteiro
                }
            }
        }
        
        return null; //retorno null (nao encontrado)

    }

    //Metodo para Buscar um funcionario pelo nome

    public Funcionario buscaFuncionarioPorNome(String nome) // Retorna um ponteiro do tipo Funcionario
    {
        if (contador > 0) //So busco se o array de funcionarios ter funcionarios
        {
            for (Funcionario func: funcionarios)
            {
                if (func != null && func.getNome().equalsIgnoreCase(nome)) //Se o nome do funcionario func for igual à chave procurada (ignorando se eh maiuscula ou minuscula)
                {
                    return func; //entao retorno o ponteiro para esse funcionario
                }
            }
        }

        return null; //Caso nao encontre o funcionario no vetor, retorna null

    }

    //Metodos de informacoes a respeito do departamento

    public double calcularTotalGasto()
    {
        double soma = 0; 
            for (Funcionario func: funcionarios) //for each (Tipo elemento: vetor_ou_colecao)
            {
                if (func != null) //Evitamos o Null Pointer Exception
                {
                    soma += func.calcularSalarios();
                }
            }
        return soma;
    }

    public void resumoDoDepartamento()
    {
        System.out.println("========= DEPARTAMENTO =========");
        System.out.println("NOME: "+nome);
        System.out.println("NUMERO DE FUNCIONARIOS: "+contador);
        System.out.println("GASTO TOTAL: R$"+ calcularTotalGasto());
    }

    public void Exibir_Informaceos_Do_Departamento(String codigo) //Recebe o codigo do Departamento como parametro para busca
    {
        System.out.println("======== TODAS AS INFORMACOES DO DEPARTAMENTO =========");
        System.out.println("NOME DO DEPARTAMENTO: "+nome);
        System.out.println("CODIGO: " +codigo);
        System.out.println("GASTO TOTAL: R$ "+calcularTotalGasto());

        System.out.println("========= FUNCIONARIOS =========");

        for (Funcionario func: funcionarios) //for each --> for (Tipo elemento: Array_ou_colecao)
            if (func != null)
                func.exibir(); //Polimorfismo: o metodo se comporta de acordo com o tipo de objeto instanciado: tecnico, efeitvo ou substituto

    }
    
    public void exibeTodosFuncionariosDoDepartamento()
    {
        for (Funcionario func: funcionarios)
        {
            if (func != null)
                func.exibir(); //Exibe as informacoes dos funcionarios, desde que o ponteiro nao seja nulo
        }
    }
    //Getters e Setters

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
    
    //Getters do vetor de ponteiros do tipo Funcionario
    public Funcionario[] getFuncionarios()
    {
        return funcionarios;
    }
    
    public int getContador()
    {
        return contador;
    }
    
    public int getMAXIMO()
    {
        return MAXIMO;
    }

}
