package Leetcode.生命游戏289;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 注意点：
 * 不能边遍历原数组边修改原数组，会导致后面的细胞判断错误
 * 需要判断边界情况
 *
 * 2种解法
 * 1. 拷贝新数组，原数组用于判断，新数组用于更新
 * 2. 用其他状态来更新数组，状态可以用来判断原细胞状态和更新后细胞状态
 *
 * 针对解法2，一共四种状态变换，可以各显神通
 * 1. 新增2个数值-1 2 表示原来活着后面死了，以及原来死的后面活了状态，0表示原来死的后面还是死的， 1表示原来活着后面还是活着
 * 状态  0： 00 ，死的，下一轮还是死的
 * 状态 -1： 01，活的，下一轮死了
 * 状态  2： 10，死的，下一轮活了
 * 状态  1： 11，活的，下一轮继续活着
 *
 * 2. 用0表示死，1表示活， 0和1的二进制组合，可以很好的表示原来和当前的状态，高位表示原来状态，低位表示现在状态。自然形成0 1 2 3 四种状态；更新原数组后，再通过右移1位的方式🔛更新一次数组即可得到最终结果
 * 状态 0： 00 ，死的，下一轮还是死的
 * 状态 1： 01，活的，下一轮死了
 * 状态 2： 10，死的，下一轮活了
 * 状态 3： 11，活的，下一轮继续活着
 *
 *
 *
 */

public class GameOfLife {

    public static int countAlive(int i, int j, int[][] board) {
        int res = 0;
        int[] neighbors = {0, -1, 1};

        System.out.println("countAlive[" + i +", " + j + "] = ");
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (k == 0 && l == 0) {
                    continue;
                }
                int m = i + neighbors[k];
                int n = j + neighbors[l];
                if (m >= 0 && m < board.length && n >=0 && n < board[0].length) {
                    System.out.println("board[" + m +", " + n + "] = " + (board[m][n] & 1));
                    res = res + (board[m][n] & 1);
                }
            }
        }
        System.out.println("countAlive[" + i +", " + j + "] = " + res);
        return res;

    }

    // 第2种解法中第2种实现
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 int count = countAlive(i, j, board);
                 System.out.println("[" + i +", " + j + "] = " + count);
                 // 状态0 和 状态1 不需要更新数组的值
                 if (board[i][j] == 0 && count == 3) {
                     board[i][j] = 2;
                 }
                 else if (board[i][j] == 1 && count >=2 && count <= 3) {
                     board[i][j] = 3;
                 }
             }
         }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
                //System.out.print(board[i][j] + " ");
            }
            //System.out.println();
        }
    }


    public static void main(String[] args) {
        int board[][] = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife life = new GameOfLife();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(life.countAlive(i, j, board));
            }
            System.out.println();
        }

        life.gameOfLife(board);
    }


}
