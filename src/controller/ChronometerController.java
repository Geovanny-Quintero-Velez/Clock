package controller;

import java.time.LocalTime;
import java.time.ZoneId;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChronometerController {

	private Main main;
	private boolean continu = true;
	private LocalTime initialTime;
	private LocalTime pauseTime;
	String message = "";
	int count = 0;

	@FXML 
	Label time;
	
	@FXML
	Button reset;
	
	@FXML
	Button start_end;
	
	@FXML
	Button round;
	
	@FXML
	Button back;
	
	@FXML
	Label times;
	
	@FXML
	public void initialize() {
		initialTime = LocalTime.now();
		tick();
		
	}
	
	@FXML
	public void goBack() {
		main.showSample();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	public void runTime() {
		if(continu == true) {
			continu = false;
			pauseTime = calculateActualTime();
		}else {
			continu = true;
			tick();
			
		}
	}
	
	@FXML
	public void roundTime() {
		count++;
		if(continu == true) {
			message += "#"+count+" "+calculateActualTime()+"\n";
		}else {
			message += "#"+count+" "+pauseTime+"\n";
		}
		
	}
	
	@FXML
	public void restartTime() {
		initialTime = LocalTime.now();
		message = "";
		count = 0;
	}
	
	
	public LocalTime calculateActualTime() {
		LocalTime actualTime = LocalTime.now().minusHours(Long.parseLong(""+initialTime.getHour()));
		actualTime = actualTime.minusMinutes(Long.parseLong(""+initialTime.getMinute()));
		actualTime =actualTime.minusSeconds(Long.parseLong(""+initialTime.getSecond()));
		return actualTime;
	}
	
	
	public void tick() {
		new Thread(()-> {
			while(continu == true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(()->{
					
					time.setText(""+calculateActualTime());
					times.setText(message);
				});
			}
		}).start();
	}
}
