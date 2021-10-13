package com.example.myfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends Fragment implements AdapterView.OnItemClickListener {

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Inisialisasi variabel array listmenu
        String[] listmenu = {"Avocado Original", "Avocado Coklat", "Boba Matcha", "Brown Sugar", "Cendol Mango", "Durian Kocok"};
        //Variabel untuk list view
        ListView listViewMenu = (ListView) view.findViewById(R.id.listView);
        //Menentukan layout untuk adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listmenu);

        listViewMenu.setAdapter(adapter);
        //Membuat click listener untuk item-item list view agar dapat di klik
        listViewMenu.setOnItemClickListener(this);
    }

        //Untuk membuat toast ketika list view di klik
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) return;
        Toast.makeText(getActivity(), "Menu yang dipilih " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}