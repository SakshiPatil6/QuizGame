package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    public static ArrayList<Modal> list_of_que;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_of_que=new ArrayList<>();
        list_of_que.add(new Modal("The chief purpose of crop rotation is to check the loss of top soil", "by water erosion", "by wind erosion","by weathering", "of its mineral content", "of its mineral content"));
        list_of_que.add(new Modal("In which year of First World War Germany declared war on Russia and France?","1914", "1915", "1916", "1917" ,"1914"));
        list_of_que.add(new Modal("ICAO stands for", "International Civil Aviation Organization","Indian Corporation of Agriculture Organization","Institute of Company Account Organisation", "None of the above", "International Civil Aviation Organization"));
        list_of_que.add(new Modal("India has largest deposits of ____ in the world.", "gold", "copper", "mica", "None of the above", "mica"));
        list_of_que.add(new Modal("How many Lok Sabha seats belong to Rajasthan?", "32", "25", "13", "17", "25"));
        list_of_que.add(new Modal("With which sport is the Jules Rimet trophy associated?", "Basketball", "Football", "Hockey", "Golf","Football"));
        list_of_que.add(new Modal("Joule is the unit of?", "Temperature", "Pressure", "energy", "heat","energy"));
        list_of_que.add(new Modal("Philology is the ", "study of bones", "study of muscles", "study of architecture", "science of languages", "science of languages"));
        list_of_que.add(new Modal("The 'Black flag' signifies", "revolution/danger", "peace", "protest", "truce", "protest"));
        list_of_que.add(new Modal("The chief constituent of gobar gas is", "methane", "ethane", "hydrogen", "carbon dioxide", "methane"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,DashBoard.class);
                startActivity(i);
            }
        },2000);
    }
}