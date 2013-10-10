package careerCup;

import java.util.Arrays;

/**
 * Rotate a n by n matrix 90 degrees (clock-wise) and do it in place.
 * @author JING
 *
 */
public class RotateMatrix {

	public static void main(String[] args) {
		int[][] test1 = {{1,2,3}, {4,1,7}, {9,5,1}};
		printMatrix(test1);
		rotate(test1);
		System.out.println("==========================");
		printMatrix(test1);
		
		System.out.println();
		
		int[][] test2 = {{1,2,3,4}, {4,1,7,6}, {9,5,1,0}, {19,15,11,10}};
		printMatrix(test2);
		rotate(test2);
		System.out.println("==========================");
		printMatrix(test2);
	}
	
	private static void printMatrix(int[][] matrix){
		int size = matrix.length;
		for (int i = 0; i < size; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	
	public static void rotate(int[][] matrix){
	/*
	 * Well, I cannot get the right formula to switch values in a matrix 
	 * when rotating 90 degrees in one step. But I figured that I could do
	 * it in two steps.
	 * 
	 * Step 1: switch the elements across the diagonal (from upper left to bottom right) 
	 */
		int size = matrix.length;
		for (int i = 0; i < size; i++){
			for (int j = 0; j < i; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
	/*
	 * Step 2: Do a mirror switch across the central column of the matrix 
	 */
		int middle = size / 2;
		for (int i = 0; i < size; i++){
			for (int j = 0; j < middle; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][size - 1 - j];
				matrix[i][size - 1 - j] = temp;
			}
		}
	}

}
