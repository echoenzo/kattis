/** Solution for kattis problem
 * @author: echoenzo
 */
import java.io.*;
import java.util.*;

public class Vauvau {

    Kattio io;
    Kattio debug;
    int i = 0, j = 0;
    int A, B, C, D;

    void solve() {
        /**************START**************/

        A = io.getInt();
        B = io.getInt();
        C = io.getInt();
        D = io.getInt();

        int P = io.getInt();
        int M = io.getInt();
        int G = io.getInt();

        printNumDogs(numDogs(P));
        printNumDogs(numDogs(M));
        printNumDogs(numDogs(G));

        /***************END***************/
    }

    int numDogs(int time) {
        int numDogs = 2;
        int a = A;
        int b = B;
        int c = C;
        int d = D;
        for (i = 1; i < time; i++) {
            if (a > 0) {
                a--;
                if (a == 0) numDogs--;
            }
            else if (b > 0) {
                b--;
                if (b == 0) {
                    numDogs++;
                    a = A;
                    b = B;
                }
            }
            if (c > 0) {
                c--;
                if (c == 0) numDogs--;
            }
            else if (d > 0) {
                d--;
                if (d == 0) {
                    numDogs++;
                    c = C;
                    d = D;
                }
            }
        }
        return numDogs;
    }

    void printNumDogs(int n) {
        switch (n) {
            case 2:
                io.println("both");
                break;
            case 1:
                io.println("one");
                break;
            case 0:
                io.println("none");
                break;
            default:
        }
    }

    public static void main(String[] args) {
        new Vauvau().runIO();
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

        // returns a character grid of the next lines of input, until EOF or empty line.
        public char[][] getCharGrid() {
            ArrayList<char[]> lines = new ArrayList<char[]>();
            String ans = nextLine();
            if (ans == null) return null;
            while (ans != null && ans.length() > 0) {
                lines.add(ans.toCharArray());
                ans = nextLine();
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

        public String nextLine() {
            st = null;
            String s = null;
            try {
                s = r.readLine();
            } catch (IOException e) { e.printStackTrace(); }
            return s;
        }

    }

}
