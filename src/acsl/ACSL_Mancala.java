import java.util.Scanner;

public class ACSL_Mancala {

	public static void main(String[] args) {
			
		Scanner s = new Scanner(System.in);
		int [] arr = new int[14];
		for(int i = 0; i < 12; i ++){
			arr[i] = 4;
		}
		for(int i = 1; i <= 5; i ++){
			boolean skipA = false;
			if(i % 2 == 0)
				skipA = true;
			
			String input = s.nextLine();
			input = input.replaceAll(" ", "");
			String [] inputsplit = input.split(",");
			int a = Integer.parseInt(inputsplit[0]) - 1;
			int b = Integer.parseInt(inputsplit[1]) - 1;
			
			int size = arr[a];
			arr[a] = 0;
			for(int x = 0; x < size; x ++){
				a++;
				if(a == 6 && !skipA){
					arr[12]++;
					arr[a]++;
					x++;
				}
				else if(a == 11 && skipA){
					arr[13]++;
					arr[a]++;
					x++;
				}else{
					arr[a]++;
				}
				if(a >= 11)
					a = -1;
			}
			System.out.println(arr[b]);
		}
		
	}

}
