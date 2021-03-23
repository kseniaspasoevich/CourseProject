package Service1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Внесите колличество судн: ");
        Scanner scan=new Scanner(System.in);
        int input=scan.nextInt();

        System.out.println("Расписание: ");

        for (int i = 0; i < input; i++){
            TimeTable obj = new TimeTable();
            System.out.println(obj);
        }

    }
}
