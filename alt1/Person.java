//
// Pure Model class Person with no JavaFX dependencies
// - Model classes in an MVC architecture should have
//   absolutely no dependencies to any GUI libraries
//
public class Person
{

protected String firstName;
protected String lastName;

public Person(String firstName, String lastName)
{
    this.firstName = firstName;
    this.lastName = lastName;
}

public String getFirstName()
{
    return firstName;
}

public String getLastName()
{
    return lastName;
}

public void capitalize()
{
    lastName = lastName.toUpperCase();
    System.out.println("changed to " + lastName);
    changed();
}

// invoke this whenever object is changed; view
// subclass will override it so that view GUI can change
protected void changed()
{
}

}
