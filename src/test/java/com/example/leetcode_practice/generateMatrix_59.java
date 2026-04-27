/**
 * 59. 螺旋矩阵 II
 *
 * 给你一个正整数 n，生成一个包含 1 到 n^2 所有元素的 n x n 矩阵，
 * 并按照顺时针螺旋顺序填充。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：
 * [
 *  [1,2,3],
 *  [8,9,4],
 *  [7,6,5]
 * ]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * - 1 <= n <= 20
 */
public static int[][] generateMatrix_59(int n) {
    int[][] result = new int[n][n];
    int x = 0,y = 0;
    int offset = 1;
    int loop = n/2;
    int num = 1;
    for(int i = 0;i < loop; i++){
        for(int j = i;j < n-i-offset;j++){
            result[i][j] = num++;
        }
        for(int j = i;j <n-i-offset;j++){
            result[j][n-i-offset] = num++;
        }
        for(int j = i;j <n-i-offset;j++){
            result[n-i-offset][n-j-offset] = num++;
        }
        for(int j = i;j <n-i-offset;j++){
            result[n-j-offset][i] = num++;
        }
    }
    if(n%2==1){
        result[n/2][n/2] = num;
    }
    return result;
}

public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println("-----");
}

public static void main(String[] args) {
    int[][] res1 = generateMatrix_59(1);
    printMatrix(res1);
    // 期望:
    // [1]

    int[][] res2 = generateMatrix_59(2);
    printMatrix(res2);
    // 期望:
    // [1,2]
    // [4,3]

    int[][] res3 = generateMatrix_59(3);
    printMatrix(res3);
    // 期望:
    // [1,2,3]
    // [8,9,4]
    // [7,6,5]

    int[][] res4 = generateMatrix_59(4);
    printMatrix(res4);
    // 期望:
    // [1,2,3,4]
    // [12,13,14,5]
    // [11,16,15,6]
    // [10,9,8,7]
}