package P1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SideDiagramPane extends Pane{
	protected int [] num;
    protected int sum;
    protected int rectanglewidth = 800;
    protected int rectangleHidth = 25;
    protected Text text = new Text();
    
	public SideDiagramPane(int [] num,int sum) {
		this.num = num;
		this.sum = sum;
		for(int i = 0;i < 26;i ++) {
			
			Text textChar = new Text();
			char c = (char) ('A' + i);
			String str = c + "";
			textChar.setText(str);
			textChar.setX(35);
			textChar.setY(70+i*rectangleHidth);

			Double d = (double)((double)num[i]/(double)sum);
			Rectangle rectangle = new Rectangle(50,50+i*rectangleHidth,d*rectanglewidth,rectangleHidth);
			rectangle.setFill(Color.BLUE);
			rectangle.setStroke(Color.BLACK);
			
			Text textNum = new Text();
			String str2 = num[i] +"";
			textNum.setText(str2);
			textNum.setX(60 + d*rectanglewidth);
			textNum.setY(70+i*rectangleHidth);
			
			getChildren().add(textChar);
			getChildren().add(rectangle);
			getChildren().add(textNum);
		}
		
		text.setText("字母出现频率侧方图");
		text.setX(100);
		text.setY(730);
		getChildren().add(text);
		
	}	

}
