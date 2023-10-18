
//
// Main app class for JavaFX simple MVC table example
// - this class has both View and Controller content
// 
import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.beans.value.*;
import java.util.List;
import javafx.collections.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class TableApp extends Application
{

static final ModelFactory factory = new FXModelFactory();
private static String rosterFilename = "roster.csv";
static TableApp app;

private BorderPane pane = null;
private Scene scene = null;
private FXRoster roster = null;
// TableAppController controller;
// Pane gamePane;
// Slider speedSlider;

// set app to last object created; this is currently not used but the JavaFX
// runtime creates TWO TableApp objects: on the first it runs init() and
// then start(), and then the second object is the one that actually exists
// when your program is running. So if you had stuff in this class that you
// needed, a static reference to this second object would be handy.
public TableApp()
{
    app = this;
}

@Override
public void init()
{
    // API docs say "NOTE: This method is not called on the JavaFX
    // Application Thread. An application must not construct a Scene
    // or a Stage in this method. An application may construct other
    // JavaFX objects in this method.
    pane = new BorderPane();
    // controller = new TableAppController(pane);

    /***
     * hardcoded list from Java API example ***
     * List<FXPerson> members = List.of(
     * new FXPerson("William", "Reed"),
     * new FXPerson("James", "Michaelson"),
     * new FXPerson("Julius", "Dean"));
     * ObservableList<FXPerson> teamMembers =
     * FXCollections.observableArrayList(members);
     **/

    // roster = (FXRoster) TableApp.factory.newRoster();
    roster = new FXRoster(); // don't really need the factory here
    if (!roster.initialize(rosterFilename)) {
        System.err.println("Error initializing roster");
        return; // need to exit here!
    }
    roster.dump();
    ObservableList<FXPerson> teamMembers = FXCollections.observableArrayList(roster.viewRoster());

    // TableView<Person> table = new TableView<>();
    // table.setItems(teamMembers);
    TableView<FXPerson> table = new TableView<>(teamMembers);

    TableColumn<FXPerson, String> firstNameCol = new TableColumn<>("First Name");
    // firstNameCol.setCellValueFactory(new
    // PropertyValueFactory<>(members.get(0).firstNameProperty().getName()));
    firstNameCol.setCellValueFactory(new PropertyValueFactory<FXPerson, String>("firstName"));
    TableColumn<FXPerson, String> lastNameCol = new TableColumn<>("Last Name");
    // lastNameCol.setCellValueFactory(new
    // PropertyValueFactory<>(members.get(0).lastNameProperty().getName()));
    lastNameCol.setCellValueFactory(new PropertyValueFactory<FXPerson, String>("lastName"));
    table.getColumns().setAll(firstNameCol, lastNameCol);

    Button caseButton = new Button("Change Case");
    caseButton.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e)
    {
        int i = table.getSelectionModel().getSelectedIndex();
        teamMembers.get(i).capitalize();
    }
    });
    pane.setCenter(table);
    pane.setBottom(caseButton);
}

@Override
public void start(Stage primaryStage)
{
    scene = new Scene(pane);
    // controller.initialize();

    // If you need the controller object, the line below works
    // TableAppController controller = (TableAppController) loader.getController();
    // I haven't tried using CSS yet, but the below might work
    // scene.getStylesheets().add("style.css");
    primaryStage.setTitle("TableExample");
    primaryStage.setScene(scene);
    primaryStage.show();
    // System.out.println("FXApp:"+this);
}

public static void main(String[] args)
{
    if (args.length > 0)
        rosterFilename = args[0];
    Application.launch(args);
}

} // end class
