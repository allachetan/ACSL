package acsl;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Dominos {

	public static void main(String[] args) {

		for(int x = 0; x < 10; x ++){
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input = input.replaceAll(" ", ""); input = input.replaceAll(",", "");
		//creation
		String [] locations = input.substring(0, 5).split("");
		String [] fill = input.substring(5, 15).split("");
		String [] nhand = input.substring(15, input.length()).split("");
		String [] [] board = new String[10][2];
		String [] [] hand = new String[5][2];
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		list.remove(list.get(Integer.parseInt(locations[0]) - 1));
		list.remove(list.get(Integer.parseInt(locations[1])-2));
		list.remove(list.get(Integer.parseInt(locations[2])-3));
		list.remove(list.get(Integer.parseInt(locations[3])-4));
		list.remove(list.get(Integer.parseInt(locations[4])-5));
		//adding value to board
		for(int i = 0; i < 5; i ++){
			board[Integer.parseInt(locations[i]) - 1][0] = fill[i*2];
			board[Integer.parseInt(locations[i]) - 1][1] = fill[(i*2) + 1];
			hand[i][0] = nhand[i * 2];
			hand[i][1] = nhand[(i * 2) + 1];
		}
		//adding new values to the board
		for(int i = 1; i < 11; i ++){
			
			if(i == 9){
				if(list.contains(10)){
				for(int j = 0; j < 5; j ++){
					if(board[8][1].equals(hand[j][0])){
						board[9][0] = hand[j][0]; board[9][1] = hand[j][1];hand[j][0] = "dadewadew";hand[j][1] = "dadewadew";
					}
					if(board[8][1].equals(hand[j][1])){
						board[9][0] = hand[j][1]; board[9][1] = hand[j][0];hand[j][0] = "dadewadew";hand[j][1] = "dadewadew";
					}
				}
				}
			}
			else if(i == 10){
				if(list.contains(1)){
					for(int j = 0; j < 5; j ++){
						if(board[1][0].equals(hand[j][1])){
							board[0][0] = hand[j][0]; board[0][1] = hand[j][1];hand[j][0] = "dadewadew";hand[j][1] = "dadewadew";}
						if(board[1][0].equals(hand[j][0])){
							board[0][0] = hand[j][1]; board[0][1] = hand[j][0];hand[j][0] = "dadewadew";hand[j][1] = "dadewadew";}
					}
					}
			}
			else if(list.contains(i + 1)){
				for(int j = 0; j< 5; j ++){
					if((board[i - 1][1].equals(hand[j][0]) && board[i + 1][0].equals(hand[j][1])) ){
						board[i][0] = hand[j][0]; board[i][1] = hand[j][1];hand[j][0] = "dadewadew";hand[j][1] = "dadewadew";
					}
					else if((board[i - 1][1].equals(hand[j][1]) && board[i + 1][0].equals(hand[j][0])) ){
						board[i][0] = hand[j][1]; board[i][1] = hand[j][0];hand[j][0] = "dadewadew";hand[j][1] = "dadewadew";
					}
				}
			}
			
		}
		//board finished all thats left is printing whats needed
		
		for(int i = 0; i < 5; i ++){
			System.out.print(board[list.get(i) - 1][0] + ",");
			System.out.print(board[list.get(i) - 1][1] + ",");
			System.out.print(list.get(i));
			System.out.println("");
		}}
	}

}
