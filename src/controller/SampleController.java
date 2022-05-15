package controller;

import java.time.LocalTime;
import java.time.ZoneId;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.TimeList;

public class SampleController {
	
	private Main main;
	
	private TimeList timesList = new TimeList();

	@FXML
	Label time;
	
	@FXML
	Label am_pm;
	
	@FXML
	TextArea times;
	
	@FXML
	Button back;
	
	@FXML
	public void selectTime() {
		
	}
	
	@FXML
	public void initialize() {
		System.out.println(ZoneId.getAvailableZoneIds());
		timesList.add(ZoneId.of("Asia/Aden"));
		tick();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	public void goBack() {
		
		main.showChronometer();
	}
	
	public TimeList getTimesList() {
		return timesList;
	}

	public void setTimesList(TimeList timesList) {
		this.timesList = timesList;
	}
	
	public void addTimeZone() {
		main.showTimeZoneSelector();
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
