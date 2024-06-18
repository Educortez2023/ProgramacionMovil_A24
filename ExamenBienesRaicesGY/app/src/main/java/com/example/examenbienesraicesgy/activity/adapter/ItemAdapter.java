package com.example.examenbienesraicesgy.activity.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenbienesraicesgy.R;
import com.example.examenbienesraicesgy.entity.BienesRaiceseEntity;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    List<BienesRaiceseEntity> lstBienesRaices;

    Activity _activity;

    public ItemAdapter(List<BienesRaiceseEntity> lstBienesRaices, Activity _activity) {
        this.lstBienesRaices = lstBienesRaices;
        this._activity = _activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bienes_layout,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Holder, int position) {
        BienesRaiceseEntity bienesRaicese =lstBienesRaices.get(position);
        Holder.descripcion.setText(bienesRaicese.getObservacion());
        Holder.precio.setText(bienesRaicese.getPrecio());

    }

    @Override
    public int getItemCount() {
        return lstBienesRaices.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView elementoImagen;
        TextView descripcion;
        TextView precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elementoImagen=itemView.findViewById(R.id.imgRecurso);
            descripcion=itemView.findViewById(R.id.txtDescripcion);
            precio = itemView.findViewById(R.id.txtPrecio);
        }
    }
}
