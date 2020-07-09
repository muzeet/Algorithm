package 剑指Offer.二维数组的查找;

/**
 * 题目：在一个二维数组中，每一行从左到右递增， 每一列从上到下递增。输入二维数组和一个整数，返回是否包含该整数
 *
 * 思路: 从二维数组的右上角开始比较:
 * 1. 该整数 < 右上角元素, 则去掉一列
 * 2. 该整数 > 右上角元素, 则去掉一行
 *
 */


public class FindInPartiallySortedMatrix {

    public boolean Find(int target, int [][] array) {
        boolean found = false;
        int rows = array.length;
        int cols = array[0].length;

        int row = 0;
        int col = cols - 1;
        while (col > 0 && row > 0) {
            int temp = array[row][col];
            if (temp == target) {
                found = true;
                break;
            }
            else if (temp < target) {
                row++;
            }
            else {
                col--;
            }
        }
        return found;
    }

}
