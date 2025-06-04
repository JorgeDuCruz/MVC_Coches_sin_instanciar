import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    /**
     * Menu inicial donde el usuario elegira que hacer dentro de las opciones preestablecidads
     */
    public static void menu(){
        int accion=-1;//variable para marcar la opcion elegida
        Scanner sc = new Scanner(System.in);//Scanner para recibir la informacion del usuario
        while (accion !=0) {
            //Muestra las distintas opciones que hay junto con el numero asociado a cada una
            System.out.println("1, Crear coche");
            System.out.println("2, subir velocidad");
            System.out.println("3, bajar velocidad");
            System.out.println("4, Mostrar velocidad");
            System.out.println("5, Mostrar todos los coches");
            System.out.println("6, Avanzar");
            System.out.println("7, Repostar");
            System.out.println("8, Mostrar gasolina");
            System.out.println("0, Salir");

            accion=sc.nextInt();//recibe la opcion elegida
            switch (accion){//elige la accion a realizar en base a la opcion elegida
                case 1-> {
                    System.out.println(Controller.crearCoche()); //Le indica al Controller que quieres crear un coche
                }
                case 2 ->{
                    System.out.println(Controller.subirVelocidad());//Le indica al Controller que quieres subir la velocidad de un coche
                }
                case 3->{
                    System.out.println(Controller.bajarVelocidad());//Le indica al Controller que quieres bajar la velocidad de un coche
                }
                case 4 ->{
                    Controller.mostrarVelocidad();//Le indica al Controller que quieres mostrar la velocidad de un coche
                }
                case 5 ->{
                    System.out.println(Controller.mostrarCoches());//Le indica al Controller que quieres mostrar todos los coches creados
                }
                case 6 ->{
                    int metros= pedirIntGenerico("Cuantos metros deseas avanzar?"); //Pregunta y captura los metros a avanzar
                    Coche aux  = Controller.avanzar(metros); //indica que avance al controller a si como cuanto debe avanzar y guarda la gasolina restante
                    mostrarGasolina(aux.gasolina, aux.matricula);//Muestra la gasolina
                }
                case 7 ->{
                    int litros = pedirIntGenerico("Cuantos litros deseas repostar");//Pregunta y captura los litros a repostar
                    Coche aux = Controller.repostar(litros);//indica que hay que repostar al controller asi como cuanto hay que repostar y guarda la gasolina despues de repostar
                    mostrarGasolina(aux.gasolina,aux.matricula);//Muestra la gasolina
                }
                case 8 ->{
                    Controller.mostrarGasolina();
                }
                default -> accion=0; // si no detecta una opcion valida convierte la opcion a la opcion de salir del programa
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

    /**
     * Funcion para pedir el modelo de un coche
     * @param msg mensaje para indicarle al usuario el motivo de pedir un modelo de coche
     * @return String con el modelo recibido
     */
    public static String pedirModelo(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        String modelo = sc.next();
        return modelo;
    }

    /**
     * Funcion para pedir la matricula de un coche
     * @param msg mensaje para indicarle al usuario el motivo de pedir una matricula de coche
     * @return String con la matricula recibida
     */
    public static String pedirMatricula(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        String matricula = sc.next();
        return matricula;
    }

    /**
     * Funcion para pedir la velocidad de un coche
     * @param msg mensaje para indicarle al usuario el motivo de pedir una velocidad
     * @return int con la velocidad recibida
     */
    public static int pedirVelocidad(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int velocidad = sc.nextInt();
        return velocidad;
    }

    /**
     * Funcion para recibir mensajes de error y mostralos por pantalla
     * @param msg mensaje de error
     * @return True para tets
     */
    public static boolean mensajeError(String msg){
        System.out.println(msg);
        return true;
    }

    /**
     * Funcion para pedirle al usuario una variable tipo int
     * @param msg mensaje para que el usuario sepa que numero tiene que introducir
     * @return el numero ingresado por el usuario
     */
    public static int pedirIntGenerico(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int generico = sc.nextInt();
        return generico;
    }

    /**
     * Funcion para mostrar la gasolina que le queda a un coche
     * @param gasolina gasolina que le queda a un coche
     */
    public static void mostrarGasolina(int gasolina, String matricula){
        System.out.println("El coche de matricula "+matricula+" ahora tiene "+gasolina+" litros de gasolina");
    }

    /**
     * Funcion para mostrar una alerta cuando sea necesaria
     */
    public static void alarmaGasolina(){
        System.out.println("Alerta: Repostar");
    }
}
