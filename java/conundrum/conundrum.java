import java.util.Scanner;
public class conundrum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next();
        text = text.toUpperCase();
        int n = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i % 3 == 0 && text.charAt(i) == 'P' );
            else if (i % 3 == 1 && text.charAt(i) == 'E');
            else if (i % 3 == 2 && text.charAt(i) == 'R');
            else n++;
        }
        System.out.println(n);
    }
}
