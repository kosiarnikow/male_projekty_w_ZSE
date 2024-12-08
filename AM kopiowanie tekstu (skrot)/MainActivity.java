package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tekst;
    TextView wynik;
    Button UP, DOWN, KOPIA, USUN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tekst = findViewById(R.id.tekst);
        UP = findViewById(R.id.UP_button);
        DOWN = findViewById(R.id.DOWN_button);
        wynik = findViewById(R.id.wynik);
        KOPIA = findViewById(R.id.KOPIA_button);
        USUN = findViewById(R.id.USUN_button);


        UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nowyTekst = tekst.getText().toString();
                String DuzeLiteryTekst = nowyTekst.toUpperCase();
                wynik.setText(DuzeLiteryTekst);
            }
        });

        DOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nowyTekst = tekst.getText().toString();
                String MaleLiteryTekst = nowyTekst.toLowerCase();
                wynik.setText(MaleLiteryTekst);
            }
        });


        USUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst.setText("");
                wynik.setText("");
            }
        });


        KOPIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String skopiowanyWynik = wynik.getText().toString();

                ClipboardManager schowek = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE); // Uzyskanie dostępu do schowka
                ClipData komunikat = ClipData.newPlainText("Skopiowany tekst", skopiowanyWynik); // kopiowanie
                schowek.setPrimaryClip(komunikat); // przekazanie danych

                Toast.makeText(getApplicationContext(), "Tekst skopiowany do schowka", Toast.LENGTH_SHORT).show(); // powiadomienie
            }
        });
    }
}