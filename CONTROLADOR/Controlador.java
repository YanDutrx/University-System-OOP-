/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR; //Essa classe sera responsavel por ser o controlador do sistema

/**
 *
 * @author yanma
 */

import MODELO.DEPARTAMENTO.Departamento; //Importa TUDO do pacote MODELO.FUNCIONARIOS (Mais pratico do que adicionar passo a passo)
import MODELO.UNIVERSIDADE.Universidade;
import MODELO.FUNCIONARIOS.Docente;
import MODELO.FUNCIONARIOS.Efetivo;
import MODELO.FUNCIONARIOS.Funcionario;
import MODELO.FUNCIONARIOS.Substituto;
import MODELO.FUNCIONARIOS.Tecnico;

public class Controlador
{
    private Universidade universidade; //Defino um atributo do tipo Universidade

    //Definicao do construtor
    public Controlador()
    {
        this.universidade = new Universidade(); //Instancio um novo objeto do tipo Universidade (por padrao, deixo o nome UNESP)
        //Invoca o construtor da classe UNIVERSIDADE
    }

    //Metodos da interface do Controlador
    
    
    //Exibicao
    public void exibirRelatorioGeral()
    {
        System.out.println("===== RELATORIO GERAL DA UNIVERSIDADE =====");
        Departamento[] aux = universidade.getDepartamentos();
        if (aux != null) //Ha departamentos para serem mostrados
        {
            for (Departamento depto: aux) //For each
            {
                if (depto != null) //Evitamos null pointer exception
                {
                    depto.resumoDoDepartamento();

                    Funcionario[] aux_func = depto.getFuncionarios();

                    if (aux_func != null) //evitando null pointer exception
                    {
                        for (Funcionario func: aux_func)
                        {
                            System.out.println("==== INFORMACOES DOS FUNCIONARIOS ====");
                            if (func != null) //Evitando null pointer exception
                            {
                                func.exibir();
                            }
                        }
                    }
                }
            }
            System.out.println("====================================================");
        }
        else
        {
            System.out.println("SISTEMA VAZIO. NADA ARMAZENADO");
        }
    }
    
    
    public void exibeNomeDosDepartamentos()
    {
        universidade.exibeNomeDosDepartamentos();
    }

    public void exibirResumoDepartamento()
    {
        Departamento[] aux = universidade.getDepartamentos();
        if (aux != null) //evita null pointer exception
        {
            System.out.println("==== RESUMO DO DEPARTAMENTO ====");
            for (Departamento depto: aux) //For each
            {
                if (depto != null)
                    depto.resumoDoDepartamento();
            }
        }
        else
        {
            System.out.println("==== NENHUM DEPARTAMENTO CADASTRADO ====");
        }        
    }
    
    public void exibirInformacoesGeraisDoDepartamento(String codigo)
    {
        if (universidade.getContDep() > 0)
        {
            if (universidade.buscaDepartamentoPorCodigo(codigo) != null)
            {
                    Departamento encontrado = universidade.buscaDepartamentoPorCodigo(codigo);                   
                    encontrado.Exibir_Informaceos_Do_Departamento(codigo);
            }
            else
            {
                System.out.println("ERRO! DEPARTAMENTO NAO ENCONTRADO");
            }
        }
        else
        {
            System.out.println("ERRO! NENHUM DEPARTAMENTO FOI INSERIDO!");
        } 
    }

    public void exibirResumoDepartamentoComGastoEntre(float inicio, float fim)
    {
        Departamento[] aux = universidade.getDepartamentos();
        if (aux != null)
        {
            System.out.println("==== RESUMO DE DEPARTAMENTOS COM GASTO ENTRE R$ "+inicio+ " E R$ "+fim);
            for (Departamento depto: aux)
            {
                double gasto = depto.calcularTotalGasto();
                if (gasto >= inicio && gasto <= fim)
                {
                    depto.resumoDoDepartamento();
                }
            }
        }
        else
        {
            System.out.println("NAO HA DEPARTAMENTOS CADASTRADOS");
        }
    }

