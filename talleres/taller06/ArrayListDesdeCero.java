
import java.util.Arrays;
/**
 * La clase ArrayListDesdeCero tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList" 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * @author Yhoan Alejandro Guzmán, Juan Sebastian Perez 
 * @version 1
 * Solución a las preguntas del taller:
 * 1. La complejidad del método agregar es O(n), por lo tanto consideramos que es posible usarla para un editor de texto
 * 2. La complejidad de agragar un caracter es O(n*c), por lo tanto la complejidad de agregar n caracteres es O(n*n) = O(n^2).
 */

public class ArrayListDesdeCero <CualquierCosa> {
    private int size;
    private static final int DEFAULT_CAPACITY = 1;
    private Object elements[]; 
    private Object elementsAux[];
    private int added;
    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El constructor no lleva parámetros en este caso.
     */
    public ArrayListDesdeCero() {
        added = 0;
        elements = new Object[DEFAULT_CAPACITY];
        size = elements.length;
        for (int i = 0; i < size; i++){//n*c1 y n = 1, => c1
            elements[i] = null; //Complejidad => O(c1), porque el size inicial es 1
        }
    }     

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return this.added; //c1 => Complejidad: O(c1)
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(CualquierCosa e) {
        //Peor de los casos: que se deban añadir más posiciones en el arreglo, es decir, que se ejecute el else del siguiente condicional
        if(added < size){ 
            if(added == size - 1){
                elements[size-1] = e;
            }else{
                elements[added] = e;
            }
            added++;
        }else{
            size *= 2;//c1
            elementsAux = new Object[size];//c2
            for (int i = 0; i < size/2; i++){//n*c3, siendo n size/2
                elementsAux[i] = elements[i];//n
            }
            elementsAux[size/2] = e;//c4
            this.elements = new Object[size];//c5
            for (int i = 0; i < size/2 + 1; i++){//(n+1)*c6
                elements[i] = elementsAux[i];//n+1
            }
            added++;//c7
            //Complejidad total en notación O = O(c1+c2+n*c3+n+c4+c5+(n+1)*c6+n+1)
            // = O((n+1)*c6)
            // = O(n+1) = O(n), siendo n la medida del arreglo antes de ser agrandado 
        }
    }    

    /** 
     * @param i es un índice donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public CualquierCosa get(int i) {
        if (i >= 0 && i < size)//c1
            return (CualquierCosa) elements[i];//c2
        else 
            throw new IndexOutOfBoundsException("Index: "+i+", Size: "+size);//c3
        //No hay un peor caso especifico, ya que siempre se ejecuta el if, y enseguida una sola instrucción ya sea en el caso verdadero o falso, ya habría que definir si el throw se demora 
        // más que el return, pero en general su complejidad es O(c1+c2) o O(c1+c3). 
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
        //El mejor caso es que el elemento que se quiera añadir vaya a la ultima posición y esta esté vacía(primer if verdadero)
        //El segundo mejor caso es si aún hay sitios disponibles para el nuevo elemento (primer if falso y el if anidado verdadero)
        //El peor caso es que el elemento a añadir se quiera poner en la posición 0, y no hayan más espacios en el arreglo (primer if falso, y el if anidado falso)
        if(index > added){
            elements[added] = e;
        }else{
            if(added < size){
                for (int i = size - 1; i > index; i--){
                    elements[i] = elements[i-1];
                }
                elements[index] = e;
            }else{
                size *= 2;//c1
                elementsAux = new Object[size];//c3
                for (int i = 0; i <= index; i++){//c4*n, siendo n el índice en el que se quiere poner el elemento + 1
                    elementsAux[i] = elements[i];//n
                }
                for (int i = index + 1; i < size/2 + 1; i++){//c5*(n2-n), siendo n2 el tamaño actual del arreglo(size/2)
                    elementsAux[i] = elements[i - 1];//(n2-n)
                }
                elementsAux[index] = e;//c6
                this.elements = new Object[size];//c7
                for (int i = 0; i < size/2 + 1; i++){//(n2+1)*c7
                    elements[i] = elementsAux[i];//n2+1
                }
            }
        } 
        added++;//c8
        //Complejidad: O(c1+c3+c4*n+n+(n2-n)+c6+c7+(n2+1)*c7+n2+1), n2 es más grande que el índice, ya que n2 es el size, y el size debe ser mayor que el índice para que se ejecute el peor caso
        //  =O(n2), siendo n2 el size del arreglo antes de agrandarlo
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        //El peor de los casos es que el index entrado por el usuario sea válido
        if(index >= 0 && index < added){//c1
            for (int i = index; i < size - 1; i++){//n*c2, siendo n = (size - index) del arreglo, pero para el peor de los casos el index = 0, por lo que n = size - 1
                elements[i] = elements[i+1];//n - 1
            }
            added--;//c3
        }else{ 
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+added);
        }
        //Complejidad total: O(c1+n*c2+n-1+c3)
        // = O(n), siendo n el tamaño del arrelgo - 1
    }

    /* El método imprimir sirve para imprimir el arreglo y el número posiciones añadidas
     *
     */
    public void imprimirArray(){
        for(int i = 0; i < size; i++){//c1*n, siendo n el tamño del arreglo
            System.out.print(get(i)+" ");//n
        }
        System.out.print("  Added: "+ added);//c2
        //Complejidad: O(c1*n+n+c2)
        //           = O(n)
    }

    /*
     * Método main para probar el programa
     * 
     */
    public static void main (String[]args){
        ArrayListDesdeCero prueba = new ArrayListDesdeCero();
        for(int i = 0; i <= 8; i++){
            prueba.add(i*10);
        }
        prueba.imprimirArray();
        prueba.add(0, 11);
        System.out.println();
        prueba.imprimirArray();
        prueba.add(12, 12);
        System.out.println();
        prueba.imprimirArray();
        prueba.add(1, 13);
        System.out.println();
        prueba.imprimirArray();
        prueba.del(3);
        System.out.println();
        prueba.imprimirArray();
    }
}