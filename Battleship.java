
import java.util.Random;
import java.util.Scanner;

public class Battleship {

    static int totaalHP = Vliegdekschip.hp + Jager.hp + Duikboot.hp + Duikboot.hp + Torpedo.hp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vliegdekschip boot1 = new Vliegdekschip();
        boot1.naam = "Vliegdekschip: De vlieger";
        boot1.hp = 5;
        //    boot1.lengte = 5;

        Jager boot2 = new Jager();
        boot2.naam = "Jager: De hond";
        boot2.hp = 4;
        //     boot2.lengte = 4;

        Duikboot boot3 = new Duikboot();
        boot3.naam = "Duikboot 1: De otter";
        boot3.hp = 3;
        //     boot3.lengte = 3;

        Duikboot boot4 = new Duikboot();
        boot4.naam = "Duikboot 1: De zeehond";
        boot4.hp = 3;
        //    boot4.lengte = 3;

        Torpedo boot5 = new Torpedo();
        boot5.naam = "Torpedo: De rat";
        boot5.hp = 2;
        //   boot5.lengte = 2;
        int totaalHP = Vliegdekschip.hp + Jager.hp + Duikboot.hp + Duikboot.hp + Torpedo.hp;

        int[][] bord = new int[10][10];
        speelBord1(bord);
   //     botenOpVeldPlaatsen(bord);

        int[] schieten = { 0 , 0 };
        boolean dood = false;
    //    int attempts = 0,
    //            raken = 0;
        System.out.println();

        do{
            botenOpVeldPlaatsen(bord);
            schieten(schieten);
  //          attempts++;

            if(raken(schieten,bord)){
 //               raken++;
            }
            else

            botenOpVeldPlaatsen(bord);


        }while(!dood);

        System.out.println("\n\n\nBattleship is gestopt! Je hebt alle 5 de schepen gezonken!");
        botenOpVeldPlaatsen(bord);

    }

    public static void dood(){

    }

    public static class Vloot {
        String naam;
        static int hp;
        static int lengte;

    }

    public static class Vliegdekschip extends Vloot {
        static int lengte = 5;
    }

    public static class Jager extends Vloot {
        static int lengte = 4;
    }

    public static class Duikboot extends Vloot {
        static int lengte = 3;
    }

    public static class Torpedo extends Vloot {
        static int lengte = 2;
    }

    public static void speelBord1(int[][] bord) {
        int een = Torpedo.lengte;
        int twee = Duikboot.lengte;
        int drie = Duikboot.lengte;
        int vier = Jager.lengte;
        int vijf = Vliegdekschip.lengte;
        int[] boten = {een, twee, drie, vier, vijf};
        for (int i = 0; i < boten.length; i++) {
            boolean botenOpBord;
            do {
                int maxRij = 10;
                int maxKolom = 10;
                int richting = (int) (Math.random() * 2);
                if (richting == 0) {
                    maxRij -= (boten[i] - 1);
                } else {
                    maxKolom -= boten[i] - 1;
                }
                int rij = (int) (Math.random() * maxRij);
                int kolom = (int) (Math.random() * maxKolom);
                botenOpBord = true;
                if (botenOpBord) {
                    for (int j = 0; j < boten[i]; j++) {
                        bord[rij][kolom] = boten[i];
                        if (richting == 0) {
                            rij++;
                        } else {
                            kolom++;
                        }
                    }
                }

            } while (!botenOpBord);

        }
    }

    public static void botenOpVeldPlaatsen(int[][] bord) {
        System.out.println(" 1  2  3  4  5  6  7  8  9  10 <<<< rijen!");
        System.out.println();
        for (int[] speelBord1 : bord) {
            for (int positie : speelBord1) {
                if (positie == 0) {
                    System.out.print(" ~ ");
                }
                else if (positie == 7){
                   System.out.print(" x ");
                }
                else if (positie == 8){
                System.out.print(" * ");
                }
                else if ( positie > 1 && positie < 7 ){
                    System.out.print(" " + positie + " ");
                }
                else;
            }
            System.out.println();
        }
    }

    public static void schieten(int[] schieten) {
        Scanner x = new Scanner(System.in);
        Scanner y = new Scanner(System.in);

        System.out.print("Verticale rij: ");
        schieten[0] = x.nextInt();
        schieten[0]--;

        System.out.print("Horizontale kolom: ");
        schieten[1] = y.nextInt();
        schieten[1]--;


    }

    public static boolean raken(int[] schieten, int[][] bord) {
        for (int boot = 0; boot < bord.length; boot++) {

            if (schieten[0] == bord[boot][0] && schieten[1] == bord[boot][1]) {
                System.out.printf("Hoera, je hebt een schip geraakt op:  (%d,%d)\n", schieten[0] + 1, schieten[1] + 1);
                schieten[0] = 7;
                schieten[1] = 7;
                botenOpVeldPlaatsen(bord);
                return true;
            }
            schieten[0] = 8;
            schieten[1] = 8;
        }
        return false;
    }
}