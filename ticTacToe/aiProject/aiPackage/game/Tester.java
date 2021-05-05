package aiPackage.game;

import java.util.*;

public class Tester {
	private static Board start;
	private static Board finish;
	
	public static void main(String[] args) {
		Character[][] temp = {
			{'o','-','x'},
			{'-','-','-'},
			{'-','-','-'}};
		
		start = new Board(temp);
		finish = minMax(start.getChildren());
		System.out.println();

	}
	
	public static Board minMax(ArrayList<Board> resultList) {
		
		
		return null;
	}
	
	

}
