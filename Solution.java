package com.kunalbadade.SortHashMapbyKeyandValue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {
  
	public static void main(String[] argv) {
 
		 int[] arr = new int[] {5,3,1,2,2,4};

		Map<Integer, Integer> InputHM = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {

			if(!InputHM.containsKey(arr[i])) {
				InputHM.putIfAbsent(arr[i], 1);

			}else {

				InputHM.put(arr[i],(InputHM.get(arr[i])+1));
			}
		}

 
		Map<Integer, Integer> key = SortByKey(InputHM);
		//DisplayHashMap(key);
 
		Map<Integer, Integer> value = SortByValue(InputHM);
		DisplayHashMap(value);
 
	}
 
 
	// To iterate through HashMap
	private static void DisplayHashMap(Map<Integer, Integer> InputHM) {
		InputHM.forEach((k, v) -> {
			while(v>0) {
				System.out.print(" "+k);
				v--;
			}
		});
 
	}
 
	// Sort HashMap by Key by extending key with comparable interface
	public static <K extends Comparable<? super K>, V> Map<K, V> SortByKey(Map<K, V> InputHM) {
 
		Map<K, V> ResultLHM = new LinkedHashMap<>();
		Stream<Map.Entry<K, V>> sequentialStream = InputHM.entrySet().stream();
 
		// comparingByKey() returns a comparator that compares Map.Entry in natural order on key.
		sequentialStream.sorted(Map.Entry.comparingByKey()).forEachOrdered(c -> ResultLHM.put(c.getKey(), c.getValue()));
		return ResultLHM;
	}
 
	// Sort HashMap by Value by extending value with comparable interface
	public static <K, V extends Comparable<? super V>> Map<K, V> SortByValue(Map<K, V> InputHM) {
 
		Map<K, V> ResultLHM = new LinkedHashMap<>();
		Stream<Map.Entry<K, V>> sequentialStream = InputHM.entrySet().stream();
 
		// comparingByValue() returns a comparator that compares Map.Entry in natural order on value.
		sequentialStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> ResultLHM.put(c.getKey(), c.getValue()));
		return ResultLHM;
	}
 
}