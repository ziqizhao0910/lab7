import java.util.Scanner;

public class DentalRecord {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int MAX_TEETH_NUM = 8;
    private static final int MAX_PEOPLE = 6;
    private static final int LAYER_NUM = 2; //There are only two layers, uppers and the lowers
    private static final int UPPER_INDEX = 0;   //The fist layer
    private static final int LOWER_INDEX =1;    //The second layer
    private static final char[] TEETH_TYPE = new char[]{'I','B','M'};   //I:Incisors, B:Bicuspids, M:Missing teeth
    private static final char[] OPTION_LIST = new char[]{'P','E','R','X'};  //(P)rint, (E)xtract, (R)oot, e(X)it
    private static final char[] TEETH_LAYER = new char[]{'U','L'};

    public static void main(String[] args){
     System.out.println("Welcome to the Floridian Tooth Records");
     System.out.println("---------------------------------------"); //Welcome message

     System.out.println("Please enter number of people in the family :");
     int num_people = keyboard.nextInt();
     while (num_people < 0 || num_people > MAX_PEOPLE) {    //Test if the number of people is no negative and less than 6
         System.out.println("Invalid number of people, try again :");
         num_people = keyboard.nextInt();   //Ask an input of number of people until it is valid
     }

     String[] names = new String[num_people];//Create a name array
     char[][][]family_teeth = new char[names.length][LAYER_NUM][];  //Create a 3-D char array for the teeth record
     getData(names,family_teeth);   //Use method 'getData' to get input

     char option;   //Create an option char
        do {
            option = menu();    //Use menu method to test if the input is in the option list
            switch (option) //Decide which method to use by the input option
            {
                case 'P' :
                    printData(names,family_teeth);  //Print all the recorded data out
                    break;
                case 'E' :
                    extract(names,family_teeth);    //Change a teeth's status to 'M'
                    break;
                case 'R' :
                    root(family_teeth); //Calculate the root for the given equation Ix^2+Bx-M
            }
        }while (option!= OPTION_LIST[3]);   //While the input is X, print the exit message
        System.out.println("Exiting the Floridian Tooth Records :-)");
    }
    public static void getData(String[]names,char[][][]family_teeth) {
        for (int member = 0; member < names.length; member++) { //Use for loops to get all family members' data

            System.out.println("Please enter the name for family member " + (member + 1));
            names[member] = keyboard.next(); //Get family members' name

            System.out.println("Please enter the uppers for " + names[member]);
            String upperTeeth = keyboard.next();    //Get the uppers for one of the family member
            upperTeeth = upperTeeth.toUpperCase();  //Make the input up case

            while (testDataLength(upperTeeth)==false || testDataValid(upperTeeth)==false) {    //Test the validation of input teeth data
                if (testDataLength(upperTeeth)==false) {  //If the data length exceed the maximum teeth number
                    System.out.println("Too many teeth, try again");
                    upperTeeth = keyboard.next();
                    upperTeeth = upperTeeth.toUpperCase();
                } else if (testDataValid(upperTeeth) == false) { //If the data contains the char other than 'I','B','M', tested by method testData
                    System.out.println("Invalid teeth types, try again");
                    upperTeeth = keyboard.next();
                    upperTeeth = upperTeeth.toUpperCase();
                }
            }
            family_teeth[member][UPPER_INDEX]= upperTeeth.toCharArray(); //Add the checked input into array by transform the input string into a char array

            System.out.println("Please enter the lowers for " + names[member]);
            String lowerTeeth = keyboard.next();    //Get the lowers for the family member
            lowerTeeth = lowerTeeth.toUpperCase();

            while (testDataLength(lowerTeeth)==false || testDataValid(lowerTeeth)==false){ //Same validation test as the uppers, with the same method testData
                if (testDataLength(lowerTeeth)==false){
                    System.out.println("Too many teeth, try again");
                    lowerTeeth = keyboard.next();
                    lowerTeeth = lowerTeeth.toUpperCase();
                } else if (testDataValid(lowerTeeth)==false) {
                    System.out.println("Invalid teeth types, try again");
                    lowerTeeth = keyboard.next();
                    lowerTeeth = lowerTeeth.toUpperCase();
                }
                    }
            family_teeth[member][LOWER_INDEX] = lowerTeeth.toCharArray();   //Add tested data into array, with the same member index and different layer index with uppers
                }
    }
    public static boolean testDataLength(String inputData){
        if (inputData.length()>MAX_TEETH_NUM){  //If the input length is over maximum, return false
            return false;
        }
        return true;    // If the input length is in the range, return true
    }
    public static boolean testDataValid(String inputData){
        boolean validation = true;
        for (int i = 0; i < inputData.length(); i++) {
            if (inputData.charAt(i)== TEETH_TYPE[0]||inputData.charAt(i)== TEETH_TYPE[1]||inputData.charAt(i)== TEETH_TYPE[2]){     //Check each chars for the input string
                validation = true;  //If the input strings only contains I,B,M, the validation is ture
            }else{
                validation = false; //If the input strings contains other chars, the data is invalid
            }
        }
        return validation;
    }
    public static char menu(){
        System.out.println("(P)rint, (E)xtract, (R)oot, e(X)it");
        char option = keyboard.next().charAt(0);
        option = Character.toUpperCase(option); //Make the input up case so no matter what the input is, it always becomes up case
        while (!(option== OPTION_LIST[0]||option== OPTION_LIST[1]||option== OPTION_LIST[2]||option== OPTION_LIST[3])){  //If the input is not in option list, ask a new input until it get the correct input
            System.out.println("Invalid menu option, try again");
            option = keyboard.next().charAt(0);
            option = Character.toUpperCase(option);
        }
        return option;
    }
    public static void printData(String[]names,char[][][]family_teeth){
        for (int name = 0; name < names.length; name++) {   //Use for loop to print all family members' data
            System.out.println(names[name]);
            System.out.print(" Uppers:");
            for (int upper = 0; upper < family_teeth[name][UPPER_INDEX].length; upper++) {  //Print all uppers
                System.out.print((upper+1)+":"+family_teeth[name][UPPER_INDEX][upper]+" "); //Since the array index starts at 0, the number before teeth type should be upper+1
            }
            System.out.println(" ");
            System.out.print(" Lowers:");
            for (int lower = 0; lower < family_teeth[name][LOWER_INDEX].length; lower++) {
                System.out.print((lower+1)+":"+family_teeth[name][LOWER_INDEX][lower]+" "); //Same as the way to print uppers
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public static int findName(String[] names,String nameInput){
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(nameInput)){
                return i;
            }
        }
        return -1;
    }
    public static int findTeethLayer(char layer){
        if (layer == TEETH_LAYER[0]){   // If the input value is U, return the uppers index
            return UPPER_INDEX;
        } else if (layer == TEETH_LAYER[1]) {   //If the input value is L, return the lowers index
            return LOWER_INDEX;
        }
        return -1;  //If the input is not one of the teeth layer, prompt user to input teeth layer again
    }
    public static int findTeeth(int tooth_num,int nameIndex,int layerIndex, char[][][]family_teeth){
        if (tooth_num>family_teeth[nameIndex][layerIndex].length||tooth_num<=0){
            return -99;
        } else if (family_teeth[nameIndex][layerIndex][tooth_num-1]== TEETH_TYPE[2]) {
            return -1;
        }
        return tooth_num;
    }
    public static void extract(String[]names,char[][][]family_teeth) {

        System.out.println("Which family member");
        String nameInput = keyboard.next();
        int nameIndex = findName(names, nameInput);
        while (nameIndex < 0) {
            System.out.println("Invalid family member, try again:");
            nameInput = keyboard.next();
            nameIndex = findName(names, nameInput);
        }

        System.out.println("Which tooth layer (U)pper or (L)ower");
        char layer = keyboard.next().charAt(0);
        layer = Character.toUpperCase(layer);
        int layerIndex = findTeethLayer(layer);
        while (layerIndex < UPPER_INDEX) {
            System.out.println("Invalid layer, try again");
            layer = keyboard.next().charAt(0);
            layer = Character.toUpperCase(layer);
            layerIndex = findTeethLayer(layer);
        }

        System.out.println("Which tooth number");
        int tooth_num = keyboard.nextInt();
        tooth_num = findTeeth(tooth_num, nameIndex, layerIndex, family_teeth);
        while (tooth_num<UPPER_INDEX){
            if (tooth_num==-1){
                System.out.println("Missing tooth, try again");
            }else {
                System.out.println("Invalid tooth number, try again");
            }
            tooth_num = keyboard.nextInt();
            tooth_num = findTeeth(tooth_num,nameIndex,layerIndex,family_teeth);
        }
        family_teeth[nameIndex][layerIndex][tooth_num]= TEETH_TYPE[2];

    }
    public static void root(char[][][]family_teeth){
        int count0 = 0; //Counts for I
        int count1 = 0; //Counts for B
        int count2 = 0; //Counts for M

        for (int member = 0; member < family_teeth.length; member++) { //Use for loop to count each data in the 3-D array

            for (int uppers = 0; uppers < family_teeth[member][UPPER_INDEX].length; uppers++) { //Count the uppers
                if (family_teeth[member][UPPER_INDEX][uppers]== TEETH_TYPE[0]){
                    count0++;
                } else if (family_teeth[member][UPPER_INDEX][uppers]== TEETH_TYPE[1]) {
                    count1++;
                } else {
                    count2++;
                }
            }

            for (int lowers = 0; lowers < family_teeth[member][LOWER_INDEX].length; lowers++) { //Count the lowers
                if (family_teeth[member][LOWER_INDEX][lowers]== TEETH_TYPE[0]){
                    count0++;
                } else if (family_teeth[member][LOWER_INDEX][lowers]== TEETH_TYPE[1]) {
                    count1++;
                }else {
                    count2++;
                }
            }
        }

        double delta = count1*count1+4*count0*count2;   //Since the equation is in the form ax^2+bx-c, delta becomes b^2+4ac
        double root1,root2;

        if (delta > 0) {
            root1 = (-count1 + Math.sqrt(delta)) / (2*count0);
            root2 = (-count1 - Math.sqrt(delta)) / (2*count0);
            System.out.printf("One root canal at %.2f%n",root1);
            System.out.printf("Another root canal at %.2f%n",root2);
        } else if (delta==0) {  //For the situation that root1 = root2
            root1=-count1/(2*count0);
            System.out.printf("One root canal at %.2f%n",root1);
        }
    }
    }

