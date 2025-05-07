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

    public static String cambiarVelocidad(){
        String resultado = "Velocidad cambiada";
        String matricula = View.pedirMatricula("Matricula del coche que quieres cambiar la velocidad"); //TODO mejorar el tratamiento para que no devuelva el mensaje de error y el mensaje de la velocidad
        int velocidad = View.pedirVelocidad("Velocidad actualizada");
        try{
            if (velocidad==Model.getVelocidad(matricula)) resultado = "Velocidad no cambiada";
            else Model.cambiarVelocidad(matricula,velocidad);
        }catch (NullPointerException e){
            View.mensajeError("Coche inexistente");
            resultado = "Velocidad no cambiada";
        }
        return resultado;
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