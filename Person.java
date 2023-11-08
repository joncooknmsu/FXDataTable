//
// Pure Model class Person with no JavaFX dependencies
// - Model classes in an MVC architecture should have
//   absolutely no dependencies to any GUI libraries
//
public class Person
{

protected String firstName;
protected String lastName;
protected double age;

public Person(String firstName, String lastName, double age)
{
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
}

public String toString()
{
    return firstName + " " + lastName + ": " + age;
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
