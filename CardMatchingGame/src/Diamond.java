import java.awt.Graphics;

public class Diamond extends Shapes{

	public Diamond(int width, int height,int color,int orientation) {
		super( width, height,color,orientation);
		shape = 3;
	}
	@Override
	public void render(Graphics g) {
		g.setColor(color);
		if(orientation == 0 ) {
			g.fillPolygon(new int[] {width/2,0,width/2,width} , new int[] {height/4,height/2,3*height/4,height/2} , 4);
		}else if (orientation == 1) {
			g.fillPolygon(new int[] {width/2,width/4,width/2,3*width/4} , new int[] {0,height/2,height,height/2} , 4);
		}		
	}

}
