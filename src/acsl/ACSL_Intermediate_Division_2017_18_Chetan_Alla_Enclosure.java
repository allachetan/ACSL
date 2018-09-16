import java.util.Scanner;

public class ACSL_Intermediate_Division_2017_18_Chetan_Alla_Enclosure {

	public static void main(String[] args) {
		String chars = "+-*/";
		String digits = "1234567890";
		Scanner s = new Scanner(System.in);
		for(int x = 0; x < 5; x ++){
		String input = s.nextLine();
		String [] inputsplit = input.split("");
		String missing;
		if(input.contains("[") && !(input.contains("]")))
			missing = "]";
		else if(input.contains("]") && !(input.contains("[")))
			missing = "[";
		else if(input.contains("(") && !(input.contains(")")))
			missing = ")";
		else
			missing = "(";
		
		String out = "";
		if(missing.equals("]")){
			boolean start = false;
			for(int i = 0; i < inputsplit.length; i ++){
				if(inputsplit[i].equals(")"))
					start = true;
				if(start){
					if(!chars.contains(inputsplit[i])){
						if(i == inputsplit.length -1 || !(digits.contains(inputsplit[i + 1]) && digits.contains(inputsplit[i])))
						out = out + (i + 2) + ", ";
					}
				}
				
			}
		}
		else if(missing.equals(")")){
			boolean start = false;
			int count = 0;
			for(int i = 0; i < inputsplit.length; i ++){
				if(inputsplit[i].equals("]"))
					break;
				if(start == true && chars.contains(inputsplit[i]))
					count++;
				if(start){
					if(!chars.contains(inputsplit[i]) && count > 0){
						if(i == inputsplit.length -1 || !(digits.contains(inputsplit[i + 1]) && digits.contains(inputsplit[i])))
						out = out + (i + 2) + ", ";
					}
				}
				if(inputsplit[i].equals("("))
					start = true;
				
			}
		}
		else if(missing.equals("[")){
			boolean start = false;
			for(int i = inputsplit.length - 1; i >= 0; i --){
				if(start){
					if(!chars.contains(inputsplit[i + 1])){
						if(i == 0 || !(digits.contains(inputsplit[i - 1]) && digits.contains(inputsplit[i]))){
						if(i == 0)
							out = (i + 1) + ", " + out;
						else
							out = (i + 2) + ", " + out;
						}
					}
				}
				if(inputsplit[i].equals("("))
					start = true;
				
			}
		}
		else if(missing.equals("(")){
			boolean start = false;
			int count = 0;
			for(int i = inputsplit.length - 1; i >= 0; i --){
				if(inputsplit[i].equals("["))
					break;
				if(start == true && chars.contains(inputsplit[i]))
					count++;
				if(start){
					if(!chars.contains(inputsplit[i]) && count > 0){
						if(i == 0 || !(digits.contains(inputsplit[i - 1]) && digits.contains(inputsplit[i]))){
							out = (i + 1) + ", " + out;
						
						}
					}
				}
				if(inputsplit[i].equals(")"))
					start = true;
				
			}
		}
		if(out.endsWith(", "))
			out = out.substring(0, out.length() - 2);
		
		System.out.println(out);
		}
	}

}
