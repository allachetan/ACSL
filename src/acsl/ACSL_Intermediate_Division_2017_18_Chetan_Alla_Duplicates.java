import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ACSL_Intermediate_Division_2017_18_Chetan_Alla_Duplicates {

	public static ArrayList<String> history = new ArrayList<String>();
	public static ArrayList<String> word = new ArrayList<String>();
	public static ArrayList<Integer> instances = new ArrayList<Integer>();
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int count = 0;
		while(count < 5){
			
			String input = s.nextLine();
			input = input.toUpperCase();
			input = input.replaceAll(" ", "");
			if(input.contains("RESET")){
				reset(input.replace("RESET", ""));
			}
			else if(input.contains("REPORT")){
				report(input.replace("REPORT", ""));
				count ++;
			}
			else if(input.contains("ADD")){
				add(input.replace("ADD", ""));
			}
			else if(input.contains("DELETE")){
				delete(input.replace("DELETE", ""));
			}
			
		}
		s.close();
	}

	private static void delete(String replace) {

		String [] str = replace.split("");
		
		for(int i = 0; i < str.length; i ++){
			if(word.contains(str[i]) && instances.get(word.indexOf(str[i])) > 1){
				int x = word.indexOf(str[i]);
				instances.set(x, instances.get(x) - 1);
			}else if(word.contains(str[i])){
				int x = word.indexOf(str[i]);
				word.remove(x);
				instances.remove(x);
				updateHistory();
			}
		}
		
	}

	private static void add(String replace) {
	
		String [] str = replace.split("");
		
		for(int i = 0; i < str.length; i ++){
			if(word.contains(str[i])){
				int x = word.indexOf(str[i]);
				instances.set(x,  instances.get(x) + 1);
			}else{
				word.add(str[i]);
				Collections.sort(word);
				int x = word.indexOf(str[i]);
				updateHistory();
				instances.add(x, 1);
			}
		}
		
	}

	private static void report(String replace) {
		
		int x = Integer.parseInt(replace);
		System.out.println(history.get(x - 1).substring(1));
		
	}

	private static void reset(String replace) {
		
		List<String> sorter = Arrays.asList(replace.split(""));
		
		history = new ArrayList<String>();
		word = new ArrayList<String>();
		instances = new ArrayList<Integer>();
		
		for(int i = 0; i < sorter.size(); i ++){
			if(word.contains(sorter.get(i))){
				int x = word.indexOf(sorter.get(i));
				instances.set(x, instances.get(x) + 1);
			}else{
				word.add(sorter.get(i));
				Collections.sort(word);
				int x = word.indexOf(sorter.get(i));
				updateHistory();
				instances.add(x, 1);
			}
		}
		
		
	}

	private static void updateHistory() {
		for(int i = 0; i < word.size(); i ++){
			if(history.size() < word.size())
				history.add(word.get(i));
			else if(!history.get(i).endsWith(word.get(i))){
				history.set(i, history.get(i) + word.get(i));
			}
		}
		
	}

}
