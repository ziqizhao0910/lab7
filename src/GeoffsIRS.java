import java.util.Scanner;

public class GeoffsIRS {
    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double HIGH_TAX_RATE = 0.25;
    private static final double MEDIUM_TAX_RATE = 0.1;
    private static final double LOW_TAX_RATE = 0.03;
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        double[] incomeAndDeductive= inputIncome();
        double income = incomeAndDeductive[0];
        double deduction = incomeAndDeductive[1];
        double taxableIncome = computeTaxableIncome(income,deduction);
        char taxGroup = chooseTaxGroup(taxableIncome);
        double tax = computeTax(taxableIncome);
        display(income,deduction);

    }
    public static double[] inputIncome(){

        double amount =keyboard.nextDouble();
         double income = 0.0;
         double deduction = 0.0;
        do{
            if(amount>0){
                income +=amount;
            }
            else{
                deduction +=Math.abs(amount);
            }
            System.out.println("Enter next amount: ");
            amount = keyboard.nextDouble();
        }while (amount!=0);
      double[] incomeAndDeductive= new double[2];
      incomeAndDeductive[0]=income;
      incomeAndDeductive[1]=deduction;
      return(incomeAndDeductive);
    }
    public static double computeTaxableIncome(double income, double deduction){
        //double taxableIncome;
        if(income>=deduction){
            return income-deduction;
        }
        else {
            return 0.0;
        }
        //return taxableIncome;

    }
    public static char chooseTaxGroup(double taxableIncome){

        if(taxableIncome>=STINKING_RICH){
           return 'S';
        } else if (taxableIncome>=QUITE_RICH) {
            return 'Q';
        } else if (taxableIncome>=MIAMI_POOR) {
            return 'M';
        } else if (taxableIncome>=AVERAGE) {
            return 'A';
        } else if (taxableIncome>=REALISTIC) {
            return 'R';
        }else {
            return 'P';
        }

    }
    public static double computeTax(double taxableIncome){
        //double tax=0.0;
        char taxGroup = chooseTaxGroup(taxableIncome);
        if(taxGroup=='S'||taxGroup=='Q'){
            return taxableIncome*HIGH_TAX_RATE;
        } else if (taxGroup=='M') {
            return taxableIncome*MEDIUM_TAX_RATE;
        } else if (taxGroup=='A'||taxGroup=='R') {
            return taxableIncome*LOW_TAX_RATE;
        } else if (taxGroup=='P') {
            return 0.0;
        }else {
            System.out.println("Error!");
            return 0.0;
        }
        //return tax;
    }
    public static void display(double income,double deduction){

        double taxableIncome = computeTaxableIncome(income,deduction);
        char taxGroup = chooseTaxGroup(taxableIncome);
        double tax = computeTax(taxableIncome);

        System.out.println("Income         = $"+income);
        System.out.println("Deductions     = $"+deduction);
        System.out.println("Taxable income = $"+taxableIncome);
        System.out.println("Tax group      = "+taxGroup);
        System.out.println("Tax owed       = $"+tax);
    }

}





