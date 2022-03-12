/********************************************************************
 * Teste da classe FileText
 * 20220312
 * arataca89@gmail.com
 * Aulas particulares de programacao
 *******************************************************************/
public class FileTextTest {
    public static void main(String[] args){

        if(args.length != 1){
            System.out.println("\nUSO: FileTextTest <arquivo>\n");
            return;
        }

        FileText arquivo = new FileText(args[0]);
        System.out.println("nr de chars: " + arquivo.charsQtde);
        System.out.println("nr de lines: " + arquivo.linesQtde);

        System.out.println();
        arquivo.print();
        System.out.println();

        System.out.println("\ngetLines()");
        for(String s: arquivo.getLines()){
            System.out.print(s);
        }

        System.out.println("\n\ngetLine()");

        try{
            for(int i = 0; i < arquivo.getLinesQtde(); i++){
            //for(int i = 0; i < 7; i++){
                System.out.printf("%03d %s", i+1, arquivo.getLine(i));
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\n>>> Nao existe esta linha no arquivo <<<");
        }
        System.out.println("\n");



    }
}
/********************************************************************
 * Fim de FileTextTest.java
 * arataca89@gmail.com
 * Aulas particulares de programacao
 *******************************************************************/