package taller3;

/**
 * Esta clase se encarga de simular con una matriz la funcion del tarrito de paint.
 * @author Juan Sebastián Pérez Salazar
 * @version 1
 * 
 */
public class TarritoPaint {
    
    /**
     * Este método es el auxiliar del método tarritoAux el cual realiza el proceso
     * @param mat es la matriz donde se tienen los valores
     * @param col es la columna donde se va a pintar
     * @param fil es la fila donde se va a pintar 
     * @param color es el color(número) con el cual se van a rellenar los espacios requeridos. 
     */
    public static void tarrito(int[][] mat, int col, int fil, int color){
       tarritoAux(mat, col, fil, color, mat[fil][col]); 
    }
    
    /**
     * Este método es la base del algoritmo, aca es donde se desarrolla el tarrito de paint
     * @param mat es la matriz donde se tienen los valores
     * @param col es la columna donde se va a pintar
     * @param fil es la fila donde se va a pintar 
     * @param color es el color(número) con el cual se van a rellenar los espacios requeridos. 
     * @param colorAnt es el color que se encontraba en el espacio seleccionado
     */
    public static void tarritoAux(int[][] mat, int col, int fil, int color, int colorAnt){
        if(mat[fil][col]==colorAnt) mat[fil][col]=color;
        
        if(col+1<mat.length && mat[fil][col+1]==colorAnt) tarritoAux(mat, col+1, fil, color, colorAnt);
        if(col-1>=0 && mat[fil][col-1]==colorAnt) tarritoAux(mat, col-1, fil, color, colorAnt);
        if(fil+1<mat.length && mat[fil+1][col]==colorAnt) tarritoAux(mat, col, fil+1, color, colorAnt);
        if(fil-1>=0 && mat[fil-1][col]==colorAnt) tarritoAux(mat, col, fil-1, color, colorAnt);
    }
    
    /**
     * Este es el método main de la clase, a partir de este se evaluan los métodos anteriores. 
     * @param args 
     */
    public static void main(String[] args){
        int[][] mat = {{2,2,0,0},
                       {2,2,0,0},
                       {2,0,0,0},
                       {0,0,0,2}};
        
        tarrito(mat, 1, 1, 3);
        
        for(int fil=0; fil<mat.length; fil++){
            for(int col=0; col<mat[0].length; col++){
                System.out.print(mat[fil][col]+" ");
            }
            System.out.println();
        }
    }
}
