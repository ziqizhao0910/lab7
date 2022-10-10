import java.util.Scanner;
public class I95 {
    private static Scanner keyboard = new Scanner(System.in);
    public  static void main(String[] args){
        System.out.println("Welcome to the I95 Speed Machine");
        System.out.println(" ");
        System.out.println("You will have to supply");
        System.out.println("+ The distance you want to travel, in miles");
        System.out.println("+ The time you have available, in hours");
        System.out.println(" ");

        System.out.println("Enter distance to travel, in miles:");
        double distance=keyboard.nextDouble();
        System.out.println("Enter time available, in hours:");
        double time=keyboard.nextDouble();

        int stopTimes= (int) distance/100;
        if (stopTimes>0){
            stopTimes=stopTimes+1;
        }
        else{
            stopTimes=stopTimes;
        }
        double timeStop = stopTimes*(5/60);
        double travelTime=time-timeStop;
        double speed=distance/travelTime;
        boolean overSpeedLimit;
        if(speed>65.00){
            overSpeedLimit=true;
        }
        else{
            overSpeedLimit=false;
        }
        System.out.println("You will have to travel at "+speed+"mph");
        System.out.println("Over speed limit: "+overSpeedLimit);








    }
}
