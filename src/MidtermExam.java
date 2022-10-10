import java.util.Scanner;

public class MidtermExam {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        char userValue1, userValue2;
        int choice;
        char result;
        userValue1 = keyboard.next().charAt(0);
        userValue2 = keyboard.next().charAt(0);
        choice = keyboard.nextInt();
        switch (choice){
            case 1: result = userValue1;
            break;
            case 2:result=userValue2;
            break;
            default:
            result = (char) choice;
        }
        System.out.println(result);

    }

}