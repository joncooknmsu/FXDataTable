//
// JavaFX specific subclass for our Model class Person
// - this subclass should be considered as part of the
//   View in an MVC architecture
//
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class FXPerson extends Person
{
private StringProperty firstNameProp;
private StringProperty lastNameProp;

public FXPerson(String firstName, String lastName)
{
    super(firstName, lastName);
    firstNameProp = new SimpleStringProperty(this, "firstName", this.firstName);
    lastNameProp = new SimpleStringProperty(this, "lastName", this.lastName);
}

public StringProperty firstNameProperty() {
    return firstNameProp;
}

public StringProperty lastNameProperty() {
    return lastNameProp;
}

// we update the viewable properties when we know
// the object has changed
@Override
protected void changed()
{
    firstNameProp.setValue(firstName);
    lastNameProp.setValue(lastName);
}

}
