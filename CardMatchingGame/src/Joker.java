import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Joker extends Shapes {
	
	private int resizable = 2 ;
	private int position = -3;
	
	
	public Joker(int width , int height,int shape) {
		super(width,height,0,0);
		this.shape = shape;
	}
	public void render(Graphics g) {
		//painting the shape
		g.setColor(Color.black);
		if(shape == 1) {
			g.fillPolygon(new int[] {width/2,0,width} , new int[] {0,height-20, height-20} ,3);
		}else if(shape == 2) {
			g.fillRect(0, 0, width , height);
		}else if(shape == 3) {
			g.fillPolygon(new int[] {width/2,0,width/2,width} , new int[] {10,height/2,height -10,height/2} , 4);
		}else if(shape == 4) {
			g.fillOval(8, 10, width-15, height-15);
		}
		
		
		//resizable just divide each position with a certain value thus every new position is relative to the old one thus the whole thing looks scaled
		//position basically moves the joker throughout the diagonal because when resizing its position should change 
		
		
		g.setColor(new Color(242,242,242)); // skin 
		g.fillPolygon(new int[] {59/resizable + position ,55/resizable + position ,55/resizable + position, 59/resizable + position, 60/resizable + position, 60/resizable + position,78/resizable + position, 90/resizable + position ,110/resizable + position,120/resizable + position,135/resizable + position,135/resizable + position,139/resizable + position,143/resizable + position,143/resizable + position,132/resizable + position,100/resizable + position,60/resizable + position },
					  new int[] {100/resizable + position,102/resizable + position,125/resizable + position,127/resizable + position,127/resizable + position,140/resizable + position,160/resizable + position,180/resizable + position,180/resizable + position,160/resizable + position,140/resizable + position,127/resizable + position,127/resizable + position,123/resizable + position,102/resizable + position,70/resizable + position ,50/resizable + position ,70/resizable + position },18);
		
		g.setColor(new Color(230,230,230));//skin shade
		g.fillPolygon(new int[] {100/resizable + position,120/resizable + position,135/resizable + position,135/resizable + position,139/resizable + position,143/resizable + position,143/resizable + position,143/resizable + position,132/resizable + position,100/resizable + position},
					  new int[] {180/resizable + position,160/resizable + position,140/resizable + position,127/resizable + position,127/resizable + position,123/resizable + position,102/resizable + position,102/resizable + position,70/resizable + position ,50/resizable + position},10);
		
		
		g.setColor(new Color(0,204,0));//hair
		g.fillPolygon(new int[] {60/resizable + position, 59/resizable + position, 44/resizable + position,60/resizable + position,70/resizable + position,80/resizable + position,120/resizable + position,116/resizable + position,150/resizable + position,135/resizable + position,150/resizable + position,135/resizable + position,135/resizable + position,128/resizable + position,134/resizable + position,115/resizable + position,100/resizable + position,85/resizable + position,68/resizable + position,74/resizable + position,67/resizable + position}, 
					  new int[] {120/resizable + position,100/resizable + position,60/resizable + position,70/resizable + position,40/resizable + position,53/resizable + position,20/resizable + position, 50/resizable + position, 45/resizable + position, 70/resizable + position, 70/resizable + position, 120/resizable + position,97/resizable + position ,90/resizable + position, 77/resizable + position ,64/resizable + position, 80/resizable + position, 64/resizable + position,72/resizable + position,90/resizable + position,97/resizable + position} , 21);
		//making a new hair with only the right parts and making a more darker green to look like a shadow
		g.setColor(new Color(0,175,51));
		g.fillPolygon(new int[] {120/resizable + position,116/resizable + position,150/resizable + position,135/resizable + position,150/resizable + position,135/resizable + position,135/resizable + position,128/resizable + position,134/resizable + position,115/resizable + position,100/resizable + position},
					  new int[] {20/resizable + position, 50/resizable + position, 45/resizable + position, 70/resizable + position, 70/resizable + position, 120/resizable + position,97/resizable + position ,90/resizable + position, 77/resizable + position ,64/resizable + position, 80/resizable + position } , 11);
		
		
		
		g.setColor(new Color(230,0,0));//outter smile
		g.fillPolygon(new int[] {65/resizable + position ,90/resizable + position ,110/resizable + position,132/resizable + position,114/resizable + position,105/resizable + position,95/resizable + position ,87/resizable + position},
					  new int[] {140/resizable + position,150/resizable + position,150/resizable + position,140/resizable + position,160/resizable + position,176/resizable + position,176/resizable + position,160/resizable + position} , 8);
		
		g.setColor(new Color(255,255,230));//indner smile
		g.fillPolygon(new int[] {85/resizable + position ,96/resizable + position,105/resizable + position,114/resizable + position,103/resizable + position,97/resizable + position},
					  new int[] {153/resizable + position,156/resizable + position,156/resizable + position,153/resizable + position,170/resizable + position,170/resizable + position}, 6);
		g.setColor(new Color(230,0,0));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 9 )); 
		g.drawString("JOKER",70/resizable + position ,116/resizable + position);
		
		
	}

}
