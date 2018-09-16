
public class ACSL_DraftPicks {

	public static void main(String[] args) {
		
		final int years[] = {5, 6, 6, 6, 5};
		final double salary[] = {57.5, 56.5, 72, 60, 51};
		
		System.out.println(getM1(years, salary));
		System.out.println(getM2(years, salary));
		System.out.println(getM3(years, salary));
		System.out.println(getM4(years, salary));
		System.out.println(getM5(years, salary));

		
	}

	private static double getM5(int[] years, double[] salary) {
		double avg1 = 0;
		double avg2 = 0;
		for(int i = 0; i < salary.length; i ++){
			salary[i] = salary[i] * 1000000;
			salary[i] = salary[i] / years[i];
			salary[i] = salary[i] / 16;
			avg1 += salary[i];
		}
		for(int i = 0; i < salary.length; i ++){
			salary[i] = salary[i] * 1000000;
			salary[i] = salary[i] / years[i];
			salary[i] = salary[i] / 18;
			avg2 += salary[i];
		}
		avg1 = avg1 /salary.length;
		avg2 = avg2/salary.length;
		
		return avg1 - avg2;
	}

	private static double getM4(int[] years, double[] salary) {
		double highest = 0;
		for(int i = 0; i < salary.length; i ++){
			salary[i] = salary[i] * 1000000;
			salary[i] = salary[i] / years[i];
			salary[i] = salary[i] / 18;
			if(salary[i] > highest)
				highest = salary[i];
		}
		return highest;
	}

	private static double getM3(int[] years, double[] salary) {
		double lowest = 100000000;
		for(int i = 0; i < salary.length; i ++){
			salary[i] = salary[i] * 1000000;
			salary[i] = salary[i] / years[i];
			salary[i] = salary[i] / 16;
			if(salary[i] < lowest)
				lowest = salary[i];
		}
		return lowest;
	}

	private static double getM2(int[] Years, double[] Salary) {
		double avg = 0.0;
		for(int i = 0; i < Salary.length; i ++){
			Salary[i] = Salary[i] * 1000000;
			Salary[i] = Salary[i] / Years[i];
			avg += Salary[i];
		}
		return avg/Salary.length;
	}

	private static int getM1(int[] years, double[] salary) {
		
		int count = 0;
		for(int i = 0; i < salary.length; i ++){
			salary[i] = salary[i] * 1000000;
			salary[i] = salary[i] / years[i];
			if(salary[i] > 10000000)
				count++;
		}
		return count;
	}

}
