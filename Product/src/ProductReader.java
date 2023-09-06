import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();

        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);


        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String csvFilePath = chooser.getSelectedFile().getAbsolutePath();

            ArrayList<String[]> data = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowData = line.split(",");
                    data.add(rowData);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("ID#     Name        Description                Cost");
            System.out.println("======================================================");
            for (String[] row : data) {
                if (row.length >= 4) {
                    String id = row[0].trim();
                    String name = row[1].trim();
                    String description = row[2].trim();
                    String costStr = row[3].trim();

                    try {
                        double cost = Double.parseDouble(costStr);

                        System.out.printf("%-7s %-11s %-26s %-6.2f%n", id, name, description, cost);
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid cost value: " + costStr);
                    }
                } 
            }
        }else{
            System.out.println("No file selected.");
        }
    }
}
