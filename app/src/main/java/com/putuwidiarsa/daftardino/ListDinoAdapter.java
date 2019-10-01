package com.putuwidiarsa.daftardino;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListDinoAdapter extends RecyclerView.Adapter<ListDinoAdapter.ListViewHolder> {
    private ArrayList<Dino> listDino;

    public ListDinoAdapter(ArrayList<Dino> list){
        this.listDino = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_dino, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        final String dinoName = listDino.get(i).getName();
        final String dinoDesc = listDino.get(i).getDescription();
        final String dinoHeight = listDino.get(i).getHeight();
        final String dinoWeight = listDino.get(i).getWeight();
        final String dinoFacts = listDino.get(i).getFacts();
        final String dinoImg = listDino.get(i).getImg();

        Dino dino = listDino.get(i);
        listViewHolder.dinoName.setText(listDino.get(i).getName() + " - Klik gambar untuk detail");
        Glide.with(listViewHolder.itemView.getContext())
                .load(dino.getImg())
                .apply(new RequestOptions().override(200))
                .into(listViewHolder.imgPhoto);

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent dinoDetailIntent = new Intent(view.getContext(), DinoDetailActivity.class);
                dinoDetailIntent.putExtra(DinoDetailActivity.DINO_IMG, dinoImg);
                dinoDetailIntent.putExtra(DinoDetailActivity.DINO_NAME, dinoName);
                dinoDetailIntent.putExtra(DinoDetailActivity.DINO_DESC, dinoDesc);
                dinoDetailIntent.putExtra(DinoDetailActivity.DINO_HEIGHT, dinoHeight);
                dinoDetailIntent.putExtra(DinoDetailActivity.DINO_WEIGHT, dinoWeight);
                dinoDetailIntent.putExtra(DinoDetailActivity.DINO_FACTS, dinoFacts);

                view.getContext().startActivity(dinoDetailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDino.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView dinoName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.dino_img);
            dinoName = itemView.findViewById(R.id.tv_dino_name);
        }
    }
}
