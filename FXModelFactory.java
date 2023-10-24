//
// Factory implementation for JavaFX
//
public class FXModelFactory implements ModelFactory
{

public Person newPerson(String firstName, String lastName)
{
    return new FXPerson(firstName, lastName);
}

public Roster newRoster()
{
    return new FXRoster();
}
}
