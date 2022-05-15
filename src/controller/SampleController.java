package controller;

import java.time.LocalTime;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.TimeList;

public class SampleController {
	
	private Main main;
	
	private TimeList timesList = new TimeList();
	@FXML
	Label time;
	
	@FXML
	Label am_pm;
	
	@FXML
	Label times;
	
	@FXML
	Button back;
	
	@FXML
	public void initialize() {
		tick();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	public void goBack() {
		main.showChronometer();
	}
	
	public void tick() {
		new Thread(()-> {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(()->{
					time.setText(""+LocalTime.now());
					times.setText(timesList.getTimes());
				});
			}
		}).start();
	}
}
