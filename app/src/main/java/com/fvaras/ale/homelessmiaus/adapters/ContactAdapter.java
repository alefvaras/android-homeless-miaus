package com.fvaras.ale.homelessmiaus.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.model.Contact;
import com.fvaras.ale.homelessmiaus.view.DetailsContact;

import java.util.ArrayList;

/**
 * Created by Alejandro on 20-10-2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private     ArrayList<Contact> contacts;
    private Context context;

    public ContactAdapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context=context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflar o darle vida al cardview layout
        //para inflar se pasa un contextoel metodo inflate devuelve un view, y recibe una referencia, ultimo parameto puede ser un viwgroup
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contact, parent, false);
        //devuelvo el view inflado a la clase static
        return new ContactViewHolder(v);
    }




    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        // voy a setiar me llega como parametro una referencia a la clase statica y la posistion
        final Contact contact = contacts.get(position);//obtengo la posicion de cada elemento
        holder.imgAvatar.setImageResource(R.drawable.flash);//seteo la foto
        holder.tvNom.setText(contact.getNom());
        holder.tvPhone.setText(contact.getPhone());
        holder.tvEmail.setText(contact.getEmail());



//metodo al hacer click a la imagen
        holder.imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, contact.getNom(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailsContact.class);
                intent.putExtra("name", contact.getNom());
                intent.putExtra("phone", contact.getPhone());
                intent.putExtra("email", contact.getEmail());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene mi lista

        return contacts.size();
    }
//pasar los datos a la clase static, heredo y le paso como parametro la clase static


    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        //declarar mis views
        private ImageView imgAvatar;
        private TextView tvNom;
        private TextView tvPhone;
        private TextView tvEmail;


        public ContactViewHolder(View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.avatarUserCard);
            tvNom = (TextView) itemView.findViewById(R.id.tvNameCard);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhoneCard);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmailCard);


        }
    }
}
