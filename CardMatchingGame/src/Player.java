
public class Player implements Comparable {

	private String name;
	private int score;
	private long time;

	public Player(int score, long time, String name)

	{
		this.name = name;
		this.score = score;
		this.time = time;

	}

	@Override
	public String toString() { //to string function 

		return name + " " + score + " " + this.time;

	}
	public String printLeader() {  //prints leaderboard 
		long second = (time / 1000) % 60;
		long minute = (time / (1000 * 60)) % 60;
		String time = String.format("%02d:%02d", minute, second);
		
		return String.format("name: %s  score: %d	time:%l",name,score,time);
	}
//toget function with to setfunction for players information in order to have better info managment
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public long getTime() {
		return time;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public int compareTo(Object p) {
		int compareScore = ((Player) p).getScore();

		return compareScore - this.score;
	}

}