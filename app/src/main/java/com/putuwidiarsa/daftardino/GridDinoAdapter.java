package com.putuwidiarsa.daftardino;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridDinoAdapter extends RecyclerView.Adapter<GridDinoAdapter.GridViewHolder> {

    private ArrayList<Dino> listDino;
    private Context context;

    public GridDinoAdapter(ArrayList<Dino> list) {
        this.listDino = list;
    }

    public GridDinoAdapter(Context context){
        this.context = context;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView dinoName;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.dino_img);
            dinoName = itemView.findViewById(R.id.tv_dino_name);
        }
    }

/*    public interface OnItemClickCallback {
        void onItemClicked(Dino data);
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }*/

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_dino, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder gridViewHolder, int i) {
        final String dinoName = listDino.get(i).getName();
        final String dinoDesc = listDino.get(i).getDescription();
        final String dinoHeight = listDino.get(i).getHeight();
        final String dinoWeight = listDino.get(i).getWeight();
        final String dinoFacts = listDino.get(i).getFacts();
        final String dinoImg = listDino.get(i).getImg();

        gridViewHolder.dinoName.setText(listDino.get(i).getName());

        Glide.with(gridViewHolder.itemView.getContext())
                .load(listDino.get(i).getImg())
                .apply(new RequestOptions().override(200))
                .into(gridViewHolder.imgPhoto);

        gridViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
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
                //Toast.makeText(gridViewHolder.itemView.getContext(), "Kamu memilih " + listDino.get(gridViewHolder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDino.size();
    }
}
