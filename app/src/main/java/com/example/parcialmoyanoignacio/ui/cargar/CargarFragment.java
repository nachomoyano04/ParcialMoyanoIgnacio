package com.example.parcialmoyanoignacio.ui.cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.parcialmoyanoignacio.MainActivity;
import com.example.parcialmoyanoignacio.R;
import com.example.parcialmoyanoignacio.databinding.FragmentCargarBinding;
import com.example.parcialmoyanoignacio.model.Auto;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel.getMVerificado().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    String patente = binding.etPatente.getText().toString();
                    String marca = binding.etMarca.getText().toString();
                    String modelo = binding.etModelo.getText().toString();
                    String precio = binding.etPrecio.getText().toString();
                    binding.etPatente.setText("");
                    binding.etMarca.setText("");
                    binding.etModelo.setText("");
                    binding.etPrecio.setText("");
                    MainActivity.listaAutos.add(new Auto(patente, marca, modelo, precio));
                }
            }
        });
        binding.btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patente = binding.etPatente.getText().toString();
                String marca = binding.etMarca.getText().toString();
                String modelo = binding.etModelo.getText().toString();
                String precio = binding.etPrecio.getText().toString();
                mViewModel.verificarAuto(new Auto(patente, marca, modelo, precio));
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        // TODO: Use the ViewModel
    }

}