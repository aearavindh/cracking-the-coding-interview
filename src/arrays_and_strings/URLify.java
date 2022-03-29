package arrays_and_strings;

import java.util.Scanner;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"
 * 
 * @author aearavindh
 *
 */
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

