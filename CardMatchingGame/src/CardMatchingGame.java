/*ICSD18174 CHRYSOVALANTIS PATEINIOTIS*/
/*ICSD18218 NIKOS TZEKAS*/


import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

public class CardMatchingGame {

	private final static int WIDTH = 1080, HEIGHT = (WIDTH * 9) / 16; // the size of the window will have a resolution
																		// of 16:9 ratio

	private static Card temp;
	private static JFrame f;


	public static void main(String[] args) {
		//updating the list with players from our file
		try {
			File file = new File("players.txt");
			Scanner input = new Scanner(file);

			while (input.hasNext()) {
				String name = input.next();
				int score = input.nextInt();
				long time = input.nextLong();
				System.out.println(name + score + time);
				Handler.players.add(new Player(score,time,name));
				
			}
		} catch (Exception e) {

		}
		
		//launching the main menyu
		
		new Menu("Shape Master");

	}

}
