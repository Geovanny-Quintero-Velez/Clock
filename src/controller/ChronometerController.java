package controller;

import java.time.LocalTime;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChronometerController {

	private Main main;
	private boolean continu = false;
	private LocalTime initialTime;
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
		}else {
			continu = true;
			
		}
	}
	
	@FXML
	public void roundTime() {
		count++;
		message += "#"+count+" "+LocalTime.now()+"\n";
	}
	
	@FXML
	public void restartTime() {
		initialTime = LocalTime.now();
		message = "";
		count = 0;
	}
	
	
	
	
	
	public void tick() {
		new Thread(()-> {
			while(continu) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(()->{
					LocalTime actualTime = LocalTime.now().minusHours(initialTime.getHour());
					actualTime = actualTime.minusMinutes(initialTime.getMinute());
					actualTime =actualTime.minusSeconds(initialTime.getSecond());
					time.setText(""+actualTime);
					times.setText(message);
				});
			}
		}).start();
	}
}
