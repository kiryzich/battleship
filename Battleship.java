/*
Doelstelling 1: een boot op een array maken en de positie laten printen (array van 5, boot van 2)
           Een array maken voor de boot; een veld maken om de boot op de plaatsen

 */


import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //     int[] speelBord = new int[10];
        int[] speelBord = {0, 0, 3, 3, 3, 0, 0, 0, 0, 0,};
        printBoard(speelBord);
        schieten(speelBord);

    }

    public static void printBoard(int[] speelBord) {
        for (int x = 0; x < speelBord.length; x++) {
            if (speelBord[x] == 0) {
                System.out.print(" [   ] ");
                if (speelBord[x] == 8){
                    System.out.print(" [ 0 ] ");
                }
                if (speelBord[x] == 9) {
                    System.out.print(" [ X ] ");
                }
            } else {
                System.out.print(" [ / ] ");
            }
        }
    }

    public static int schieten(int[] speelBord) {
        System.out.println(" ");
        int x = 0;
        Scanner inputX = new Scanner(System.in);
        speelBord[x] = inputX.nextInt();
        boolean qq;
        while (qq = false) {
            if (speelBord[x] == 0) {
                speelBord[x] = 9;
                Battleship.printBoard(speelBord);
                System.out.println("MIS!");
                return speelBord[x];
            } else if (speelBord[x] > 1 && speelBord[x] < 6) {
                speelBord[x] = 8;
                Battleship.printBoard(speelBord);
                System.out.println("RAAK!");
                return speelBord[x];
            }
            Battleship.printBoard(speelBord);
            System.out.println("Weird!");
            return speelBord[x];
        }
    //    x = keuzeX;
        System.out.println("weird2!");
        Battleship.printBoard(speelBord);
        return schieten(speelBord);
    }

}

