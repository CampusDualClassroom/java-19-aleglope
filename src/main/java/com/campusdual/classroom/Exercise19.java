package com.campusdual.classroom;

/**
 * La clase {@code Exercise19} proporciona métodos para crear, poblar y convertir arrays unidimensionales,
 * bidimensionales y tridimensionales de tipo entero. También incluye métodos para convertir estos arrays
 * en representaciones de cadenas de texto para su visualización.
 * <p>
 * Incluye métodos para:
 * <ul>
 *     <li>Crear y poblar arrays unidimensionales, bidimensionales y tridimensionales.</li>
 *     <li>Convertir arrays unidimensionales y bidimensionales en cadenas de texto.</li>
 *     <li>Aplanar arrays tridimensionales a bidimensionales.</li>
 * </ul>
 * </p>
 *
 * @version 1.0
 */
public class Exercise19 {

    /**
     * Convierte un array tridimensional a una representación de cadena de texto que muestra
     * la matriz aplanada junto con la matriz original.
     *
     * @param intArrayTri El array tridimensional de enteros.
     * @param flatMatrix  El array bidimensional aplanado.
     * @return Una cadena que representa tanto la matriz aplanada como la original.
     */
    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {
        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /**
     * Convierte una fila específica de un array tridimensional en una representación de cadena.
     *
     * @param intArrayTri El array tridimensional de enteros.
     * @param row         El índice de la fila a convertir.
     * @return Una cadena que representa la fila especificada del array tridimensional.
     */
    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));
        return sb.toString();
    }

    /**
     * Convierte una fila específica de un array bidimensional a una representación de cadena.
     *
     * @param flatMatrix El array bidimensional aplanado.
     * @param row        El índice de la fila a convertir.
     * @return Una cadena que representa la fila especificada del array bidimensional.
     */
    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    /**
     * Convierte un array tridimensional de enteros en una representación de cadena que incluye
     * tanto la matriz original como la matriz aplanada.
     *
     * @param intArrayTri El array tridimensional de enteros.
     * @return Una cadena que representa tanto la matriz aplanada como la original.
     */
    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    /**
     * Aplana un array tridimensional sumando los elementos que tienen la misma posición en cada capa.
     *
     * @param intArrayTri El array tridimensional de enteros.
     * @return Un array bidimensional que resulta del aplanamiento del array tridimensional.
     */
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int depth = intArrayTri.length;
        int rows = intArrayTri[0].length;
        int columns = intArrayTri[0][0].length;

        int[][] flatMatrix = new int[rows][columns];

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    flatMatrix[j][k] += intArrayTri[i][j][k];
                }
            }
        }

        return flatMatrix;
    }

    /**
     * Convierte un array bidimensional de enteros en una representación de cadena donde cada fila
     * está separada por un salto de línea y los elementos están separados por espacios.
     *
     * @param intArrayBi El array bidimensional de enteros.
     * @return Una cadena que representa el array bidimensional.
     */
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(getUnidimensionalString(intArrayBi[i]));
            if (i < intArrayBi.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Convierte un array unidimensional de enteros en una representación de cadena donde los elementos
     * están separados por espacios.
     *
     * @param uniArray El array unidimensional de enteros.
     * @return Una cadena que representa el array unidimensional.
     */
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);
            if (i < uniArray.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * Crea y pobla un array unidimensional de enteros con los primeros N números naturales.
     *
     * @param columns El número de elementos que tendrá el array.
     * @return Un array unidimensional de enteros inicializado con los primeros N números naturales.
     */
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] uniArray = new int[columns];
        for (int i = 0; i < columns; i++) {
            uniArray[i] = i + 1;
        }
        return uniArray;
    }

    /**
     * Crea y pobla un array bidimensional de enteros con los primeros N números naturales.
     *
     * @param rows    El número de filas que tendrá el array bidimensional.
     * @param columns El número de columnas que tendrá el array bidimensional.
     * @return Un array bidimensional de enteros inicializado con los primeros N números naturales.
     */
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] biArray = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                biArray[i][j] = value++;
            }
        }
        return biArray;
    }

    /**
     * Crea y pobla un array tridimensional de enteros con los primeros N números naturales.
     *
     * @param depth   El número de capas (profundidad) que tendrá el array tridimensional.
     * @param rows    El número de filas que tendrá cada capa del array tridimensional.
     * @param columns El número de columnas que tendrá cada fila del array tridimensional.
     * @return Un array tridimensional de enteros inicializado con los primeros N números naturales.
     */
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] triArray = new int[depth][rows][columns];
        int value = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    triArray[i][j][k] = value++;
                }
            }
        }
        return triArray;
    }

    /**
     * Punto de entrada del programa que demuestra la creación, conversión y visualización
     * de arrays unidimensionales, bidimensionales y tridimensionales.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Crear y poblar un array unidimensional
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");

        // Crear y poblar un array bidimensional
        int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");

        // Crear y poblar un array tridimensional
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
