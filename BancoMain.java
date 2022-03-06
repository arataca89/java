/** *****************************************************************
 * Este eh o arquivo principal da solucao apresentada por mim  para
 * o desafio "Criando um Banco Digital com Java e Orientação a Objetos"
 * apresentado em um bootcamp da DIO (https://www.dio.me/).
 * O objetivo do desafio era reforçar o conhecimento em Programacao
 * Orientada a Objetos (POO) em java.
 * Foi muito legal este exercicio. Pratiquei muito, aprendi novas
 * tecnicas e consolidei conhecimentos ja adquiridos.
 * 
 * arataca89@gmail.com
 * Aulas particulares de programacao 
 ********************************************************************/
import java.util.InputMismatchException;
import java.io.IOException;

import banco.*;
import box.*;
import input.*;

class Menu {    
    public int run() throws IOException{
        try{
            String titulo = "      Banco Java      ";
            BoxTitle t = new BoxTitle(titulo);
            t.print();

            Box b = new Box(12, titulo.length() + 4);
            b.insertString("<< 1 >> Inserir Cliente", 1, 1);
            b.insertString("<< 2 >> Listar Clientes", 2, 1);
            b.insertString("<< 3 >> Inserir Conta", 3, 1);
            b.insertString("<< 4 >> Listar Contas", 4, 1);
            b.insertString("<< 5 >> Deposito", 5, 1);
            b.insertString("<< 6 >> Saque", 6, 1);
            b.insertString("<< 7 >> Transferencia", 7, 1);
            b.insertString("<< 8 >> Saldo", 8, 1);
            b.insertString("<< 9 >> Aplicar renda", 9, 1);
            b.insertString("<< 0 >> Sair", 10, 1);
            b.print();

            // implentacoes futuras:
            // alterar rendimento da poupanca
            // alterar taxa de servido de conta corrente

            int opcao = Input.getInt("Entre com sua opcao: ");
            System.out.println();
            return opcao;
        }
        catch(InputMismatchException exc){
            return -1;
        }
    }    
}

public class BancoMain {
    public static void main(String[] args) throws IOException {

        System.out.println();
        String titulo = "      Banco Java      ";
        BoxTitle t = new BoxTitle(titulo);
        t.print();

        double rendimento = Input.getDouble("\nEntre com o rendimento da poupanca(%): ");  

        Banco banco = new Banco(rendimento);

        System.out.println();

        
        int nrConta = 1;

        Menu menu = new Menu();
        int opcao = menu.run();     

        while(true){

            if(opcao == 0) break;

            int tipo;
            String cpf;
            String nome;
            double saldo;
            double taxa;

            int nr;
            double valor;

            String s;

            switch(opcao) {
                case 1:                    
                    cpf = Input.getString("Entre com o CPF: ");                   
                    nome = Input.getString("Entre com o nome: ");                   
                    banco.insertCliente(cpf, nome);                 
                    break;                    
                case 2:
                    banco.listarClientes();
                    System.out.print("\nPressione ENTER para continuar...");
                    s = Input.getString("");
                    System.out.println();
                    break;
                case 3:                    
                    tipo = Input.getInt("Tipo (1 - corrente; 2 - poupanca): ");
                    if(tipo != 1 & tipo != 2){
                        System.out.println("\n>>> TIPO DE CONTA DESCONHECIDO <<<\n");
                        break;
                    }
                    cpf = Input.getString("Entre com o CPF: ");                   
                    saldo = Input.getDouble("Entre com o saldo: "); 
                    if(tipo == 1)
                        taxa = Input.getDouble("Entre com a taxa para este cliente: ");
                    else
                        taxa = banco.getRendimento();                                         
                    if(banco.insertConta(nrConta, saldo, cpf, tipo, taxa)) 
                        nrConta++;                
                    break; 
                case 4:
                    banco.listarContas();
                    System.out.print("\nPressione ENTER para continuar...");
                    s = Input.getString("");
                    System.out.println();
                    break; 
                case 5:
                    nr = Input.getInt("Entre com o numero da conta: ");
                    valor = Input.getDouble("Entre com valor do deposito: ");
                    banco.deposito(nr, valor);
                    break;    
                case 6:
                    nr = Input.getInt("Entre com o numero da conta: ");
                    valor = Input.getDouble("Entre com valor do saque: ");
                    banco.saque(nr, valor);
                    break;    
                case 7:
                    nr = Input.getInt("Entre com o numero da conta para saque: ");
                    valor = Input.getDouble("Entre com valor a ser transferido: ");                   
                    if(banco.saque(nr, valor)){
                        nr = Input.getInt("Entre com o numero da conta para deposito: ");
                        banco.deposito(nr, valor);
                    }
                    break;
                case 8:
                    nr = Input.getInt("Entre com o numero da conta: ");
                    banco.saldo(nr);
                    break;  
                case 9:
                    banco.aplicarRenda();
                    break;  
                case 10:
                    taxa = Input.getDouble("Entre com o novo rendimento: ");
                    banco.setRendimento(taxa);
                    break;  
                default:
                    System.out.println("\nOpcao invalida!\n");
            }
            opcao = menu.run();
        }

        BoxTitle fim = new BoxTitle("Obrigado por usar o Banco Java.");
        fim.print();
    }
}
/** *****************************************************************
 * Fim de BancoMain.java
 * arataca89@gmail.com
 * Aulas particulres de programacao
 ********************************************************************/
