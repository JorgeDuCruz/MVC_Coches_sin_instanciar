public class ObserverGasolina {
    private final static int minimoGas=10;
    public static void update(Coche c){
        if (c.gasolina<minimoGas){
            View.alarmaGasolina();
        }
    }
}
