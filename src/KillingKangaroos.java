import java.util.Scanner;

public class KillingKangaroos {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter the length of the side of the square of land (in kilometers)." );
        double lengthSide = keyboard.nextDouble();
        System.out.println("The length of roads running through the square (in kilometers).");
        double lengthRoad = keyboard.nextDouble();
        System.out.println("The number of kangaroos living in that square.");
        int numKangaroo = keyboard.nextInt();

        double area = lengthSide * lengthSide;
        double densityKangaroo =  numKangaroo/ area;
        double roadArea = 0.01* lengthRoad;
        double kangKills = densityKangaroo * roadArea * 1.47;
        System.out.println("The Kangaroos in Australia kill "+ kangKills+" people.");




    }


}
