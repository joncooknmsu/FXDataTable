//
// Abstract factory for our Model classes
//
public interface ModelFactory
{
public Person newPerson(String firstName, String lastName);
public Roster newRoster();
}
