import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args)
    {

        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";
        int YOB = 0;
        boolean done = false;

        Scanner in = new Scanner(System.in);

        ArrayList<Person> People = new ArrayList<>();

        do {



            ID = SafeInput.getNonZeroLenString(in, "Enter the ID");
            fName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getRangedInt(in, "Enter the year for the age calc: ", 1000, 9999);


            Person p = new Person(ID, fName, lName, title, YOB);

            People.add(p);

            done = SafeInput.getYNConfirm(in, "Are you done");
        }while(!done);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\Persondata.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(Person p : People)
            {
              writer.write(p.toCSVRecord());
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