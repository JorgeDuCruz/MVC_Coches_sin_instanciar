public class ObserverGasolina {
    private final static int minimoGas=10; // Minimo de gasolina para que no sea alarmante

    /**
     * Funcion para comprobar la gasolina de un coche recien modificado y avisar en caso de tener menos de 10 de gasolina
     * @param c coche recien modificado
     */
    public static void update(Coche c){
        if (c.gasolina<minimoGas){
            View.alarmaGasolina();
        }
    }
}
