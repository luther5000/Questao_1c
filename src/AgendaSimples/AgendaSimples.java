package AgendaSimples;

import PessoaEscola.*;
import javax.swing.JOptionPane;
public class AgendaSimples {
    public static void main(String[] args) {

        /*Criamos um vetor de objetos do tipo Aluno que iŕa armazenar todas as informações que precisamos. Também
        criamosmuma variável para contar o número de alunos que ja foram inseridos, lembrando que são apenas 10,
        e por fim uma string que servira para verificar o que o usuário quer realizar no programa*/
        Aluno[] aluno = new Aluno[10];
        int contador = 0;
        String verifica;

        System.out.println("BEM VINDO A AGENDA DA ESCOLA!");
        //criamos um laço de repetição para que o programa possa ser executado enquanto o usuário deseja. A única forma
        //de sair do laço é usando a opção de sair
        do {
            System.out.println("\nO QUE DESEJA FAZER?\n1. Adicionar novo contato \n" +
                    "2. Ver contatos existentes \n3. Sair");

            /*note que em todas as entradas de dados é passado um valor int para a função, que nelas é armazenado pela
            variável 'a'. Esse valor inteiro tem como objetivo informar a função o que ela estará recebendo do usuário,
            se é o nome do pai ou do aluno, se é um número de telefone, uma matrícula, etc. Quando temos o valor 0, a
            entrada de dados será referente ao aluno, quando é 1, a entrada de dados é referente ao responsável do
            aluno (isso serve para os nomes, emails e números de telefone). Quando é 2, será inserida a matrícula do
            aluno, e qualquer outro valor é a entrada do usuário*/

            verifica = EntradaDados.entradaNumero(6);

            switch (verifica) {
                case "1":
                    //chamada do construtor caso o número máximo de alunos não tiver sido excedido
                    if (contador < 10) {
                        aluno[contador] = new Aluno(EntradaDados.entraString(0), EntradaDados.entradaNumero(0),
                                EntradaDados.entradaEmail(0), EntradaDados.entradaNumero(2), EntradaDados.entraString(1),
                                EntradaDados.entradaNumero(1), EntradaDados.entradaEmail(1));
                        contador++;
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Já foram inseridos 10 alunos",
                                "ERRO", JOptionPane.ERROR_MESSAGE);
                    break;

                case "2":
                    //verificação para saber se algum aluno já foi adicionado a agenda
                    if (contador == 0) {
                        System.out.println("Não há alunos na agenda");
                        break;
                    }

                    System.out.println("\nQuais contatos você deseja ver?\n1. Todos \n2. Alunos \n3. Responsáveis");
                    verifica = EntradaDados.entradaNumero(6);
                    switch (verifica) {
                        case "1":
                            for (int i = 0; i < contador; i++) {
                                System.out.println("Aluno " + (i + 1) + ":\n" + aluno[i] + "\n");
                                System.out.println("Responsável do Aluno " + (i + 1) + ":\n" +
                                        aluno[i].infoResponsavel());
                                System.out.println("-------------------------------------------------------" +
                                        "--------------\n");
                            }
                            break;

                        case "2":
                            for (int i = 0; i < contador; i++) {
                                System.out.println("Aluno " + (i + 1) + ":\n" + aluno[i] + "\n");
                                System.out.println("-----------------------------------------------------" +
                                        "----------------\n");
                            }
                            break;

                        case "3":
                            for (int i = 0; i < contador; i++) {
                                System.out.println("Responsável do Aluno " + (i + 1) + ":\n" +
                                        aluno[i].infoResponsavel());
                                System.out.println("-------------------------------------------" +
                                        "--------------------------\n");
                            break;
                            }
                    }
                case "3":
                    EntradaDados.fechaScanner();
                    System.exit(0);
            }
        }while (true);
    }
}