package arrays_and_strings;

import java.util.Scanner;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 * 
 * @author aearavindh
 *
 */
public class IsUnique {

	public static void main(String[] args) {
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
			System.out.println(s + " => " + isUniqueCharactersInString(s));
		}
		in.close();
	}
	
	/**
	 * Check whether the string has unique characters 
	 * [ 256 characters solution ]
	 * 
	 * Time Complexity => O(min(n, c)), n -> size, c -> character set size ( We can also say O(1) since the 
	 * loop will never iterate more than 256 (c) )
	 * Space Complexity => O(1)
	 * 
	 * @param s
	 * @return true or false
	 */
//	public static boolean isUniqueCharactersInString(final String s) {
//		long startTime = System.nanoTime();
//		if (s.length() > 256 ) return false;
//		boolean[] hash = new boolean[256];
//		for (int i = 0;i < s.length(); i++) {
//			int val = s.charAt(i);
//			if (hash[val]) {
//	            System.out.println("Time to process [ " + s + " ] is [ " + ( System.nanoTime() - startTime ) + " ]");
//				return false;
//			}
//			hash[val] = true;
//		}
//		System.out.println("Time to process [ " + s + " ] is [ " + ( System.nanoTime() - startTime ) + " ]");
//		return true;
//	}
	
	/**
	 * Check whether the string has unique characters
	 * [ 26 characters (a-z) solution]
	 * 
	 * Time Complexity => O(n), n -> size
	 * Space Complexity remains constant but it got reduced to 32 bit (integer) from 256 bit
	 * 
	 * @param s
	 * @return true or false
	 */
	public static boolean isUniqueCharactersInString(final String s) {
		long startTime = System.nanoTime();
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				System.out.println("Time to process [ " + s + " ] is [ " + ( System.nanoTime() - startTime ) + " ]");
				return false;
			}
			checker |= (1 << val);
		}
		System.out.println("Time to process [ " + s + " ] is [ " + ( System.nanoTime() - startTime ) + " ]");
		return true;
	}

}

