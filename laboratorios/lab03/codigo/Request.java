package laboratorio3;

/**
 * This class contains the attributes of the fridge object.
 * @author Juan Sebastian Perez Salazar
 */
public class Request {
    private String storeName;
    private int cantN;
    
    /**
     * This method is the constructor of the class.
     * @param storeName name of the store 
     * @param cantN number of fridges
     */
    public Request(String storeName, int cantN){
        this.storeName = storeName;
        this.cantN = cantN;
    }

    /**
     * @return the storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @return the cantN
     */
    public int getCantN() {
        return cantN;
    } 
}
