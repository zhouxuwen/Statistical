package P1;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class HistogramPane extends Pane{
	
	
	protected int [] num;
    protected int sum;
    protected int rectanglewidth = 25;
    protected int rectangleHidth = 500;
    protected Text text = new Text();
    
	public HistogramPane(int [] num,int sum) {
		this.num = num;
		this.sum = sum;
		for(int i = 0;i < 26;i ++) {
			
			Text textChar = new Text();
			char c = (char) ('A' + i);
			String str = c + "";
			textChar.setText(str);
			textChar.setX(55 + i * rectanglewidth);
			textChar.setY(420);

			Double d = (double)((double)num[i]/(double)sum);
			Rectangle rectangle = new Rectangle(50 + i*rectanglewidth,400 - d*rectangleHidth,rectanglewidth,d*rectangleHidth);
			rectangle.setFill(Color.BLUE);
			rectangle.setStroke(Color.BLACK);
			
			Text textNum = new Text();
			String str2 = num[i] +"";
			textNum.setText(str2);
			textNum.setX(55 + i * rectanglewidth);
			textNum.setY(390 - d*rectangleHidth);
			
			getChildren().add(textChar);
			getChildren().add(rectangle);
			getChildren().add(textNum);
		}
		
		text.setText("字母出现频率直方图");
		text.setX(300);
		text.setY(450);
		getChildren().add(text);
		
		
	}
}
