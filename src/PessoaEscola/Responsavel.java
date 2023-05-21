package PessoaEscola;
public class Responsavel extends PessoaEscola {

    //construtor completo da classe responsavel
    public Responsavel (String nome, String numTelefone, String email){
        this.nome = nome; this.numTelefone = numTelefone; this.email = email;
    }

    //método toString para obter as informações do responsavel
    public String toString() {
        return ("Nome do Responsável: " +nome+ "\nNúmero de Telefone do Responsável: " +numTelefone+
                "\nEmail do Responsável: " +email);
    }
}