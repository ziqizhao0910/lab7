import java.util.Scanner;

public class StreetMaintance {
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[]args){
        int[]house = createHouseArray();
        int[][] housePeople = createPeopleArray(house);
        int[] sumAge = calculateAge(housePeople,house);
        int totalAge = 0;
        for (int i = 0; i < sumAge.length; i++) {
            System.out.println("House "+house[i]+" has a total age of "+sumAge[i]);
        }
        for (int j = 0; j < sumAge.length; j++) {
            totalAge+=sumAge[j];
        }
        System.out.println("The street has a total age of "+totalAge);
    }
    public static int[] createHouseArray() {
        System.out.println("How many houses in the street?");
        int[] house = new int[keyboard.nextInt()];
        for (int i = 0; i < house.length; i++) {
            System.out.println("What is the next house number?");
            house[i] = keyboard.nextInt();
        }
        return house;
    }
    public static int[][] createPeopleArray(int[]house){
        int[][] housePeople = new int[house.length][];
        for (int j = 0; j < house.length; j++) {
            System.out.println("How many people live in number"+house[j]);
            housePeople[j] = new int[keyboard.nextInt()];
            for (int k = 0; k < housePeople[j].length; k++) {
                System.out.println("What is the age of person" + (k + 1));
                housePeople[j][k] = keyboard.nextInt();
            }
        }
        return housePeople;
    }
    public static int[] calculateAge(int[][]housePeople,int[] house){
        int[] sumAge = new int[house.length];
        for (int i = 0; i < sumAge.length; i++) {
            sumAge[i]=0;
            for (int j = 0; j < housePeople[i].length; j++) {
                sumAge[i] =housePeople[i][j]+sumAge[i];
            }
        }
        return sumAge;
    }

}
