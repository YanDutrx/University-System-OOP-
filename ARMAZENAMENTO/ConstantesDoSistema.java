//Essa classe sera responsavel por estabelecer constantes no sistema (por exemplo, a taxa adicional por nivel de Tecnico, docente e docente substituto)
//No mapeamento, a chave tem que ser unica
//É semelhante ao #define MACRO-PREPROCESSAMENTO int_valor, em C
package ARMAZENAMENTO;

/**
 *
 * @author yanma
 */

//Importando as classes para definirmos os valores 

import java.util.HashMap; //Armazena pares de chave valor, por exemplo, ("T1", 0.10) ou ("DDD", "18")
import java.util.Map; //Classe concreta de Map, que permite a instanciacao de objetos

public class ConstantesDoSistema
{
    //Criaremos os atributos (CONSTANTES com a clausula final)
    public static final Map <String, Double> ADICIONAL_TECNICO = new HashMap<>();
    public static final Map <String, Double> ADICIONAL_DOCENTE_EFETIVO = new HashMap<>();
    public static final Map <String, Double> ADICIONAL_DOCENTE_SUBSTITUTO = new HashMap<>();
    //Acima, definimos que havera o objetos do tipo chave valor, apontados por um ponteiro do tipo generico (MAP)

    static  //Inicializador Estatico, antes da inicializacao do metodo main()
    {
        //Passando os valores para o objeto hash_map criado, sendo que o metodo PUT adiciona um par chave-valor ao mapa

        //Para os TECNICOS
        ADICIONAL_TECNICO.put("T1", 0.10); 
        ADICIONAL_TECNICO.put("T2", 0.20);

        //Para os DOCENTES EFETIVOS
        ADICIONAL_DOCENTE_EFETIVO.put("D1", 0.05);
        ADICIONAL_DOCENTE_EFETIVO.put("D2", 0.10);
        ADICIONAL_DOCENTE_EFETIVO.put("D3", 0.20);

        //Para os DOCENTES SUBSTITUTOS
        ADICIONAL_DOCENTE_SUBSTITUTO.put("S1", 0.05);
        ADICIONAL_DOCENTE_SUBSTITUTO.put("S2",0.10);
    }

    //Agora, criaremos nossos metodos estaticos (visto que nao precisamos criar os objetos para acessar o valor do adicional, que ja eh pre definido)

    //getters apenas, ja que nao precisamos setar algo que ja é fixo

    //Getter dos tecnicos
    public static double getAdicionalTecnico(String nivel)
    {
        return ADICIONAL_TECNICO.getOrDefault(nivel, 0.0); //Se existe o nivel, retorna o valor referente à chave
        //Caso nao exista o nivel, retorna 0.0 (valor padrao pre definido) 
    }

    //Getter do Docente Efetivo
    public static double getAdicionalDocenteEfetivo(String nivel)
    {
        return ADICIONAL_DOCENTE_EFETIVO.getOrDefault(nivel, 0.0);
    }

    //Getter do Docente Substituto
    public static double getAdicionalDocenteSubstituto(String nivel)
    {
        return ADICIONAL_DOCENTE_SUBSTITUTO.getOrDefault(nivel, 0.0);
    }

    //Constante adicional para DOCENTE EFETIVO
    public static final double ADICIONAL_EFETIVO = 0.05; //Extra de 5%

    //Definindo as funcoes que cada subclasse de funcionario (atributos especificos) podem possuir

    //Funcoes que a classe Tecnico pode assumir
    //definicao de um vetor de Strings das funcoes que os tecnicos podem assumor
    public static final String[] FUNCOES_TECNICO = {"Assessor", "Laboratório", "Secretário"};

    //Funcoes que a classe Docente pode assumir (isso diz a respeito da titulacao)
    public static final String[] TITULACAO_DOCENTE = {"Graduacao", "Mestrado", "Doutorado", "Livre-Docente", "Titular"};

    //Funcoes que a classe Efetivo (subclasse de Docente) pode assumir
    //Note que tem que ser vetor para eu definir de acordo com as especificacoes do problema (ou 12h de trabalho ou 24h de trabalho semanais)
    public static final int[] CARGA_HORARIA_SUBSTITUTO = {12, 24};

    //Funcoes que a classe Docente efetivo (atributo área) poed assumir
    public static final String[] AREA_DOCENTE_EFETIVO = {"Exatas", "Biológicas", "Humanas", "Saúde"};

}