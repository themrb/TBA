
public class Game {
	World world;
	
	public Game() {
		world = new World();
	}
	
	public boolean input(char inputchar){
		System.out.print("lol");
		return true;
	}

	public boolean save(){
		return true;
	}
	
	public boolean load(){
		return true;
		
	}
	
	public boolean exit(){
		return true;
		
	}
	
	public boolean newgame(){
		return true;
	}
	
	public boolean handleinput(){
		return true;
	}
	
	public void step(GameComponent canvas){
		if (canvas.keypressed != 'g') {
		world.doturns(canvas.keypressed);
		}
	}

	public void draw(GameComponent canvas) {
		// draw across level
		
	}
}
