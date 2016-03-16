// Template Author: Michael-G-Sullivan
// Author: echoenzo
import java.io.*;
import java.util.*;

public class Peg {

    FastScanner in;
    PrintWriter out;
    int i = 0, j = 0;

    void solve() {
        /**************START**************/

        char[][] grid = in.getCharGrid();
        int n = grid.length;
        int m = grid[0].length;
        int a = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                switch(grid[i][j]) {
                    case '.':
                        if (i > 1 && grid[i-1][j] == 'o' && grid[i-2][j] == 'o') a++;
                        if (i < n-2 && grid[i+1][j] == 'o' && grid[i+2][j] == 'o') a++;
                        if (j > 1 && grid[i][j-1] == 'o' && grid[i][j-2] == 'o') a++;
                        if (j < m-2 && grid[i][j+1] == 'o' && grid[i][j+2] == 'o') a++;
                        break;
                    default:
                        break;
                }
            }
        }
        out.println(a);

        /***************END***************/
    }

    public static void main(String[] args) {
        new Peg().runIO();
    }

    void runIO() {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    void printGrid(char[][] g) {
        for (int a = 0; a < g.length; a++) {
            out.println(new String(g[a]));
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        //This will empty out the current line (if non-empty) and return the next line down. If the next line is empty, will return the empty string.
        //If there is no more input, this will return null.
        String nextLine() {
            st = null;
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        double[] getDoubleArray(int s) {
            double[] arr = new double[s];
            for (int d = 0; d < s; d++) {
                arr[d] = in.nextDouble();
            }
            return arr;
        }

        int[] getIntArray(int s) {
            int[] arr = new int[s];
            for (int d = 0; d < s; d++) {
                arr[d] = in.nextInt();
            }
            return arr;
        }

        char[][] getCharGrid() {
            ArrayList<char[]> lines = new ArrayList<char[]>();
            String line = in.nextLine();
            while (line != null && line.length() == 0) {
                line = in.nextLine();
            }
            if (line == null) {
                return null;
            }
            while (line != null && line.length() > 0) {
                lines.add(line.toCharArray());
                line = in.nextLine();
            }
            char[][] grid = new char[lines.size()][];
            for (int l = 0; l < grid.length; l++) {
                grid[l] = lines.get(l);
            }
            return grid;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
