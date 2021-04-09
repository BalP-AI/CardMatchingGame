import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Grid extends JFrame {
	private int width, height, numberOfTries, points;
	private Game game;
	private Container pane;
	private JButton pause;

	private JLabel numOfLives;
	private JPanel grid, card[][], gap1, gap2;
	private ArrayList<Card> tempList = new ArrayList<Card>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Card> compare = new ArrayList<Card>();
	private CardLayout cl = new CardLayout();
	private long startTime, endTime, totalTime;
	private long startTimePause, endTimePause, totalTimePause = 0;
	Random r = new Random();
	private final int shapeSize = 93;

	public Grid(int width, int height, Game game) {
		// starting the clock
		startTime = System.currentTimeMillis();
		// creates a new grid choosing the size of it aka difficulty
		if (width == 5) {
			numberOfTries = 10;
		} else if (width == 8) {
			numberOfTries = 15;
		} else if (width == 10) {
			numberOfTries = 150;
		}
		this.width = width;
		this.height = height;
		this.game = game;
		// creating a array with cards (panels) where each card will be stored
		card = new JPanel[width][height];
		grid = new JPanel(new GridLayout(width, height, 5, 5));

		pane = getContentPane();
		pane.setLayout(new BorderLayout());

		setFrame();
		// adding the frames to our lists one that contains all the cards and one that
		// contain clones of those cards...basically pointers that point in the same
		// position at the heap
		addShapes();
		gap1 = new JPanel();
		pause = new JButton("PAUSE");
		pause.addActionListener(e -> {
			startTimePause = System.currentTimeMillis();
			setVisible(false);
			new Menu("PAUSE", this);
		});
		// printing the number of lives for the first time

		numOfLives = new JLabel("❤×" + numberOfTries);
		numOfLives.setFont(new Font("Serif", Font.PLAIN, 80));

		gap1.add(numOfLives);
		gap2 = new JPanel();

		gap2.add(pause);

		gap1.setPreferredSize(new Dimension(400, 1000));
		gap2.setPreferredSize(new Dimension(400, 1000));
		pane.add(grid, BorderLayout.CENTER);
		pane.add(gap2, BorderLayout.EAST);
		pane.add(gap1, BorderLayout.WEST);
		// setting up our grid in the center of the frame...right and left are panel
		// that contain pause button and lives and can easily be used later for more
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// creating the grid
				card[i][j] = new JPanel();

			}
		}
		// finally adding the jokers in the list

		addJokers();

	}

	// every time the user hits the pause button a new clock starts counting and in
	// the end the the total pause time get subtracked from the total time

	public void unpause() {
		endTimePause = System.currentTimeMillis();
		totalTimePause = totalTimePause + (endTimePause - startTimePause);
	}

	//
	public long getTime() {
		totalTime = endTime - startTime - totalTimePause;
		return totalTime;
	}

	public void addCompareq(Card s) {

		if (s.getShape() instanceof Joker) {
			// for every card in the game we check if the shape of it is the same as the
			// jokers face
			// also we make sure to flip it only if its face down so that we don't flip
			// cards that already been found
			for (Card c : cards) {
				if (c.getShape().getShapeID() == s.getShape().getShapeID() && !c.isFaceUp())
					c.flip();
			}
			for (Card c : compare)
				c.flip();
			compare.clear();
			return;
		}
		compare.add(s);
	}

	public void compare() {
		// in every click inside the grid the compare checks if there are more that 2
		// items in the list
		// if thats the case we see if the shapes are equal since we implemented that in
		// the shape class
		// if they are equal 100 points are added to your score else the cards flip back
		// and one live is removed
		if (compare.size() == 2) {
			Shapes shape1 = compare.get(0).getShape();
			Shapes shape2 = compare.get(1).getShape();
			if (!shape1.equals(shape2)) {
				compare.get(0).flip();
				compare.get(1).flip();

				numberOfTries--;
			} else if (shape1.equals(shape2)) {
				points += 100;
			}
			// if the number of lives is decreased then we display the new number
			numOfLives.setText("❤×" + numberOfTries);
			compare.clear();
			if (numberOfTries == 0) {

				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime - totalTimePause;

				long second = (totalTime / 1000) % 60;
				long minute = (totalTime / (1000 * 60)) % 60;
				String time = String.format("%02d:%02d", minute, second);
				// if your run out lives the program ends and alerts the user with a proper
				// message
				JOptionPane.showMessageDialog(null,
						"Sorry you ran out of lives\nYour score is :" + points + " \nYou have played for :" + time);// we
																													// should
																													// terminate
																													// the
																													// game
																													// here
				for (int i = 0; i < Handler.players.size(); i++) {
					if (Handler.players.get(i).getTime() == 0) {
						Handler.players.get(i).setTime(totalTime);
						Handler.players.get(i).setScore(points);
					}
				}
				new Menu("Shape Master");
				dispose();
			}

		}
	}

	public void printWin() {
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime - totalTimePause;

		long second = (totalTime / 1000) % 60;
		long minute = (totalTime / (1000 * 60)) % 60;
		String time = String.format("%02d:%02d", minute, second);
		JOptionPane.showMessageDialog(null,
				"Congratulations you just won the game\nYour score is :" + points + " \nYou have played for :" + time);
		for (int i = 0; i < Handler.players.size(); i++) {
			if (Handler.players.get(i).getTime() == 0) {
				Handler.players.get(i).setTime(totalTime);
				Handler.players.get(i).setScore(points);
			}
		}
		//when u win you get alerted and the window closes while a new menu comes up 
		new Menu("Shape Master");
		dispose();
	}

	public int getNumOfTries() {
		return numberOfTries;
	}
	//if all the cards in the grid are facing up then thats a win 
	public boolean checkWin() {
		for (Card c : cards) {
			if (!c.isFaceUp())
				return false;
		}
		return true;
	}

	private void setFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setUndecorated(true);
		setVisible(true);
	}

	private void addShapes() {
		//adding shapes to the list...
		//we use a random number to choose which shape to add and we add it twice to our lists since we always need duplicates
		int color;
		int orientation;
		for (int i = 0; i < (width * height) / 2; i++) {
			int rand = r.nextInt(4);
			color = r.nextInt(4);
			if (rand == 0) {
				orientation = r.nextInt(4);
				// adding new triangle
				Card object = new Card(1, shapeSize, shapeSize, color, orientation, this);
				Card clone = new Card(1, shapeSize, shapeSize, color, orientation, this);

				tempList.add(object);
				tempList.add(clone);
				cards.add(object);
				cards.add(clone);
			} else if (rand == 1) {
				orientation = r.nextInt(2);
				// adding new rectangle
				Card object = new Card(2, shapeSize, shapeSize, color, orientation, this);
				Card clone = new Card(2, shapeSize, shapeSize, color, orientation, this);

				tempList.add(object);
				tempList.add(clone);
				cards.add(object);
				cards.add(clone);
			} else if (rand == 2) {
				orientation = r.nextInt(2);
				// adding new diamond
				Card object = new Card(3, shapeSize, shapeSize, color, orientation, this);
				Card clone = new Card(3, shapeSize, shapeSize, color, orientation, this);

				tempList.add(object);
				tempList.add(clone);
				cards.add(object);
				cards.add(clone);
			} else if (rand == 3) {
				orientation = 0;
				// adding new circleS
				Card object = new Card(4, shapeSize, shapeSize, color, orientation, this);
				Card clone = new Card(4, shapeSize, shapeSize, color, orientation, this);

				tempList.add(object);
				tempList.add(clone);
				cards.add(object);
				cards.add(clone);
			}
		}
		Collections.shuffle(tempList);

	}

	private void addJokers() {
		int joker1, joker2;
		if (width < 6) {
			joker1 = r.nextInt(width * height);
			joker2 = -1;
		} else {
			joker1 = r.nextInt(width * height);
			joker2 = r.nextInt(width * height);
			while (joker1 == joker2) {
				joker2 = r.nextInt();
			}
		}
		int counter = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// we take from the list a random object (which exists twice in the list
				// the jokers are assigned to a specific cell before thus if we find that cell
				// we just add a joker
				if (counter == joker1 || counter == joker2) {
					Card cd = new Card(5, shapeSize, shapeSize, r.nextInt(4) + 1, 0, this);
					card[i][j].addMouseListener(cd);
					card[i][j].add(cd);
					grid.add(card[i][j]);
					j++;

				}
				int index;
				if (tempList.size() > 0)
					index = r.nextInt(tempList.size());
				else
					index = 0;
				Card cd = tempList.get(index);

				card[i][j].addMouseListener(cd);
				card[i][j].add(cd);
				grid.add(card[i][j]);

				counter++;
				tempList.remove(index);

			}

		}

	}


}
