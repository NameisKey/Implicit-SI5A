    package com.example.implicitsi5a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

    public class MainActivity extends AppCompatActivity {
    EditText etUrl,etLokasi,etTeks;
    Button btnBukaWebsite, btnBukaLokasi, btnBagikanTeks;
    String getWebsite,getLokasi, getTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.et_url);
        etLokasi = findViewById(R.id.et_lokasi);
        etTeks = findViewById(R.id.et_text);
        btnBukaWebsite = findViewById(R.id.btn_buka_website);
        btnBukaLokasi = findViewById(R.id.btn_buka_lokasi);
        btnBagikanTeks = findViewById(R.id.btn_bagikan_teks);

        btnBukaWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWebsite = etUrl.getText().toString();
                Uri urigetWebsite = Uri.parse(getWebsite);
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, urigetWebsite);
                try {
                    startActivity(intentWebsite);
                }catch (Exception e){
                    etUrl.setError("Url Tidak Sesuai!");
                }
            }
        });

        btnBukaLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLokasi = etLokasi.getText().toString();

                Uri location = Uri.parse("geo:0,0?q=" + getLokasi);
                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW, location);
                startActivity(bukaLokasi);
            }
        });

        btnBagikanTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTeks = etTeks.getText().toString();
                String mimeType = "text/plain";
                new ShareCompat.IntentBuilder(MainActivity.this).setType(mimeType).setChooserTitle("Bagikan Teks ini").setText(getTeks).startChooser();
            }
        });
    }
}