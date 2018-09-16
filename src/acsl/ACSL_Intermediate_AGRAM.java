/*
 * Name: Chetan Alla
 * Year: 2017 - 2018
 * Program: AGRAM
 */
import java.util.Scanner;

public class ACSL_Intermediate_AGRAM {

	public static String numbers = "A23456789TJQK";
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for(int i = 0; i < 5; i ++){	
		//gathering input and putting it into an array splitting at the , .																	
		String input = s.nextLine();							
		String[] inputsplit = input.split(", ");		
		//sending info to the method and prints what comes back.
		System.out.println(getOutput(inputsplit));
		}
		s.close();
		
	}

	private static String getOutput(String[] inputsplit) {
		/*
		 * Return is used to store a temporary value to check if it is the value we are supposed to get. The for loop loops around 5 times because there are 5 cards in the dealers deck starting at 1
		 * instead of 0 because 0 is the index for the opponents card. The first if statement is used to check if the suites are the same and if the card number is greater than the card the
		 * opponent played using substrings. The value of each number such as A or 5 or T are determined by a string numbers created above the main method. It is a string with all the numbers put
		 * together in order and uses .indexOf to get the value of each number. Once the first if statement passes, it needs to add a value to Return if it is and if it isn't then it needs to 
		 * check if there is a value less than what is already in Return to put into it. What this all does is basically finding the smallest possible value to fit into Return.
		 */
		String Return = "";
		for(int i = 1; i <= 5; i ++){
			if(inputsplit[0].substring(1).equals(inputsplit[i].substring(1)) && numbers.indexOf(inputsplit[0].substring(0, 1)) < numbers.indexOf(inputsplit[i].substring(0, 1))){
			
				if(Return == "")
					Return = inputsplit[i];
				else if(numbers.indexOf(Return.substring(0, 1)) > numbers.indexOf(inputsplit[i].substring(0, 1)))    
					Return = inputsplit[i];
			}
		}
		//if there was not any card went through the first if statement Return should be empty. If it isn't that means we have out output and this method will not keep going. 
			if(Return != "")
				return Return;
		/*
		 * Just like the one above, this also has a for loop that goes 5 times starting at 1 to skip the opponents card. The first if statement only check if there is a card in the same suite 
		 * because if the program made it this far it know knows that there is no card in the same suite that is greater than the opponents card so the next thing we must play is the lowest card
		 * in the same suite. If the if statement passes it adds something to return if there is nothing in it or adds in a value for return if there is something smaller than what is already in 
		 * return.
		 */
		for(int i = 1; i <= 5; i ++){
			if(inputsplit[0].substring(1).equals(inputsplit[i].substring(1))){
				if(Return == "")
					Return = inputsplit[i];
				else if((numbers.indexOf(Return.substring(0, 1)) > numbers.indexOf(inputsplit[i].substring(0, 1))))
					Return = inputsplit[i];
					
			}
		}
		//if there was not any card went through the first if statement Return should be empty. If it isn't that means we have out output and this method will not keep going. 
		if(Return != "")
			return Return;
		/*
		 * Just like above, this also has a for loop that goes 5 times starting at 1 to skip the opponents card. There is no if statement in this one because if the program made it this far we know
		 * that there is no card in the same suite as the opponents card. So know we must just update Return and look for the smallest possible card value in the deck and play that by updating 
		 * return if we get a smaller value than what is in it.
		 */
		for(int i = 1; i <= 5; i ++){
			if(Return =="")
				Return = inputsplit[i];
			else if((numbers.indexOf(Return.substring(0, 1)) > numbers.indexOf(inputsplit[i].substring(0, 1))))
				Return = inputsplit[i];
		}
		//Returns what we got in the previous for loop printing it.
		return Return;
	}

}
