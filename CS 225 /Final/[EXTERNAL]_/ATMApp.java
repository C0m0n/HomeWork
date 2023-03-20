import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ATMApp extends Application {
    
    //Label page names
    public static enum PageName{
        LOGIN,
        MAINPAGE,
        CREATE,
        TRANSFER
    }
    
    //Use map to map pages to the names
    private Map<PageName, Pane> pages = Map.of(PageName.LOGIN, new LoginPage(), PageName.CREATE, new Create(), PageName.MAINPAGE, new MainPage(), PageName.TRANSFER, new Transfer());
    //
    
    //Declare the different elements of the Gui
    // Pane
    private BorderPane borderPane;
    
    //Menu items
    private MenuBar menuBar;
    private Menu menuFile, menuOptions, menuHelp;
    private MenuItem menuClose, menuPrint, menuChangePin, menuCreateNew, menuLogOut;

    public void setupPane(){

        //Creating the elements for the menu
        borderPane = new BorderPane();
        //Menubar
        menuBar = new MenuBar();
        //Tabs for the menu
        menuFile = new Menu("File");
        menuOptions = new Menu("Options");
        menuHelp = new Menu("Help");
        //Elements that will go inside the dropdowns
        menuClose = new MenuItem("Close");
        menuPrint = new MenuItem("Print to File");
        menuChangePin = new MenuItem("Change Pin");
        menuCreateNew = new MenuItem("Create new Account");
        menuLogOut = new MenuItem("Log Out");

        //Assign menu elements to the correct tab
        menuFile.getItems().addAll(menuClose, menuPrint);
        menuOptions.getItems().addAll(menuChangePin,menuCreateNew,menuLogOut);

        //Add all the menu tabs to the menu bar
        menuBar.getMenus().addAll(menuFile,menuOptions,menuHelp);
    }

    public ATMApp(){
        setupPane();
        setupEventHandlers();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create a rectangle 2D object to obtain the screen size
        Rectangle2D screenSize = Screen.getPrimary().getBounds();

        //Create a scene with 75% of screen size
        Scene scene = new Scene(borderPane, screenSize.getWidth() * 0.75, screenSize.getHeight() * 0.75);

        //Set the menu bar
        borderPane.setTop(menuBar);
        primaryStage.setScene(scene);
        selectPage(PageName.LOGIN);
        primaryStage.setTitle("Eagle Bank ATM");
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        ATMApp.launch(args);
        
    }

    private void setupEventHandlers() {
        // When a page fires a "ChangePageEvent", the app
        // will tranfer to that event's specified page.

        // (This is a "for-each" loop, it will iterate
        // through each entry in our pages Map)
        // Syntax: for (variable : iterable) {}
        for (java.util.Map.Entry<ATMApp.PageName, Pane> entry : pages.entrySet()) {
            entry.getValue().addEventHandler(
                    ChangePageEvent.PAGE_CHANGE, // listening for a PAGE_CHANGE
                    (event) -> selectPage(event.getPageName()));
        }
    }
     
    
    void selectPage(PageName pageName){
        borderPane.setCenter(pages.get(pageName));
    }
    
}
