package rule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Runner {

	public static void main(String[] args) {

		File dir = new File("C:\\Users\\ginks\\workspace\\CheckGrammar\\src\\data\\");
		String all = "";

		for (File file : dir.listFiles()) {
			all += readFile(file);
		}

		String[] arr = all.split(" ");
		Rule r = new Rule();

		Writer writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
		              new FileOutputStream("C:\\Users\\ginks\\workspace\\CheckGrammar\\src\\rule\\result.txt"), "utf-8"));
			for (int i = 0; i < arr.length; i++) {
				if (!r.checkVowelTotal(arr[i])) {
					writer.write(arr[i] + " ");
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFile(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			String everything = sb.toString();
			everything = removeSymbol(everything);
			br.close();
			return everything;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String removeSymbol(String x) {
		String str = x;
		str = str.replaceAll(",", " ");
		str = str.replaceAll(":", " ");
		str = str.replaceAll("!", " ");
		str = str.replaceAll("\\?", " ");
		str = str.replaceAll("\\.", " ");
		str = str.replaceAll("\"", " ");
		return str;
	}

}
