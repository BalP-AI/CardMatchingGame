import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Handler implements ActionListener {
	static ArrayList<Player> players = new ArrayList<Player>();

	@Override
	public void actionPerformed(ActionEvent e) {               //function to create a new player based on the string that the user has typed in 
		String user = e.getActionCommand();
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(user)) {
				return;
			}
		}
		Player p1 = new Player(0,0, user);
		addList(p1);
	}
	

	static void displayLeaderBoard() {                    //displays the leaderboard
		Collections.sort(players);
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < players.size(); i++) {
			str.append(players.get(i) + "\n");
		}
		JOptionPane.showMessageDialog(null, str.toString());

		try {		
			PrintWriter writer = new PrintWriter("players.txt");
			writer.print("");
			writer.close();
			writer = new PrintWriter("players.txt", "UTF-8");
			for(Player p : Handler.players) {
				writer.println(p);
				
			}
			writer.close();
		}catch(Exception e) {
			
		}
	}

	static void addList(Player p1) {                              //add player to the list of players 
			players.add(p1);
			

	}
}
