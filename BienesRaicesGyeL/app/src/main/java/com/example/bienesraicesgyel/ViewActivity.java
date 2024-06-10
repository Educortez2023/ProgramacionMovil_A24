package com.example.bienesraicesgyel;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DepartmentAdapter adapter;
    private List<Department> departmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        departmentList = new ArrayList<>();
        adapter = new DepartmentAdapter(departmentList, new DepartmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Department department) {
                Intent intent = new Intent(ViewActivity.this, DetailActivity.class);
                intent.putExtra("department", (CharSequence) department);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        loadDepartments();
    }

    private void loadDepartments() {
        // Agregar datos de prueba
        departmentList.add(new Department("Departamento 1", "2000", null));
        departmentList.add(new Department("Departamento 2", "2500", null));
        adapter.notifyDataSetChanged();
    }
}
