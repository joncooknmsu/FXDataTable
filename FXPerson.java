
//
// JavaFX specific subclass for our Model class Person
// - this subclass should be considered as part of the
//   View in an MVC architecture
//
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class FXPerson extends Person
{
private StringProperty firstNameProp;
private StringProperty lastNameProp;
private DoubleProperty ageProp;

public FXPerson(String firstName, String lastName, double age)
{
    super(firstName, lastName, age);
    firstNameProp = new SimpleStringProperty(this, "firstName", this.firstName);
    lastNameProp = new SimpleStringProperty(this, "lastName", this.lastName);
    ageProp = new SimpleDoubleProperty(this, "age", this.age);
}

public StringProperty firstNameProperty()
{
    return firstNameProp;
}

public StringProperty lastNameProperty()
{
    return lastNameProp;
}

public DoubleProperty ageProperty()
{
    return ageProp;
}

// we update the viewable properties when we know
// the object has changed
@Override
protected void changed()
{
    firstNameProp.setValue(firstName);
    lastNameProp.setValue(lastName);
    ageProp.setValue(age);
}

}
