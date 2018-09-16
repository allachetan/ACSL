package acsl;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Numble {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input = input.replaceAll(", ", "");
		String [] inputsplit = input.split("");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < inputsplit.length - 1; i ++){
			list.add(Integer.parseInt(inputsplit[i]));
		}
		for(int i = 0; i < getAmount(inputsplit.length - 1); i ++){
			break;
		}
	}
	
	public static int getAmount(int n){
		int out = 1;
		for(int i = n; i > 0; i --){
			out = out*n;
		}
		System.out.println(out);
		return n;
	}
	
}