    public void exibirFuncionariosQueGanhamNaFaixa(float inicio, float fim)
    {
        Departamento[] dep_aux = universidade.getDepartamentos(); //recebo os departamentos da minha univeridadae
        if (dep_aux != null) //evita o null pointer exception
        {
            for (Departamento depto: dep_aux)
            {
                if (depto != null) //Se o departamento existir, entao posso ver de ter 
                {
                    Funcionario[] funcionarios = depto.getFuncionarios();
                   for (int i = 0; i < depto.getContador(); i++)
                   {
                       if (funcionarios[i] != null) //evita o null pointer exception
                       {
                           if (funcionarios[i].getSalario() >= inicio && funcionarios[i].getSalario() <= fim)
                           {
                               funcionarios[i].exibir();
                           }
                       }
                   }
                }
            }
        }
        else
        {
            System.out.println("ERRO! NAO HA FUNCIONARIOS CADASTRADOS");
        }
    }
    
    //Metodos de Busca
    
    //Busca de Departamento
    public void BuscaDepartamentoPorNome(String nome)
    {
        Departamento procurado = universidade.buscaDepartamentoPorNome(nome);
        if (procurado != null) //Encontramos o departamento
        {
            procurado.resumoDoDepartamento();
        }
        else
        {
            System.out.println("DEPARTAMENTO DE NOME" +nome+ "NAO FOI CADASTRADO");
        }
    }
    
    public void BuscaDepartamentoPorCodigo(String codigo)
    {
        Departamento procurado = universidade.buscaDepartamentoPorCodigo(codigo);
        if (procurado != null) //Encontramos o departamento
        {
            procurado.resumoDoDepartamento();
        }
        else
        {
            System.out.println("DEPARTAMENTO DE CODIGO" +codigo+ "NAO FOI CADASTRADO");
        }
    }
    
    //Busca de Funcionarios
    
    public void BuscaFuncionarioPorNome(String nome)
    {
       for (Departamento depto: universidade.getDepartamentos()) //Procuraremos em todos os departamentos da universidade
       {
           if (depto != null) //Evita o null pointer exception
           {
               if (depto.buscaFuncionarioPorNome(nome) != null) //Procuro o funcionario entre os departamentos)
               {
                    Funcionario encontrado = depto.buscaFuncionarioPorNome(nome);
                    System.out.println("=== FUNCIONARIO ENCONTRADO ====");
                    encontrado.exibir();
                    return; //Encerro o metodo
               }
            }  
       }
        System.out.println("Funcionario" +nome+ "NAO encontrado");
       }   
    
    public void BuscaFuncionarioPorCodigo(String codigo)
    {
        for (Departamento depto: universidade.getDepartamentos()) //For each --> vasculha todos os departamentos cadastrados
        {
            if (depto != null) //evitamos o null pointer exception
            {
                if (depto.BuscaFuncionarioPorCodigo(codigo) != null) //Se é diferente de null, entao encontramos o funcionario
                {
                    Funcionario encontrado = depto.BuscaFuncionarioPorCodigo(codigo);
                    System.out.println("=== FUNCIONARIO ENCONTRADO ===");
                    encontrado.exibir();
                    return; //Encerro o metodo
                }
            }
        
        System.out.println("Funcionario com codigo "+codigo+" NAO foi encontrado no sistema");
    }
    }
    
    //Exibe todos os funcionarios de todos os departamentos
    public void exibeTodosFuncionariosDaUniversidade() //emite um relatório geral com todos os funcionários da universidade;
    {
        universidade.geralUniversidade(); //Emite o relatorio geral
        if (universidade.getContDep() > 0)
        {
            Departamento[] departamentos = universidade.getDepartamentos();
            for (Departamento depto: departamentos)
            {
                if(depto != null) //Evitamos o null pointer exception
                    depto.exibeTodosFuncionariosDoDepartamento(); //Exibe os funcionarios de cada departamento
            }
        }
        else
        {
            System.out.println("ERRO! NENHUM DEPARTAMENTO CRIADO --> LOGO, NAO HA FUNCIONARIOS!");
        }
    }
    
