package com.example.parcialmoyanoignacio.ui.cargar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.parcialmoyanoignacio.MainActivity;
import com.example.parcialmoyanoignacio.model.Auto;

public class CargarViewModel extends AndroidViewModel {

    public MutableLiveData<Boolean> mVerificado = new MutableLiveData<>();

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getMVerificado(){
        if(mVerificado == null){
            mVerificado = new MutableLiveData<>();
        }
        return mVerificado;
    }

    public void verificarAuto(Auto a){
        if(!(a.getPatente().isEmpty() || a.getMarca().isEmpty() || a.getModelo().isEmpty() || a.getPrecio().isEmpty())){
            boolean verificado = true;
            for(Auto auto: MainActivity.listaAutos){
                if(auto.getPatente().equalsIgnoreCase(a.getPatente())){
                    verificado = false;
                }
            }
            if(verificado){
                Toast.makeText(getApplication(), "Auto guardado con éxito", Toast.LENGTH_SHORT).show();
                mVerificado.setValue(true);
            }else{
                Toast.makeText(getApplication(), "La patente ya existe", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplication(), "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}