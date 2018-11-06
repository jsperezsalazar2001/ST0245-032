package datastructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Implementation of an algorithm to prevent collisions Data structure used: 3D
 * Matrix Arrays Complexity: Worst Case O(n) and Best case O(n)
 *
 * @author Yhoan Alejandro Guzman
 * @author Juan Sebastian Perez
 * @version 1
 */
public class CollisionPrevention3D {

    public int offset = 2;
    private int numberOfBees = 0;
    public int precission = 33;
    public double maxLA;
    public double maxLO;
    public double minLA;
    public double minLO;
    public double maxH;
    public double minH;
    public double distanceLongi;
    public double distanceLat = 111000;
    public int countBeesCR = 0;
    private Bee3D beesArray[];
    private LinkedList<Bee3D>[][][] BeesCollision;

    /**
     * Costructor of the CollisionPrevention3D class
     *
     * @param n the number of bees that are going to be analized from a file
     */
    public CollisionPrevention3D(int n) {
        this.numberOfBees = n;
        this.beesArray = new Bee3D[n];
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
     * Method to set the number of bees.
     *
     * @param n number of bees.
     */
    public void setNumberOfBees(int n) {
        this.numberOfBees = n;
    }

    /**
     * Method to read a file with bees and store them in an array of Bees3D This
     * method also finds the maximum and minimum latitud, longitude and height
     * given the bees position.
     */
    public void readFile() {
        try {
            final String file = "ConjuntoDeDatosCon" + this.numberOfBees + "abejas.txt";
            double average = 0;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            line = br.readLine();
            String[] splited = line.split(",");
            this.maxLA = Double.parseDouble(splited[0]);
            this.minLA = Double.parseDouble(splited[0]);
            this.maxLO = Double.parseDouble(splited[1]);
            this.minLO = Double.parseDouble(splited[1]);
            this.maxH = Math.abs(Double.parseDouble(splited[2]));
            this.minH = Math.abs(Double.parseDouble(splited[2]));
            int index = 0;
            double x;
            double y;
            double z;
            while (line != null) {
                String[] splitedString = line.split(",");
                x = Double.parseDouble(splitedString[0]);
                y = Double.parseDouble(splitedString[1]);
                z = Math.abs(Double.parseDouble(splitedString[2]));
                average += y;
                if (x > maxLA) {
                    maxLA = x;
                } else if (x < minLA) {
                    minLA = x;
                }
                if (y > maxLO) {
                    maxLO = y;
                } else if (y < minLO) {
                    minLO = y;
                }
                if (z > maxH) {
                    maxH = z;
                } else if (z < minH) {
                    minH = z;
                }
                Bee3D newBee = new Bee3D(x, y, z);
                this.beesArray[index++] = newBee;
                line = br.readLine();
            }
            average = average / this.numberOfBees;
            System.out.println("Maximum latitude: " + maxLA + " Minimum latitude: " + minLA);
            System.out.println("Maximum longitude: " + maxLO + " Minimum longitude: " + minLO);
            System.out.println("Maximum height: " + maxH + " Minimum height: " + minH);
            this.distanceLongi = getDistanceBetween(average);
            System.out.println("Distance between the most distant latitudes " + (int) (Math.abs(Math.abs(maxLA) - Math.abs(minLA)) * distanceLat) + " m");
            System.out.println("Distance between the most distant longitudes: " + (int) (Math.abs(Math.abs(maxLO) - Math.abs(minLO)) * distanceLongi) + " m");
            System.out.println("Distance between the most distant heights: " + (int) (Math.abs(Math.abs(maxH) - Math.abs(minH))) + " m");
            System.out.println("Average distance between longitudes: " + distanceLongi + " m");
            this.offset *= 2;
            this.offset += 10;
            this.BeesCollision = new LinkedList[(int) ((Math.abs(Math.abs(maxLO) - Math.abs(minLO)) * distanceLongi / precission) + offset)][(int) ((Math.abs(Math.abs(maxLA) - Math.abs(minLA)) * distanceLat / precission) + offset)][(int) (Math.abs((Math.abs(maxH) - Math.abs(minH)) / precission) + offset)];
            this.offset -= 10;
            this.offset /= 2;
        } catch (IOException ioe) {
            File file = new File("ConjuntoDeDatosCon" + this.numberOfBees + "abejas.txt");
            System.out.println("Something went wrong reading the file");
            System.out.println("File exist: " + file.exists());
        }
    }

    /**
     * Method to save a file with bees in collision risk This method also prints
     * the total amount of bees in collision risk
     */
    public void saveFile() {
        final String file = "respuestaConjuntoDeDatosCon" + this.numberOfBees + "abejas.txt";
        try {
            int count = 0;
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            for (int i = 0; i < this.numberOfBees; i++) {
                if (beesArray[i].isInCollisionRisk()) {
                    writer.println(beesArray[i].getLatitude() + "," + beesArray[i].getLongitude() + "," + beesArray[i].getHeight());
                    count++;
                }
            }
            System.out.println("Number of bees in collision risk: " + count);
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Something went wrong writing the exit file");
        }
    }

    /**
     * Method to add all the bees in the 3D Matrix structure
     */
    public void addBeesToMatrix() {
        int i;
        int j;
        int k;
        for (int b = 0; b < this.numberOfBees; b++) {
            Bee3D bee = this.beesArray[b];
            i = (int) (Math.abs(Math.abs(bee.getLongitude()) - Math.abs(minLO)) * distanceLongi / precission) + offset + 1;
            j = (int) (Math.abs(Math.abs(bee.getLatitude()) - Math.abs(minLA)) * distanceLat / precission) + offset + 1;
            k = (int) (Math.abs(Math.abs(bee.getHeight()) - Math.abs(minH)) / precission) + offset + 1;
            bee.setI(i);
            bee.setJ(j);
            bee.setK(k);
            if (BeesCollision[i][j][k] == null) {
                BeesCollision[i][j][k] = new LinkedList<>();
                BeesCollision[i][j][k].add(bee);
            } else {
                BeesCollision[i][j][k].add(bee);
                bee.setCollision(true);
                BeesCollision[i][j][k].getFirst().setCollision(true);
            }
        }
    }

    /**
     * Method to detect wich bees are in collsion risk
     */
    public void detectCollisions() {

        for (int pos = 0; pos < this.numberOfBees; pos++) {
            if (!beesArray[pos].isInCollisionRisk()) {
                int i = beesArray[pos].getI();
                int j = beesArray[pos].getJ();
                int k = beesArray[pos].getK();
                for (int x = (i - offset); x <= (i + offset); x++) {
                    for (int y = (j - offset); y <= (j + offset); y++) {
                        for (int z = (k - offset); z <= (k + offset); z++) {
                            if (x == i && y == j && z == k || (Math.abs(i - j) == 0) || Math.abs(i - j) == 2 * offset) {
                                continue;
                            } else if (BeesCollision[x][y][z] != null) {
                                beesArray[pos].setCollision(true);
                                if (BeesCollision[x][y][z].size() == 1) {
                                    BeesCollision[x][y][z].getFirst().setCollision(true);
                                    break;
                                }
                            }
                        }
                        if (beesArray[pos].isInCollisionRisk()) {
                            break;
                        }
                    }
                    if (beesArray[pos].isInCollisionRisk()) {
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * Main method to execute the algorithm
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("Digite el numero de abejas");
        Scanner scan = new Scanner(System.in);
        int numberOfBees = scan.nextInt();
        long mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        if (numberOfBees > 5000) {
            CollisionPrevention3D test = new CollisionPrevention3D(numberOfBees);
            test.readFile();
            long startMemory = (runtime.totalMemory() - runtime.freeMemory()) / mb;
            long startTime = System.currentTimeMillis();
            test.addBeesToMatrix();
            test.detectCollisions();
            long estimatedTime = System.currentTimeMillis() - startTime;
            long finalMemory = (runtime.totalMemory() - runtime.freeMemory()) / mb;
            long estimatedMemory = (finalMemory - startMemory);
            test.saveFile();
            System.out.println("El algoritmo tomo un tiempo de: " + estimatedTime + " ms");
            System.out.println("El algoritmo El algoritmo usó : " + estimatedMemory + " mb");
        } else {
            CollisionPrevention test2 = new CollisionPrevention(numberOfBees);
            test2.leerArchivo();
            long startMemory2 = (runtime.totalMemory() - runtime.freeMemory()) / mb;
            long startTime2 = System.currentTimeMillis();
            test2.detectarColisiones();
            long estimatedTime2 = System.currentTimeMillis() - startTime2;
            test2.guardarArchivo();
            long finalMemory2 = (runtime.totalMemory() - runtime.freeMemory()) / mb;
            long estimatedMemory2 = (finalMemory2 - startMemory2);
            System.out.println("El algoritmo tomo un tiempo de: " + estimatedTime2 + " ms");
            System.out.println("El algoritmo usó : " + estimatedMemory2 + " mb");
       }
    }
}
