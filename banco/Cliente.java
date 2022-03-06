package banco;

public class Cliente{
    private String cpf;
    private String nome;

    public Cliente(String c, String n){
        //if(validarCPF(c)) {
            cpf = c.substring(0, 3);
            nome = n;
        //}
        //else{
            // tratamento do CPF invalido
        //}
    }

    public void setNome(String novoNome){
        nome = novoNome;
    }

    public void setCPF(String c){
        cpf = c;
    }

    public String getCPF(){
        return cpf;
    }

    public String getNome(){
        return nome;
    } 

    // private boolean validaCPF(String c){
    //     // implementacao futura
    // }

    public void print(){
        System.out.println(cpf + "\t" + nome);
    }
}