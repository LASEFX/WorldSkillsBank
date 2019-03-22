package com.example.karim.bank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Valutes extends AppCompatActivity {

    TextView valutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valutes);
        setTitle("Валюта");

        valutes = findViewById(R.id.valutes);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.areas.su/" )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlace jsonPlace = retrofit.create(JsonPlace.class);

        Call<List<Get1>> call = jsonPlace.getPops();
        call.enqueue(new Callback<List<Get1>>() {
            @Override
            public void onResponse(Call<List<Get1>> call, Response<List<Get1>> response) {
                if (!response.isSuccessful()){
                    valutes.setText("Code:" + response.code());
                    return;

                }

                List<Get1> getz = response.body();

                for (Get1 get: getz){
                    String content = "";
                    content += "id:" + get.getId() + "\n";
                    content += "Адресс:" + get.getCharcode() + "\n";
                    content += "Тип:" + get.getName()  + "\n";
                    content += "ШИрина:" + get.getSell()  + "\n";
                    content += "Долгота:" + get.getBuy()+ "\n";
                    content += "С:" + get.getSell() + "\n";
                    content += "До:" + get.getDate()+"\n";
                    content +=  "----------------------------------" + "\n\n\n";


                    valutes.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Get1>> call, Throwable t) {
                valutes.setText(t.getMessage());
            }
        });
    }
}
