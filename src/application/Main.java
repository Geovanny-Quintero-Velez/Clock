package application;
	
import java.io.IOException;

import controller.SampleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage currentStage;
	
	@Override
	public void start(Stage primaryStage) {
		showLogin();
	}
	
	public void showLogin() {
		try {
			BorderPane root;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Sample.fxml"));
			root = (BorderPane)loader.load();
			SampleController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showChronometer() {
		try {
			BorderPane root;
			BorderPane chronometer = (BorderPane)FXMLLoader.load(getClass().getResource("../ui/Chronometer.fxml"));
			Stage stage = currentStage;
			//currentStage.setFullScreen(true);
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(chronometer);
			//currentStage.close();
			stage.show();
			//currentStage = stage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
