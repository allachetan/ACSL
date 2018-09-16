import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Complement {

	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String [] inputsplit = input.split(", ");
		int minuend = Integer.parseInt(inputsplit[0]);
		int subtrahend = Integer.parseInt(inputsplit[1]);
		
		System.out.println(base2Conversion(minuend));
		System.out.println(base2Conversion(subtrahend));
		System.out.println(complement(subtrahend));
		System.out.println(complement(minuend));
		
	}

	private static String complement(int d){
		String x = base2Conversion(d);
		String result = "";
		String string = x + "";
		for (char c : string.toCharArray()) {
			if (c == '0')
				result += "1";
			if (c == '1')
				result += "0";			
		}
		long negro = rebase(result, 2);
		negro = negro + 1;
		String legend = negro + "";
		int god = Integer.parseInt(legend);
		return base2Conversion(god);
	}

	private static String base2Conversion(int x) {
		int num = x;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!(num == 1)){
			num = num/2;
		}
		String output = "1";
		for(int i = list.size() - 1; i >= 0; i --){
			output = output + (list.get(i).toString());
		}
		return output;
	}
	
	//symbols array
    private static final String SYMBOLS = "0123456789ABCDEF";

    //actual algorithm 
    public static long rebase(String number, int base)
    {
        long result = 0;
        int position = number.length(); //we start from the last digit in a String (lowest value)
        for (char ch : number.toCharArray())
        {
            int value = SYMBOLS.indexOf(ch);
            result += value * pow(base,--position); //this is your 1x2(pow 0)+0x2(pow 1)+0x2(pow 2)+1x2(pow 3)

        }
        return result;
    }

    //power - don't know if this is needed?
    private static long pow(int value, int x)
    {
        if (x == 0) return 1;
        return value * pow(value,x-1);
    }
}

