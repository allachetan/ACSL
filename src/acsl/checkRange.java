import java.util.Scanner;

public class checkRange {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter center point of the Square");
		String center = s.nextLine();
		System.out.println("Enter the side length of the Square");
		int sideLength = s.nextInt();
		Scanner n = new Scanner(System.in);
		System.out.println("enter the coordinate to check");
		String coordinate = n.nextLine();
		
		int cx = Integer.parseInt((center.substring(1, 2)));
		int cy = Integer.parseInt(center.substring(3, 4));
		
		int x = Integer.parseInt((coordinate.substring(1, 2)));
		int y = Integer.parseInt((coordinate.substring(3, 4)));
		
		System.out.println(cx-sideLength/2.0 <= x && x<= cx+ sideLength/2.0 && cy- sideLength/2.0 <= y && y<= cy + sideLength/2.0);
		
	}

}
