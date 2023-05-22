package PessoaEscola;
public class Aluno extends PessoaEscola {

    //declaração da variavel matricula pertencente apenas ao aluno e da instancia
    //referente a classe responsável. cada aluno possui um responsável
    private String matricula;
    private Responsavel responsavel;

    //construtor completo da classe aluno que cria o objeto responsavel para o aluno
    public Aluno (String nomeAluno, String numTelefoneAluno, String emailAluno, String matricula,
                  String nomeRes, String numTelefoneRes, String emailRes) {
        nome = nomeAluno; numTelefone = numTelefoneAluno; email = emailAluno; this.matricula = matricula;
        responsavel = new Responsavel(nomeRes, numTelefoneRes, emailRes);
    }

    //função que retorna as informações do responsável
    public String infoResponsavel (){
        return responsavel.toString();
    }

    public String infoNome(){ return nome;}

    public String toString (){
        return ("Nome do Aluno: " +nome+ "\nMatrícula do Aluno: " +matricula+
                "\nNúmero de Telefone do Aluno: " +numTelefone+ "\nEmail do Aluno: " +email);
    }
}