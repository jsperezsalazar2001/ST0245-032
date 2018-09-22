import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.Math;
/**
 * Implementation of an algorithm to prevent collisions Data structure used: Arrays 
 * Complexity: Worst Case O (n squared) and Best case O (n square)
 * @author Juan Sebastian Perez
 * @author Yhoan Alejandro Guzman
 * @version 1
 */
public class CollisionPrevention {
    private int numberOfBees = 0;
    private int contNumberOfBees = 0;
    private int currentPos = 0;

    /**
     * Costructor of the CollisionPrevention class
     * @param n the number of bees that are going to be analized
     */
    public CollisionPrevention(int n) {
        this.numberOfBees = n;
        this.contNumberOfBees = n;
        this.currentPos = 0;
    }

    /**
          * Method to approximate the distance between two robotic bees
          * @param bee1 the first bee
          * @param bee2 the second bee
          * @return the approximate distance between the two bees, approaching 1 degree as 111111 meters
          */
    public static double distancia(Bee bee1, Bee bee2) {
        return Math.sqrt(Math.pow((bee1.getX() - bee2.getX()) * 111111, 2)
            + Math.pow((bee1.getY() - bee2.getY()) * 111111, 2)
            + Math.pow(bee1.getZ() - bee2.getZ(), 2));
    }

    /**
          * Method to read a file of bees and store them in an array of Bees
          * @return a Bee array
          */
    public Bee[] leerArchivo() {
        final String file = "ConjuntoDeDatosCon"+this.numberOfBees+"abejas.txt";
        Bee[] beeArray = new Bee[this.numberOfBees];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            line = br.readLine(); 
            int index = 0;
            while (line != null) {
                String[] splitedString = line.split(",");
                Bee abeja = new Bee(Double.parseDouble(splitedString[0]),
                        Double.parseDouble(splitedString[1]),
                        Double.parseDouble(splitedString[2]));
                beeArray[index++] = abeja;
                line = br.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Something went wrong reading the file");
        }
        return beeArray;
    }

    /**
          * Algorithm to prevent collisions
          *
          * @param beeArray An array with bees
          * @return beesInCollsionRisk defined list with an array with bees that are at risk of collision
          */
    public Bee[] detectarColisiones(Bee[] beeArray) {
        Bee[] beesInCollsionRisk = new Bee[this.numberOfBees];
        for (int i = 0; i < beeArray.length; i++) {
            for (int j = i + 1; j < beeArray.length; j++) {
                if (distancia(beeArray[i], beeArray[j]) <= 100) {
                    if (!(beeArray[i].isCollision())) {
                        beeArray[i].setCollision(true);
                        beesInCollsionRisk[this.currentPos] = beeArray[i];
                        this.currentPos++;
                    }
                    if (!(beeArray[j].isCollision())) {
                        beeArray[j].setCollision(true);
                        beesInCollsionRisk[this.currentPos] = beeArray[j];
                        this.currentPos++;
                    }
                }
            }
        }
        return beesInCollsionRisk;
    }

    /**
          * Method to write a file with the answer
          * @param beesInCollsionRisk List defined with fixes with the bees at risk of collision
          */
    public void guardarArchivo(Bee[] beesInCollsionRisk) {
        final String file = "respuestaConjuntoDeDatosCon" + this.numberOfBees + "abejas.txt";
        try {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            for (int i = 0; i < this.currentPos; i++) {
                writer.println(beesInCollsionRisk[i].getX() + "," + beesInCollsionRisk[i].getY() + "," + beesInCollsionRisk[i].getZ());
            }
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Something went wrong writing the exit file");
        }
    }

    public static void main(String[] args) {
        int numberOfBees = 1000;
        CollisionPrevention test = new CollisionPrevention(numberOfBees);
        long startTime = System.currentTimeMillis();
        Bee[] beesInCollsionRisk = test.detectarColisiones(test.leerArchivo());
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: " + estimatedTime + " ms");
        test.guardarArchivo(beesInCollsionRisk);
    }
}
