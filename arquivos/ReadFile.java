/********************************************************************
 * Exercicio de leitura de arquivo
 * 
 * arataca89@gmail.com
 * Aulas particulares de programacao
 ********************************************************************/ 
import java.io.*;

public class ReadFile{
    public static void main(String[] args){
        int c;
        FileInputStream arquivo = null;

        if(args.length != 1){
            System.out.println("\nUSO: ReadFile <arquivo>\n");
            return;
        }

        try{
            arquivo = new FileInputStream(args[0]);
        }
        catch(FileNotFoundException e){
            System.out.println("\nERRO: arquivo " + args[0] + " nao encontrado!\n");
            return;
        }

        try{
            do{
                c = arquivo.read(); // le um byte do arquivo
                if(c != -1) System.out.print((char) c);
            } while(c != -1); 
        }
        catch(IOException e){
            System.out.println("\nERRO ao ler arquivo.\n");
        }

        finally{
            try{
                if(arquivo != null) arquivo.close();
            }
            catch(IOException e){
            System.out.println("\nERRO ao fechar arquivo.\n");
            }
        }
    }
}