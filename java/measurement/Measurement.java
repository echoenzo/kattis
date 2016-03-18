// Template Author: Michael-G-Sullivan
// Author: echoenzo
import java.io.*;
import java.util.*;

public class Measurement {

    FastScanner in;
    PrintWriter out;
    int i = 0, j = 0;

    final int IN_TH = 1000;
    final int FT_IN = 12;
    final int YD_FT = 3;
    final int CH_YD = 22;
    final int FUR_CH = 10;
    final int MI_FUR = 8;
    final int LEA_MI = 3;

    void solve() {
        /**************START**************/

        double val = in.nextDouble();
        String from = in.next();
        in.next();
        String to = in.next();

        val = toThou(val, from);
        val = toUnit(val, to);

        out.println(val);

        /***************END***************/
    }

    double toThou(double val, String s) {
        switch (s) {
            case "lea": case "league":
                val = val*LEA_MI;
            case "mi": case "mile":
                val = val*MI_FUR;
            case "fur": case "furlong":
                val = val*FUR_CH;
            case "ch": case "chain":
                val = val*CH_YD;
            case "yd": case "yard":
                val = val*YD_FT;
            case "ft": case "foot":
                val = val*FT_IN;
            case "in": case "inch":
                val = val*IN_TH;
            case "th": case "thou":
                return val;
            default:
                return val;
        }
    }

    double toUnit(double val, String s) {
        switch (s) {
            case "th": case "thou":
                return val;
            case "in": case "inch":
                val = val / IN_TH;
                return val;
            case "ft": case "foot":
                val = val / IN_TH;
                val = val / FT_IN;
                return val;
            case "yd": case "yard":
                val = val / IN_TH;
                val = val / FT_IN;
                val = val / YD_FT;
                return val;
            case "ch": case "chain":
                val = val / IN_TH;
                val = val / FT_IN;
                val = val / YD_FT;
                val = val / CH_YD;
                return val;
            case "fur": case "furlong":
                val = val / IN_TH;
                val = val / FT_IN;
                val = val / YD_FT;
                val = val / CH_YD;
                val = val / FUR_CH;
                return val;
            case "mi": case "mile":
                val = val / IN_TH;
                val = val / FT_IN;
                val = val / YD_FT;
                val = val / CH_YD;
                val = val / FUR_CH;
                val = val / MI_FUR;
                return val;
            case "lea": case "league":
                val = val / IN_TH;
                val = val / FT_IN;
                val = val / YD_FT;
                val = val / CH_YD;
                val = val / FUR_CH;
                val = val / MI_FUR;
                val = val / LEA_MI;
                return val;
            default:
                return val;
        }
    }

    public static void main(String[] args) {
        new Measurement().runIO();
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
