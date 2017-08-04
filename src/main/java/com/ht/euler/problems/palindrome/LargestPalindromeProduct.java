package com.ht.euler.problems.palindrome;

import org.junit.Assert;
import org.junit.Test;

public class LargestPalindromeProduct {

	/**
	 * https://projecteuler.net/problem=4
	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	Find the largest palindrome made from the product of two 3-digit numbers.
	Time Complexity : O(n^2)
	 **/
	public long letLargestProductOfThreeDigitNumber(){
		int MIN = 100;
		int MAX = 999;
		long largestPalindrome =0;
		for (int index =MIN ; index < MAX ; ++index) {
			for (int innerIndex = index ;innerIndex < MAX; ++innerIndex) {
				long product = index * innerIndex;
				if (isPallindrome (product))  {
					if (product> largestPalindrome )  largestPalindrome = product;
				}
			}
		}
		return largestPalindrome;
	}
	
	/** We could reverse string but this is another way to use front and back index.*/
	public boolean isPallindrome (long product) {
		String productStr =product+ "";
		int frontP = 0;
		int backP = productStr.length()-1;
		boolean pallindrome = true;
		while (pallindrome && frontP<=backP) {
			if (productStr.charAt(frontP) != productStr.charAt(backP))  pallindrome = false;
			++frontP;
			--backP;
		}
		return pallindrome;
		
	}
	
	
	@Test
	public void testLargestPallindrome(){
		
		Assert.assertEquals(906609, letLargestProductOfThreeDigitNumber());
		 
	}
	
}
