package P1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Test extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		InputTextPane inputtextpane = new InputTextPane(20);
		pane.setCenter(inputtextpane);
		BorderPane.setAlignment(inputtextpane, Pos.CENTER);
		
		Scene scene = new Scene(pane,400,50);
		primaryStage.setScene(scene);
		primaryStage.setTitle("StatisticalText");
		primaryStage.show();
		primaryStage.setResizable(false);
	
	}
}
