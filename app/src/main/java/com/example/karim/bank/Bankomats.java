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
import retrofit2.http.GET;

public class Bankomats extends AppCompatActivity {

    TextView bankomats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankomats);
        setTitle("Отделения");

        bankomats = findViewById(R.id.banks);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.areas.su/" )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlace jsonPlace = retrofit.create(JsonPlace.class);

        Call<List<Get>> call = jsonPlace.getPosts();
        call.enqueue(new Callback<List<Get>>() {
            @Override
            public void onResponse(Call<List<Get>> call, Response<List<Get>> response) {
                if (!response.isSuccessful()){
                    bankomats.setText("Code:" + response.code());
                    return;

                }

                List<Get> gets = response.body();

                for (Get get: gets){
                String content = "";
                content += "id:" + get.getId() + "\n";
                content += "Адресс:" + get.getAddress() + "\n";
                content += "Тип:" + get.getType()  + "\n";
                content += "ШИрина:" + get.getLat()  + "\n";
                content += "Долгота:" + get.getLon()+ "\n";
                content += "С:" + get.getHours_start() + "\n";
                content += "До:" + get.getHours_end()+"\n";
                content +=  "----------------------------------" + "\n\n\n";


                bankomats.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Get>> call, Throwable t) {
                bankomats.setText(t.getMessage());
            }
        });
        }
}
