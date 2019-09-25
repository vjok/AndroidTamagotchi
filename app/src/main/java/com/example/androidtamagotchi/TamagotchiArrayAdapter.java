package com.example.androidtamagotchi;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class TamagotchiArrayAdapter extends ArrayAdapter<Tamagotchi> {

    static final int VIEW_TYPE_COUNT = 1;
    static final int VIEW_TYPE= 2;

    public TamagotchiArrayAdapter(Context context, ArrayList<Tamagotchi> tamagotchis)
    {
        super(context,0,tamagotchis);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int position) {
        Tamagotchi tamagotchi = getItem(position);
        return VIEW_TYPE;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Tamagotchi tamagotchi = getItem(position);


        if(convertView == null) {
            int layoutid = 0;
            layoutid = R.layout.tamagotchi;
            convertView = LayoutInflater.from(getContext()).inflate(layoutid,parent,false);
        }

        //tänne luku
        //ToDoModel model = new ToDoModel(getContext());
        //ArrayList joo = model.getItemFromDb();
        TextView textViewID = convertView.findViewById(R.id.tvID);
        textViewID.setText(tamagotchi.getID());
        TextView textViewFood = convertView.findViewById(R.id.tvFood);
        textViewFood.setText(tamagotchi.getFood());
        return convertView;
    }
}
