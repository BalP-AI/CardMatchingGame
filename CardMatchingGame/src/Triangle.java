import java.awt.Graphics;

public class Triangle extends Shapes {

	public Triangle(int width,int height,int color,int orientation) {
		super(width,height,color,orientation);
		shape = 1; // not starting from 0 since we need that value to create a hashcode and multiplying with 0 wont work
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		if(orientation == 0 ) {
			g.fillPolygon(new int[] {0,0,height} , new int[] {0,width,0} , 3);
		}else if (orientation == 1) {
			g.fillPolygon(new int[] {0,width,width} , new int[] {0,height,0} , 3);
		}else if (orientation == 2 ) {
			g.fillPolygon(new int[] {0,0,width} , new int[] {0,height,height} , 3);
		}else if (orientation == 3) {
			g.fillPolygon(new int[] {width,0,width} , new int[] {0,height,height} , 3);
		}
		
	}
}
