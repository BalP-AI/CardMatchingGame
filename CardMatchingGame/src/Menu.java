import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int width, height;
	private JPanel row1, row2, row3, row4, row5;
	private JLabel menu;
	private JButton newGame;
	private JButton leaderboard;
	private JButton help;
	private JButton credits;
	private JButton exit;
	private Grid grid;
	
	//this class has 2 constructors basically doing the same thing...one of them tho is only when the game is paused thus we pass the current grid as a parameter
	
	public Menu(String title,Grid grid) {
		super(title);
		this.grid = grid;
		//setting the JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JFrame holder = new JFrame();
		//row1 is just a label with the string menu on it
		row1 = new JPanel();
		menu = new JLabel("MENU");
		//row 2 has a button for pause or start a new game in the other construecton
		row2 = new JPanel();
		if(title.equals("PAUSE")) {
			newGame = new JButton("CONTINUE");
			newGame.addActionListener(e -> {
				
				grid.unpause();
				grid.setVisible(true);
				
				dispose();
			});
			
		}
		else {
			newGame = new JButton("NEW GAME");

			newGame.addActionListener(e -> {
				new Game(this);
				dispose();
			});
		}
		//row 3 has the leaderboard that shows which sorts the players by scores from high to low
		row3 = new JPanel();
		leaderboard = new JButton("LEADERBOARD");
		//row 4 just has the help where there are described all the rule and credits where are mentioned our names
		row4 = new JPanel();
		help = new JButton("HELP");
		help.addActionListener(e -> JOptionPane.showOptionDialog(null,
				"In this game you select two cards each time if the are the same they remain open if you dont then they turn back down . For each difficulty level you get a number of tries.\nJoker cards:When you open a joker you can open any other card and their pair will open automatically .\nWinning coditions :if you manage to open all your cards without losing all your tries you win points .",
				"How to Play Shape Master.", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,
				null));

		credits = new JButton("CREDITS");
		//and final row 5 with the exit button
		row5 = new JPanel();
		exit = new JButton("EXIT");
		exit.addActionListener(e -> System.exit(0));
		
		//setting up the panel and adding all the missing components
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5, 1));

		
		
		FlowLayout fl = new FlowLayout();
		row1.setLayout(fl);
		row1.add(menu);

		row2.setLayout(fl);
		row2.add(newGame);

		row3.setLayout(fl);
		row3.add(leaderboard);
		leaderboard.addActionListener(e -> Handler.displayLeaderBoard());

		row4.setLayout(fl);
		row4.add(help);
		credits.addActionListener(e -> JOptionPane.showMessageDialog(null,
				"This game was developed by Valadis Patiniotis and Nikos Tzekas.\nTwo young developers who love the art or programming\n and would sucrifice their lives to it.  "));

		row4.add(credits);

		row5.setLayout(fl);
		row5.add(exit);

		pane.add(row1);
		pane.add(row2);
		pane.add(row3);
		pane.add(row4);
		pane.add(row5);
		pack();
		holder.setLayout(new BorderLayout());
		pack();
		
		setSize(1080, (1080 * 9) / 16);
		setLocationRelativeTo(null);
		
		holder.add(pane);

		setResizable(false);

		setContentPane(pane);
	}
	
	public Menu(String title) {

		super(title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JFrame holder = new JFrame();

		row1 = new JPanel();
		menu = new JLabel("MENU");

		row2 = new JPanel();
		if(title.equals("PAUSE")) {
			newGame = new JButton("CONTINUE");
			newGame.addActionListener(e -> {
				
				grid.unpause();
				grid.setVisible(true);
				
				dispose();
			});
			
		}
		else {
			newGame = new JButton("NEW GAME");

			newGame.addActionListener(e -> {
				new Game(this);
				dispose();
			});
		}

		row3 = new JPanel();
		leaderboard = new JButton("LEADERBOARD");

		row4 = new JPanel();
		help = new JButton("HELP");
		help.addActionListener(e -> JOptionPane.showOptionDialog(null,
				"In this game you select two cards each time if the are the same they remain open if you dont then they turn back down . For each difficulty level you get a number of tries.\nJoker cards:When you open a joker you can open any other card and their pair will open automatically .\nWinning coditions :if you manage to open all your cards without losing all your tries you win points .",
				"How to Play Shape Master.", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,
				null));

		credits = new JButton("CREDITS");

		row5 = new JPanel();
		exit = new JButton("EXIT");
		exit.addActionListener(e -> System.exit(0));

		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5, 1));

		
		
		FlowLayout fl = new FlowLayout();
		row1.setLayout(fl);
		row1.add(menu);

		row2.setLayout(fl);
		row2.add(newGame);

		row3.setLayout(fl);
		row3.add(leaderboard);
		leaderboard.addActionListener(e -> Handler.displayLeaderBoard());

		row4.setLayout(fl);
		row4.add(help);
		credits.addActionListener(e -> JOptionPane.showMessageDialog(null,
				"This game was developed by Valadis Patiniotis and Nikos Tzekas.\nTwo young developers who love the art or programming\n and would sucrifice their lives to it.  "));

		row4.add(credits);

		row5.setLayout(fl);
		row5.add(exit);

		pane.add(row1);
		pane.add(row2);
		pane.add(row3);
		pane.add(row4);
		pane.add(row5);
		pack();
		holder.setLayout(new BorderLayout());
		pack();
		
		setSize(1080, (1080 * 9) / 16);
		setLocationRelativeTo(null);
		
		holder.add(pane);

		setResizable(false);

		setContentPane(pane);

	}

	public void setVisible() {
		setVisible(true);

	}
	

}
