//
//
//
import java.util.List;

public class FXRoster extends Roster
{

    
@Override
public void changed()
{
}

public List<FXPerson> viewRoster() {
    // this forces Java to allow me to cast the list
    // to what it truly is, but it is unsafe; there may
    // be a better way...
    return (List<FXPerson>) ((List<?>) members);
}

}
