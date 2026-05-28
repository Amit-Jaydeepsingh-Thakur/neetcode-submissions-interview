class Solution {
    public void solve(char[][] board) {
        int i = 0, j = 0, n = board.length, m = board[0].length;

        for (i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 1);
            }
        }

        for (i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if (board[n - 1][i] == 'O') {
                dfs(board, n - 1, i);
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
