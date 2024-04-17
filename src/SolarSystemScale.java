import java.util.Scanner;

public class SolarSystemScale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Planet data based on CSV (relative diameter and mean distance in AU)
        double[] planetDiameters = {0.382, 0.949, 1.0, 0.532, 11.21, 9.45, 4.01, 3.88}; // Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune
        double[] distancesFromSun = {0.39, 0.72, 1.0, 1.52, 5.2, 9.58, 19.22, 30.05}; // in AU

        // Asking for the diameter which represents the Sun in cm
        System.out.println("Enter the diameter of our scaled Sun (in cm):");
        double sunDiameterInCm = scanner.nextDouble();

        // Sun diameter in terms of Earth diameters 
        double earthDiameterRelativeToSun = 1 / 109.0;

        // Scaling factor for diameters and distances
        double scaleForDiameters = earthDiameterRelativeToSun * sunDiameterInCm;
        double earthOrbitalRadiusInCm = 149.6e6 * scaleForDiameters; // Scaling AU (149.6 million km per AU)

        System.out.println("Scaled planetary sizes and orbital radii:");

        for (int i = 0; i < planetDiameters.length; i++) {
            double planetDiameterInCm = planetDiameters[i] * scaleForDiameters;
            double orbitalRadiusInM = distancesFromSun[i] * earthOrbitalRadiusInCm/100;
            System.out.printf("%s: Diameter = %.2f cm, Orbital Radius = %.2f m%n",
            getPlanetName(i), planetDiameterInCm, orbitalRadiusInM);
        }

        scanner.close(); // did not know you have to do this
    }
    // helper method to clean up the code 
    private static String getPlanetName(int index) {
        String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        return planetNames[index];
    }
}