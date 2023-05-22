package AgendaSimples;

import java.util.Scanner;
import javax.swing.JOptionPane;

//classe estática com o fim de realizar todas as entradas de dados do programa e tratar esses dados
public class EntradaDados {

    private static Scanner tc = new Scanner(System.in);


    //classe que realiza a entrada de uma string padrão, será usada para a entrada dos nomes
    public static String entraString (int a){
        if (a==0)
            System.out.println ("Insira o nome do aluno");
        else if (a==1)
            System.out.println ("Insira o nome do pai");

        return tc.nextLine();
    }


    //classe que realiza a entrada dos números de telefone e matriculas. o motivo de ter criado outras classes
    //para uma entrada de dados do mesmo tipo eh a verificação diferente que é necessária para as classes dependendo
    //da variavel para a qual ela será utilizada.
    public static String entradaNumero(int a){
        if (a ==0)
            System.out.println("Insira o número de telefone do aluno com apenas dígitos numéricos");
        else if ( a== 1)
            System.out.println ("Insira o número de telefone do responsável com apenas dígitos numéricos");
        else if (a==2)
            System.out.println ("Insira a matrícula do aluno");
        //criação da string que armazenará os dados da entrada até que seja feita a verificação
        String retorna;


        //criamos uma repetição cuja condição de saída é inserir um valor numérico válido.
        do {
            retorna = tc.nextLine();
            if (verificaNumero(retorna, a)) //chamada da função tipo boolean que verifica se o numero inserido eh valido
                return retorna;
        }while (true);
    }


    //semelhantemente a função entradaNumero, a função entradaEmail cria uma repetição que só irá acabar quando o
    //usuário inserir um email válido
    public static String entradaEmail (int a) {
        if (a==0)
            System.out.println("Insira o email do aluno");
        else
            System.out.println("Insira o email do responsável");

        //declaração da string que armazena a informação inserida pelo usuário
        String retorna;

        do {
            retorna = tc.nextLine();
            if (verificaEmail(retorna))//chamada da função tipo boolean que retorna se o email inserido foi válido
                return retorna;
            else
                JOptionPane.showMessageDialog (null, "Insira um email válido",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
        }while (true);
    }


    /*para verificar se o numero inserido é realmente um número utilizamos a tabela ASCCI e a passagem de char para int
    que nos fornece o número da tabela ASCCI que se refere ao caracter. como os número de 0 a 9 são representados
    pelos números de 48 a 57 na tabela ASCCI, qualquer outro valor que seja inserido fará com que a função retorne
    falso*/
    public static boolean verificaNumero (String s, int a){
        //primeiro realizamos a verificação do tamanho dos números, lembrando que a eh a variável que determina o que
        //está sendo inserido pelo usuário
        if (a==2)
            if (s.length() != 5) {
                JOptionPane.showMessageDialog(null, "Insira uma matrícula " +
                        "válida por favor", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        if (a==0 || a==1)
            if (s.length() != 11 && s.length() != 9) {
                JOptionPane.showMessageDialog(null, "Insira um número de telefone " +
                                "válido por favor (9 dígitos sem DDD, 11 dígitos com DDD)", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
                return false;
                }

        //agora verificamos se algo além de números foram inseridos usando a tabela ASCCI
        for (int i=0; i<s.length(); i++)
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                JOptionPane.showMessageDialog (null, "Insira apenas " +
                        "números por favor", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        return true;
    }


    /*para realizar a verificação do email, utilizei as regras de criação do gmail, quer também acaba servindo para a
    grande maioria dos outros. Assim, qualquer caracter diferente de A-Z (maiusculo ou minusculo), 0-9, '.', '_' não
    podem fazer parte da string. Além disso, o @ só pode ser usado uma vez, e após ele é necessário que exista pelo
    menos um ponto e a palavra "com"*/
    public static boolean verificaEmail (String s){

        //a localização do @ é importante para verificar se o que vem após ele é a formatação do tipo de email (gmail,
        //hotmail,, etc)
        int indice = s.indexOf('@');

        if (indice != s.lastIndexOf('@'))//verificação para saber se há mais de um @
            return false;
        if (s.indexOf(' ') != -1)//verificação para saber se há algum espaço
            return false;
        else if (indice < 4)//o minimo de caracteres antes do @ é 3, logo ele precisa estar pelo menos no indice 3
            return false;
        else if (s.lastIndexOf('.') < indice )//verificação para saber se há um ponto após o @
            return false;
        else if (s.lastIndexOf("com") < indice)//verificação para saber se há o "com" após o @
            return false;
        else if (s.indexOf('.')+1 == '.' || s.lastIndexOf('.')+1 == '.')//verifica se há dois pontos seguidos no email
            return false;
        for (int i=0; i<s.length(); i++) {
            int verifica = s.charAt(i);
            if (verifica < 46 || verifica == 47 || verifica > 122 || (verifica > 57 && verifica < 64)
            || (verifica > 90 && verifica < 95) || verifica == 96)
                //verificação de todos os caracteres especiais da tabela ASCCI
                return false;
        }
        return true;
    }

    //função para fechar o scanner apos a conclusão do programa
    public static void fechaScanner (){
        tc.close();
    }
}