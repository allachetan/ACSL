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

public class ACSL_Contest2_2016_17_ASCENDING_ChetanAlla {

	public static void main(String[] args) {
		
		for(int j = 0; j < 5; j ++){
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String inputsplit [] = input.split("");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(Integer.parseInt(inputsplit[0]));
		int count = 0; // last index in the list 
		int current = 1; //current index in the input
		while(true && current < inputsplit.length){
			int last = list.get(count);
			int now = Integer.parseInt(inputsplit[current]);
			if(now > last){
				list.add(now);
				count ++;
				current++;
			}
			else if(last >= now && current + 1 < inputsplit.length){
				current ++;
				while(last >= now && current < inputsplit.length){
					now = (now*10) + Integer.parseInt(inputsplit[current]);
					current ++;
					if(now > last){
						list.add(now);
						count ++;
					}
				}
			}
			else
				break;	
		}
		for(int i = 0; i < list.size(); i ++){
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		}
	}
}