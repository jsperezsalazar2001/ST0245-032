
/**
 * Contiene el método que calcula si hay un subgrupo de sumados den el resultado que se espera.
 * 
 *  @author (Yhoan Alejandro Guzman García) 
 *  @author (Juan Sebastián Pérez Salazar)
 *  @version 1
 */
public class SumaGrupo
{
    /**
     * Este método calcula si hay un subgrupo de el conjunto que al sumarse den el target 
     * @param int start con este valor empieza el método
     * @param int[] nums este es el grupo de elementos con los que se trabaja
     * @param int target este es el valor al que se debe llegar 
     * @return boolean returna true o false si se llega al resultado esperado o no, el cual es target 
     */
    public static boolean sumaGrupo(int start, int[] nums, int target) {
          return start >= nums.length ? target == 0 :
          sumaGrupo(start+1, nums, target - nums[start])|| sumaGrupo(start+1, nums, target);
    }
    
    /**
     * En este método se hacen las pruebas del método anterior.
     */
    public static void pruebaSumaGrupo() {
        int[] nums={1,4,8};
        System.out.println(sumaGrupo(0, nums, 10));
        System.out.println(sumaGrupo(0, nums, 14));
        System.out.println(sumaGrupo(0, nums, 9));
        System.out.println(sumaGrupo(0, nums, 7));
    }
}
