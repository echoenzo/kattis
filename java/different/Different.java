// Template Author: Michael-G-Sullivan
// Author: echoenzo
import java.io.*;
import java.util.*;

public class Different {

    FastScanner in;
    PrintWriter out;
    int i = 0, j = 0;

    void solve() {
        /**************START**************/

        while (in.hasMoreTokens()) {
            long a = in.nextLong();
            long b = in.nextLong();
            if (a > b) out.println((a-b));
            else out.println((b-a));
        }

        /***************END***************/
    }

    public static void main(String[] args) {
        new Different().runIO();
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
