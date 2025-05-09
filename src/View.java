import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    /**
     * Menu inicial
     */
    public static void menu(){
        int accion=-1;
        Scanner sc = new Scanner(System.in);
        while (accion !=0) {
            System.out.println("1, Crear coche");
            System.out.println("2, subir velocidad");
            System.out.println("3, bajar velocidad");
            System.out.println("4, Mostrar velocidad");
            System.out.println("5, Mostrar todos los coches");
            System.out.println("0, Salir");
            accion=sc.nextInt();
            switch (accion){
                case 1-> {
                    System.out.println(Controller.crearCoche());
                }
                case 2 ->{
                    System.out.println(Controller.subirVelocidad());
                }
                case 3->{
                    System.out.println(Controller.bajarVelocidad());
                }
                case 4 ->{
                    Controller.mostrarVelocidad();
                }
                case 5 ->{
                    System.out.println(Controller.mostrarCoches());
                }
                default -> accion=0;
            }
        }
    }

    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public static boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }

    public static String pedirModelo(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        String modelo = sc.next();
        return modelo;
    }

    public static String pedirMatricula(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        String matricula = sc.next();
        return matricula;
    }

    public static int pedirVelocidad(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int velocidad = sc.nextInt();
        return velocidad;
    }
    public static boolean mensajeError(String msg){
        System.out.println(msg);
        return true;
    }
}
