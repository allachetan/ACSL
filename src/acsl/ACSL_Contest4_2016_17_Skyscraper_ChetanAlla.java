/*
Name:Chetan Alla
Division:Junior
School: CompSciPrep
Grade:9
Year: 2016-2017
 */
package acsl;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Contest4_2016_17_Skyscraper_ChetanAlla {
	
	public static ArrayList<Integer> combos = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		
		
		// creating all the possible combinations of 1, 2, 3, 4, 5 before we start the program 
        int[] Skyscrapers = new int[] {1, 2, 3, 4, 5};
        possibleStrings(5, Skyscrapers,"");
	    
        for(int a = 0; a < 5; a ++ ){
        	
        	Scanner s = new Scanner(System.in);
    		String input = s.nextLine();
    		String inputsplit [] = input.split(", ");
        
        //all possible combinations of the skyscrapers has been made at this point around 120 now just checking which ones apply to the clues given...
        System.out.println(check(Integer.parseInt(inputsplit[0]), Integer.parseInt(inputsplit[1])));
       
        }
	}
	
	private static int check(int x, int y) {
		int count = 0;
		for(int i = 0; i < 120; i ++){
		int val [] = new int[5];
		int d = combos.get(i);
		for(int j = 4; j >= 0; j --){
			val[j] = d%10;
			d = d/10;
		}
		ArrayList<Integer>legend = new ArrayList<Integer>();
		legend.add(val[0]);legend.add(val[1]);legend.add(val[2]);legend.add(val[3]);legend.add(val[4]);
		//split up the number given from combos array
		int xcheck = 0; // left 
		int ycheck = 0; // right
		int loc = 0;
		while(legend.size() != 1){
			int num = legend.get(loc);
			if(loc + 1 == legend.size() )
				break;
			else if(num > legend.get(loc + 1))
				legend.remove(loc + 1);
			else if(num < legend.get(loc + 1))
				loc = loc + 1;
		}
		xcheck = legend.size();
		legend.clear();legend.add(val[0]);legend.add(val[1]);legend.add(val[2]);legend.add(val[3]);legend.add(val[4]);
		loc = 4;
		while(legend.size() != 1){
			int num = legend.get(loc);
			if(loc - 1 == -1)
				break;
			else if(num > legend.get(loc - 1)){
				legend.remove(loc - 1);
				loc = loc - 1;
			}
			else if(num < legend.get(loc - 1 ))
				loc = loc - 1;
				
		}
		ycheck = legend.size();
		//gotten the clues for this certain combination of the skyscrapers 
		if(x == xcheck && y == ycheck){
			count = count + 1;
		}}
		return count;
		
	}

	public static void possibleStrings(int maxLength, int[] Skyscrapers, String curr) {

		
        if(curr.length() == maxLength) {
        	int x = Integer.parseInt(curr);
        	if(difDigits(x))
        		combos.add(x);

        } else {
            for(int i = 0; i < Skyscrapers.length; i++) {
                String oldCurr = curr;
                curr += Skyscrapers[i];
                possibleStrings(maxLength,Skyscrapers,curr);
                curr = oldCurr;
            }
        }
    }

	public static boolean difDigits(int number) {
	     int numMask = 0;
	     int numDigits = (int) Math.ceil(Math.log10(number+1));
	     for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
	         int curDigit = (int)(number / Math.pow(10,digitIdx)) % 10;
	         int digitMask = (int)Math.pow(2, curDigit);             
	         if ((numMask & digitMask) > 0) return false;
	         numMask = numMask | digitMask;
	     }
	     return true;
	 }
}
