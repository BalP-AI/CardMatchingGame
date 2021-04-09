import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Card extends JPanel implements MouseListener {
	private Shapes faceUp;
	private CardBack faceDown;
	private int chooseFace = 0 ;
	Grid grid;
	
	public Card(int shape , int width , int height , int color,int orientation,Grid grid) {
		super();
		this.grid = grid;
		setPreferredSize(new Dimension(100,100));
		if(shape == 1) {
			faceUp = new Triangle(width,height,color,orientation);
		}else if(shape == 2) {
			faceUp = new Rect(width,height,color,orientation);
		}else if (shape == 3 ) {
			faceUp = new Diamond(width,height,color,orientation);
		}else if (shape == 4) {
			faceUp = new Circle(width,height,color);
		}else if (shape == 5) {
			//the color is basically the shape of the joker since the color will always be black
			faceUp = new Joker(width,height,color);
		}
		faceDown = new CardBack(width,height);


	}
	public Card getCard() {
		return this;
	}
	public Shapes getShape() {
		return faceUp;
	}
	public boolean isFaceUp() {
		if(chooseFace%2 == 0)
			return false;
		return true;
	}
	public void flip() {
		chooseFace++;
		repaint();
		
		
	}
	@Override 
	public void paintComponent(Graphics g) {
		boolean first = true;
		g.setColor(Color.white);
		if(chooseFace%2 == 0 ) {
			g.fillRect(0, 0, 93, 93);
			faceDown.paintBack(g);
			
		}

		else {
			g.fillRect(0, 0, 93, 93);
			faceUp.render(g);
		}
		//the images do not load quickly enough thus it only paint a white rect
		//with this method we force again the paintComponent now that the images are load
		if(first) {
			first = false;
			repaint();
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//if its already face up you can not click it again (well technically you can but the card will not react)
		if(chooseFace%2 != 1) {
			flip();
			grid.addCompareq(this);
		}
		if(grid.checkWin()) {
			grid.printWin();		
		}
				
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		grid.compare();
				
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {


					
	}
	

	
}
