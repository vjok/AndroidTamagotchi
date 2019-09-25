package com.example.androidtamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Tamagotchi.TamagotchiInterface {

    ListView listView;
    public ArrayList<Tamagotchi> tamagotchis = new ArrayList<Tamagotchi>();
    int index = 0;
    TamagotchiArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lw);
        createTamagotchis();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Tamagotchi feedTamagotchi = tamagotchis.get(position);
                if(feedTamagotchi.feed()){
                    //System.out.println("Tamagotchi " + feedTamagotchi.getID() +" fed");
                    //updateConsole();
                } else {
                    System.out.println("This tamagotchi is already dead");
                }
            }
        });
    }


    public void createTamagotchis() {
        for(int i = 0; i < 5; i++) {
            Tamagotchi newTamagotchi = new Tamagotchi(10, i, this);
            tamagotchis.add(newTamagotchi);
            newTamagotchi.start();
            adapter = new TamagotchiArrayAdapter(this, tamagotchis);
        }
    }


    public void TamagotchiStatus(Tamagotchi tamagotchi){
        tamagotchis.set(tamagotchi.getID(), tamagotchi);
        //System.out.println("Tamagotchi " + tamagotchi.getID() + " " + tamagotchi.getStatus() + tamagotchi.getFood());
        //  if( {
        //    updateConsole();
        //  }
        //
    }


    public void userInput(){
        int userInput = -1;

        while (true) {
            if(userInput > -1 && userInput < 10) {
                Tamagotchi feedTamagotchi = tamagotchis.get(userInput);
                if(feedTamagotchi.feed()){
                    System.out.println("Tamagotchi " + feedTamagotchi.getID() +" fed");
                    //updateConsole();
                } else {
                    System.out.println("This tamagotchi is already dead");
                }
            }
            //for(Tamagotchi t : tamagotchis)
            //System.out.println("Tamagotchi " + t.getID() + " " + t.getStatus() + t.getFood());

            //userInput = scanner.nextInt();
        }
    }

}
