package assignmentSnakes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard implements KeyListener, WindowListener {
	//Graphical representation of gameBoard
	Frame gameBoard = null;
	Canvas canvas = null;
	Graphics graph = null;
	int res = 600;
	//Data representation of emptyspaces = 0, snakeheads = 1, snakebody = 2, and fruit = 3.
	int[][] gameMap = null;
	int mapX;
	int mapY;
	
	/**
	 * GameBoard constructor
	 */
	public GameBoard(){
		gameBoard = new Frame();
		canvas = new Canvas();
		init();
	}
	
	/**
	 * Initiate gameboard
	 */
	public void init() {
		 gameBoard.setSize(res,res);
		 gameBoard.setResizable(false);
		 gameBoard.setLocationByPlatform(true);
		 canvas.setSize(res,res);
		 gameBoard.add(canvas);
		 canvas.addKeyListener(this);
		 gameBoard.addWindowListener(this);
		 gameBoard.validate();
		 gameBoard.setTitle("Snakes & Snakes");
		 gameBoard.setVisible(true);
		 canvas.setIgnoreRepaint(true);
		 canvas.setBackground(Color.WHITE);

		 }

	/**
	 * Create data map based on number of players playing.
	 * Plot players and fruit on board
	 * @param playerList
	 */
	public void createMap(ArrayList<Player> playerList, ArrayList<Fruit> fruitList){
		
		if (playerList.size() < 10){
			gameMap = new int[20][20];
			mapX = 20;
			mapY = 20;
		}
		else{
			mapX = playerList.size() + playerList.size()/2; 
			mapY = playerList.size() + playerList.size()/2;
			gameMap = new int[mapX][mapY];
		}
		
		//Plot snakes randomly on gameboard
		for (int i = 0; i < playerList.size(); i++){
			boolean emptySpace = false;
			int randX = 0;
			int randY = 0;
			while(emptySpace == false){
				Random random = new Random();
				randX = random.nextInt(((mapX - 2) - 2) + 1) + 2;
				randY = random.nextInt(((mapY - 2) - 2) + 1) + 2;
				//Ensure snakes do not try and exist in the same space
				if (valueOfPoint(randX,randY) == 0){
					emptySpace = true;
				}
			}
			playerList.get(i).snake.head.setLocation(randX, randY);
			gameMap[randX][randY] = 1;
			emptySpace = false;
		}
		
		for (int i = 0; i < fruitList.size(); i++){
			boolean emptySpace = false;
			int randX = 0;
			int randY = 0;
			while(emptySpace == false){
				Random random = new Random();
				randX = random.nextInt(((mapX - 2) - 2) + 1) + 2;
				randY = random.nextInt(((mapY - 2) - 2) + 1) + 2;
				//Ensure snakes do not try and exist in the same space
				if (valueOfPoint(randX,randY) == 0){
					emptySpace = true;
				}
			}
			fruitList.get(i).location.setLocation(randX, randY);
			gameMap[randX][randY] = 3;
			emptySpace = false;
		}
		
		//TESTING OF GAME MAPPING
		for (int i = 0; i < gameMap[1].length; i++){
			for (int i2 = 0; i2 < gameMap[1].length; i2++){
				System.out.print("[" + gameMap[i][i2] + "]");
			}
			System.out.println("");
		}
		//END OF TESTING SNIPPET
	}
	
	/**
	 * Returns an integer based on the value of the point on the grid
	 * e.g 0 = free space, 1 = snakeHead, 2 = snakeBody, 3 = fruits
	 */
	public int valueOfPoint(int x, int y){
		return gameMap[x][y];
	}
	
	public void renderGame(){
		int unitSize = res / mapX;
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		gameBoard.dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
