package com.example.bienesraicesgye;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

class ActivityDetail extends AppCompatActivity {

    private ImageView ivDepartmentImage;
    private TextView tvDepartmentName;
    private TextView tvDepartmentPrice;
    private TextView tvDepartmentDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivDepartmentImage = findViewById(R.id.ivDepartmentImage);
        tvDepartmentName = findViewById(R.id.tvDepartmentName);
        tvDepartmentPrice = findViewById(R.id.tvDepartmentPrice);
        tvDepartmentDescription = findViewById(R.id.tvDepartmentDescription);

        // Get department from intent
        Departamento department = (Departamento) getIntent().getSerializableExtra("department");

        if (department != null) {
            tvDepartmentName.setText(department.getName());
            tvDepartmentPrice.setText(department.getPrice());
            tvDepartmentDescription.setText("Descripción del departamento aquí...");

            // Set image if available
            Bitmap image = department.getImage();
            if (image != null) {
                ivDepartmentImage.setImageBitmap(image);
            }
        }
    }
}
