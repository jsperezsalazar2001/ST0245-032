/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Usuario
 */
/**
 * Bee class to store the longitude,latitude,height position of a bee, and if it
 * is in colision risk or not.
 *
 * @author Juan Sebastian Perez
 * @author Yhoan Alejandro Guzman
 * @version 1
 */
public class Bee3D {

    private double longitude;
    private double latitude;
    private double height;
    private int i;
    private int j;
    private int k;
    private boolean collision;

    public Bee3D(double x, double y, double z) {
        this.latitude = x;
        this.longitude = y;
        this.height = z;
        this.collision = false;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @return the j
     */
    public int getJ() {
        return j;
    }

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @return the collision
     */
    public boolean isInCollisionRisk() {
        return collision;
    }

    /**
     * @param collision the collision to set
     */
    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * @param j the j to set
     */
    public void setJ(int j) {
        this.j = j;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }
}
