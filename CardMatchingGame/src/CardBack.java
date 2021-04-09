import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class CardBack extends JPanel {
	private int width ,height;
	
	public CardBack(int width,int height) {
		super();
		this.width = width;
		this.height = height;
	}
	//just paints the back of our cards we use that wolf as a placeholder but we kinna liked it and we think of keeping it ...will see
	public void paintBack(Graphics g) {
		try {
			Image image = Toolkit.getDefaultToolkit().getImage("polygon-wallpaper-18.jpg");
			g.drawImage(image, 0, 0,width,height, null);
		}catch(Exception e) {
			System.out.println("Image not foung");
		}
		
	}
}
