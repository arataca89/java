/********************************************************************
 * diff compara dois arquivos texto com o mesmo numero de linhas
 * 
 * Versao: 0.0.1
 * Data  : 20220312
 * arataca89@gmail.com
 * Aulas particulares de programacao
 ********************************************************************/
public class diff {
    public static void main(String[] args){

        if(args.length != 2){
            System.out.println("\nUSO: diff <arquivo 1> <arquivo 2>\n");
            return;
        }

        FileText arquivo1 = new FileText(args[0]);
        FileText arquivo2 = new FileText(args[1]);     
        
        if(arquivo1.getLinesQtde() == arquivo2.getLinesQtde()){
            for(int i = 0; i < arquivo1.getLinesQtde(); i++){
                if(arquivo1.getLine(i).compareTo(arquivo2.getLine(i)) != 0){
                    System.out.printf("\n%03d %s", i+1, arquivo1.getLine(i));
                    System.out.printf("%03d %s", i+1, arquivo2.getLine(i));
                }
            }
        }
        else if(arquivo1.getLinesQtde() != 0 & arquivo2.getLinesQtde() != 0) {
            System.out.printf("\nERRO:\t%s e %s nao tem o mesmo numero de linhas.\n",
                              arquivo1.getFilename(),
                              arquivo2.getFilename()); 
            System.out.println("\tdiff so compara arquivos com o mesmo numero de linhas.");            
        }
    }
}
