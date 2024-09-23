package com.example.parcialmoyanoignacio.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcialmoyanoignacio.R;
import com.example.parcialmoyanoignacio.model.Auto;

import java.util.ArrayList;

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.ViewHolderAuto> {
    private ArrayList<Auto> autos = new ArrayList<>();
    private LayoutInflater li;

    public AutoAdapter(ArrayList<Auto> autos, LayoutInflater li) {
        this.autos = autos;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderAuto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderAuto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAuto holder, int position) {
        Auto a = autos.get(position);
        holder.tvPatente.setText(a.getPatente());
        holder.tvMarca.setText(a.getMarca());
        holder.tvModelo.setText(a.getModelo());
        holder.tvPrecio.setText("$"+a.getPrecio());
    }

    @Override
    public int getItemCount() {
        return autos.size();
    }

    public class ViewHolderAuto extends RecyclerView.ViewHolder{
        TextView tvPatente, tvMarca, tvModelo, tvPrecio;

        public ViewHolderAuto(@NonNull View itemView) {
            super(itemView);
            tvPatente = itemView.findViewById(R.id.tvPatente);
            tvMarca = itemView.findViewById(R.id.tvMarca);
            tvModelo = itemView.findViewById(R.id.tvModelo);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}
