package banco;

import box.*;

public class Banco {

    private Cliente clientes[];
    private Conta contas[];

    private int qtdeClientes;
    private int qtdeContas;
    private int cap; // capacidade maxima de clientes
    private int capContas; // capacidade maxima de contas

    private double rendimento;

    public Banco(double r){
        qtdeClientes = 0;
        qtdeContas = 0;
        cap = 5;
        capContas = 10;
        clientes = new Cliente[cap];
        contas = new Conta[capContas];
        rendimento = r;
    }

    public double getRendimento(){
        return rendimento;
    }

    // implementacao futura: alterar rendimento
    public void setRendimento(double r){
        if(r > 0.0)
            rendimento = r;
        else
            System.out.println("\n>>> O RENDIMENTO DEVE SER MAIOR QUE ZERO <<<\n");
    }

    public void insertCliente(String cpf, String nome){
        // verificando se foi atingida a quantidade maxima de clientes
        if(qtdeClientes == cap){
            // implementacao futura de realocacao de memoria e
            // copia de dados do array clientes
            System.out.println("\n>>> Capacidade maxima de clientes atingida <<<\n");
            return;
        }

        // verificando se o cliente ja esta cadastrado
        for(int i = 0; i < qtdeClientes; i++){            
            if(clientes[i].getCPF().equals(cpf)){
                System.out.println("\n>>> CPF " + cpf + " ja cadastrado <<<\n");
                return;
            }           
        }

        clientes[qtdeClientes++] = new Cliente(cpf, nome);
        System.out.println("\n>>> Cliente inserido com sucesso <<<\n");
        System.out.println("CPF : " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println();
    }

    // tipo: 1 - conta corrente; 2 - conta poupanca
    public boolean insertConta(int nr, double saldo, String cpf, int tipo, double taxa){
        // verificando se foi atingida a quantidade maxima de contas
        if(qtdeContas == capContas){
            // implementacao futura de realocacao de memoria e
            // copia de dados do array contas
            System.out.println("\n>>> Capacidade maxima de contas atingida <<<\n");
            return false;
        }

        // verificando se o cliente ja esta cadastrado
        boolean clienteCadastrado = false;
        for(int i = 0; i < qtdeClientes; i++){            
            if(clientes[i].getCPF().equals(cpf)){
                clienteCadastrado = true;
            }           
        }

        if(!clienteCadastrado){
            System.out.println("\n>>> CLIENTE NAO CADASTRADO NO SISTEMA <<<\n");
            return false;
        }

        switch(tipo){
            case 1:
                contas[qtdeContas++] = new ContaCorrente(nr, saldo, cpf, tipo, taxa);
                break;
            case 2:
                contas[qtdeContas++] = new ContaPoupanca(nr, saldo, cpf, tipo, taxa);
                break;
        }

        if(tipo == 1)
            System.out.println("\n>>> Conta corrente inserida com sucesso <<<\n" );
        else
            System.out.println("\n>>> Conta poupanca inserida com sucesso <<<\n" );

        System.out.println("Nr da conta: " + nr);
        System.out.println("CPF        : " + cpf);
        System.out.println("Saldo      : " + saldo);

        if(tipo == 1)
            System.out.println("Taxa       : " + taxa);
        else
            System.out.println("Rendimento : " + taxa + " %");
        System.out.println();

        return true;
    }    

    public void listarClientes(){
        String titulo = "       Clientes       ";
        BoxTitle t = new BoxTitle(titulo);
        t.print();

        System.out.println("CPF\tNome\n");
        for(int i = 0; i < qtdeClientes; i++){
            clientes[i].print();
        }
    }

    public void listarContas(){
        String titulo = "             Contas               ";
        BoxTitle t = new BoxTitle(titulo);
        t.print();

        System.out.println("Numero\tTipo\t\tCPF\tSaldo\n");
        for(int i = 0; i < qtdeContas; i++){
            contas[i].print();
        }
    }

    public int getQtdeClientes(){
        return qtdeClientes;
    }

    public int getQtdeContas(){
        return qtdeContas;
    }

    public void deposito(int nr, double valor){
        for(int i = 0; i < qtdeContas; i++) {
            if(contas[i].getNr() == nr) {
                contas[i].deposito(valor);
                System.out.println("\n>>> Deposito efetuado com sucesso <<< ");
                System.out.println("Conta: " + contas[i].getNr());
                System.out.println("Valor: " + valor);
                System.out.println();
                return;
            }
        }
        System.out.println("\n>>> NAO HA CONTA CADASTRADA COM ESTE NUMERO <<<\n");
    }

    public boolean saque(int nr, double valor){
        for(int i = 0; i < qtdeContas; i++) {
            if(contas[i].getNr() == nr) {
                contas[i].saque(valor);
                System.out.println("\n>>> Saque efetuado com sucesso <<<\n");
                System.out.println("Conta: " + contas[i].getNr());
                System.out.println("Valor: " + valor);

                if(contas[i].getTipo() == 1)
                    System.out.println("Taxa : " + contas[i].getTaxa());

                System.out.println();
                return true;
            }
        }
        System.out.println("\n>>> NAO HA CONTA CADASTRADA COM ESTE NUMERO <<<\n");
        return false;
    }

    public void saldo(int nr){
        for(int i = 0; i < qtdeContas; i++) {
            if(contas[i].getNr() == nr) {
                System.out.println("\nConta: " + contas[i].getNr());

                if(contas[i].getTipo() == 1)
                    System.out.println("Tipo : " + "corrente");
                else
                    System.out.println("Tipo : " + "poupanca");

                System.out.println("CPF  : " + contas[i].getCPF());
                System.out.println("Saldo: " + contas[i].getSaldo());
                System.out.println();
                return;
            }
        }
        System.out.println("\n>>> NAO HA CONTA CADASTRADA COM ESTE NUMERO <<<\n");
    }
    
    public void aplicarRenda(){
        for(int i = 0; i < qtdeContas; i++) {
            if(contas[i].getTipo() == 2) {
                double renda, novoSaldo;
                if(contas[i].getSaldo() > 0){
                    renda = contas[i].getSaldo() * contas[i].getTaxa() / 100;        
                    novoSaldo = contas[i].getSaldo() + renda;
                    contas[i].setSaldo(novoSaldo);
                }   
            }
        } 
        System.out.println("\n>>> Aplicado rendimento de " + getRendimento() +
        " % na poupanca <<<\n");
    }
}
