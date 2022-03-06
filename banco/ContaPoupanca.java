package banco;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int nr, double saldo, String cpf, int tipo, double taxa){
        super(nr, saldo, cpf, tipo, taxa);
    }

    public void saque(double valor){
        double novoSaldo = saldo - valor;
        if(novoSaldo > 0){
            saldo = novoSaldo;
        }
        else{
            System.out.println("\n>>> SALDO INSUFICIENTE <<<\n");
        }
    }
}
