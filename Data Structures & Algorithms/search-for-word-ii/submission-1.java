class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int i = 0, j = 0;
        List<String> res = new ArrayList<>();

        for (String word : words) {
            for (i = 0; i < board.length; i++) {
                for (j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean ans = solve(0, i, j, word, board);

                        //System.out.println("Outide" +  " " + word);

                        if (ans && !res.contains(word)) {
                            //System.out.println("Inside" +  " " + word);
                            res.add(word);
                        }
                    }
                }
            }
        }

        return res;
    }

    private boolean solve(int idx, int i, int j, String word, char[][] board) {
        
        if (idx >= word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length 
            || j >= board[0].length || board[i][j] == '*' 
            || idx >= word.length() || board[i][j] != word.charAt(idx)) {
                return false;
            }

        char org = board[i][j];

        board[i][j] = '*';

        boolean ans = solve(idx + 1, i + 1, j, word, board)
                        || solve(idx + 1, i - 1, j, word, board)
                        || solve(idx + 1, i, j + 1, word, board)
                        || solve(idx + 1, i, j - 1, word, board);
        
        board[i][j] = org;

        return ans;
    }
}
