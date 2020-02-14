package com;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: secondQuestion : The program need to support converting the digits from 0 to 99 into letters
 * @author: LiangXing
 * @create: 2019-2-13 19:36
 */
@SpringBootTest
public class SecondMiniCodeTest {

	

	/**
	 * secondQuestion : The program need to support converting the digits from 0 to 99 into letters
	 */
	@Test
	public void secondQuestion() {
		Integer[] arr = { 2, 35};
		ArrayList<String> res = SecondMiniCodeTest.letterCombinations(arr);
		System.out.println(res);

	}

	
	static ArrayList<String> res = new ArrayList<>();
	static String temp = "";

	static ArrayList<String> letterCombinations(Integer[] digits) {
		if (digits.length == 0 || digits == null) {
			res.add("");
			return res;
		}
		// put the number and letters into a map
		HashMap<Integer, String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		res = combine(digits, 0, map);
		return res;
	}

	// Backtracking
	public static ArrayList<String> combine(Integer[] digits, int start, HashMap<Integer, String> map) {
		if (start == digits.length) {
			res.add(temp);
			return res;
		}

		Integer key = digits[start];

		// secondQuestion : The program need to support converting the digits from 0 to
		// 99 into letters
		if (key > 10) {
			String firstValue = map.get(key / 10);
			String secondValue = map.get(key % 10);
			String finaleValue = firstValue + secondValue;
			map.put(key, finaleValue);
		}
		String str = map.get(key);
		for (int i = 0; i < str.length(); i++) {
			// Splicing letters
			temp = temp + str.charAt(i);
			// start+1,still get the first letter and Splicing it 
			combine(digits, start + 1, map);
			// remove the last letter and Splicing the new one  
			temp = temp.substring(0, temp.length() - 1);
		}

		return res;
	}



}
