import java.util.HashSet;

public class dsa25 {

     /*
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
     *  return the number of islands.

     An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
      You may assume all four edges of the grid are all surrounded by water.

        Input: grid = {  {1,1,1,1,0},
                         {1,1,0,1,0}, 
                         {1,1,0,0,0}, 
                         {0,0,0,0,0} } 
        Output: 1
     */
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,1,1,0},
            {1,1,0,0,0}, 
            {1,1,0,1,0}, 
            {0,0,0,0,0}
        };

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited.contains(i + "," + j)) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println("Number of islands: " + count);
    }

    static void dfs(int[][] grid, int i, int j, HashSet<String> visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        // boundary check
        if (i < 0 || i >= rows || j < 0 || j >= cols) return;
        if (grid[i][j] == 0) return;

        String key = i + "," + j;
        if (visited.contains(key)) return;

        visited.add(key);

        // Explore up, down, left, right (no diagonals)
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }
}
