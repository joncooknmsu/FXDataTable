//
// Factory implementation for JavaFX
//
public class FXModelFactory extends ModelFactory
{

private FXModelFactory()
{
    // disallow external classes from making objects
}

public static void makeFactory()
{
    oneFactory = new FXModelFactory();
}

public Person newPerson(String firstName, String lastName, double age)
{
    return new FXPerson(firstName, lastName, age);
}

public Roster newRoster()
{
    return new FXRoster();
}
}
