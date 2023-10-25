//
// Abstract factory for our Model classes
//
public abstract class ModelFactory
{
// modified singleton pattern for one factory object
protected static ModelFactory oneFactory = null;

protected ModelFactory()
{
    // disallow external classes from making objects
}

public static void makeFactory() throws java.lang.Exception
{
    // this method should never execute, but must be
    // redefined by a subclass, which must set the field
    // oneFactory to reference a factory object, e.g.:
    //   oneFactory = new SubclassModelFactory();
    throw (new java.lang.Exception("ModelFactory subclass must implement makeFactory()"));
}

public static ModelFactory factory()
{
    return oneFactory;
}

// factory methods for the creation of model objects are below here

public abstract Person newPerson(String firstName, String lastName);

public abstract Roster newRoster();
}
