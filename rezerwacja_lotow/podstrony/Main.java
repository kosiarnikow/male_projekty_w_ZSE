package podstrony;

import realizacja_opcji.Klient;
import realizacja_opcji.Lot;

import java.time.LocalDateTime;
import java.util.Scanner;

import static realizacja_opcji.Klient.*;

public class Main {
// informacje o zaplanowanych lotach
        static Lot Lot1 = new Lot(LocalDateTime.of(2023, 02, 27, 12, 30), LocalDateTime.of(2023, 02, 27, 18, 30), 123, "Gdansk", "Katar");
        static Lot Lot2 = new Lot(LocalDateTime.of(2023, 02, 28, 16, 10), LocalDateTime.of(2023, 02, 28, 17, 05), 124, "Gdansk", "Barcelona");
        static Lot Lot3 = new Lot(LocalDateTime.of(2023, 03, 01, 11, 23), LocalDateTime.of(2023, 03, 01, 11, 42), 125, "Gdansk", "Ateny");
        static Lot Lot4 = new Lot(LocalDateTime.of(2023, 03, 02, 05, 04), LocalDateTime.of(2023, 02, 01, 23, 56), 126, "Gdansk", "Bangkok");
        static Lot Lot5 = new Lot(LocalDateTime.of(2023, 03, 03, 03, 46), LocalDateTime.of(2023, 03, 01, 18, 23), 127, "Gdansk", "Libreville");
        public static int[] zbior_lotow = {Lot1.ID_lotu, Lot2.ID_lotu, Lot3.ID_lotu, Lot4.ID_lotu, Lot5.ID_lotu};
        public static void menu () {
            try {
                System.out.println("\n" +
                        "opcje do wyboru: \n" +
                        "1. możliwość dokonania rezerwacji\n" +
                        "2. możliwość zobaczenia najbliższych lotow\n" +
                        "3. możliwość zobaczenia rezerwacji\n" +
                        "4. możliwość anulowania rezerwacji\n" +
                        "5. możliwość zakonczenia dzialania programu\n" +
                        "");

                System.out.printf("ktora opcje wybierasz: ");
                Scanner scanner = new Scanner(System.in);
                int opcja = scanner.nextInt();

                switch (opcja) {
                    case 1:
                        System.out.println("a wiec opcja nr 1");
                        boolean found = false;
                        while (found == false) {
                            System.out.printf("\nWpisz ID lotu: ");
                            int proba_ID_lotu = scanner.nextInt();

                            for (int x = 0; x < zbior_lotow.length; x++) {
                                if (zbior_lotow[x] == proba_ID_lotu) {
                                    System.out.println("Jest taki lot\n");
                                    found = true;
                                    rezerwacja();
                                    menu();
                                }
                            }
                            if (found == false) {
                                System.out.println("Nie ma takiego ID lotu w bazie danych");
                                menu();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("a wiec opcja nr 2");
                        System.out.println();
                        System.out.println("znaczenie kolejno informacji dla lotu: \n" +
                                "data i godzina odlotu, data i godzina wyladowania, ID_lotu, miasto odlotu, miasto wyladowania\n");
                        System.out.println(Lot1.pokaz_loty());
                        System.out.println(Lot2.pokaz_loty());
                        System.out.println(Lot3.pokaz_loty());
                        System.out.println(Lot4.pokaz_loty());
                        System.out.println(Lot5.pokaz_loty());
                        menu();
                        break;
                    case 3:
                        System.out.println("a wiec opcja nr 3\n"); // pokazuje nam aktualnie wszystkie loty
                        if (klienci.isEmpty()) {
                            System.out.println("nie ma aktualnie zadnych rezerwacji\n");
                        } else {
                            Klient.pokaz_rezerwacje();
                        }
                        menu();
                        break;
                    case 4:
                        System.out.println("a wiec opcja nr 4");
                        usun_rezerwacje();
                        menu();
                        break;
                    case 5:
                        System.out.println("a wiec opcja nr 5");
                        System.out.println("dzięki, miło było :)");
                        break;
                    default:
                        System.out.println("no i po jakie licho naciskasz jakies niepotrzebne przyciski?");
                        menu();
                }
            }catch (Exception e){
                System.out.println("podales nieprawidlową wartosc");
                menu();
            }
        }

    public static void main(String[] args) {
        menu();
    }
}
