/**
 * Bee class to store the x,y,z position of a bee, and if it is in colision risk or not.
 * @author Juan Sebastian Perez
 * @author Yhoan Alejandro Guzman
 * @version 1
 */
public class Bee {
    private double x;
    private double y;
    private double z;
    private boolean collision;
    
    public Bee(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        setCollision(false);
    }

    /**
     * @return the x position
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x position to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y position
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y position to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the z position
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z the z position to set
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * @return risk of collision
     */
    public boolean isCollision() {
        return collision;
    }

    /**
     * @param collision the risk of collision to set
     */
    public void setCollision(boolean collision) {
        this.collision = collision;
    }
    
}

