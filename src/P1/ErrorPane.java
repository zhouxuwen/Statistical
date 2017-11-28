package P1;



import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
public class ErrorPane extends StackPane{

	public ErrorPane() {
		Label text = new Label("Error,not found file!");
		text.setFont(Font.font("Sourier",FontWeight.BOLD,FontPosture.ITALIC,15));
		
		getChildren().add(text);
	}
}
