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
public class Box{
    protected int n; // numero de linhas da Box
    protected int m; // numero de colunas da Box
    protected char matriz[][]; // matriz que define a Box

    public Box(){
        n = 3;
        m = 15;
        matriz = new char[n][m];
        border(true);
    }

    public Box(int nn, int mm){
        n = nn;
        m = mm;
        matriz = new char[n][m];
        border(true);
    }

    // Desenha a borda da Box
    public void border(boolean b){
        if(b){
            matriz[0][0] = '+';
            matriz[0][m-1] = '+';
            matriz[n-1][0] = '+';
            matriz[n-1][m-1] = '+';

            for(int mm = 1; mm < m-1; mm++){
                matriz[0][mm] = '-';
                matriz[n-1][mm] = '-';
            }

            for(int nn = 1; nn < n-1; nn++){
                matriz[nn][0] = '|';
                matriz[nn][m-1] = '|';
            }
        }
        else{
            matriz[0][0] = ' ';
            matriz[0][m-1] = ' ';
            matriz[n-1][0] = ' ';
            matriz[n-1][m-1] = ' ';

            for(int mm = 1; mm < m-1; mm++){
                matriz[0][mm] = ' ';
                matriz[n-1][mm] = ' ';
            }

            for(int nn = 1; nn < n-1; nn++){
                matriz[nn][0] = ' ';
                matriz[nn][m-1] = ' ';
            }
        }
    }

    // Exibe a Box no console.
    public void print(){    
        for(int lin = 0; lin < n; lin++){
            for(int col = 0; col < m; col++){
                System.out.print(matriz[lin][col]);
            }
            System.out.println();
        }
    }

    // Limpa a Box, apaga todos os caracteres.
    public void clear(){
        for(int lin = 0; lin < n; lin++){
            for(int col = 0; col < m; col++){
                matriz[lin][col] = ' ';
            }
        }
    }

    // Insere a String s na Box a partir da posicao (nn,mm).
    // Se a Box terminar a String sera truncada. 
    // Nao respeita a borda da Box. 
    public void insertString(String s, int nn, int mm){
        int lin = nn;
        int col = mm;

        for(int i = 0; i < s.length(); i++){

            if(lin == n) return; // atingiu o fim da box

            matriz[lin][col] = s.charAt(i);
            col++;
            if(col == m){
                col = 0;
                lin++;
            }
        }
    }

    // Insere um texto na Box.
    // Se a Box terminar o texto sera truncado. 
    // Respeita a borda da Box.    
    public void insertText(String s){
        int lin = 1;
        int col = 2;

        for(int i = 0; i < s.length(); i++){

            if(lin == n - 1) return; // atingiu nultima linha da box

            matriz[lin][col] = s.charAt(i);
            col++;
            if(col == m - 1){
                if(s.charAt(i) != ' '){
                    int t = col - 1;
                    // voltar na string ate encontrar um espaco
                    for(int j = i-1; j >= 0; j--){
                        matriz[lin][t--] = ' '; // apaga caracteres
                        if(s.charAt(j) == ' '){
                                i = j; // reajusta o indice do caractere em s
                                break;
                        }
                    }                   
                }
                col = 2;
                lin++;
            }
        }
    }
} // fim da classe Box

// fim do arquivo Box.java
// arataca89@gmail.com
// Aulas particulares de programacao.
/////////////////////////////////////////////////////////////////////
