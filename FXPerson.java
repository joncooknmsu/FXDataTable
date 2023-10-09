
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class FXPerson extends Person
{
public StringProperty firstNameProp;
public StringProperty lastNameProp;

public FXPerson(String firstName, String lastName)
{
    super(firstName, lastName);
    firstNameProp = new SimpleStringProperty(this, "firstName", this.firstName);
    lastNameProp = new SimpleStringProperty(this, "lastName", this.lastName);
    // setFirstName(firstName);
    // setLastName(lastName);
}

public StringProperty firstNameProperty() {
    return firstNameProp;
}

public StringProperty lastNameProperty() {
    return lastNameProp;
}

}
