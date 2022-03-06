package banco;

public class ContaCorrente extends Conta{

    public ContaCorrente(int nr, double saldo, String cpf, int tipo, double taxa){
        super(nr, saldo, cpf, tipo, taxa);        
    }

    public void saque(double valor){
        double retirada = saldo - valor;
        double novoSaldo = retirada - taxa;
        if(novoSaldo > 0){
            saldo = novoSaldo;
        }
        else{
            System.out.println("\n>>> SALDO INSUFICIENTE <<<\n");
        }
    }

    // implentacao futura: alterar taxa de servicos para esta conta

}
