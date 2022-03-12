/********************************************************************
 * Classe FileText contem funcionalidades para manipular
 * arquivos de texto.
 *       
 * Versao: 0.0.1
 * Data  : 20220312
 * Funcionalidades:
 * public FileText(String filename) - construtor
 * private void init() - inicializa objeto
 * private void pushLines() - preenche o array String lines[]
 *                            com as linhas do arquivo 
 * public String getFilename() - retorna o nome do arquivo
 * public int getLinesQtde() - retorna a quantidade de linhas do arquivo 
 * public String getText() - retorna o texto do arquivo
 * public String[] getLines() - retorna o array String lines[] que contem
 *                              as linhas do texto do arquivo
 * public String getLine(int n) - retorna o item n do array String lines[]
 * public void print() - exibe o texto do arquivo no console
 * public void printLines() - exibe o texto do arquivo no console com o
 *                            numero das linhas 
 * public void printLine(int n) - exbie no console o item n do array
 *                                String lines[]
 * 
 * arataca89@gmail.com
 * Aulas particulares de programacao       
 *******************************************************************/
import java.io.*;

public class FileText {
    private int b; // usada para armazenar um byte na leitura do arquivo 
    public int linesQtde;
    public int charsQtde;
    private FileInputStream arquivo;
    private String filename;
    private String texto;
    private String lines[];

    public FileText(String filename){
        this.filename = filename;
        try{
            arquivo = new FileInputStream(filename);

        }
        catch(FileNotFoundException e){
            System.out.println("\nERRO: arquivo " + filename + " nao encontrado!");
            return;
        }
        texto = new String("");
        init();
        charsQtde--; // despreza o caractere de fim de arquivo
        lines = new String[linesQtde];
        pushLines();
    }

    private void init(){
        try{
            do{
                b = arquivo.read(); // le um byte do arquivo
                if( (char) b != '\r') charsQtde++; // considera apenas '\n' nas quebras
                                                   // de linha e não '\n' + '\r'               
                if(b != -1)
                    texto = texto + (char)b;
                if( (char) b == '\n' | b == -1){
                    linesQtde++;
                }
            } while(b != -1); 
        }
        catch(IOException e){
            System.out.println("\nERRO ao ler arquivo " + filename + "\n");
        }
        finally{
            try{
                arquivo.close();
            }
            catch(IOException e){
                System.out.println("\nERRO ao fechar arquivo " + filename + "\n");
            }
        }
        
    }

    private void pushLines(){
        int j = 0;
        String linha = "";
        for(int i = 0; i < texto.length(); i++){
            linha += texto.charAt(i);
            if(texto.charAt(i) == '\n'){
                lines[j++] = new String(linha);
                linha = "";            
            }
        }
        lines[j] = new String(linha);
    }

    public String getFilename(){
        return filename;
    }

    public int getLinesQtde(){
        return linesQtde;
    }

    public String getText(){
        return texto;
    }

    public String[] getLines(){
        return lines;
    }

    public String getLine(int n){
        return lines[n];
    }

    public void print(){
        System.out.print(texto);
    }

    public void printLines(){
        int nr = 1;
        System.out.printf("%03d ",nr);
        for(int i = 0; i < texto.length(); i++){
            System.out.print(texto.charAt(i));
            if(texto.charAt(i) == '\n'){
                nr++;
                System.out.printf("%03d ",nr);
            }
        }
    }

    public void printLine(int n){
        int nr = 0;
        String linha = "";

        for(int i = 0; i < texto.length(); i++){
            linha += texto.charAt(i);
            if(texto.charAt(i) == '\n'){
                nr++;
                if(nr == n){
                    System.out.printf("%03d %s", nr, linha);
                    return;  
                }  
                linha = "";            
            }
        }
    }
}
/********************************************************************
 * Fim de FileText.java
 * arataca89@gmail.com
 * Aulas particulares de programacao
 *******************************************************************/