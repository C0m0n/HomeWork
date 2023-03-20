import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RaceGameGUI extends Application {


	private BorderPane borderPane;
	private Pane shapePane;
	private MenuBar menuBar;
	private Menu menuFile;
	private MenuItem start;
	private MenuItem close;

	private Circle circle1;
	private Circle circle2;
	private Circle circle3;
	private Circle circle4;
	

	public RaceGameGUI() {

		// we do not have while loops in GUI so a Timeline is used
		// make timeline
		Timeline timeline = new Timeline();
		// make timeline repeat infinite number of times
		timeline.setCycleCount(Timeline.INDEFINITE);
		// timeline uses keyframes so make a keyframe
		//make a keyframe that runs every half second
		// keyframe can use a lambda expression for its action
		KeyFrame keyframe = new KeyFrame(Duration.millis(500), action -> {
			
			// do something
			System.out.println("HI");
			
			
		});

		// add keyframe to timeline
		timeline.getKeyFrames().add(keyframe);

		// start the timeline
		timeline.play();

		RaceGame raceGame = new RaceGame();
		//Create the menu
	
		shapePane = new Pane();
		close = new MenuItem("Close");
		start = new MenuItem("Start");
		menuFile = new Menu("File");
		menuBar = new MenuBar();
		menuFile.getItems().addAll(close,start);
		menuBar.getMenus().addAll(menuFile);
		circle1 = new Circle(20);
		circle1.setCenterX(100);
		circle1.setCenterY(250);
		circle2 = new Circle(20);
		circle2.setCenterX(100);
		circle2.setCenterY(250);
		circle3 = new Circle(20);
		circle3.setCenterX(100);
		circle3.setCenterY(250);
		circle4 = new Circle(20);
		circle4.setCenterX(100);
		circle4.setCenterY(250);


		shapePane.getChildren().addAll(circle1,circle2,circle3,circle4);
		circle1.setVisible(true);
		
	
		

	}

	@Override
	public void start(Stage stage) {

 		Scene scene = new Scene(borderPane, 1100, 500);
		borderPane.setTop(menuBar);
		borderPane.setCenter(shapePane);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
