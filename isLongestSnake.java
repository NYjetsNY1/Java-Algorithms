import java.util.Random;

public class isLongestSnake {
	
	// Find the longest snake using an N x N matrix in ascending order.
	// Example: 
	// 0, 1, 2, 4
	// 1, 2, 3, 5
	// 9, 5, 1, 7
	// The longest snake in ascending order would be: 4.
	// 0 at location matrix[0][0]
	// 1 at location matrix[1][0]
	// 2 at location matrix[1][1]
	// 3 at location matrix[1][2]
	public static int longestSnake(int [][] matrix, int n) {
		// Keep track of each run as well as the longest run.
		int counter = 0;
		int maxcounter = 0;
		
		// Iterate through the entire matrix.
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				
				// Series of if statements to increment a counter and then call
				// the recursive helper method to determine how long the run was.
				
				// If you should proceed to the left.
				if (i != 0 && ((matrix[i][j] + 1)  == matrix[i-1][j])) {
					++counter;
					counter += recursivePart(matrix, n, i-1, j);
					
				}
				
				// If you should proceed to the right.
				if ((i != (n - 1)) && (matrix[i][j] + 1) == matrix[i+1][j]) {
					++counter;
					counter += recursivePart(matrix, n, i+1, j);
					
				}
				
				// If you should proceed down.
				if ((j != 0) && (matrix[i][j] + 1) == matrix[i][j-1]) {
					++counter;
					counter += recursivePart(matrix, n, i, j-1);
					
				}
				
				// If you should proceed up.
				if ((j != (n - 1)) && (matrix[i][j] + 1) == matrix[i][j+1]) {
					++counter;
					counter += recursivePart(matrix, n, i, j+1);
					
				}
				
				// If the counter was greater then the current maxcounter,
				// then assign the maxcounter to the counter.
				if (counter > maxcounter) {
					maxcounter = counter;
				}
				// Reset the counter after the run to do a new run.
				counter = 0;
			}
		}
		// You are not counting the last number in the snake,
		// so add one to the snake's length.
		return maxcounter + 1;
	};

	// Helper method for the longestSnake method.
	private static int recursivePart(int[][] matrix, int n, int i, int j) {
		// Keep track of each run as well as the longest run.
		int counter = 0;
		int maxcounter = 0;
		
		// Each if statement has similar logic:
		// The longest run is be set to the maxcounter,
		// then the original counter can then be reset.
		
			if (i != 0 && ((matrix[i][j] + 1) == matrix[i-1][j])) {
				++counter;
				counter += recursivePart(matrix, n, i-1, j);
				if (counter > maxcounter) {
					maxcounter = counter;
				}
				counter = 0;
			}
			
			if ((i != (n - 1)) && (matrix[i][j] + 1) == matrix[i+1][j]) {
				++counter;
				counter += recursivePart(matrix, n, i+1, j);
				if (counter > maxcounter) {
					maxcounter = counter;
				}
				counter = 0;
				
			}
			
			if ((j != 0) && (matrix[i][j] + 1) == matrix[i][j-1]) {
				++counter;
				counter += recursivePart(matrix, n, i, j-1);
				if (counter > maxcounter) {
					maxcounter = counter;
				}
				counter = 0;
			}
			
			if ((j != (n - 1)) && (matrix[i][j] + 1) == matrix[i][j+1]) {
				++counter;
				counter += recursivePart(matrix, n, i, j+1);	
				if (counter > maxcounter) {
					maxcounter = counter;
				}
				counter = 0;
			}
			return maxcounter;
	}

	// def main()
	public static void main(String[] args) {
		
		// Arbitrary matrix.
		// Feel free to change and put whatever you want in it for testing
		// or whatever else you want.
		int matrix[][]={{99, 1, 2, 3, 5, 3},
				{7, 6, 5, 0, 5, 6},
				{8, 5, 4, 1, 5, 3},
				{8, 6, 3, 2, 5, 3},
				{8, 7, 8, 9, 10, 11},
				{9, 8, 11, 11, 13, 12}};
		
		int the_longest_snake = 0;
		// Length of N x N 
		int n = 6;
		int[][] randomMatrix = new int [n][n];

		// Create a randomMatrix from 0-10
		Random randomM = new Random(); 
		randomM.setSeed(System.currentTimeMillis());
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int rand = randomM.nextInt() % 11; 
				randomMatrix[i][j] = Math.abs(rand);
			}
		}
		for (int i = 0; i < n; ++i) {  
			System.out.print("[");   
			for (int j = 0; j < n; ++j) {
				System.out.print(randomMatrix[i][j]);
				if (j != (n - 1)) {
					System.out.print(", ");
				}
			} 
			System.out.println("]");
		}
		// Testing the algorithm
		the_longest_snake = longestSnake(randomMatrix, n);
		// Finally printing the value.
		System.out.println("The longest snake in the matrix is: " + the_longest_snake);
	}
}
