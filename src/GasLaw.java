import java.util.Scanner;

public class GasLaw {

    private static Scanner keyboard = new Scanner(System.in);
//----The gas constant in Joules/mole/K
    private static double GasConstant = 8.3143;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume,moles,temp;
        double pressure;

//----What is this all about?
        System.out.print("Enter volume, moles, temperature : ");
          volume = keyboard.nextDouble();
   moles = keyboard.nextDouble();
        volume = keyboard.nextDouble();
temp = keyboard.nextDouble();
//----Is anything happening here?
        pressure = moles * GasConstant * temp / volume;

//----Why do this?
        System.out.println("Pressure is " + pressure);
    }
}
