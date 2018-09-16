import java.util.Scanner;

public class ACSL_CHMOD {

	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i ++){
			
			Scanner s = new Scanner(System.in);
			String input = s.nextLine();
			String inputsplit [] = input.split(", ");
			if(i == 0 || i == 1){
				
				System.out.println(convertToBinary(inputsplit) + "AND " + convertToWords(convertToBinary(inputsplit)) );
				
			}else if( i == 2 || i == 3){
				
				System.out.println(convertToDecimal(inputsplit) + " AND " + convertToWords(input.replaceAll(",", "")));
				
			}
			else{
				
				String convert = convertToWords(input.replaceAll(",", ""));
				String [] isplit = convert.split(" ");
				System.out.println(convertToDecimal(isplit) + " AND " + convert);
				
			}
		
		}
	}
	
	public static String convertToBinary(String inputsplit []){
		
		String Return = "";
		
		for(int i = 0; i < 3; i ++){
		 if(Integer.parseInt(inputsplit[i]) == 0){
			Return = Return + "000 ";
		}else if(Integer.parseInt(inputsplit[i]) == 1){
			Return = Return + "001 ";
		}else if(Integer.parseInt(inputsplit[i]) == 2){
			Return = Return + "010 ";
		}else if(Integer.parseInt(inputsplit[i]) == 3){
			Return = Return + "011 ";
		}else if(Integer.parseInt(inputsplit[i]) == 4){
			Return = Return + "100 ";
		}else if(Integer.parseInt(inputsplit[i]) == 5){
			Return = Return + "101 ";
		}else if(Integer.parseInt(inputsplit[i]) == 6){
			Return = Return + "110 ";
		}else if(Integer.parseInt(inputsplit[i]) == 7){
			Return = Return + "111 ";
		}
			
		}
		return Return;
				
	}

	public static String convertToWords(String convert){
		
		String Return = "";
		
			if(convert.startsWith("0") || convert.startsWith("1")){
				convert = convert.replaceAll(" ", "");
				String [] csplit = convert.split("");
				for(int i = 0; i < 9; i ++){
					 if(csplit[i].equals("1") && i%3 == 0){
						csplit[i] = "r";
					}else if(csplit[i].equals("1") && i%3 == 1){
						csplit[i] = "w";
					}else if(csplit[i].equals("1") && i%3 == 2){
						csplit[i] = "x";
					}
					else if(csplit[i].equals("0")){
							csplit[i] = "-";
					}
					 if(i%3 == 2){
						 Return = Return + csplit[i] + " ";
					 }else{
					Return = Return + csplit[i];
					 }
				}
			}
			else{
				convert = convert.replaceAll("r", "1"); 
				convert = convert.replaceAll("w", "1");
				convert = convert.replaceAll("x", "1");
				convert = convert.replaceAll("-", "0");
				Return = convert;
			}
			
			
			
				
		return Return;
	}
	
	public static String convertToDecimal(String inputsplit[]){
		
		String Return = "";
		
		for(int i = 0; i < 3; i ++){
						
		if(inputsplit[i].equals("000"))
			Return = Return + "0";
		else if(inputsplit[i].equals("001"))
			Return = Return + "1";
		else if(inputsplit[i].equals("010"))
			Return = Return + "2";
		else if(inputsplit[i].equals("011"))
			Return = Return + "3";
		else if(inputsplit[i].equals("100"))
			Return = Return + "4";
		else if(inputsplit[i].equals("101"))
			Return = Return + "5";
		else if(inputsplit[i].equals("110"))
			Return = Return + "6";
		else if(inputsplit[i].equals("111"))
			Return = Return + "7";
		}
		
		return Return;
	}
}
