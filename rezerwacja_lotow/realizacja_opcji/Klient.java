package realizacja_opcji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static podstrony.Main.menu;

public class Klient {

     String imie;
     String nazwisko;
     Integer nr_telefonu;
     Integer ilosc_pasazerow;
     Integer ID_pasazera;
     Integer nr_taryfy;

    public static List<Klient> klienci = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public Klient(String imie, String nazwisko, Integer nr_telefonu, Integer ilosc_pasazerow, Integer ID_pasazera, Integer nr_taryfy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.ilosc_pasazerow = ilosc_pasazerow;
        this.ID_pasazera = ID_pasazera;
        this.nr_taryfy = nr_taryfy;
    }

    public static void rezerwacja() {
        try{
            System.out.printf("podaj swoje imie: ");
            scanner.nextLine();
            System.out.printf("\nnapisz ponowanie swoje imie (czasami scanner nieodpowiednio zadziala): ");
            String imie = scanner.nextLine();
            System.out.printf("\npodaj swoje nazwisko: ");
            String nazwisko = scanner.nextLine();
            System.out.printf("\npodaj swoj numer telefonu: ");
            Integer nr_telefonu = scanner.nextInt();
            System.out.printf("\npodaj ilosc miejsc ktore chcesz zarezerwować: ");
            Integer ilosc_pasazerow = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("\npodaj ID jakie chcesz mieć (zapamietaj to, bo to wazne): ");
            Integer ID_pasazera = scanner.nextInt();
            System.out.printf("\npodaj numer klasy w ktorej chcesz siedziec (1-4): ");
            Integer nr_taryfy = scanner.nextInt();
            if(nr_taryfy > 0 || nr_taryfy < 5){
                klienci.add(new Klient(imie, nazwisko, nr_telefonu, ilosc_pasazerow, ID_pasazera, nr_taryfy));
            }
            else{
                System.out.println("\nNo i dales za duzo");
                menu();
            }
        } catch (Exception e){
            System.out.println("podales nieprawidlowa wartosc");
            menu();
            System.out.println(" ");
        }
    }

    public Integer getID_pasazera() {
        return ID_pasazera;
    }

    public void pokaz_dane(){
        System.out.println(imie + " " + nazwisko + " " + nr_telefonu + " " + ilosc_pasazerow + " " + ID_pasazera  + " " + nr_taryfy);
    }

    public static void pokaz_rezerwacje() {
        for (Klient klient : klienci){
            klient.pokaz_dane();
        }
    }

    public static boolean chwilowa_zmienna = false;
    public static void usun_rezerwacje() {
        int ID_pasazera_do_usuniecia;
        try{
            if(chwilowa_zmienna == true){
                scanner.next();
                chwilowa_zmienna = false;
            }
            System.out.printf("\npodaj swoje ID ktore wpisales na poczatku: ");
            ID_pasazera_do_usuniecia = scanner.nextInt();

            boolean znaleziono = false;
            for (int i = 0; i < klienci.size(); i++){
                if(klienci.get(i).getID_pasazera() == ID_pasazera_do_usuniecia){
                    klienci.remove(i);
                    znaleziono = true;
                    System.out.println("\nusunieto pasazera o takim ID");
                }
            }
            if (!znaleziono){
                System.out.println("\nnie ma pasazera o takim ID");
            }
        } catch (Exception e){
            chwilowa_zmienna = true;
            System.out.println("podales nieprawidlowa wartosc");
            usun_rezerwacje();
        }
    }
}