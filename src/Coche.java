public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;
    Integer gasolina;

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.gasolina=100;
    }
    public void setGasolina(int gasolina){
        if (gasolina<0){
            this.gasolina=0;
        }
        else {this.gasolina=gasolina;}
    }
}
