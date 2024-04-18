import java.util.Scanner;

public class SolarSystemScale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data
        double[] planetDiameters = {4878, 12104, 12756, 6787, 142984, 120536, 51118, 49528, 2370}; // in kilometers
        double[] orbitalRadiiAU = {0.39, 0.72, 1.00, 1.52, 5.20, 9.58, 19.22, 30.05, 39.48}; // in AU
        String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"}; // indices line up 

        System.out.print("Enter the scaled diameter of the Sun in centimeters: ");
        double scaledSunDiameterCM = scanner.nextDouble();

        // Convert the scaled Sun diameter from centimeters to kilometers for scaling
        double scaledSunDiameterKM = scaledSunDiameterCM / 100000; // 100,000 cm in a km

        // Constants for calculation
        double SUN_DIAMETER_KM = 1392000; // original diameter of the sun in kilometers
        double AU_IN_KM = 149597870.7; // 1 AU in kilometers

        // Calculate the scale factor
        double scaleFactor = scaledSunDiameterKM / SUN_DIAMETER_KM;

        // Output scaled dimensions
        System.out.println("\nScaled Solar System Dimensions:");
        System.out.println("Sun Diameter: " + scaledSunDiameterCM + " cm");

        for (int i = 0; i < planetNames.length; i++) {
            double scaledDiameter = planetDiameters[i] * scaleFactor * 1000000; // Convert to millimeters
            double scaledOrbitalRadius = orbitalRadiiAU[i] * scaleFactor * AU_IN_KM * 1000; // Convert AU to meters

            System.out.printf("%s: Diameter = %.5f mm, Orbital Radius = %.2f m\n", planetNames[i], scaledDiameter, scaledOrbitalRadius);
        }
    }
}
