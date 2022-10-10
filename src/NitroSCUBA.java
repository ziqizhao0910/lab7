import java.util.Scanner;
public class NitroSCUBA {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter depth :");
        int depth = keyboard.nextInt();
        System.out.println("Enter percentage O2:");
        int o2Percentage = keyboard.nextInt();
        int AtmosphereConstant = 33;

        double ambientPressure = depth / AtmosphereConstant + 1;
        System.out.println("Ambient pressure: " + ambientPressure);
        double partialPressure = o2Percentage * ambientPressure / 100;
        System.out.println("O2 pressure:" + partialPressure);
        char group = (char) (int) (partialPressure * 10 + 'A');
        System.out.println("o2 group:" + group);

        final double MaximalPressure = 1.4;
        final double ContingencyPressure = 1.6;
        if (partialPressure >= MaximalPressure) {
            System.out.println("Exceeds maximal O2 pressure: true");
        } else {
            System.out.println("Exceeds maximal O2 pressure: false");
        }

        if (partialPressure >= ContingencyPressure) {
            System.out.println("Exceeds contingency O2 pressure: true");
        } else {
            System.out.println("Exceeds contingency O2 pressure: flase");
        }
    }
}





