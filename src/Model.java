import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public static int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public static int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    /**
     * Funcion para devolver el parking
     * @return el ArrayList de coches de la propiedad parking
     */
    public static ArrayList<Coche> getParking() {
        return parking;
    }

    /**
     * Funcion para repostar un coche
     * @param gasolina gasolina a repostar
     * @param matricula matricula del coche que se va a repostar
     * @return coche repostado
     */
    public static Coche repostar(int gasolina,String matricula){
        Coche aux = getCoche(matricula);
        int nGasolina = aux.gasolina+gasolina; // calcula la nueva cantidad de gasolina del coche
        aux.setGasolina(nGasolina);
        notifyObservers(aux);
        return aux;
    }

    /**
     * Funcion para avanzar un coche que lo unico que hace es reducir su gasolina
     * @param metros cantida que avanza. Se usa para calular la gasolina a restar
     * @param matricula matricula del coche que va a avanzar
     * @return coche que ha avanzado
     */
    public static Coche avanzar(int metros, String matricula){
        Coche aux = getCoche(matricula);
        int gasolinaConsuimda = metros+aux.velocidad;
        int gasolinaRestante = aux.gasolina - gasolinaConsuimda; // calcula la nueva cantidad de gasolina del coche
        aux.setGasolina(gasolinaRestante);
        notifyObservers(aux);
        return aux;
    }

    private static void notifyObservers(Coche aux){
        ObserverGasolina.update(aux);
    }
}
