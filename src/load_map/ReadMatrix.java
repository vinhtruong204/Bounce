package load_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMatrix {
    public static int[][] getMapMatrix() {
        String fileName = "map.txt"; // Replace with the actual file name

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Get the number of rows
            int numRows = Integer.parseInt(reader.readLine());

            // Get the number of columns
            int numCols = Integer.parseInt(reader.readLine());

            // Create the matrix
            int[][] matrix = new int[numRows][numCols];

            // Read the matrix elements
            for (int i = 0; i < numRows; i++) {
                String[] line = reader.readLine().split("\\s+"); // Split by spaces or other delimiters as needed
                for (int j = 0; j < numCols; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]); // Assuming integer values
                }
            }
            
            return matrix;
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

}
