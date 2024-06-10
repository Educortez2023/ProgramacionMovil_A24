package com.example.bienesraicesgye;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DepartamentoAdapter adapter;
    private List<Departamento> departmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize departmentList and adapter
        departmentList = new ArrayList<>();
        adapter = new DepartamentoAdapter(departmentList, new DepartamentoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Departamento department) {
                Intent intent = new Intent(ViewActivity.this, ActivityDetail.class);
                intent.putExtra("department", department);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        // Load departments from your database or backend
        loadDepartments();
    }

    private void loadDepartments() {
        // Add mock data for testing
        departmentList.add(new Departamento("Departamento 1", "2000", null));
        departmentList.add(new Departamento("Departamento 2", "2500", null));
        adapter.notifyDataSetChanged();
    }
}
