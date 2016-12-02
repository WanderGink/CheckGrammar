package rule;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean mark = true;
		Scanner sn = new Scanner(System.in);
		while (mark) {
			System.out.println("Enter any string: ");
			String x = sn.next();
			
			if (x.equals("close")) {
				mark = false;
			}
			Rule r = new Rule();
			if (r.checkVowelTotal(x)) {
				System.out.println("Đúng chính tả");
			} else {
				System.out.println("Sai chính tả");
			}
		}
		sn.close();
	}
}
