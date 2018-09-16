import java.util.Scanner;

public class ACSL_NYSIIS {

	public static void main(String[] args) {
		
		String vowels = "AEIOU";
		Scanner s = new Scanner(System.in);
		for(int x = 0; x < 5; x++){
		String input = s.next();
		
		//rule 1
		if(input.startsWith("MAC"))
			input = "MC" + input.substring(3);
		else if(input.startsWith("KN"))
			input = "N" + input.substring(2);
		else if(input.startsWith("K"))
			input = "C" + input.substring(1);
		else if(input.startsWith("PH") || input.startsWith("PF"))
			input = "F" + input.substring(2);
		else if(input.startsWith("SCH"))
			input = "S" + input.substring(3);
		
		//rule 2
		if(input.endsWith("EE") || input.endsWith("IE"))
			input = input.substring(0, input.length() - 2) + "Y";
		else if(input.endsWith("DT") || input.endsWith("RT") || input.endsWith("RD") || input.endsWith("NT") || input.endsWith("ND"))
			input = input.substring(0, input.length() - 2) + "D";
		
		//rule 4
		for(int i = 0; i < 9; i ++){
			for(int j = 1; j < input.length(); j ++){
				if(i == 0 && j + 1 != input.length() &&  input.charAt(j) == 'E' && input.charAt(j + 1) == 'V' )
					input = input.substring(0, j) + "AF" + input.substring(j + 2);
				if(i == 1 && (input.charAt(j) == 'E' || input.charAt(j) == 'I' || input.charAt(j) == 'O' || input.charAt(j) == 'U'))
					input = input.substring(0, j) + "A" + input.substring(j + 1);
				if(i == 2 && (input.charAt(j) == 'Q' || input.charAt(j) == 'Z' || input.charAt(j) == 'M')){
					String a = ""; if(input.charAt(j) == 'Q') a = "G"; if(input.charAt(j) == 'Z') a = "S"; if(input.charAt(j) == 'M') a = "N";
					input = input.substring(0, j) + a + input.substring(j + 1);	
				}
				if(i == 3 && j + 1 != input.length() &&  input.charAt(j) == 'K' && input.charAt(j + 1) == 'N' )
					input = input.substring(0, j) + "N" + input.substring(j + 2);
				if(i == 4 && input.charAt(j) == 'K')
					input = input.substring(0, j) + "C" + input.substring(j + 1);
				if(i == 5 && j + 2 < input.length() &&  input.charAt(j) == 'S' && input.charAt(j + 1) == 'C' && input.charAt(j + 2) == 'H' )
					input = input.substring(0, j) + "S" + input.substring(j + 3);
				if(i == 5 && j + 1 != input.length() &&  input.charAt(j) == 'P' && input.charAt(j + 1) == 'H' )
					input = input.substring(0, j) + "F" + input.substring(j + 2);
				if(i == 6 && input.charAt(j) == 'H' &&  (!(vowels.contains(Character.toString(input.charAt(j - 1)))) || (j + 1 != input.length() &&  !(vowels.contains(Character.toString(input.charAt(j + 1)))))))
					input = input.substring(0, j) + input.substring(j + 1);
				if(i == 7 && input.charAt(j) == 'W' && vowels.contains(Character.toString(input.charAt(j - 1))))
					input = input.substring(0, j) + input.substring(j + 1);
				if(i == 8 && (input.charAt(j) == input.charAt(j - 1) ))
					input = input.substring(0, j) + input.substring(j + 1);
				
			}
		}
		
		//rule 5 - 7
		if(input.endsWith("S"))
			input = input.substring(0, input.length() - 1);
		if(input.endsWith("AY"))
			input = input.substring(0, input.length() - 2) + "Y";
		if(input.endsWith("A"))
			input = input.substring(0, input.length() - 1);
		System.out.println(input);
		
		}
	}

}
