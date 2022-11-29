package realizacja_opcji;

import java.time.LocalDateTime;

public class Lot {
    LocalDateTime data_odlotu; // yyyy-MM-dd HH:mm
    LocalDateTime data_przylotu;// yyyy-MM-dd HH:mm
    public Integer ID_lotu;
    String miasto_odlotu;
    String miasto_przylotu;

    public Lot(LocalDateTime data_odlotu, LocalDateTime data_przylotu, Integer ID_lotu, String miasto_odlotu, String miasto_przylotu) {
        this.data_odlotu = data_odlotu;
        this.data_przylotu = data_przylotu;
        this.ID_lotu = ID_lotu;
        this.miasto_odlotu = miasto_odlotu;
        this.miasto_przylotu = miasto_przylotu;
    }


    public String pokaz_loty(){
        System.out.println(data_odlotu + " " + data_przylotu  + " " + ID_lotu  + " " + miasto_odlotu  + " " + miasto_przylotu);
        return "";
    }
}
