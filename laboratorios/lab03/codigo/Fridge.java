package laboratorio3;

/**
 * This class contains the attributes of the fridge object.
 * @author Juan Sebastian Perez Salazar
 */
public class Fridge {
    private int cod;
    private String desc;
    
    /**
     * This method is the constructor of the class.
     * @param cod fridge code
     * @param desc description of the fridge
     */
    public Fridge(int cod, String desc){
        this.cod = cod;
        this.desc = desc;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
    
    /**
     * This method converts the data of the fridge into a string.
     * @return a String with the fridge datas
     */
    @Override
    public String toString(){
        return "Cod: " + cod + "\n" + 
               "Descripción: " +desc;
    }
}
