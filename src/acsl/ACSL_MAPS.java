import java.util.Scanner;

public class ACSL_MAPS {

	public static void main(String[] args) {
		for (int j = 0; j < 5; j++) {
			String indexMiles = "ABCDEFG";
			String indexGas = "CMFV";
			String indexRoad = "IHMS";
			int miles[] = {0, 450, 590, 710, 1030, 1280, 1360 };
			int gas[] = { 28, 25, 22, 20 };
			int road[] = { 65, 60, 55, 45 };
			Scanner s = new Scanner(System.in);
			String input = s.nextLine();
			String inputsplit[] = input.split(", ");
			int m = miles[indexMiles.indexOf(inputsplit[1])] - miles[indexMiles.indexOf(inputsplit[0])];
			double p = ((m + 0.0) / gas[indexGas.indexOf(inputsplit[2])]) * Double.parseDouble(inputsplit[4]);		
			String rp = ((int) (p * 100)) /100.0 + "";
			if(rp.length() == 4)
				rp +="0";
			System.out.println(m + ", " + getTime(indexRoad, road, m, inputsplit) + ", $" + rp);
		}
	}

	private static String getTime(String indexRoad, int[] road, int m, String[] inputsplit) {

		double minutes = m / (road[indexRoad.indexOf(inputsplit[3])] / 60.0);
		minutes = minutes / 60;
		int hours = (int) (minutes);
		int min = (int) Math.round(((minutes - hours) * 60));

		String r = "";
		if (hours < 10) {
			r += "0" + hours;
		} else {
			r += hours;
		}
		r += ":";
		if (min < 10) {
			r += "0" + min;
		} else {
			r += min;
		}
		
		return r;
	}

}
