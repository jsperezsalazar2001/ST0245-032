package taller8;

/**
 *
 * @author Juan Sebastian Perez Salazar
 */
public class Nevera {
    private int cod;
    private String desc;
    
    public Nevera(int cod, String desc){
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
    
    @Override
    public String toString(){
        return "Cod: " + cod + "\n" + 
               "Descripción: " + desc;
    }
}
