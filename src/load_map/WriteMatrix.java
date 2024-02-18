package load_map;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class WriteMatrix {

    public static void main(String[] args) throws IOException {
        // Replace this with your actual matrix
        int[][] matrix = new int[12][18];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 18; j++) {
                matrix[i][j] = 0;
            }
        }

        String fileName = "map.txt"; // File name

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the number of rows and columns
            writer.write(matrix.length + "\n"); // Number of rows
            writer.write(matrix[0].length + "\n"); // Number of columns (assuming all rows have the same length)

            // Write the matrix elements
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    writer.write(matrix[i][j] + " "); // Write each element with a space
                }
                writer.write("\n"); // Newline after each row
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
