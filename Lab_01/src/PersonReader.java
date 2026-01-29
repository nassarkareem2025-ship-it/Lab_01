import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        String id = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yob = 0;
        final int FIELDS_LENGTH = 5;

        ArrayList<Person> People = new ArrayList<>();
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
                        firstName = fields[1].trim();
                        lastName = fields[2].trim();
                        title = fields[3].trim();
                        yob = Integer.parseInt(fields[4].trim());

                        Person p = new Person(id, firstName, lastName, title, yob);
                        People.add(p);
                    }
                    else {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(rec);
                    }
                }
                reader.close();
                System.out.println("\n\nData file read!");
                System.out.printf("%-8s%-15s%-15s%-6s%s","ID#","Firstname","Lastname","Title","YOB");
                System.out.println("\n==============================================");

                for(Person p : People){
                    System.out.printf("\n%-8s%-15s%-15s%-6s%d",
                            p.getIDNum(),
                            p.getFirstName(),
                            p.getLastname(),
                            p.getTitle(),
                            p.getYOB());
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