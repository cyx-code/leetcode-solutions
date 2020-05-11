package cyx.solution.leetcode.pic;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {
    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'},
        };
        System.out.println(numIslands.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int islands_nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 在发现岛屿时进入深度优先遍历
                if (grid[i][j] == '1') {
                    // 岛屿数加一
                    islands_nums++;
                    dfs(grid, i, j);
                }
            }
        }
        for (char[] chars : grid) {
            System.out.println(Arrays.toString(chars));
        }
        return islands_nums;
    }

    /**
     * 深度优先遍历
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        // 防止数组越界，并且在没有"岛屿"时返回
        if (i < 0 || j < 0 || i > row - 1 || j > col - 1 || grid[i][j] != '1') {
            return;
        }
        // 将已经发现的1置为2，防止重复遍历
        grid[i][j] = '2';
        // 遍历
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }

    private int bfs(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        boolean[][] marked = new boolean[row][col];
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    marked[i][j] = true;
                    deque.add(grid[i][j]);
                }
            }
        }
        return 0;
    }
}
