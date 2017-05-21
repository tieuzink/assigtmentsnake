package assignmentSnakes;

import java.util.ArrayList;
import java.util.Scanner;

public class Server {
	
	Server server = null;
	GameBoard gameboard = null;
	ArrayList<Player> playerList = null;
	ArrayList<Fruit> fruitList = null;
	ArrayList<ServerThread> threadPool = null;
	int threadPoolLimit = 10;
 
	public static void main(String[] args) {
		//Instantiate server components
		Server server = new Server();
		server.playerList = new ArrayList<Player>();
		server.fruitList = new ArrayList<Fruit>();
		server.threadPool = new ArrayList<ServerThread>();
		
		server.tempCreatePlayerList(server.playerList);
		server.fillFruitList(server.playerList, server.fruitList);
		
		server.createThreadPool(server.threadPool, server.threadPoolLimit);
		server.createPlayerThreads(server.playerList);
		
		server.assignPlayers(server.playerList, server.threadPool);
		
		server.gameboard = new GameBoard();
		server.gameboard.createMap(server.playerList, server.fruitList);
	}

	/**
	 * Temporary method to create players and computers in the playerList
	 * @param playerList
	 */
	public void tempCreatePlayerList(ArrayList<Player> playerList){
		//Real players and their keymapping.
		Player p1 = new Player("David", 'Q', 'W', 'E', 'R', true);
		Player p2 = new Player("Dave", 'U', 'I', 'O', 'P', true);
		Player p3 = new Player("Davey",  'A', 'S', 'D', 'F', true);
		Player p4 = new Player("Davo",  'H', 'J', 'K', 'L', true);
		//Add real players to playerList
		playerList.add(p1);
		playerList.add(p2);
		playerList.add(p3);
		playerList.add(p4);

		//Add X amount of bots to game
		Scanner s = new Scanner(System.in);
		System.out.println("How many bots would you like to play with? ");
		int botCount = s.nextInt();
		if (botCount > 100){
			botCount = 100;
		}
		for (int i = 0; i < botCount; i++){
			Player bot = new Player("comp" + i, 'X', 'X', 'X', 'X', false);
			Thread botT = new Thread(bot);
			bot.ref = botT;
			playerList.add(bot);
			botT.setName("comp" + i);
		}
		System.out.println("Player creation successful: " + playerList.size() + " player(s) on map.");
	}
	
	/**
	 * Thread to fill FruitList with fruit based on playerList size
	 * There is always half as many fruit as there is players. 
	 * @param playerList
	 * @param fruitList
	 */
	public void fillFruitList(ArrayList<Player> playerList, ArrayList<Fruit> fruitList){
		int playerListSize = 2;
		if (playerList.size() > 2){
			playerListSize = playerList.size();
		}
		
		for (int i=0; i < playerListSize/2; i++){
			fruitList.add(new Fruit());
		}
		System.out.println("Fruit creation successful: " + fruitList.size() + " fruit(s) on map.");
	}

	/**
	 * Create threads to manage the snakes and players
	 * @param threadPool
	 */
	public void createThreadPool(ArrayList<ServerThread> threadPool, int threadPoolLimit){
		for(int i = 0; i < threadPoolLimit; i++){
			threadPool.add(new ServerThread());
		}
		System.out.println("Thread Pool complete: " + threadPool.size() + " threads created.");
	}
	
	/**
	 * Create threads to simulate different computers.
	 * One for each snake in the game.
	 * @param playerList
	 */
	public void createPlayerThreads(ArrayList<Player> playerList){
		for (int i = 0; i < playerList.size(); i++){
			Thread t = new Thread(playerList.get(i));
			playerList.get(i).ref = t;
		}
		System.out.println("Threads successfully created for each player");
	}
	
	/**
	 * Assign players equally across server threads
	 * @param playerList
	 * @param serverThreadList
	 */
	public void assignPlayers(ArrayList<Player> playerList, ArrayList<ServerThread> serverThreadList){
		ArrayList<Player> playerListCopy = new ArrayList<Player>();
		for (int i = 0; i < playerList.size(); i++){
			playerListCopy.add(playerList.get(i));
		}
		int pos = 0;
		while(!playerListCopy.isEmpty()){
			for(int i = 0; i < serverThreadList.size(); i++){
				if(!playerListCopy.isEmpty()){
					serverThreadList.get(i).playerList.add(playerListCopy.get(playerListCopy.size()-1));
					playerListCopy.remove(playerListCopy.size() - 1);
				}
			}
		}
		System.out.println("");
	}
	

}
