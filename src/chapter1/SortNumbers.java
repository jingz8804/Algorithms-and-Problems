package chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class SortNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,0,2,4,3,5,6,7};
		System.out.println("Before sorting: " + Arrays.toString(numbers));
		int[] sortedByInsertion = insertionSort(numbers);
		System.out.println("After sorting: " + Arrays.toString(sortedByInsertion));
		int[] sortedByMerge = mergeSort(numbers, 0, numbers.length - 1);
		System.out.println("After sorting: " + Arrays.toString(sortedByMerge));
	}
	
	private static int[] insertionSort(int[] numbers){
		int numLen = numbers.length;
		if(numLen == 0) {
			return null;
		}
		// create an arraylist to store the current sorted numbers
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		// initialize the arraylist by adding the first element of numbers (pick the first card)
		sorted.add(numbers[0]);
		for (int i = 1; i < numLen; i++){
			//pick the next card
			int current = numbers[i];
			compareAndPosition(sorted, current);
		}
		int[] sortedArray = new int[numLen];
		for(int i = 0; i < numLen; i++){
			sortedArray[i] = sorted.get(i);
		}
		return sortedArray;
	}

	private static void compareAndPosition(ArrayList<Integer> sorted,
			int current) {
		for(int i = 0; i < sorted.size(); i++){
			if (current < sorted.get(i)){
				// insert at i and break
				sorted.add(i, current);
				return;
			}
		}
		// if the new number is larger than all the numbers in the former sorted list
		// we should add it to the end.
		sorted.add(current);
	}
	
	private static int[] mergeSort(int[] numbers, int start, int end){
		/**
		 * Well if we are really subsetting the array (creating subarray every time), it would cost too mush resources.
		 * A better way is just to keep track of the index of the subarray you are considering.
		 * So a subarray is denoted by the original array, a start point and an end point.
		 */
		if (numbers.length == 0) return null;
		if (start == end){
			// if there is only one element, we just return it.
			// and this element can be accessed by numbers[start]
			int[] res = {numbers[start]};
			return res;
		}
		int[] sortedSubset1 = mergeSort(numbers, start, (start + end)/2);
		int[] sortedSubset2 = mergeSort(numbers, (start + end)/2 + 1, end);
		return merge(sortedSubset1, sortedSubset2);
	}

	private static int[] merge(int[] sortedSubset1, int[] sortedSubset2) {
		int len1 = sortedSubset1.length;
		int len2 = sortedSubset2.length;
		int[] sorted = new int[len1 + len2];
		int k = 0; //index for sorted
		int current1 = 0;
		int current2 = 0; // current index of each sortedSubset
		while (current1 < len1 && current2 < len2){
			if (sortedSubset1[current1] < sortedSubset2[current2]){
				// put the element of subset 1 into sorted
				sorted[k] = sortedSubset1[current1];
				current1++;
			}else{
				// put the element of subset 2 into sorted
				sorted[k] = sortedSubset2[current2];
				current2++;
			}
			k++;
		}
		if (current1 == len1){
			// subset 2 has more elements
			while(current2 < len2){
				sorted[k] = sortedSubset2[current2];
				current2++;
				k++;
			}
		}else{
			// subset 1 has more elements
			while(current1 < len1){
				sorted[k] = sortedSubset1[current1];
				current1++;
				k++;
			}
		}
		return sorted;
	}
}
