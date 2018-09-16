import java.util.Scanner;

public class ACSL_Intermediate_Division_2017_18_Chetan_Alla_Walk {
	
	static int [][] instances;
	static int [][] board = new int[8][8];

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String in = s.nextLine(); 
		String [] data = in.split(", ");
		for(int i = 0; i < 8; i ++){
			String bin = Integer.toBinaryString(Integer.parseInt(data[i], 16));
			String [] binsplit = bin.split("");
			int place = 0;
			for(int j = 0; j < 8; j ++){
				if(binsplit.length + j < 8){
					board[i][j] = 0;
				}
				else{
					board[i][j] = Integer.parseInt(binsplit[place]);
					place ++;
				}
			}
		}
		
		for(int i = 0; i < 5; i ++){
			instances = new int[8][8];
			String input = s.nextLine();
			String [] inputsplit = input.split(", ");
			int r = Integer.parseInt(inputsplit[0]) - 1;
			int c = Integer.parseInt(inputsplit[1]) - 1;
			String pos = inputsplit[2];
			
			for(int j = 0; j < Integer.parseInt(inputsplit[3]); j++){
				
				String out = getNewPosition(r, c, pos);
				r = Integer.parseInt(out.substring(0, 1)) ;
				c = Integer.parseInt(out.substring(1, 2)) ;
				pos = out.substring(2);
			} 
			r++;
			c++;
			System.out.println(r + ", " + c);
		}
	}

	private static String getNewPosition(int r, int c, String pos) {
		
		if(board[r][c] == 0){
			if(pos.equals("L")){
				if(c == 7)
					c = 0;
				else
					c++;
			}
			else if(pos.equals("R")){
				if(c == 0)
					c = 7;
				else
					c--;
			}
			else if(pos.equals("A")){
				if(r == 7)
					r = 0;
				else
					r++;
			}
			else if(pos.equals("B")){
				if(r == 0)
					r = 7;
				else
					r--;
			}
			return r  + "" + c + pos;
		}else{
		
			instances[r][c] ++;
			// 1 = to left 2 = to right 3 = up 4 = down
			int [] L = {0, 3, 2, 4, 1};
			int [] R = {0, 4, 1, 3, 2};	
			int [] B = {0, 1, 3, 2, 4};
			int [] A = {0, 2, 4, 1, 3};
			
			int m = 0;
			if(pos.equals("L"))
				m = L[instances[r][c]];
			else if(pos.equals("R"))
				m = R[instances[r][c]];
			else if(pos.equals("A"))
				m = A[instances[r][c]];
			else if(pos.equals("B"))
				m = B[instances[r][c]];
			
			if(m == 1){// to left
				if(c == 0)
					c = 7;
				else
					c--;
				pos = "R";
			}
			else if(m == 2){ // to right
				if(c == 7)
					c = 0;
				else
					c++;
				pos = "L";
			}
			else if(m == 3){// up
				if(r == 0)
					r = 7;
				else
					r--;
				pos = "B";
			}
			else if(m == 4){ // down
				if(r == 7)
					r = 0;
				else
					r++;
				pos = "A";
			}
			return r + "" + c + pos;
		}
					
	}

}
