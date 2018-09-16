package acsl;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Fanorona {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input.trim();
		String inputsplit [] = input.split(",");
		int wLength = Integer.parseInt(inputsplit[0]);
		int bLength = Integer.parseInt(inputsplit[wLength + 1]);
		String board[][] = {{"1", "2", "3", "4", "5",},{"6", "7", "8", "9", "10"},{"11","12", "13", "14", "15"},{"16", "17", "18", "19", "20"},{"21", "22", "23", "24", "25"}};
		for(int i = 1; i <= wLength; i ++){
			for(int x = 0; x < 5; x ++){
				for(int y = 0; y < 5; y ++){
					if(board[x][y].equals(inputsplit[i])){
						board[x][y] = "w";
					}
				}
			}
		}
		for(int i = wLength + 1; i <= wLength + 1 + bLength; i ++){
			for(int x = 0; x < 5; x ++){
				for(int y = 0; y < 5; y ++){
					if(board[x][y].equals(inputsplit[i])){
						board[x][y] = "b";
					}
				}
			}
		}
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//d
		for(int a = 0; a < wLength; a ++){
			int x = 0; int y = 0;
			for(int i = 0; i < 5; i ++){
				for(int j = 0; j < 5; j ++){
					if(board[i][j].equals("w"))
						x = i; y = j;
				}
			}
			//check top
			if(x!=0 && board[x-1][y].equals("b")){
				boolean stop = false;
				for(int i = 1; i <= 4; i ++){
					if(x-i==-1)
						break;
					else if(board[x-i][y].equals("b")){
						list.add(x-i); list.add(y);}
					else if(!board[x-i][y].equals("b")){
							break;}
				}
				board[x][y] = "d";
			}
			//dog
			if(x!=1 && x!=0 && board[x-2][y].equals("b") && !board[x-1][y].equals("b")){
				boolean stop = false;
				for(int i = 2; i <= 4; i ++){
					if(x-i==-1)
						break;
					else if(board[x-i][y].equals("b")){
						list.add(x-i); list.add(y);}
					else if(!board[x-i][y].equals("b")){
							break;}
				}
				board[x][y] = "d";
			}
			//check right
			if(y!=4 && board[x][y + 1].equals("b")){
				boolean stop = false;
				for(int i = 1; i < 4; i ++){
					if(y+1 == 5)
						break;
					else if(board[x][y + i].equals("b")){
						list.add(x);list.add(y+1);}
					else{
						break;}
				}
				board[x][y]= "d";
			}
			//check bot
			if(x!=4 && board[x+1][y].equals("b")){
				boolean stop = false;
				for(int i = 1; i <= 4; i ++){
					if(x+i==5)
						break;
					else if(board[x+i][y].equals("b")){
						list.add(x+i); list.add(y);}
					else if(!board[x+i][y].equals("b")){
							break;}
				}
				board[x][y] = "d";
			}
			//check left
			if(y!=0 && board[x][y - 1].equals("b")){
				boolean stop = false;
				for(int i = 1; i < 4; i ++){
					if(y-1 == -1)
						break;
					else if(board[x][y - i].equals("b")){
						list.add(x);list.add(y-1);}
					else{
						break;}
				}
				board[x][y]= "d";
			}
			
		}
	}

}