    public void exibeTodosTecnicos()
    {
        Departamento[] departamentos = universidade.getDepartamentos();
        if (departamentos != null)
        {
            for (Departamento depto: departamentos) //Procura no array de ponteiros para departamentos
            {
                if (depto != null)
                {
                    Funcionario[] funcionarios = depto.getFuncionarios(); //Em departamentos, procura os funcionarios
                    if (funcionarios != null)
                    {
                        for (Funcionario func: funcionarios) //Vai "andando" dentro do array de funcionarios daquele departamento
                        {
                            if(func != null && func instanceof Tecnico)
                                func.exibir(); //Polimorfismo: se comporta de acordo com o objeto que chamou o metodo
                        }
                    }
                }
            }
        }
    }
    
    public void exibeTodosDocentes()
    {
        Departamento[] departamentos = universidade.getDepartamentos();
        if (departamentos != null)
        {
            for (Departamento depto: departamentos) //Procura no array de ponteiros para departamentos
            {
                if (depto != null)
                {
                    Funcionario[] funcionarios = depto.getFuncionarios(); //Em departamentos, procura os funcionarios
                    if (funcionarios != null)
                    {
                        for (Funcionario func: funcionarios)
                        {
                            if(func != null && func instanceof Docente) //Instanceof avalia se um objeto é de uma classe ou é uma classe filha tambem
                                func.exibir();
                        }
                    }
                }
            }
        }
    }
    
    public void exibeTodosDocentesEfetivos()
    {
        Departamento[] departamentos = universidade.getDepartamentos();
        if (departamentos != null)
        {
            for (Departamento depto: departamentos) //Procura no array de ponteiros para departamentos
            {
                if (depto != null)
                {
                    Funcionario[] funcionarios = depto.getFuncionarios(); //Em departamentos, procura os funcionarios
                    if (funcionarios != null)
                    {
                        for (Funcionario func: funcionarios)
                        {
                            if(func != null && func instanceof Efetivo)
                                func.exibir(); //Polimorfismo
                        }
                    }
                }
            }
        }
    }
    
    public void exibeTodosDocentesSubstitutos()
    {
        Departamento[] departamentos = universidade.getDepartamentos();
        if (departamentos != null)
        {
            for (Departamento depto: departamentos) //Procura no array de ponteiros para departamentos
            {
                if (depto != null)
                {
                    Funcionario[] funcionarios = depto.getFuncionarios(); //Em departamentos, procura os funcionarios
                    if (funcionarios != null)
                    {
                        for (Funcionario func: funcionarios)
                        {
                            if(func != null && func instanceof Substituto)
                                func.exibir();
                        }
                    }
                }
            }
        }
    }
    
    //Metodos para adicionar algo ao sistema
    
    public void adicionaDepartamento(String nome, String codigo)
    {
        if (universidade.getContDep() < universidade.getMAXDep()) //Se ainda ha espaco para adicionar algo à universidade
        {
           Departamento depto = new Departamento(nome, codigo);
           universidade.adicionarDepartamento(depto);
           System.out.println("DEPARTAMENTO "+nome+ " Adicionado com SUCESSO!");
        }
        else
        {
            System.out.println("ERRO NA ADICAO DO DEPARTAMENTO! UNIVERSIDADE CHEIA");
        }
    }
    
    public void adicionaFuncionario(String codDep, Funcionario funcionario)
    {
        Departamento aux = universidade.buscaDepartamentoPorCodigo(codDep);
        if (aux != null) //O departamento existe
        {
            if (aux.getContador() < aux.getMAXIMO()) //Ainda posso inserir no departamento
            {
                aux.adicionaFuncionario(funcionario);
                System.out.println("=== FUNCIONARIO "+funcionario.getNome()+ " Inserido com SUCESSO no DEPARTAMENTO "+ codDep);
            }
            else
            {
                System.out.println("ERRO!! DEPARTAMENTO CHEIO!");
            }
        }
        else
        {
            System.out.println("ERRO! CODIGO DO DEPARTAMENTO INVALIDO!");
        }
    }
  

}