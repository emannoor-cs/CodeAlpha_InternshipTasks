import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- WELCOME TO STUDENT GRADE TRACKER ---");

        System.out.println("Enter no. of stds");
        int noOfStds = sc.nextInt();
        String[] stdName = new String[noOfStds];
        int[] stdScore = new int[noOfStds];

        do {
            showMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                   inputStdInfo(noOfStds,stdScore,stdName,sc);
                    break;

                case 2:
                   calculateAverage(noOfStds,stdScore);
                    break;

                case 3:
                   showHighestAndLowest(stdScore,stdName);
                    break;

                case 4:
                    displayInfo(stdScore,stdName,noOfStds);
                    break;

                case 5:
                    System.out.println("Exiting the system!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
        while (true);
    }

    public static void showMenu() {
        System.out.println("Choose any task to perform:" +
                "1.Input student data\n" +
                "2.Calculate average grade\n" +
                "3.Display highest and lowest scorer\n" +
                "4.Display all information\n" +
                "5.Exit the system");
    }

    public static void inputStdInfo(int noOfStds, int[] stdScore, String[] stdName, Scanner sc) {
        for (int i = 0; i < noOfStds; i++) {
            System.out.println("Enter your name to proceed ");
            sc.nextLine();
            stdName[i] = sc.nextLine();
            System.out.println("Enter score ");
            stdScore[i] = sc.nextInt();
        }
        System.out.println("Data entered successfully!");
    }

    public static void calculateAverage(int noOfStds, int[] stdScore) {
        double sum = 0;
        for (int i = 0; i < noOfStds; i++) {
            sum += stdScore[i];
        }
        double avg = sum / noOfStds;
        System.out.printf("Average of enterted students marks is %.2f\n", avg);
    }
    public static void showHighestAndLowest(int[] stdScore, String[] stdName) {
        int max = stdScore[0];
        int min = stdScore[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < stdName.length; i++) {
            if (max < stdScore[i]) {
                max = stdScore[i];
                maxIndex = i;
            }
            if (min > stdScore[i]) {
                min = stdScore[i];
                minIndex = i;
            }
        }

        System.out.printf("Highest score are %d achieved by %s and lowest score are %d by %s \n",
                max, stdName[maxIndex], min, stdName[minIndex]);
    }

    public static void displayInfo(int[] stdScore,String[] stdName,int noOfStds){
        System.out.println("Student \t Marks");
        for(int i=0; i<noOfStds;i++){
            System.out.printf("%s \t %d \n",stdName[i],stdScore[i]);
        }
    }
}