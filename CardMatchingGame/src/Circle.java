import java.awt.Graphics;
import java.util.Random;

public class Circle extends Shapes{
	
	private Random r = new Random();

	public Circle(int width, int height,int color) {
		super( width, height,color,0);
		shape = 4;
		
	}
	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(8, 10, width-15, height-15);

		
		
	}
	


}
