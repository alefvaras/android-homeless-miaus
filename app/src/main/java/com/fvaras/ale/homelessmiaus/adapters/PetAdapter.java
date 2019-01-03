package com.fvaras.ale.homelessmiaus.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.db.BdHelper;
import com.fvaras.ale.homelessmiaus.model.Pet;
import com.fvaras.ale.homelessmiaus.view.DetailsPet;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 19/04/16.
 */
public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{

   private ArrayList<Pet> pets;
    private Context context;

    public PetAdapter(ArrayList<Pet> pets, Context context) {
        this.pets= pets;
        this.context = context;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);

        return new PetViewHolder(v);
    }



    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {
        final Pet pet = pets.get(position);
        holder.imgAvatar.setImageResource(pet.getAvatar());
        holder.tvNomPet.setText(pet.getNom());
        holder.tvsexPet.setText(pet.getSex());
        holder.likeNumberCard.setText(String.valueOf(pet.getLikes()) + " " + context.getString(R.string.likenumbercard_card));


        
        holder.imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, pet.getNom(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailsPet.class);
                intent.putExtra("nombre", pet.getNom());
                intent.putExtra("sexo", pet.getSex());
                intent.putExtra("descripcion", pet.getDescription());
                intent.putExtra("edad", pet.getAge());
                context.startActivity(intent);

            }
        });

        holder.likeCheckCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Diste like a " + pet.getNom(),
                        Toast.LENGTH_SHORT).show();

                BdHelper bdHelper = new BdHelper(context);
                bdHelper.saveLikesPet(pet);

                holder.likeNumberCard.setText(String.valueOf(bdHelper.getLikesPet(pet)+" "+context.getString(R.string.likenumbercard_card)) );


            }
        });


    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgAvatar;
        private TextView tvNomPet;
        private TextView tvsexPet;
        private CheckBox likeCheckCard;
        private TextView likeNumberCard;

        public PetViewHolder(View itemView) {
            super(itemView);

            imgAvatar    = (ImageView) itemView.findViewById(R.id.avatarPetCard);
            tvNomPet     = (TextView) itemView.findViewById(R.id.tvNamePetCard);
            tvsexPet     = (TextView) itemView.findViewById(R.id.tvSexPetCard);
            likeCheckCard   = (CheckBox) itemView.findViewById(R.id.likeCheckCard);
           likeNumberCard     = (TextView) itemView.findViewById(R.id.likeNumberCard);

        }
    }
}
