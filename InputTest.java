/** *****************************************************************
 * Teste do pacote input
 * arataca89@gmail.com
 * Aulas particulares de programacao
 *******************************************************************/

import java.io.IOException;
import input.Input;

public class InputTest{   

    public static void main(String[] args) throws IOException {    

        String s = Input.getString("Entre com uma string: ");         
        System.out.println("String digitada: " + s);    
        System.out.println();

        char op = Input.getChar("Entre com um caracter: ");
        System.out.println("Caractere digitado: " + op);
        System.out.println();

        int n = Input.getInt("Entre com um inteiro: ");
        if(n != 0)
            System.out.println("Inteiro digitado: " + n);
        else
            System.out.println("Valor digitado nao pode representar um inteiro.");
        System.out.println();

        long m = Input.getInt("Entre com um inteiro longo: ");
        if(m != 0)
            System.out.println("Inteiro longo digitado: " + m);
        else
            System.out.println("Valor digitado nao pode representar um inteiro longo.");
        System.out.println();

        float f = Input.getFloat("Entre com um float: ");
        if(f != 0)
            System.out.println("Float digitado: " + f);
        else
            System.out.println("Valor digitado nao pode representar um float.");
        System.out.println();

        double d = Input.getDouble("Entre com um double: ");
        if(d != 0)
            System.out.println("Double digitado: " + d);
        else
            System.out.println("Valor digitado nao pode representar um double.");
        System.out.println();
    }
}
