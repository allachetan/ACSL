package acsl;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_PIP {

	public static void main(String[] args) {
		for(int j = 0; j < 5; j ++){
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String inputsplit [] = input.split("");
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < input.length(); i ++){
			list.add(inputsplit[i]);
		}
		
		while(list.contains("*")){
		for(int i = 0; i < list.size(); i ++){
			if(list.get(i).equals("*")){
				list.remove(i);
				list.add(i - 1 , "q");
				String add = list.get(i - 1) + list.get(i) + list.get(i + 1);
				list.remove(i -1); list.remove(i - 1); list.remove(i -1); list.add(i - 1, add);
				
			}
		}	
		}
		
		while(list.contains("+") || list.contains("-")){
			for(int i = 0; i < list.size(); i ++){
				if(list.get(i).equals("+") || list.get(i).equals("-")){
					if(list.get(i).equals("+")){
					list.remove(i);
					list.add(i - 1 , "w");
					}else{
						list.remove(i);
						list.add(i - 1, "e");
					}
					String add = list.get(i - 1) + list.get(i) + list.get(i + 1);
					list.remove(i -1); list.remove(i - 1); list.remove(i -1); list.add(i - 1, add);
				}
			}	
			}
		
		
		
		String output = "";
		for(int i = 0; i < list.size(); i ++){
			output = output + list.get(i);
		}
		output = output.replaceAll("w", "+");
		output = output.replaceAll("e", "-");
		output = output.replaceAll("q", "*");
		System.out.println(output);
		

	}}}
