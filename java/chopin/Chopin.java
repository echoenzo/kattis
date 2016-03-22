/** Solution for kattis problem
 * @author: echoenzo
 */
import java.io.*;
import java.util.*;

public class Chopin {

    Kattio io;
    Kattio debug;
    int i = 0, j = 0;

    void solve() {
        /**************START**************/

        String key;
        String tonality;
        i = 1;
        while (io.hasMoreTokens()) {
            key = io.nextToken();
            tonality = io.nextToken();

            char letter;
            char flatsharp;
            letter = key.charAt(0);
            if (key.length() == 1) flatsharp = ' ';
            else flatsharp = key.charAt(1);
            int n = toInt(letter, flatsharp);

            String res = "";
            switch (n) {
                case 1:
                case 3:
                case 4:
                case 6:
                case 8:
                case 9:
                case 11:
                    res = "UNIQUE";
                    break;
                case 2:
                    if (letter == 'A') res = "Bb " + tonality;
                    else res = "A# " + tonality;
                    break;
                case 5:
                    if (letter == 'C') res = "Db " + tonality;
                    else res = "C# " + tonality;
                    break;
                case 7:
                    if (letter == 'D') res = "Eb " + tonality;
                    else res = "D# " + tonality;
                    break;
                case 10:
                    if (letter == 'F') res = "Gb " + tonality;
                    else res = "F# " + tonality;
                    break;
                case 12:
                    if (letter == 'G') res = "Ab " + tonality;
                    else res = "G# " + tonality;
                    break;
                default:
                    res = "oops";
            }
            io.println("Case " + i + ": " + res);
            i++;
        }

        /***************END***************/
    }

    int toInt(char letter, char flatsharp) {
        boolean flat = false;
        boolean sharp = false;
        switch(flatsharp) {
            case 'b': flat = true; break;
            case '#': sharp = true; break;
            default:
        }
        int n;
        switch(letter) {
            case 'A': n = 1; break;
            case 'B': n = 3; break;
            case 'C': n = 4; break;
            case 'D': n = 6; break;
            case 'E': n = 8; break;
            case 'F': n = 9; break;
            case 'G': n = 11; break;
            default: return -1;
        }
        if (sharp) n++;
        else if (flat) n--;
        if (n == 0) n = 12;
        if (n == 13) n = 1;
        return n;
    }

    public static void main(String[] args) {
        new Chopin().runIO();
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
