import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistroPersonasTest {
    private RegistroPersonas registro;

    @BeforeEach
    public void setup() {
        // Resetea el registro antes de cada prueba
        RegistroPersonas.limpiarRegistro();
    }

    @Test
    public void testContarMayoresEdad() {
        // Agregar personas de prueba
        registro.agregarPersona("Juan", "Soltero/a", 20);
        registro.agregarPersona("Ana", "Casado/a", 17);
        registro.agregarPersona("Isabel", "Casado/a", 76);

        // Verificar la cantidad de mayores de edad
        assertEquals(2, registro.contarMayoresEdad());
    }

    @Test
    public void testContarMenoresEdad() {
        // Agregar personas de prueba
        registro.agregarPersona("Juan", "Soltero/a", 20);
        registro.agregarPersona("Ana", "Casado/a", 17);
        registro.agregarPersona("Isabel", "Casado/a", 76);

        // Verificar la cantidad de menores de edad
        assertEquals(1, registro.contarMenoresEdad());
    }

    @Test
    public void testContarPorEstadoCivil() {
        // Agregar personas de prueba
        registro.agregarPersona("Juan", "Soltero/a", 25);
        registro.agregarPersona("Ana", "Casado/a", 30);
        registro.agregarPersona("Isabel", "Casado/a", 76);

        // Verificar la cantidad de solteros y casados
        int[] resultado = registro.contarPorEstadoCivil();
        assertEquals(1, resultado[0]); // Solteros
        assertEquals(2, resultado[1]); // Casados
    }

    @Test
    public void testVerificarAdultoMayor() {
        // Agregar personas de prueba
        registro.agregarPersona("Juan", "Soltero/a", 25);
        registro.agregarPersona("Ana", "Casado/a", 30);
        registro.agregarPersona("Isabel", "Casado/a", 76);

        // Verificar la cantidad de adultos mayores
        assertEquals(1, registro.verificarAdultoMayor());
    }

    @Test
    public void testValidarEntradaNoNumericaEdad() {
        // Simular entrada no numérica en el campo de edad
        String simulatedInput = "abc\n25\n"; // Primera entrada inválida, segunda válida
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        int edad = registro.leerEdad(); // Se espera que el método solicite de nuevo la entrada
        assertEquals(25, edad); // La edad válida debe ser devuelta
    }
}
