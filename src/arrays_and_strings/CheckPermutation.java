package arrays_and_strings;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPermutation {
	public static void main(String[] args) {
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		while (t-- > 0) {
			String s1 = in.next();
			String s2 = in.next();
			System.out.println(s1 + ", " + s2 + " => " + checkPermutation(s1, s2));
		}
		in.close();
	}

	/**
	 * Readable but inefficient solution
	 * @param s1
	 * @param s2
	 * @return
	 */
//	private static boolean checkPermutation(String s1, String s2)
//	{
//		if (s1.length() != s2.length()) {
//			return false;
//		}
//		return sort(s1).equals(sort(s2));
//	}
//
//	private static String sort(String s) {
//		char[] content = s.toCharArray();
//		Arrays.sort(content);
//		return String.valueOf(content);
//	}

	/**
	 * In case of permutation, both the strings should have same character count
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean checkPermutation(String s1, String s2)
	{
		if (s1.length() != s2.length())
			return false;
		int hash[] = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			hash[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			hash[s2.charAt(i)]--;
			if (hash[s2.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}
}
