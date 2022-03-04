package box;

import java.util.Scanner;

class BoxTest{
    public static void main(String[] args){

        Scanner pause = new Scanner(System.in);

        BoxTitle t = new BoxTitle("Teste da classe Box");
        t.print();

        System.out.println("\nCriando uma Box com o construtor padrao.");
        System.out.println("O contrutor padrao cria uma Box 3 x 15.");
        Box b1 = new Box();
        b1.print();

        System.out.println("\nCriando uma Box 10 x 30.");
        Box b2 = new Box(10, 30);
        b2.print();

        System.out.print("\nPressione ENTER para continuar...");
        pause.nextLine();

        System.out.println("\nInserindo uma string na Box");
        b1.insertString("Inserindo string na Box", 1, 1);
        b1.print();
        System.out.println();

        Box b3 = new Box(3, 25);
        b3.insertString("Inserindo string na Box", 1, 1);
        b3.print();
        System.out.println();

        b3.clear();
        b3.border(true);
        b3.insertString("Inserindo string na Box", 1, 5);
        b3.print();
        System.out.println();

        System.out.print("\nPressione ENTER para continuar...");
        pause.nextLine();

        System.out.println("\nInserindo texto na Box");
        b2.insertText("Inserindo um texto numa Box. O texto" +
        " eh inserido no interior da Box, respeitando a borda." +
        " Se os caracteres do texto forem maiores que a Box o texto" +
        " Sera truncado. arataca89@gmail.com");
        b2.print();
        System.out.println();        

        System.out.print("\nPressione ENTER para continuar...");
        pause.nextLine();

        System.out.println();
        BoxTitle b4 = new BoxTitle("Controle de Produtos");
        b4.print();

        Box b5 = new Box(6,24);
        b5.border(true);
        b5.insertString("<< 1 >> Inserir", 1, 1);
        b5.insertString("<< 2 >> Pesquisar", 2, 1);
        b5.insertString("<< 3 >> Deletar", 3, 1);
        b5.insertString("<< 0 >> Sair", 4, 1);
        b5.print();

        System.out.println();
    }
}
