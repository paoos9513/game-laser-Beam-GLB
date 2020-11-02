package ui;

import model.LinkedListMatrix;
import java.util.Scanner;

public class StartGame {
    Scanner scan = new Scanner(System.in);
    LinkedListMatrix lm;
    private String[] dates;
    public StartGame() {

        System.out.println("Ingrese el nickName, la fila, la columna y la cantidad de espejos seguidos de espacios");
        System.out.println("ROW MAX ---> 26");
        System.out.println("COLUMN MAX ---> 26");
        System.out.println("MIRROR MAX ---> 676");
        dates = scan.nextLine().split(" ");
        String nickName = dates[0];
        int row = Integer.parseInt(dates[1]);
        int column= Integer.parseInt(dates[2]);
        int mirror = Integer.parseInt(dates[3]);
        if (row <=26 && column <= 27 && mirror <= (row * column)) {
            lm = new LinkedListMatrix(row, column);
            System.out.println(lm);
        }else {
            System.out.println("Exceeds allowed values");
        }
        new OptionsGame();
    }





}
