/*
Name:Chetan Alla
Division:Junior
School: CompSciPrep
Grade:9
Year: 2016-2017
 */
package acsl;

import java.util.Scanner;

public class ACSL_Contest3_2016_17_LightsOut_ChetanAlla {

	public static void main(String[] args) {
		for(int c = 0; c < 5; c ++){
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input = input.replaceAll(" ", "");
		String [] inputsplit = input.split(",");
		int nRows = Integer.parseInt(inputsplit[0]);
		String board [][] = {
				{"u", "u", "u", "u", "u", "u", "u", "u"}, 
				{"u", "u", "u", "u", "u", "u", "u", "u"},
				{"u", "u", "u", "u", "u", "u", "u", "u"},
				{"u", "u", "u", "u", "u", "u", "u", "u"},
				{"u", "u", "u", "u", "u", "u", "u", "u"},
				{"u", "u", "u", "u", "u", "u", "u", "u"},
				{"u", "u", "u", "u", "u", "u", "u", "u"},
				{"u", "u", "u", "u", "u", "u", "u", "u"}}; 
		
		String [] xLoc = inputsplit[inputsplit.length - 1].split("");
		int xr = 8 -Integer.parseInt(xLoc[0]); int xc = Integer.parseInt(xLoc[1]) - 1;
		
		if(xr > 1 )
			board[xr-2][xc] = "a";
		if(xr > 0 )
			board[xr-1][xc] = "a";
		if(xc < 7 && xr > 0 )
			board[xr - 1][xc + 1] = "a";
		if(xc < 6  )
			board[xr][xc + 2] = "a";
		if(xc < 7 )
			board[xr][xc + 1] = "a";
		if(xr < 7 && xc < 7 )
			board[xr + 1][xc + 1] = "a";
		if(xr < 6 )
			board[xr + 2][xc] = "a";
		if(xr < 7)
			board[xr + 1][xc] = "a";
		if(xr < 7 && xc > 0 )
			board[xr + 1][xc - 1] = "a";
		if(xc > 1 )
			board[xr][xc - 2] = "a";
		if(xc > 0)
			board[xr][xc - 1] = "a";
		if(xr > 0 && xc > 0 )
			board[xr - 1][xc - 1] = "a";
		board[xr][xc]="a";
		

	
		

			for(int j = 0; j < inputsplit.length - 2; j ++){
				String [] val = inputsplit[j + 1].split("");
				for(int z = 1; z < val.length ; z ++){
					if(board[8 - Integer.parseInt(val[0])][Integer.parseInt(val[z]) - 1].equals("a")){
						board[8 - Integer.parseInt(val[0])][Integer.parseInt(val[z]) - 1] = "q";
					}else if(!(board[8 - Integer.parseInt(val[0])][Integer.parseInt(val[z]) - 1].equals("a"))){
					board[8 - Integer.parseInt(val[0])][Integer.parseInt(val[z]) - 1] = "o";
					}
				}
			}
		
			int count = 0;
			for(int i = 0; i < 8; i ++){
				for(int j = 0; j < 8; j ++){
					if(board[i][j].equals("a") || board[i][j].equals("o"))
						count ++;
				}}
			
		System.out.println(count);
		
	}

	}}
