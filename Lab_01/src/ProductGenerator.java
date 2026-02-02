import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args)
    {

        String ID = "";
        String productName = "";
        String Desc = "";
        Double cost;
        String csvRec = "";
        boolean done = false;

        Scanner in = new Scanner(System.in);

        ArrayList<Product> Products = new ArrayList<>();

        do {



            ID = SafeInput.getNonZeroLenString(in, "Enter the ID");
            productName = SafeInput.getNonZeroLenString(in, "Enter the product name");
            Desc = SafeInput.getNonZeroLenString(in, "Enter the description");
            cost = SafeInput.getRangedDouble(in, "Enter the cost of the product ", 10, 9999);


            Product e = new Product(ID, productName, Desc, cost);

            Products.add(e);

            done = SafeInput.getYNConfirm(in, "Are you done");
        }while(!done);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\Productdata.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(Product e : Products)
            {
                writer.write(e.toCSVRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
