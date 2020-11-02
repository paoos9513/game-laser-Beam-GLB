package ui;

import model.LinkedListMatrix;
import java.util.Scanner;

public class StartGame {
    Scanner scan = new Scanner(System.in);
    LinkedListMatrix lm;
    private String[] dates;
    public StartGame() {

        System.out.println("Enter the nickname, row, column and the number of mirrors followed by spaces");
        System.out.println("ROW MAX ---> 26 " + " _______ " + "COLUMN MAX ---> 26 " + " _______ " + "MIRROR MAX ---> (ROW*COLUMN)");
        dates = scan.nextLine().split(" ");
        if (dates.length == 4) {
            String nickName = dates[0];
            int row = Integer.parseInt(dates[1]);
            int column = Integer.parseInt(dates[2]);
            int mirror = Integer.parseInt(dates[3]);
            if (row <= 26 && column <= 27 && mirror <= (row * column)) {
                lm = new LinkedListMatrix(row, column);
                System.out.println(lm);
            } else {
                System.out.println("Exceeds allowed values");
                new StartGame();
            }
        }else {
            System.out.println("Exceeds allowed values");
            new StartGame();
        }
        new OptionsGame();
    }





}
