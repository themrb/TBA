import java.util.ArrayList;


public class World {
	int gameclock;
	ArrayList<Level> levels;
	Level curlevel;
	User player;
	
	public World() {
		player = new User();
		gameclock = 0;
	}
	
	public boolean doturns(char input){
		if (player.turn()){
			gameclock++;
		} else 
			return false;
		System.out.println(input + " " + gameclock);
			
		return true;
	}
}
