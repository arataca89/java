package banco;

abstract class Conta {
    private int nr;
    protected double saldo;
    protected String cpf;
    protected double taxa;
    protected int tipo; // 1 - conta corrente; 2 - conta poupanca

    public Conta(int n, double s, String c, int t, double tax){
        nr = n;
        saldo = (s > 0) ? s : 0.0;
        taxa = (tax > 0) ? tax : 0.0;

        // implementacao futura: CPF devera ser verificado na lista
        // de clientes do banco. Caso nao exista o cliente devera
        // ser cadastrado.
        cpf = c.substring(0, 3);

        tipo = t;
    }

    public int getNr(){
        return nr;
    }

    public String getCPF(){
        return cpf;
    }

    public int getTipo(){
        return tipo;
    }

    public double getTaxa(){
        return taxa;
    }

    public void print(){
        if(tipo == 1)
            System.out.print(nr + "\t" + "corrente\t" + cpf + "\t" +  getSaldo());
        else
            System.out.print(nr + "\t" + "poupanca\t" + cpf + "\t" +  getSaldo());
        System.out.println();
    }   

    public void deposito(double valor){
        saldo += valor;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double valor){
        saldo = valor;
    }

    abstract void saque(double valor);
}

