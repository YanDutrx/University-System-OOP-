//A classe universidade possui um vetor de departamentos

package MODELO.UNIVERSIDADE;
import MODELO.DEPARTAMENTO.Departamento;

public class Universidade
{
    private String nome;
    private Departamento[] departamentos; //Atributo que sera um vetor de departamentos
    private int contDep; //Variavel auxiliar contadora de departamentos na Universidade
    private int MAXDep; //Variavel de controle para armazenarmos o maximo de departamentos

    //Construtores
    public Universidade()
    {
        this.nome = "UNESP";
        this.MAXDep = 12; //Definindo um valor padrao
        departamentos = new Departamento[MAXDep]; //Instanciacao de um vetor de objetos
        this.contDep = 0; //Ainda nao existe nenhum departamento cadastrado
    }

    public Universidade(String nome, int MAXDep) //Se o usuario escolher um Maximo de Departamentos
    {
        this.nome = nome;
        this.MAXDep = MAXDep;
        departamentos = new Departamento[MAXDep];
        this.contDep = 0;
    }

    //Metodos

    //Gasto total de todos os departamentos juntos
    public double gastoTotalUniversidade()
    {
        int somatorio = 0;
        for (Departamento depto: departamentos)  //for each
        {
            if (depto != null) //evita null pointer exception
            {
                somatorio += depto.calcularTotalGasto();
            }
        }
    return somatorio;
    }

    //Busca de departamento
    public Departamento buscaDepartamentoPorCodigo(String codigo) //retorna um ponteiro do tipo Departamento
    {
        if (contDep > 0) //Ha departamentos para realizarmos a busca
        {
            for (Departamento depto: departamentos) //for each
            {
                if(depto != null) //Evitamos o null pointer exception
                {
                    if (depto.getCodigo().equalsIgnoreCase(codigo))
                        return depto; //retorno o ponteiro para o meu departamento buscado
                }
            }
        }

        System.out.println("ERRO! NENHUM DEPARTAMENTO CADASTRADO");
        return null; //Entao, como nao ha nenhum departamento com aquele codigo, retorno null
    }

    public Departamento buscaDepartamentoPorNome(String nome)
    {
        if (contDep > 0)
        {
            for (Departamento depto: departamentos) //for each
            {
                if (depto != null) //evita o encerramento por null pointer exception
                {
                    if (depto.getNome().equalsIgnoreCase(nome)) //Ignora o case devido ao possivel esquecimento de um nome maiusculo ou afins
                    {
                        return depto; //retorno o ponteiro para o objeto do tipo Departamento procurado
                    }
                }
            }
        }
        System.out.println("ERRO! NENHUM DEPARTAMENTO CADASTRADO\n");
        return null; //departamento com nome procurado nao foi encontrado
    }

    //Exibicao dos departamentos
    
    public void exibeNomeDosDepartamentos()
    {
        for (int i = 0; i < contDep; i++)
        {
            if (departamentos[i] != null)
                System.out.println("DEPARTAMENTO["+i+"]: " +departamentos[i].getNome());
        }
    }

    public void exibeDepartamentoComGastoEntre(float inicio, float fim)
    {
        if (contDep > 0)
        {
            for (Departamento depto: departamentos) //for each
            {
                if (depto != null) //evita o null pointer exception
                {
                    if (depto.calcularTotalGasto() > inicio && depto.calcularTotalGasto() < fim) //Exibe se estiver na faixa [inicio, fim]
                    {
                        depto.resumoDoDepartamento();
                    }
                }
            }
        }
    }


    public void resumoDosDepartamentos()
    {
        System.out.println("======= RESUMO DOS DEPARTAMENTOS ======");
        if (contDep > 0)
        {
            for (Departamento depto: departamentos) //for each
            {
                if (depto != null)
                    depto.resumoDoDepartamento();
            }
        }
        else
        {
            System.out.println("NENHUM DEPARTAMENTO CADASTRADO!!!");
        }
    }
    
    public void geralUniversidade() //Mostra todas as informações da faculdade
    {
        System.out.println("NOME DA UNIVERSIDADE: "+nome);
        System.out.println("GASTOS COM TODOS OS DEPARTAMENTOS: R$"+gastoTotalUniversidade());
        resumoDosDepartamentos();
    }

    //adicao e remocao dos departamentos

    public void adicionarDepartamento(Departamento departamento)
    {
        if (contDep < MAXDep) //Se ainda nao atingi a quantidade maxima de departamentos, posso inserir
        {
            departamentos[contDep++] = departamento; //Adiciono o departamento e ja incremento a quantidade
            System.out.println("DEPARTAMENTO CADASTRADO COM SUCESSO!");
        }
        else
        {
            System.out.println("ERRO! QUANTIDADE MAXIMA DE DEPARTAMENTO JA ATINGIDAS\n");
        }
    }

    public void removeDepartamento(String codigo)
    {
        if (contDep > 0) //Posso remover se haver algum departamento
        {
            for (int i = 0; i < contDep; i++)
            {
                if(departamentos[i].getCodigo().equalsIgnoreCase(codigo)) //se o departamento no vetor de departamentos tiver o codigo procurado
                {
                    for (int j = i; j < contDep - 1; j++) //ContDep - 1 pq a ultima posicao vai ficar "livre/limpa"
                    {
                        departamentos[j] = departamentos[j + 1]; //Passo os departamentos para a esquerda (shift to left)
                    }

                    departamentos[--contDep] = null; //Defino o ponteiro do ultimo elemento (a ser limpo) como null
                    //Decremento a quantidade de departamentos e defino o penultimo indice como null

                    System.out.println("DEPARTAMENTO REMOVIDO COM SUCESSO!");
                    return; //Termino o metodo aqui
                }
            }
            System.out.println("NENHUM DEPARTAMENTO COM O CODIGO ENCONTRADO!"); //Se passou pelo loop, nao encontrou o codigo
        }
        else
        {
            System.out.println("ERRO! NADA A SER REMOVIDO");
        }
    }

    //Getter e setters
    public String getNome()
    {
        return nome;
    }
    
    public int getMAXDep()
    {
        return MAXDep;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getContDep() //Metodo que retorna a quantidade de departametnos
    {
        return contDep;
    }

    public Departamento[] getDepartamentos() //retorna um vetor de departamento
    {
        return departamentos;
    }
}

    

