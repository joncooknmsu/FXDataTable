
//
// This class reads a CSV file for roster names. It is NOT
// a robust CSV reader, for a real application that needed
// to read/write CSV files, use https://opencsv.sourceforge.net/
//
// some CSV code here based on:
//   https://www.baeldung.com/java-csv-file-array
//
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;
//import java.util.ArrayList;

public class Roster
{
protected List<Person> members;

public Roster()
{
    members = new ArrayList<Person>();
}

public boolean initialize(String filename)
{
    Scanner scanner;
    try {
        scanner = new Scanner(new File(filename));
        //scanner.useDelimiter("[,\\s]+");
        scanner.useDelimiter("[,\\n]");
        while (scanner.hasNext()) {
            String firstname = scanner.next();
            String lastname = scanner.next();
            members.add(TableApp.factory.newPerson(firstname, lastname));
        }
    } catch (IOException e) {
        System.err.println("I/O Error" + e);
        return false;
    }
    changed();
    return true;
}

public void dump()
{
    System.out.println("Roster\n======");
    for (Person p: members) {
        System.out.println("member: " + p);
    }
}

protected void changed()
{
}

}
