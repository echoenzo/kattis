import java.util.Scanner;
import java.util.ArrayList;

public class Everywhere {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTrips = in.nextInt();
        int numCities;
        ArrayList<String> cities = new ArrayList<String>();
        String city;
        for (int i = 0; i < numTrips; i++) {
            numCities = in.nextInt();
            in.nextLine();
            for (int j = 0; j < numCities; j++) {
                city = in.nextLine();
                if (!cities.contains(city)) cities.add(city);
            }
            System.out.println(cities.size());
            cities.clear();
        }
    }
}
