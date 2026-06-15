class Solution {
    public void solve(char[][] board) {
        int i = 0, j = 0, r = board.length, c = board[0].length;

        for (i = 0; i < r; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
        }
        
        for (i = 0; i < r; i++) {
            if (board[i][c - 1] == 'O') {
                dfs(i, c - 1, board);
            }
        }

        for (i = 0; i < c; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
        }
        
        for (i = 0; i < c; i++) {
            if (board[r - 1][i] == 'O') {
                dfs(r - 1, i, board);
            }
        }

        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O'; 
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
