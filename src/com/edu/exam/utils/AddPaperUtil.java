package com.edu.exam.utils;

import java.util.HashSet;
import java.util.List;

public class AddPaperUtil {
	public static HashSet<Integer> getranadom(int n, List<Integer> list) {
		int max = list.size();
		HashSet<Integer> set = new HashSet<>();
		int setSize = 0;
		while (setSize < n) {
			int num = (int) (Math.random() * max);
			set.add(list.get(num));
			setSize = set.size();
		}
		return set;
	}
}
