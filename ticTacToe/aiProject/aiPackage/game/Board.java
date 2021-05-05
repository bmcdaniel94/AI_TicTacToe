package aiPackage.game;

import java.util.*;
import java.util.stream.*;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 

public class Board extends convertArray{
	//declaration of private members
	private int score;
	private Board previousB = null;
	private Character[][] thisBoard;

	// ------------------------------------------------------;

	public Board (Character[][] inBoard) {
		//Declare
		//Convert Board to a long array
		Character[] flatArray = flattenStream(inBoard).toArray(Character[] ::new);
		//get the length
		int flatSize = flatArray.length;
		//old: int[] flat = flatten(inBoard).mapToInt(Integer.class::cast).toArray();

		//check if square
		if (Math.sqrt(flatSize)==3) {
			if(inBoard.length == 3) {
				thisBoard = inBoard;
			}
			else {
				System.out.println("The array isnt a square.");
			}
		}
		else {
			System.out.println("It doesnt match the dimensions of a tictactoe board.");
		}

		//we'll assume its not gonna break from the input atm
		setThisBoard(inBoard);
	}

	// ------------------------------------------------------;

	//https://stackoverflow.com/questions/31851548/flatten-nested-arrays-in-java
	/*
	 * You are using the comparison with Object[] to decompose the array, but in reality is a char[].
	 * That makes that your result instead of being an Stream Object is a Stream char[].
	 * The main point is that you can't use a Stream to work with primitives. Stream only works with Objects
	 *  	and char is a primitive.
	 *  
	 *  also will work
	 *  Arrays.stream(inBoard)
	 *  .flatMap(x -> (Stream<Character>)new String(x).chars().mapToObj(i->(char)i))
	 *  .collect(Collectors.toList())
	 */

	private static Stream<Object> flatten(Object[] array) {
		return Arrays.stream(array)
				.flatMap(o -> o instanceof Object[]? flatten((Object[])o): Stream.of(o));
	}

	// ------------------------------------------------------;

	public Board getPreviousB() {
		return previousB;
	}

	// ------------------------------------------------------;

	public void setPreviousB(Board previousB) {
		this.previousB = previousB;
	}

	// ------------------------------------------------------;

	public int getScore() {
		return score;
	}

	// ------------------------------------------------------;

	public void setScore(int score) {
		this.score = score;
	}

	// ------------------------------------------------------;

	public Character[][] getThisBoard() {
		return thisBoard;
	}

	// ------------------------------------------------------;

	public void setThisBoard(Character[][] inBoard) {
		this.thisBoard = inBoard;
	}

	// ------------------------------------------------------;

	//if there are even elements on the board, its x's turn
	public ArrayList<Board> getChildren(){

		return null;
	}

	// ------------------------------------------------------;

	public void checkIfEnded() {
		for (int i = 0; i < 3; i++) {
			//check row wins
			if (thisBoard[i][0] != '-' &&
					thisBoard[i][0] == thisBoard[i][1] &&
					thisBoard[i][1] == thisBoard[i][2]) {

				//updates score based on winner
				if (thisBoard[0][2] == 'x') {
					updateScore(1);
				}
				else {
					updateScore(-1);
				}
				return;
			}

			//check column wins
			if (thisBoard[i][0] != '-' &&
					thisBoard[0][i] == thisBoard[1][i] &&
					thisBoard[1][i] == thisBoard[2][i]) {

				//updates score based on winner
				if (thisBoard[0][2] == 'x') {
					updateScore(1);
				}
				else {
					updateScore(-1);
				}

				return;
			}


		}

		//check diagonals
		if (thisBoard[0][0] != '-' &&
				thisBoard[0][0] == thisBoard[1][1] &&
				thisBoard[1][1] == thisBoard[2][2]) {

			//updates score based on winner
			if (thisBoard[0][2] == 'x') {
				updateScore(1);
			}
			else {
				updateScore(-1);
			}

			return;
		}
		if (thisBoard[0][2] != '-' &&
				thisBoard[0][2] == thisBoard[1][1] &&
				thisBoard[1][1] == thisBoard[2][0]) {

			//updates score based on winner
			if (thisBoard[0][2] == 'x') {
				updateScore(1);
			}
			else {
				updateScore(-1);
			}

			return;
		}
	}

	// ------------------------------------------------------;

	//outputs the board's contents as a string
	public String toString() {
		String result = "";

		//gets the previous board's info to output first
		result = "" + previousB;

		//gets this boards info to output
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				result += thisBoard[i][j] + " ";
			}

			//adds newline char at end of row
			result += "\n";
		}
		//adds an extra newline char at end of board
		result += "\n";

		return result;
	}

	// ------------------------------------------------------;

	private void updateScore(int win) {
		if (win > 0) {
			score = 1;
		} else if(win == 0){
			score = 0;
		}else {
			score = -1;
		}
	}

	// ------------------------------------------------------;
}
