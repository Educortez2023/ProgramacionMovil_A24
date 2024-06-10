package com.example.bienesraicesgye;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DepartamentoAdapter extends RecyclerView.Adapter<DepartamentoAdapter.DepartmentViewHolder> {

    private List<Departamento> departmentList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Departamento department);
    }

    public DepartamentoAdapter(List<Departamento> departmentList, OnItemClickListener listener) {
        this.departmentList = departmentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_department, parent, false);
        return new DepartmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        Departamento department = departmentList.get(position);
        holder.bind(department, listener);
    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    public static class DepartmentViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivDepartmentImage;
        private TextView tvDepartmentName;
        private TextView tvDepartmentPrice;

        public DepartmentViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDepartmentImage = itemView.findViewById(R.id.ivDepartmentImage);
            tvDepartmentName = itemView.findViewById(R.id.tvDepartmentName);
            tvDepartmentPrice = itemView.findViewById(R.id.tvDepartmentPrice);
        }

        public void bind(final Departamento department, final OnItemClickListener listener) {
            tvDepartmentName.setText(department.getName());
            tvDepartmentPrice.setText(department.getPrice());

            // Set image if available
            if (department.getImage() != null) {
                ivDepartmentImage.setImageBitmap(department.getImage());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(department);
                }
            });
        }
    }
}
