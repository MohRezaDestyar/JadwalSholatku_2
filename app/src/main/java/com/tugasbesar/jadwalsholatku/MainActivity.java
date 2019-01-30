package com.tugasbesar.jadwalsholatku;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tugasbesar.jadwalsholatku.api.ApiService;
import com.tugasbesar.jadwalsholatku.api.ApiUrl;
import com.tugasbesar.jadwalsholatku.model.ModelJadwal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//menampilkan jadwal solatnya
public class MainActivity extends AppCompatActivity {

    private TextView tv_lokasi_value, tv_fajr_value, tv_shurooq_value,
            tv_dhuhr_value, tv_asr_value, tv_maghrib_value, tv_isha_value;
    private FloatingActionButton fab_refresh;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Jadwal Sholat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_lokasi_value = findViewById(R.id.tv_lokasi_value); // memanggil nama id yang ada di xml main activitynya
        tv_fajr_value = findViewById(R.id.tv_fajr_value); // memanggil nama id yang ada di xml main activitynya
        tv_shurooq_value = findViewById(R.id.tv_shurooq_value); // memanggil nama id yang ada di xml main activitynya
        tv_dhuhr_value = findViewById(R.id.tv_dhuhr_value); // memanggil nama id yang ada di xml main activitynya
        tv_asr_value = findViewById(R.id.tv_asr_value); // memanggil nama id yang ada di xml main activitynya
        tv_maghrib_value = findViewById(R.id.tv_maghrib_value);
        tv_isha_value = findViewById(R.id.tv_isha_value);
        fab_refresh = findViewById(R.id.fab_refresh); //ketika internet mati atau jaringan buruk kita bisa merefreshnya

        getJadwal();
        fab_refresh.setOnClickListener(new View.OnClickListener() { //memanggil kembali jadwal setelah di refresh
            @Override
            public void onClick(View view) {
                getJadwal();
            }
        });
    }

    //memnggil atribut kepada menu home
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //memunculkan jadwal sholatnya
    private void getJadwal () {

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait / Silahkan tunggu ...");
        progressDialog.show();

        //memanggil apiURLnya
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_ROOT_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ModelJadwal> call = apiService.getJadwal();

        call.enqueue(new Callback<ModelJadwal>() {

            //memanggil class modeljadwal
            @Override
            public void onResponse(Call<ModelJadwal> call, Response<ModelJadwal> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    tv_lokasi_value.setText(response.body().getCity()+", "+response.body().getItems().get(0).getDateFor());
                    tv_fajr_value.setText(response.body().getItems().get(0).getFajr());
                    tv_shurooq_value.setText(response.body().getItems().get(0).getShurooq());
                    tv_dhuhr_value.setText(response.body().getItems().get(0).getDhuhr());
                    tv_asr_value.setText(response.body().getItems().get(0).getAsr());
                    tv_maghrib_value.setText(response.body().getItems().get(0).getMaghrib());
                    tv_isha_value.setText(response.body().getItems().get(0).getIsha());

                } else {

                }
            }

            //memunculkan teks jika tidak ada koneksi internet
            @Override
            public void onFailure(Call<ModelJadwal> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Sorry, please try again... server Down..", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
