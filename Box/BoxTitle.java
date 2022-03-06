package box;

/** *****************************************************************
 * A classe Box define uma matriz de caracteres e oferece
 * funcionalidades para exibicao desta matriz no terminal.
 * Pode ser usada para exibir textos no console e auxiliar na
 * construcao de softwares com interface de linha de comando (CLI).
 * 
 * A classe BoxTitle herda de Box e eh uma Box especializada para
 * a exibicao do titulo.
 * 
 * Versao 1.0.0
 * Data 20220304
 * arataca89@gmail.com
 * Aulas particulares de programacao.
 */
public class BoxTitle extends Box{
    public BoxTitle(String s){
        super(3, s.length() + 4);
        border(true);
        insertString(s, 1, 2);
    }
}

// fim do arquivo BoxTitle.java
// arataca89@gmail.com
// Aulas particulares de programacao.
/////////////////////////////////////////////////////////////////////
