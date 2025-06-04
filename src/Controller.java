import java.util.ArrayList;

public class Controller {
    public static void inicio() {
        // Crear tres coches
        Model.crearCoche("LaFerrari", "SBC 1234");
        Model.crearCoche("Alpine", "HYU 4567");
        Model.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = Model.getCoche("SBC 1234");
        // modifica la velocidad
        int nuevaVelocidad = Model.cambiarVelocidad("SBC 1234", 30);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = View.muestraVelocidad("SBC 1234", Model.getVelocidad("SBC 1234"));

        if (hecho) {
            System.out.println("Correcto");
        } else {
            System.out.println("Error");
        } ;
    }

    /**
     * Funcion para crear un coche
     * @return una string con el mensaje de Coche creado
     */
    public static String crearCoche(){
        String modelo = View.pedirModelo("Modelo del coche a crear?"); //Le pide a la View que le pida al usuario el modelo del coche
        String matricula = View.pedirMatricula("Matricula del coche a crear?"); //Le pide a la View que le pida al usuario la matricula del coche
        Model.crearCoche(modelo,matricula); //Le indica al model que cree el coche
        return "Coche creado";
    }

    /**
     * Funcion para cambiar la velocidad a un coche
     * @param matricula matricula del coche que va a cambiar su velocidad
     * @param velocidad velocidad que se quiere sumar a la velocidad que ya tenia
     * @return True si pudo cambiar la velocidad // False si no encuentra el coche para cambiar la velocidad
     */
    private static boolean cambiarVelocidad(String matricula,int velocidad){
        boolean resultado = true; // valor de si pudo o no cambiar la velocidad, se entiende que en principio se puede hacer
        //TODO mejorar el tratamiento para que no devuelva el mensaje de error y el mensaje de la velocidad

        try{
            int nuevaVelocidad = velocidad + Model.getVelocidad(matricula); // calcula la velocidad resultante despues del cambio
            Model.cambiarVelocidad(matricula,nuevaVelocidad);//le indica al Model la nueva velocidad del coche
        }catch (NullPointerException e){//detecta si no encutra el coche
            View.mensajeError("Coche inexistente"); //le manda a la view que hubo un error
            resultado = false;
        }
        return resultado;
    }

    /**
     * Funcion para subir la velocidad de un coche
     * @return String que indica si la velocidad se pudo cambiar o no
     */
    public static String subirVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres subir la velocidad");//Le pide a la View que le pida al usuario la matricula del coche
        int velocidad = View.pedirVelocidad("Cuanta velocidad quieres subirle?");//Le pide a la View que le pida al usuario la velocidad a subir para el coche
        boolean resultado = cambiarVelocidad(matricula,velocidad); // funcion para cambiar la velocidad
        if (resultado){
            return "Velocidad cambiada";
        }
        else return "Velocidad no cambiada";
    }

    /**
     * Funcion para bajar la velocidad de un coche
     * @return String que indica si la velocidad se pudo cambiar o no
     */
    public static String bajarVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres bajar la velocidad");//Le pide a la View que le pida al usuario la matricula del coche
        int velocidad = View.pedirVelocidad("Cuanta velocidad quieres bajarle?") *(-1);//Le pide a la View que le pida al usuario la velocidad a bajar para el coche y la vuelve negativa para indicar que es una reduccion
        boolean resultado = cambiarVelocidad(matricula,velocidad);//funcion para cambiar la velocidad
        if (resultado){
            return "Velocidad cambiada";
        }
        else return "Velocidad no cambiada";
    }

    /**
     * Funcion para mostrar la velocidad de un coche
     * @return True para tests
     */
    public static boolean mostrarVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres ver velocidad"); //Le pide a la View que le pida al usuario la matricula del coche
        //TODO tratar el caso de matricula inexistente
        int velocidad = Model.getVelocidad(matricula);//recive del model la velocidad del coche
        View.muestraVelocidad(matricula,velocidad);//le indica a la view que muestre la velocidad
        return true;
    }

    /**
     * Funcion para mostrar los coches creados
     * @return ArrayList de Strings con los datos de los coches
     */
    public static ArrayList<String> mostrarCoches(){
        ArrayList<Coche> coches = Model.getParking();//Le pide al Model los datos de todos los coches creados
        ArrayList<String> datosCoches = new ArrayList<>();//Crea el ArrayList que contendra los datos de los coches en Strings
        for (Coche coche:coches){ // for para pasar los datos de los coches al Array de Strings
            datosCoches.add("Matricula: "+coche.matricula+". Modelo: "+coche.modelo+". Velocidad: "+coche.velocidad+"km/hr");//Pasa los datos de los coches a Strings porque la clase Coche no tiene un metodo toString
        }
        return datosCoches;
    }

    /**
     * Funcion para repostar la gasolina de un coche
     * @param gasolina gasolina que vas a repostar
     * @return coche repostado
     */
    public static Coche repostar(int gasolina){
        String mat = View.pedirMatricula("Matricula del coche que va a repostar?");
        Coche aux = Model.repostar(gasolina,mat);
        return aux;
    }

    /**
     * Funcion para avanzar un coche
     * @param metros cantidad que avanza el coche
     * @return coche avanzado
     */
    public static Coche avanzar(int metros){
        String mat = View.pedirMatricula("Matricula del coche que avanza?");
        Coche aux = Model.avanzar(metros,mat);
        return aux;
    }

    /**
     * Funcion para mostrar la gasolina de una coche
     */
    public static void mostrarGasolina(){
        String mat = View.pedirMatricula("Matricula del coche al que quiere revisar la gasolina");//Le pide al usuario la matricula del coche que quiere revisar su gasolina
        Coche aux = Model.getCoche(mat);
        View.mostrarGasolina(aux.gasolina,aux.matricula);
    }
}