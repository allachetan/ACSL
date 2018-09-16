package acsl;

import java.util.Scanner;

public class ACSL_Strings {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String mput = s.nextLine();
		mput = mput.replaceAll(" ", "");
		mput = mput.toLowerCase();
		String [] list = mput.split(",");
		for(int d = 0; d < 5; d ++){
			Scanner a = new Scanner(System.in);
			String input = a.next();
			input = input.toLowerCase();
			String output = "";
			String letters [] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
			for(int i = 0; i < list.length; i ++){
				if(input.contains("?")){
					for(int j = 0; j < 26; j ++){
						String use = input.replace("?", letters[j]);
						if(list[i].equals(use))
							output = output + list[i] + ", ";
					}
				}
				else if(input.startsWith("*")){
					String use = input.substring(1);
					if(list[i].endsWith(use))
						output = output + list[i] + ", ";
				}
				else if(input.endsWith("*")){
					String use = input.substring(0, input.length() - 1);
					if(list[i].startsWith(use))
						output = output + list[i] + ", ";
				}
				if(input.startsWith("*") && input.contains("?")){
					for(int j = 0; j < 26; j ++){
						String use = input.replace("?", letters[j]);
						use = use.substring(1);
						if(list[i].endsWith(use))
							output = output + list[i] + ", ";
					}}
				else if(input.endsWith("*") && input.contains("?")){
					for(int j = 0; j < 26; j ++){
						String use = input.replace("?", letters[j]);
						use = use.substring(0 , use.length() - 1);
						if(list[i].startsWith(use))
							output = output + list[i] + ", ";
				} 
				
			}
			}
			output = output.toUpperCase();
			if(output.equals("" ))
				output = "No Match   ";
			System.out.println(output.substring(0, output.length() - 2));
		}
	}

}
