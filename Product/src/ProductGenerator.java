import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
   public static void main(String[] args) {

      ArrayList<Product> productList = new ArrayList<>();
      Scanner in = new Scanner(System.in);
      String filePath = "C:\\Users\\tadpo\\IdeaProjects\\Product\\src\\productTestData.txt";

      boolean done = false;

      do {

         String IDNum = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
         String name = SafeInput.getNonZeroLenString(in, "Enter the name");
         String description = SafeInput.getNonZeroLenString(in, "Enter the description");
         double cost = SafeInput.getRangedDouble(in, "Enter the cost", 0,999999);

         done = SafeInput.getYNConfirm(in, "Are you done?");

         Product product = new Product(IDNum, name, description, cost);
         productList.add(product);
      } while (!done);


      in.close();


      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
         for (Product product : productList) {

            String csvRecord = String.format("%s,%s,%s,%s,%f\n", product.getIDNum(), product.getName(),
                    product.getDescription(), product.getIDNum(), product.getCost());
            writer.write(csvRecord);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      System.out.println("Data written to " + filePath);
   }
}
