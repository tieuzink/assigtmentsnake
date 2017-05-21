package assignmentSnakes;

import java.awt.Point;
import java.util.ArrayList;

public class Snake {
	Point head; //Head location
	ArrayList<Point> body; //Array of all body part locations
	
	/**
	 * Snake constructor
	 */
	public Snake(){
		head = new Point(0,0);
		body = new ArrayList<Point>();
	}
}
