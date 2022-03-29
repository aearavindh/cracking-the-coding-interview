package arrays_and_strings;

import java.util.Scanner;

public class URLify {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("URLify");
		String s = in.nextLine();
		System.out.println(s + " => " + urlify(s));
		in.close();
	}

	/**
	 * URLify a string
	 * 
	 * @param s
	 * @return
	 */
	private static String urlify(String s) {
		char[] out = s.toCharArray();
		int trueLength = s.trim().length();
		int spaceCount = 0, index, i;
		for (i = 0; i < trueLength; i++) {
			if (out[i] == 32) {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < out.length)
			out[trueLength] = '\0';
		System.out.println("******" + out[trueLength]);
		for (i = trueLength - 1; i >= 0; i--) {
			if (out[i] == 32) {
				out[index - 1] = '0';
				out[index - 2] = '2';
				out[index - 3] = '%';
				index = index - 3;
			} else {
				out[index - 1] = out[i];
				index--;
			}
		}
		return String.valueOf(out);
	}

}

