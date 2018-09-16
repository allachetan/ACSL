import java.util.Scanner;

public class ACSL_Scrabble {
	
	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		String word = s.nextLine();
		String [] wordsplit = word.split(", ");
		String letters = "AEDRBMVYJX";
		int [] point = {1, 1, 2, 2, 3, 3, 4, 4, 8, 8};
		for(int i = 0; i < 5; i ++){
			String input = s.nextLine();
			String [] inputsplit = input.split(", ");
			int add;
			if(inputsplit[1].equals("H"))
				add = 1;
			else 
				add = 10;
			int place = Integer.parseInt(inputsplit [0]);
			int points = 0;
			int multiply = 1;
			for(int j = 0; j < 4; j ++){
				if(place % 6 == 3)
					points += 2 * point[letters.indexOf(wordsplit[j])];
				else if(place % 5 == 0)
					points += 3 * point[letters.indexOf(wordsplit[j])];
				else if(place%7 == 0){
					points += point[letters.indexOf(wordsplit[j])]; 
					multiply = 2;
				}
				else if(place % 8 == 0){
					points += point[letters.indexOf(wordsplit[j])];
					multiply = 3;
				}else 
					points += point[letters.indexOf(wordsplit[j])];	
				place += add;
			}
			System.out.println(multiply * points);
		}
		s.close();
	}
}
/*
X, R, A, Y
3, V
7, V
10, V
31, H
35, H
*/