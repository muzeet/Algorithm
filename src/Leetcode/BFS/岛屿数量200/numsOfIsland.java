package Leetcode.BFS.岛屿数量200;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 *
 *  思路:
 *  1. 深度优先搜索
 *  2. 广度优先搜索
 *
 *
 */

public class numsOfIsland {

    public void dfs(char[][] grid, int i, int j) {
        if (grid == null || grid.length == 0) {
            return;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }

    /**
     *
     * 我们可以将二维网格看成一个无向图，竖直或水平相邻的 11 之间有边相连。
     *
     * 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 11，则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的 11 都会被重新标记为 00。
     *
     * 最终岛屿的数量就是我们进行深度优先搜索的次数。
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int nums = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs(grid, i, j);
                }
            }
        }
        return nums;
    }

    /**
     * 同样地，我们也可以使用广度优先搜索代替深度优先搜索。
     *
     * 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 11，则将其加入队列，开始进行广度优先搜索。在广度优先搜索的过程中，每个搜索到的 11 都会被重新标记为 00。直到队列为空，搜索结束。
     *
     * 最终岛屿的数量就是我们进行广度优先搜索的次数。
     *
     *
     */
     public int numIslands2(char[][] grid) {
        // 广度优先搜索用队列
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int nums = 0;
        for (int i  = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    grid[i][j] = '0';
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.add(i * col + j);
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int c = cur % col;
                        int r = cur / col;
                        // [r, c - 1]
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            queue.addLast(r * col + (c - 1));
                            grid[r][c - 1] = '0';
                        }
                        // [r, c + 1]
                        if (c + 1 < col && grid[r][c + 1] == '1') {
                            queue.addLast(r * col + (c + 1));
                            grid[r][c + 1] = '0';
                        }
                        // [r - 1, c]
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            queue.addLast((r - 1) * col + c);
                            grid[r - 1][c] = '0';
                        }
                        // [r + 1, c]
                        if (r + 1 < row && grid[r + 1][c] == '1') {
                            queue.addLast((r + 1) * col + c);
                            grid[r + 1][c] = '0';
                        }
                    }
                }
            }
        }
        return nums;
     }
}
