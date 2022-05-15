package application;
	
import java.io.IOException;
import java.time.ZoneId;

import controller.ChronometerController;
import controller.SampleController;
import controller.TimeZoneSelectorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage currentStage;
	private TimeZoneSelectorController tzsController;
	private SampleController sampleController;
	
	@Override
	public void start(Stage primaryStage) {
		showBegin();
	}
	
	public void showBegin() {
		try {
			BorderPane root;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Sample.fxml"));
			root = (BorderPane)loader.load();
			sampleController = loader.getController();
			sampleController.setMain(this);
			
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
	
	public void showSample() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Sample.fxml"));
			BorderPane sampleRoot = (BorderPane)loader.load();
			SampleController sample = loader.getController();
			sample.setMain(this);
			//currentStage.setFullScreen(true);
			Stage stage = currentStage;
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(sampleRoot);
			//currentStage.close();
			stage.show();
			//currentStage = stage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showChronometer() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Chronometer.fxml"));
			BorderPane chronometer = (BorderPane)loader.load();
			ChronometerController chrono = loader.getController();
			chrono.setMain(this);
			//currentStage.setFullScreen(true);
			Stage stage = currentStage;
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
	
	public void showTimeZoneSelector() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/TimeZoneSelector.fxml"));
			BorderPane timeZoneSelector = (BorderPane)loader.load();
			tzsController = loader.getController();
			tzsController.setMain(this);
			//currentStage.setFullScreen(true);
			Stage stage = currentStage;
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(timeZoneSelector);
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
	
	public void addTimeZone(ZoneId timeZone) {
		sampleController.getTimesList().add(timeZone);
	}
}
