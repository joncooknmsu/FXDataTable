//
// Roster subclass for JavaFX
//
import java.util.List;
import java.util.Collections;

public class FXRoster extends Roster
{

@Override
protected void changed()
{
}

public List<FXPerson> viewRoster()
{
    // the inner expression forces Java to allow me to cast the list
    // to what it truly is, but it is unsafe; there may be a better way...;
    // the wrapper make the list read-only (but not the elements)
    return Collections.unmodifiableList((List<FXPerson>) ((List<?>) members));
}

}
