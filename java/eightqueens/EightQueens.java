/** Solution for kattis problem
 * @author: echoenzo
 */
import java.io.*;
import java.util.*;

public class EightQueens {

    Kattio io;
    Kattio debug;
    int i = 0, j = 0;

    char[][] board;

    void solve() {
        /**************START**************/

        board = io.getCharGrid();
        int numQueens = 0;
        boolean isValid = true;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                if (board[i][j] == '*') {
                    numQueens++;
                    for (int a = 0; a < 8; a++) {
                        if (a != j && board[i][a] == '*') isValid = false;
                        else if (a != i && board[a][j] == '*') isValid = false;
                        else if (a > 0) {
                            if (i+a < 8 && j+a < 8 && board[i+a][j+a] == '*') isValid = false;
                            else if (i-a >=0 && j-a >=0 && board[i-a][j-a] == '*') isValid = false;
                            else if (i+a < 8 && j-a >=0 && board[i+a][j-a] == '*') isValid = false;
                            else if (i-a >=0 && j+a < 8 && board[i-a][j+a] == '*') isValid = false;
                        }
                        if (!isValid) break;
                    }
                }
                if (!isValid) break;
            }
            if (!isValid) break;
        }
        if (numQueens != 8) isValid = false;

        if (isValid) io.println("valid");
        else io.println("invalid");

        /***************END***************/
    }

    public static void main(String[] args) {
        new EightQueens().runIO();
    }

    void runIO() {
        io = new Kattio(System.in, System.out);
        debug = new Kattio(System.in, System.err);
        solve();
        io.close();
        debug.close();
    }

    /** Simple yet moderately fast I/O routines.
     * @author: Kattis
     */
    class Kattio extends PrintWriter {

        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        public char[][] getCharGrid() {
            ArrayList<char[]> lines = new ArrayList<char[]>();
            String ans = peekToken();
            token = null;
            if (ans == null) return null;
            while (ans != null && ans.length() > 0) {
                lines.add(ans.toCharArray());
                ans = peekToken();
                token = null;
            }
            char[][] grid = new char[lines.size()][];
            for (int row = 0; row < grid.length; row++) {
                grid[row] = lines.get(row);
            }
            return grid;
        }

        public void printGrid(char[][] g) {
            for (int a = 0; a < g.length; a++) {
                println(new String(g[a]));
            }
        }

        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null) try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { e.printStackTrace(); }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }

    }
}
