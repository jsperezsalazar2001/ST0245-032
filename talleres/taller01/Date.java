 
 /* Esta clase contiene la solución propuesta al ejercicio 2 del taller 1
 * @author (Juan Sebastián Pérez Salazar)
 * @author (Yhoan Alejandro Guzman)
 * @version (17 de julio, 2018)
 */
public class Date {
    
    private final byte day;
    private final byte month;
    private final short year;
    
    public Date(byte day, byte month, short year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int day() {
        return this.day;
    }

    public int month() {
        return this.month;
    }

    public int year() {
        return this.year;
    }

    public int compare(Date other) {
        if(other.year() > this.year()){
            return 1;
        }else if(other.year() < this.year()){
            return -1;
        }else{
            if(other.month() < this.month()){
                return -1;
            }else if(other.month() > this.month()){
                return 1;
            }else{
                if(other.day() < this.day()){
                    return -1;
                }else if(other.day() > this.day()){
                    return 1;
                }else {return 0;}
            }
        }
    }

    public String toString() {
        return this.day+"/"+this.month+"/"+this.year;
    }

}