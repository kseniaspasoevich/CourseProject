package Service1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Внесите колличество судн: ");
        Scanner scan=new Scanner(System.in);
        int input=scan.nextInt();

        System.out.println("Расписание: ");
        TimeTable obj = new TimeTable(input);

    }
}
