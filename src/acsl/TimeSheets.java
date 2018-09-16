import java.util.Scanner;

public class TimeSheets {

	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		for(int i = 0; i < 5; i ++){
		String input = s.nextLine();
		input = input.replaceAll(" ", "");
		String input2 = input.substring(10);
		input = input.substring(0, 10);
		double a = getCash(input);
		double b = getCash(input2);
		System.out.println(Math.round((a + b) * 100.0) / 100.0);
		}
		s.close();
	}

	private static double getCash(String input) {
		
		String inputsplit [] = input.split(",");
		
		double money = 0;
		if(Integer.parseInt(inputsplit[0]) >= 500){
			for(double i = 0; i < (Integer.parseInt(inputsplit[3], 18) - Integer.parseInt(inputsplit[2], 18))/2.0; i += 0.5){
				if(i < 6)
					money += 4;
				else
					money+= 6;
			}
		}else if(Integer.parseInt(inputsplit[0]) >= 400){
			for(double i = 0; i < (Integer.parseInt(inputsplit[3], 18) - Integer.parseInt(inputsplit[2], 18))/2.0; i += 0.5){
				if(Integer.parseInt(inputsplit[1]) == 1 || Integer.parseInt(inputsplit[1]) == 7 )
					money += 6.75;
				else
					money+= 3.375;
			}
		}else if(Integer.parseInt(inputsplit[0]) >= 300){
			for(double i = 0; i < (Integer.parseInt(inputsplit[3], 18) - Integer.parseInt(inputsplit[2], 18))/2.0; i += 0.5){
				if(i < 4)
					money += 4.625;
				else
					money+= 5.25;
			}
		}else if(Integer.parseInt(inputsplit[0]) >= 200){
			for(double i = 0; i < (Integer.parseInt(inputsplit[3], 18) - Integer.parseInt(inputsplit[2], 18))/2.0; i += 0.5){
				if(i < 6)
					money += 3.75;
				else
					money+= 7.5;
			}
		}else if(Integer.parseInt(inputsplit[0]) >= 100){
			for(double i = 0; i < (Integer.parseInt(inputsplit[3], 18) - Integer.parseInt(inputsplit[2], 18))/2.0; i += 0.5){
				if(i < 5)
					money += 5;
				else
					money+= 7.5;
			}
		}
		
		return money;
	}
	
}
