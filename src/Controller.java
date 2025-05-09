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

    public static String crearCoche(){
        String modelo = View.pedirModelo("Modelo del coche a crear?");
        String matricula = View.pedirMatricula("Matricula del coche a crear?");
        Model.crearCoche(modelo,matricula);
        return "Coche creado";
    }

    private static boolean cambiarVelocidad(String matricula,int velocidad){
        boolean resultado = true;
        //TODO mejorar el tratamiento para que no devuelva el mensaje de error y el mensaje de la velocidad

        try{
            int nuevaVelocidad = velocidad + Model.getVelocidad(matricula);
            Model.cambiarVelocidad(matricula,nuevaVelocidad);
        }catch (NullPointerException e){
            View.mensajeError("Coche inexistente");
            resultado = false;
        }
        return resultado;
    }

    public static String subirVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres subir la velocidad");
        int velocidad = View.pedirVelocidad("Cuanta velocidad quieres subirle?");
        boolean resultado = cambiarVelocidad(matricula,velocidad);
        if (resultado){
            return "Velocidad cambiada";
        }
        else return "Velocidad no cambiada";
    }

    public static String bajarVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres bajar la velocidad");
        int velocidad = View.pedirVelocidad("Cuanta velocidad quieres bajarle?") *(-1);
        boolean resultado = cambiarVelocidad(matricula,velocidad);
        if (resultado){
            return "Velocidad cambiada";
        }
        else return "Velocidad no cambiada";
    }

    public static boolean mostrarVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres ver velocidad"); //TODO tratar el caso de matricula inexistente
        int velocidad = Model.getVelocidad(matricula);
        View.muestraVelocidad(matricula,velocidad);
        return true;
    }

    public static ArrayList<String> mostrarCoches(){
        ArrayList<Coche> coches = Model.parking;
        ArrayList<String> datosCoches = new ArrayList<>();
        for (Coche coche:coches){
            datosCoches.add("Matricula: "+coche.matricula+". Modelo: "+coche.modelo+". Velocidad: "+coche.velocidad+"km/hr");
        }
        return datosCoches;
    }
}