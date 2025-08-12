package Day11;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    help(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    void help(char[][] grid, int si, int sj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(si, sj));
        grid[si][sj] = '0';
        int r = grid.length, c = grid[0].length;
        while (q.size() > 0) {
            Pair te = q.poll();
            int i = te.x;
            int j = te.y;
            if (isValid(r, c, i - 1, j) && grid[i - 1][j] == '1') {
                q.add(new Pair(i - 1, j));
                grid[i - 1][j] = '0';
            }
            if (isValid(r, c, i + 1, j) && grid[i + 1][j] == '1') {
                q.add(new Pair(i + 1, j));
                grid[i + 1][j] = '0';
            }
            if (isValid(r, c, i, j - 1) && grid[i][j - 1] == '1') {
                q.add(new Pair(i, j - 1));
                grid[i][j - 1] = '0';
            }
            if (isValid(r, c, i, j + 1) && grid[i][j + 1] == '1') {
                q.add(new Pair(i, j + 1));
                grid[i][j + 1] = '0';
            }
        }
    }

    boolean isValid(int r, int c, int i, int j) {
        return ((i >= 0 && i < r) && (j >= 0 && j < c));
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}