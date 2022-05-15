package controller;

import java.time.ZoneId;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TimeZoneSelectorController {
	
	String tz1 = "Asia/Aden";
	String tz2 = "America/Cuiaba";
	String tz3 = "Africa/Nairobi";
	String tz4 = "America/Marigot";
	String tz5 = "Asia/Aqtau";
	String tz6 = "Pacific/Kwajalein";
	String tz7 = "America/El_Salvador";
	String tz8 = "Asia/Pontianak";
	String tz9 = "Africa/Cairo";
	String tz10 = "Pacific/Pago_Pago";

	private Main main;

	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	Button but1;
	
	@FXML
	Button but2;
	
	@FXML
	Button but3;
	
	@FXML
	Button but4;
	
	@FXML
	Button but5;
	
	@FXML
	Button but6;
	
	@FXML
	Button but7;
	
	@FXML
	Button but8;
	
	@FXML
	Button but9;
	
	@FXML
	Button but10;
	
	@FXML
	public void initialize() {
		but1.setText(tz1);
		but1.setText(tz1);
		but2.setText(tz2);
		but3.setText(tz3);
		but4.setText(tz4);
		but5.setText(tz5);
		but6.setText(tz6);
		but7.setText(tz7);
		but8.setText(tz8);
		but9.setText(tz9);
		but10.setText(tz10);
		
	}
	
	@FXML
	public void option(ActionEvent e) {
		ZoneId timeZone = null;
		Button btn = (Button) e.getSource();
		switch(btn.getText()) {
			case "Asia/Aden":
				timeZone = ZoneId.of(tz1);
				break;
			case "America/Cuiaba":
				timeZone = ZoneId.of(tz2);
				break;
			case "Africa/Nairobi":
				timeZone = ZoneId.of(tz3);
				break;
			case "America/Marigot":
				timeZone = ZoneId.of(tz4);
				break;
			case "Asia/Aqtau":
				timeZone = ZoneId.of(tz5);
				break;
			case "Pacific/Kwajalein":
				timeZone = ZoneId.of(tz6);
				break;
			case "America/El_Salvador":
				timeZone = ZoneId.of(tz7);
				break;
			case "Asia/Pontianak":
				timeZone = ZoneId.of(tz8);
				break;
			case "Africa/Cairo":
				timeZone = ZoneId.of(tz9);
				break;
			case "Pacific/Pago_Pago":
				timeZone = ZoneId.of(tz10);
				break;
		}
		main.addTimeZone(timeZone);
		main.showSample();
	}
	
}
