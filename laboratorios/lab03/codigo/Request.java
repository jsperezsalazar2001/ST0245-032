package laboratorio3;

/**
 *
 * @author Juan Sebastian Perez Salazar
 */
public class Request {
    private String nombTienda;
    private int cantN;
    
    public Request(String nombTienda, int cantN){
        this.nombTienda = nombTienda;
        this.cantN = cantN;
    }

    /**
     * @return the nombTienda
     */
    public String getNombTienda() {
        return nombTienda;
    }

    /**
     * @return the cantN
     */
    public int getCantN() {
        return cantN;
    }
    
    
}