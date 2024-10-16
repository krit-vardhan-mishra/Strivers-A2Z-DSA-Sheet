
public class NoOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int j = 0; j < col; j++) {
            dfs(grid, 0, j);
            dfs(grid, row-1, j);
        }

        for (int i = 0; i < row; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, col-1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count += grid[i][j];
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}

/*
 class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        for(int i=0;i<rows;i++) {
            if(visited[i][0]==0 && grid[i][0]==1) {
                dfs(i,0,grid,visited);
            }

            if(visited[i][cols-1]==0 && grid[i][cols-1]==1) {
                dfs(i,cols-1,grid,visited);
            }
        }

        for(int i=0;i<cols;i++) {
            if(visited[0][i]==0 && grid[0][i]==1) {
                dfs(0,i,grid,visited);
            }

            if(visited[rows-1][i]==0 && grid[rows-1][i]==1) {
                dfs(rows-1,i,grid,visited);
            }
        }

        int count = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int row, int col, int[][] grid, int[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        visited[row][col]=1;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int i=0;i<4;i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            if(x>=0 && x<rows && y>=0 && y<cols && visited[x][y]==0 && grid[x][y]==1) {
                visited[x][y]=1;
                dfs(x,y,grid,visited);
            }
        }
    }
}
 */
