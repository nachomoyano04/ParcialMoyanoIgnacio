package com.example.parcialmoyanoignacio.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.parcialmoyanoignacio.MainActivity;
import com.example.parcialmoyanoignacio.model.Auto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Auto>> mLista;

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Auto>> getMLista(){
        if(mLista == null){
            mLista = new MutableLiveData<>();
        }
        return mLista;
    }

    public void llenarLista(){
        ArrayList<Auto> listaAutos = MainActivity.listaAutos;
        Collections.sort(listaAutos, new Comparator<Auto>() {
            @Override
            public int compare(Auto a1, Auto a2) {
                Double precio1 = parsePrecio(a1.getPrecio());
                Double precio2 = parsePrecio(a2.getPrecio());

                return Double.compare(precio2, precio1);
            }

            private Double parsePrecio(String precio) {
                if (precio == null || precio.isEmpty()) {
                    return Double.NaN;
                }
                try {
                    return Double.parseDouble(precio);
                } catch (NumberFormatException e) {
                    return Double.NaN;
                }
            }
        });
        mLista.setValue(MainActivity.listaAutos);
    }

}