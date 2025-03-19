/**
 * Clase para el exámen de Test Unitarios de COD
 * Comprueba si la letra del DNI es correcta
 */

public class Main {
    public static void main(String[] args) {
        if (comprobarDNI("00000000", 'T')) {
            System.out.println("El DNI es correcto");
        } else {
            System.out.println("El DNI no es correcto");
        }
    }

    /**
     * Comprueba DNI y su letra para ver si es correcto
     *
     * @param dni
     * @param letra
     * @return true si es correcto, false si no lo es
     */
    public static boolean comprobarDNI(String dni, char letra) {
        // Verificar longitud y formato numérico del DNI
        if (dni.length() != 8 || !dni.matches("\\d+") || Integer.parseInt(dni) < 0) {
            return false;
        }

        // Calcular y comprobar la letra
        char letraCalculada = calcularLetraDNI(dni);
        return letraCalculada == letra;
    }

    /**
     * Calcula la letra de un DNI
     *
     * @param dni
     * @return la letra del DNI
     */
    public static char calcularLetraDNI(String dni) {
        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'Q', 'S', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = Integer.parseInt(dni) % 23;
        return letrasDNI[resto];
    }
}