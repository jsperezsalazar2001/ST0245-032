package datastructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.Math;
import java.io.File;

/**
 * Implementation of an algorithm to prevent collisions Data structure used:
 * Arrays Complexity: Worst Case O (n squared) and Best case O (n square)
 *
 * @author Juan Sebastian Perez
 * @author Yhoan Alejandro Guzman
 * @version 1
 */
public class CollisionPrevention {

    private int numberOfBees = 0;
    private int currentPos = 0;
    public double distanceLongi;
    public double distanceLat = 111000;
    Bee[] beesInCollsionRisk;

    /**
     * Costructor of the CollisionPrevention class
     *
     * @param n the number of bees that are going to be analized
     */
    public CollisionPrevention(int n) {
        this.numberOfBees = n;
        this.currentPos = 0;
        beesInCollsionRisk = new Bee[n];
    }

    /**
     * Method to approximate the distance between two robotic bees      
     *
     * @param bee1 the first bee       
     * @param bee2 the second bee      
     *
     * @return the approximate distance between the two bees, approaching 1
     * degree as 111111 meters      
     */
    public  double distancia(Bee bee1, Bee bee2) {
        return Math.sqrt(Math.pow((bee1.getX() - bee2.getX()) * this.distanceLongi, 2)
                + Math.pow((bee1.getY() - bee2.getY()) * distanceLat, 2)
                + Math.pow(bee1.getZ() - bee2.getZ(), 2));
    }

    /**
     * Method to calculate the distance between longitudes depending on the
     * average latitude.
     *
     * @param average Average latitude
     * @return Distance between longitudes
     */
    public double getDistanceBetween(double average) {
        return -3 * Math.pow(10, -9) * Math.pow(average, 6) - 2 * Math.pow(10, -7) * Math.pow(average, 5) + 0.0004 * Math.pow(average, 4) - 0.0005 * Math.pow(average, 3) - 16.948 * Math.pow(average, 2) - 0.0463 * average + 111325;
    }

    /**
     * Method to read a file of bees and store them in an array of Bees   
     */
    public void leerArchivo() {
        try {
            final String file = "ConjuntoDeDatosCon" + this.numberOfBees + "abejas.txt";
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            line = br.readLine();
            int index = 0;
            double averageLat = 0;
            while (line != null) {
                String[] splitedString = line.split(",");
                Bee abeja = new Bee(Double.parseDouble(splitedString[0]),
                        Double.parseDouble(splitedString[1]),
                        Math.abs(Double.parseDouble(splitedString[2])));
                this.beesInCollsionRisk[index++] = abeja;
                averageLat += Double.parseDouble(splitedString[1]);
                line = br.readLine();
            }
            averageLat /= this.numberOfBees;
            this.distanceLongi = getDistanceBetween(averageLat);
        } catch (IOException ioe) {
            File file = new File("ConjuntoDeDatosCon" + this.numberOfBees + "abejas.txt");
            System.out.println("Something went wrong reading the file");
            System.out.println("File exist: " + file.exists());
        }
    }

    /**
     * Method to prevent collisions  
     */
    public void detectarColisiones() {
        for (int i = 0; i < beesInCollsionRisk.length; i++) {
            for (int j = i + 1; j < beesInCollsionRisk.length; j++) {
                if (distancia(beesInCollsionRisk[i], beesInCollsionRisk[j]) <= 100) {
                    if (!(beesInCollsionRisk[i].isInCollisionRisk())) {
                        beesInCollsionRisk[i].setCollision(true);
                        this.currentPos++;
                    }
                    if (!(beesInCollsionRisk[j].isInCollisionRisk())) {
                        beesInCollsionRisk[j].setCollision(true);
                        this.currentPos++;
                    }
                }
            }
        }
        System.out.println("Number of bees in collision risk: " + this.currentPos);
    }

    /**
     * Method to write a file with the answer   
     */
    public void guardarArchivo() {
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
        int numberOfBees = 5000;
        CollisionPrevention test = new CollisionPrevention(numberOfBees);
        test.leerArchivo();
        long startTime = System.currentTimeMillis();
        test.detectarColisiones();
        long estimatedTime = System.currentTimeMillis() - startTime;
        test.guardarArchivo();
        System.out.println("El algoritmo tomo un tiempo de: " + estimatedTime + " ms");
    }
}
