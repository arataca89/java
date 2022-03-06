package input;

/** *****************************************************************
 * A classe Input implementa funcoes estaticas que executam a
 * entrada de dados via console (terminal).
 * 
 * Exemplo de main() para usar os metodos desta classe:
 * 
 *      public static void main(String[] args) throws IOException{
 *      
 *      } 
 * 
 * Versao: 1.0.0 
 * Data  : 20220305
 * 
 * Referências:
 * ZIVIANI, N. Projeto de Algoritmos: Com implementacoes em
 * Java e C++. 1a Edicao. Sao Paulo: Cengage Learning, 2017.
 *  
 * arataca89@gmail.com
 * Aulas particulares de programacao 
 ********************************************************************/
import java.io.*;

public class Input{

    public static String getString(String msg) throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        System.out.print(msg);
        String s = buffer.readLine();
        return s;
    }

    public static char getChar(String msg) throws IOException{
        String s = getString(msg);
        return s.charAt(0);
    }

    // Em todas os metodos abaixo, caso a string entrada nao
    // possa representar um numero, o metodo retorna 0 (zero).
    // Este valor de retorno devera ser testado para
    // garantir que a entrada do usuario foi um valor aceitavel.

    public static int getInt(String msg) throws IOException{
        try{
            String s = getString(msg);
            return Integer.parseInt(s);
        }
        catch(NumberFormatException e){            
            return 0;
        }
    }

    public static long getLong(String msg) throws IOException{
        try{
            String s = getString(msg);
            return Long.parseLong(s);
        }
        catch(NumberFormatException e){            
            return 0;
        }
    }

    public static float getFloat(String msg) throws IOException{
        try{
            String s = getString(msg);
            return Float.parseFloat(s); 
        }
        catch(NumberFormatException e){
            return 0;
        }   
    } 

    public static double getDouble(String msg) throws IOException{
        try{
            String s = getString(msg);
            return Double.parseDouble(s);   
        }
        catch(NumberFormatException e){
            return 0;
        } 
    }

} 
/** *****************************************************************
 * Fim de Input.java
 * arataca89@gmail.com
 * Aulas particulares de programacao
 ********************************************************************/
