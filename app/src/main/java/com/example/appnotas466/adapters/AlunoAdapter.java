package com.example.appnotas466.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appnotas466.R;
import com.example.appnotas466.modelos.Aluno;

import java.util.List;
// 3°
public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder> {

    // 2°
    private List<Aluno> alunos;
    private Context context;

    public AlunoAdapter(List<Aluno> alunos, Context context) {
        this.alunos = alunos;
        this.context = context;
    }

    // 4°
    @NonNull
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup,false);
        return new AlunoViewHolder(view);
    }

    public void onBindViewHolder(@NonNull AlunoViewHolder alunoViewHolder, int pos) {
        Aluno aluno = alunos.get(pos);
        alunoViewHolder.txtAlunoNome.setText(aluno.getNome());
    }

    public int getItemCount() {
        return this.alunos.size();
    }

    // 1°
    // Representa o item
    class AlunoViewHolder extends RecyclerView.ViewHolder{
        TextView txtAlunoNome, txtAlunoNota1, txtAlunoNota2, txtAlunoMedia, txtAlunoSituacao;

        public AlunoViewHolder(@NonNull View itemView) {
            super(itemView);

            // binding
            txtAlunoNome = itemView.findViewById(R.id.txt_aluno_nome);
            txtAlunoNota1 = itemView.findViewById(R.id.txt_aluno_nota1);
            txtAlunoNota2 = itemView.findViewById(R.id.txt_aluno_nota2);
            txtAlunoMedia = itemView.findViewById(R.id.txt_aluno_media);
            txtAlunoSituacao = itemView.findViewById(R.id.txt_aluno_situacao);
        }
    }
}
