package assignmentSnakes;

import java.util.ArrayList;

public class ServerThread {

	ArrayList<Player> playerList = null;
	
	public ServerThread(){
		playerList = new ArrayList<Player>();
	}
	
	public void addToList(Player player){
		playerList.add(player);
	}
	
	@Override
	public String toString(){
		String t = "Players: ";
		for(int i = 0; i < playerList.size(); i++){
			t = t + playerList.get(i).playerID + " ";
		}
		return t;
	}
}
