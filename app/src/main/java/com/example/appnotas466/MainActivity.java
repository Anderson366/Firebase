package com.example.appnotas466;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.appnotas466.adapters.AlunoAdapter;
import com.example.appnotas466.modelos.Aluno;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAlunos;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding
        rvAlunos = findViewById(R.id.rv_alunos);
        firestore = FirebaseFirestore.getInstance();
    }
    // chamado sempre que a tela é exibida
    @Override
    protected void onResume() {
        super.onResume();
        carregarDadosDoFirestore();
    }
    // Será chamado após o carregar
    private void atualizarListagemAlunos(List<Aluno> alunos){
        AlunoAdapter adapter = new AlunoAdapter(alunos, this);
        rvAlunos.setAdapter(adapter);
        rvAlunos.setLayoutManager(new LinearLayoutManager(this));
    }
    private void carregarDadosDoFirestore() {
        // TODO: buscas dados no banco de dados
        final List<Aluno> alunos = new ArrayList<>();
        firestore.collection("alunos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()){
                    for (DocumentSnapshot documentSnapshot:task.getResult()){
                        Aluno aluno = documentSnapshot.toObject(Aluno.class);
                        alunos.add(aluno);
                    }
                    atualizarListagemAlunos(alunos);
                }
            }
        });
    }
}

