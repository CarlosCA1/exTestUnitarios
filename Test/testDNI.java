import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDNI {

    @Test
    @DisplayName("Calcular letra DNI")
    public void testCalcularLetraDNI() {
        assertEquals('T', Main.calcularLetraDNI("00000000"));
        assertEquals('E', Main.calcularLetraDNI("99999999"));
        assertEquals('A', Main.calcularLetraDNI("00000003"));
    }

    @ParameterizedTest
    @DisplayName("Comprobar DNI")
    @CsvSource({
            // Casos válidos
            "00000000, T, true",
            "12345678, Z, true",
            "87654321, H, true",

            // Casos inválidos
            "12345678, A, false",  // Letra incorrecta
            "1234, A, false",      // DNI muy corto
            "123456789, X, false", // DNI muy largo
            "ABCDEFGH, T, false",  // DNI con letras
            "'', T, false",        // DNI vacío
            "-1234567, T, false",  // DNI negativo
            "00001234, P, true",   // DNI válido con ceros a la izquierda
            "99999999, E, true",   // Límite superior correcto
            "99999999, A, false",  // Límite superior con letra incorrecta
            "   12345678, Z, false", // Espacios en blanco al inicio
            "1234 5678, Z, false", // Espacios en blanco en medio
            "12345678   , Z, false", // Espacios en blanco al final
            "null, T, false"       // DNI null
    })
    public void testComprobarDNI(String dni, char letra, boolean esperado) {
        assertEquals(esperado, Main.comprobarDNI(dni, letra));
    }
}


