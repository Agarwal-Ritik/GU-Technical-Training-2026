// Time complexity = O(m) where m -> size of matrix [actual calculation function]
//                   O(m*n) where m -> size of matrix and n -> size of row of matrix [for whole program] 
// Space complexity = O(n) where n -> size of ans array

import java.util.Scanner;
public class NumMatrix {
    
    public int[][] matrix;

    public NumMatrix(int[][] matrix){
        // taking prefix sum of each row of matrix
        for(int i=0; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        // initializing the data member
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        int sum = 0;

        for(int i=row1; i<row2; i++){
            int excludingValue = 0;
            if(col1!=0){
                excludingValue = matrix[i][col1-1];
            }
            sum+=(matrix[i][col2]-excludingValue);
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input array length: ");
        int inputLen = sc.nextInt();

        String inputArray[] = new String[inputLen];

        for(int i=0; i<inputLen; i++){
            inputArray[i] = sc.next();
        }

        System.out.print("Enter row of matrix: ");
        int m= sc.nextInt();

        System.out.print("Enter col of matrix: ");
        int n = sc.nextInt();

        int matrix[][] = new int[m][n];
        System.out.print("Enter elements of matix: ");
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int ans[] = new int[inputLen-1];

        // instanciating class object
        NumMatrix numMatrix = new NumMatrix(matrix);

        for(int i=0; i<inputArray.length; i++){
            System.out.print("Enter range for sum: ");
            int row1 = sc.nextInt();
            int row2 = sc.nextInt();
            int col1 = sc.nextInt();
            int col2 = sc.nextInt();
            ans[i] = numMatrix.sumRegion(row1, col1, row2, col2);
        }
        sc.close();

        // printing output
        for(int i:ans){
            System.out.print(i + " ");
        }
    }
}