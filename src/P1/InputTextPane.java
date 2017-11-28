package P1;


import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InputTextPane extends HBox {
	
	protected int [] num;
	protected int sum;
	protected Label label;
	protected TextField text;
	
	public InputTextPane(double n) {
		super(n);
		sum =0;
		label = new Label("Input File Name:");
		text = new TextField();
		setHeight(20);
		setWidth(20);
		getChildren().addAll(label,text);
		setPadding(new Insets(10,10,10,10));
		
		text.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER) {
				try {
					calculate(text.getText());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
		
		
	
	

	private void calculate(String text) throws IOException {
		// TODO Auto-generated method stub
//		File file = new File(text);
		num = new int[26];
		char c = ' ';
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(text));
			String s = null;
			while((s = input.readLine()) != null) {
				for(int i = 0;i < s.length(); i++) {
					c = s.charAt(i);
					if(c >= 'A'&&c <= 'Z'||c >= 'a'&&c <= 'z') {
						if(c >= 'A'&&c <= 'Z') {
							num[c - 'A']++;
						}
						else {
							num[c - 'a']++;
						}
						sum ++;
					}
				}
				
				
			}
			input.close();
			paintHistogram();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			ErrorPane pane = new ErrorPane();
			painterrorpane(pane);
			e.printStackTrace();
		} catch (EOFException e) {
			
		}
		
		
	}
	






	private void painterrorpane(ErrorPane pane) {
		Stage stage = new Stage();
		Scene scene = new Scene(pane,400,200);
		stage.setTitle("Error");
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	private void paintHistogram() {
		// TODO Auto-generated method stub

		HistogramPane pane = new HistogramPane(num, sum);
		Stage stage = new Stage();
		Scene scene = new Scene(pane,800,500);
		stage.setTitle("Histogram");
		stage.setScene(scene);
		stage.show();
		
		SideDiagramPane pane2 = new SideDiagramPane(num, sum);
		Stage stage2 = new Stage();
		Scene scene2 = new Scene(pane2,500,800);
		stage2.setTitle("SideDiagram");
		stage2.setScene(scene2);
		stage2.show();
		
		
	}
	

}
