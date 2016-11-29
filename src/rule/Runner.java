package rule;

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Enter any string: ");
		String x = sn.nextLine();
		
		Rules r = new Rules();
		
		if (r.checkVowelFinalConsonant(x) || r.checkVowelForceFinalLetter(x)) {
			System.out.println("Dung chinh ta");
		} else {
			System.out.println("Sai chinh ta");
		}
		
		sn.close();
	}
	
}
