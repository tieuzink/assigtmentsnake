package assignmentSnakes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Player implements Runnable{
	Thread ref;
	String playerID;
	Snake snake;
	char[] keyMapping = new char[4]; //Keymapping[Up, Right, Down, Left]
	int direction; //Current moving direction
	boolean notBot; //Player or Bot?
	
	/**
	 * Player constructor
	 * @param ID
	 * @param up
	 * @param right
	 * @param down
	 * @param left
	 * @param player
	 */
	public Player(String ID, char up, char right, char down, char left, boolean player){
		playerID = ID;
		keyMapping[0] = up;
		keyMapping[1] = right;
		keyMapping[2] = down;
		keyMapping[3] = left;
		notBot = player;
		snake = new Snake();
		
	}

	public Snake getSnake(){
		return snake;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Player [ref=" + ref + ", playerID=" + playerID + ", keyMapping="
				+ Arrays.toString(keyMapping) + ", direction=" + direction + ", notBot=" + notBot + "]";
	}
	
	
}
