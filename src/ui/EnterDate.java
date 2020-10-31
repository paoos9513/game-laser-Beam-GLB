package ui;

import java.util.Scanner;

public class EnterDate {
    Scanner scan = new Scanner(System.in);
    private String[] dates;
    public EnterDate() {

        System.out.println("Ingrese el nickName, la fila, la columna y la cantidad de espejos seguidos de espacios");
        dates = scan.nextLine().split(" ");
        String nickName = dates[0];
        int row = Integer.parseInt(dates[1]);
        int column= Integer.parseInt(dates[2]);
        int mirror = Integer.parseInt(dates[3]);

        System.out.println(nickName + row + column + mirror);
    }





}
