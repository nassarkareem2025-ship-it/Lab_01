import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        String id = "";
        String pName = "";
        String Desc = "";
        Double cost = (double) 0;
        final int FIELDS_LENGTH = 4;

        ArrayList<Product> Products = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(workingDirectory);

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            try {
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                int line = 0;
                while(reader.ready())
                {
                    String rec = reader.readLine();
                    line++;

                    String[] fields = rec.split(",");

                    if(fields.length == FIELDS_LENGTH){
                        id = fields[0].trim();
                        pName = fields[1].trim();
                        Desc = fields[2].trim();
                        cost = Double.parseDouble(fields[3].trim());

                        Product e = new Product(id,pName, Desc, cost);
                        Products.add(e);
                    }
                    else {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(rec);
                    }
                }
                reader.close();
                System.out.println("\n\nData file read!");
                System.out.printf("%-8s%-15s%-15s%-10.2s","ID#","ProductName","Description","Cost");
                System.out.println("\n==============================================");

                for(Product e :Products){
                    System.out.printf("\n%-8s%-15s%-15s%-10.2f",
                            e.getID(),
                            e.getName(),
                            e.getDescription(),
                            e.getCost());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{

        }

    }
}
