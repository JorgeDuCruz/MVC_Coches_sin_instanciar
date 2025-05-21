import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    @Test
    void crearCoche() {

        Coche aux = new Coche("zeat","BXK 1234");
        Coche dev=Model.crearCoche("zeat","BXK 1234");

        Assertions.assertEquals(aux.modelo,dev.modelo);
        Assertions.assertEquals(aux.velocidad,dev.velocidad);
        Assertions.assertEquals(aux.matricula,dev.matricula);
    }

    @Test
    void crearCocheDuplicado() {

        String matricula="BXK 1234",modelo="zeat";
        Coche dev=Model.crearCoche(modelo,matricula);
        Coche dev1=Model.crearCoche(modelo,matricula);

        Assertions.assertEquals(Model.getCoche(matricula),dev);
        Assertions.assertNull(dev1);
    }

    @Test
    @DisplayName("test getCoche")
    void getCoche() {
        String matricula = "BXK 1244",modelo="Citroen";

        Model.crearCoche(modelo,matricula);
        Coche dev = Model.getCoche(matricula);

        Assertions.assertEquals(modelo,dev.modelo);
        Assertions.assertEquals(0,dev.velocidad);
        Assertions.assertEquals(matricula,dev.matricula);
    }

    @Test
    @DisplayName("test getCoche con matricula inecistente")
    void getCocheMatricula() {
        String matricula = "BXK 1",modelo="Citroen";
        Model.crearCoche(modelo,matricula);


        Assertions.assertNull(Model.getCoche("BXJ 1"));

    }

    @Test
    void cambiarVelocidad() {
        String matricula = "BXK 1434";
        Model.crearCoche("Citroen",matricula);
        int velocida=15;

        Assertions.assertEquals(velocida,Model.cambiarVelocidad(matricula,velocida));
    }

    @Test
    void cambiarVelocidadSinMatricula() {
        String matricula = "BXK 1434";
        Model.crearCoche("Citroen",matricula);
        int velocida=15;

        Assertions.assertNull(Model.cambiarVelocidad(matricula+"1",velocida));
    }

    @Test
    void getVelocidad() {
        String matricula = "BXK 4234";
        Model.crearCoche("zeat",matricula);

        Assertions.assertEquals(0,Model.getVelocidad(matricula));

    }
    @Test
    void getVelocidadSinMatricula() {
        String matricula = "BXK 4234";
        Model.crearCoche("zeat",matricula);

        Assertions.assertNull(Model.getVelocidad(matricula+"1"));

    }
}