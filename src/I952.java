import java.util.Scanner;

public class I952 {
    public static void main(String[] args) {
        welcomeMessages();
        System.out.println("Enter distance to travel, in miles:");
        double distance = keyboard.nextDouble();
        System.out.println("Enter time available, in hours:");
        double time = keyboard.nextDouble();
        double speed = getSpeed(distance,time);
        displaySpeed(speed);



    }
    private static Scanner keyboard = new Scanner(System.in);


    public static void welcomeMessages(){
        System.out.println("Welcome to the I95 Speed Machine");
        System.out.println(" ");
        System.out.println("You will have to supply");
        System.out.println("+ The distance you want to travel, in miles");
        System.out.println("+ The time you have available, in hours");
        System.out.println(" ");
    }
    public static  double getSpeed(double distance,double time) {
        double timeStop = Math.ceil(distance / 100) * (5.0 / 60);
        double speed = distance / (time - timeStop);

        System.out.println("You will have to travel at "+speed+"mph");

        return speed;
    }


    public static void displaySpeed(double speed) {
        boolean overSpeedLimit =false;
        if (speed > 65.00) {
            overSpeedLimit = true;
        }
        System.out.println("Over speed limit: " + overSpeedLimit);

    }

    }















