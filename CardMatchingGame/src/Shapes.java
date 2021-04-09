import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Shapes extends JPanel{
	protected Random r = new Random();
	protected int shape,orientation,width,height;
	protected int i = 0;
	protected Color color;		// red				//blue				//green 		//yellow
	protected Color colors[] = {new Color(255,0,0),new Color(0,0,255),new Color(0,255,0),new Color(255,225,0)};
	
	
	public Shapes(int width , int height,int color ,int orientation ) {
		super();
		this.width = width;
		this.height = height;	
		this.color = colors[color];
		this.orientation = orientation;
	}
	protected void render(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(0, 0, 200, 200);
		g.drawString("no shape here",0,0);
	}
	//functions to get information for the shapes 
	public int getOrientation() {return orientation;}
	public int getShapeID() {return shape;}
	public int getColor() {
		for(int i = 0 ; i < colors.length ; i++) {
			if(colors[i].getRGB() == this.color.getRGB()) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public int hashCode() {
		return getColor()*orientation*shape;
		
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Shapes)) return false;
		if(o == null) return false;
		
		Shapes temp = (Shapes) o;
		if(temp.getOrientation() != orientation) return false;
		if(temp.getShapeID() != shape) return false;
		if(temp.getColor() != this.getColor()) return false;
		return true;
		
	}
	


}
