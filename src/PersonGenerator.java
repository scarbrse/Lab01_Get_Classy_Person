import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class PersonGenerator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String fileName = "";
        boolean done = false;

        /** Create ArrayList */
        ArrayList<Person> personsRec = new ArrayList<Person>();
        do {
            String ID = SafeInput.getRegExString(in, "Enter ID #", "\\d{6}");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            String title = SafeInput.getNonZeroLenString(in, "Enter your title");
            int yob = SafeInput.getRangedInt(in, "Enter year of birth ", 1940, 2023);
            personsRec.add(new Person(ID, firstName, lastName, title, yob));
            System.out.println();
            done = SafeInput.getYNConfirm(in, "Submit another person?");
            System.out.println();
        } while (done);
        try{
            fileName = SafeInput.getNonZeroLenString(in, "Name your file");
            File workingDirectory = new File(System.getProperty("user.dir"));
            Path file = Paths.get(workingDirectory.getPath() + "//src//" + fileName + ".txt");
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));
            for(Person person : personsRec)
            {
                writer.write(person.toCSV());
                writer.newLine();
            }
            writer.close();
            System.out.println();
            System.out.println("Data file " + fileName + ".txt written!");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}