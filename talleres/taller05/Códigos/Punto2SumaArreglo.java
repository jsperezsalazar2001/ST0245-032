import java.util.concurrent.TimeUnit;

public class Punto2SumaArreglo {
    public static void main(String[] args){
        for (int i = 10000000; i <= 200000000; i = i + 10000000){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            suma(a);
            long fin = System.currentTimeMillis();
            System.out.println(fin-start);
        }
    }


    public static int suma(int[] a){
        int suma = 0; // c_1
        for(int i = 0; i < a.length; i++) { // c2 + sum c3, i=0 to n
            try {
                TimeUnit.MILLISECONDS.sleep(1/100);
            } catch (Exception e) {
            }
            suma += a[i];  //sum c4, i=0 to n-1
        }
        return suma; //c5
    }
}
