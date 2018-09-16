import java.util.Scanner;

public class ACSL_Intermediate_Division_2017_18_Chetan_Alla_NientyNine {

	private static int index = 0;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for(int j = 0; j < 5; j ++){
		String input = s.nextLine();
		String cards = "0123456789TJQKA";
		String [] inputsplit = input.split(", ");
		int points = Integer.parseInt(inputsplit[0]);
		int[] deck = {cards.indexOf(inputsplit[1]), cards.indexOf(inputsplit[2]), cards.indexOf(inputsplit[3])};
		int[] picks = {cards.indexOf(inputsplit[4]), cards.indexOf(inputsplit[6]), cards.indexOf(inputsplit[8]), cards.indexOf(inputsplit[10])};
		int[] plays = {cards.indexOf(inputsplit[5]), cards.indexOf(inputsplit[7]), cards.indexOf(inputsplit[9])};
		String winner = "player";
		
		for(int i = 0; i < 4; i ++){
			
			int card = getGreatest(deck);
			points = addPoints(card, points);
			deck[index] = picks[i];
			if(points > 99){
				winner = "dealer";
				break;
			}
			points = addPoints(plays[i], points);
			if(points > 99)
				break;
			
		}
		
		System.out.println(points + ", " + winner);
	
		}
		s.close();
		
	}

	private static int addPoints(int card, int points){
		
		
		if(card == 9)
			points += 0;
		else if(card == 10)
			points += -10;
		else if(card == 14){
			if(points + 14 > 99)
				points += 1;
			else
				points += 14;	
		}
		else 
			points += card;
		
		return points;
		
	}
	

	private static int getGreatest(int[] deck) {
		int greatest = deck[0];
		index = 0;
		for(int i = 1; i < deck.length; i ++){
			if(deck[i] > greatest){
				greatest = deck[i];
				index = i;
			}
		}
		return greatest;
	}

}
