package com.fvaras.ale.homelessmiaus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.fvaras.ale.homelessmiaus.model.Contact;
import com.fvaras.ale.homelessmiaus.model.Pet;
import com.fvaras.ale.homelessmiaus.model.Provider;


import java.util.ArrayList;

/**
 * Created by Alejandro on 18-10-2017.
 */

public class BdHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MiBase4.db";
    public static final int DATABASE_VERSION = 1;
    private static final int LIKE = 1;
    private Context context;


    public BdHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ContactContract.SQL_CREATE_ENTRIES_CONTACTS);
        db.execSQL(PetContract.SQL_CREATE_ENTRIES_PETS);
        db.execSQL(ProviderContract.SQL_CREATE_ENTRIES_PROVIDERS);
        db.execSQL(PetContract.SQL_CREATE_ENTRIES_LIKES_PETS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(ContactContract.SQL_DELETE_TABLE_CONTACTS);
        db.execSQL(PetContract.SQL_DELETE_TABLE_PETS);
        db.execSQL(PetContract.SQL_DELETE_TABLE_LIKES_PETS);
        db.execSQL(ProviderContract.SQL_DELETE_TABLE_PROVIDERS);
        onCreate(db);
    }

    public void saveContact(Contact contact) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ContactContract.TABLE_CONTACTS_NOMBRE, contact.getNom());
        values.put(ContactContract.TABLE_CONTACTS_EMAIL, contact.getEmail());
        values.put(ContactContract.TABLE_CONTACTS_TELEFONO, contact.getPhone());
        values.put(ContactContract.TABLE_CONTACTS_PASSWORD, contact.getPassword());

        //clave primaria introducirla
        //Insertar la nueva fila, devolviendo el valor de la clave principal de la nueva fila
        long newRowId = db.insert(ContactContract.TABLE_CONTACTS, null, values);
        if (newRowId != -1) {
            Toast.makeText(context, "Bienvenido " + contact.getNom() + " ID: " + newRowId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error" + newRowId, Toast.LENGTH_SHORT).show();
        }
        db.close();


    }
    public void saveProvider(Provider provider) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ProviderContract.TABLE_PROVIDERS_NOMBRE_EMPRESA, provider.getNomBusiness());
        values.put(ProviderContract.TABLE_PROVIDERS_EMAIL, provider.getEmail());
        values.put(ProviderContract.TABLE_PROVIDERS_GIRO, provider.getTurn());
        values.put(ProviderContract.TABLE_PROVIDERS_RAZONSOCIAL, provider.getRazonSocial());
        values.put(ProviderContract.TABLE_PROVIDERS_TELEFONO, provider.getPhone());
        values.put(ProviderContract.TABLE_PROVIDERS_DIRECCION, provider.getAddress());

        //clave primaria introducirla
        //Insertar la nueva fila, devolviendo el valor de la clave principal de la nueva fila
        long newRowId = db.insert(ProviderContract.TABLE_PROVIDERS, null, values);
        if (newRowId != -1) {
            Toast.makeText(context, "Bienvenido " + provider.getNomBusiness() + " ID: " + newRowId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error" + newRowId, Toast.LENGTH_SHORT).show();
        }
        db.close();

    }


    public void savePet(Pet pet) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PetContract.TABLE_PETS_NOMBRE, pet.getNom());
        values.put(PetContract.TABLE_PETS_SEXO, pet.getSex());
        values.put(PetContract.TABLE_PETS_AGE, pet.getAge());
        values.put(PetContract.TABLE_PETS_DESCRIPCION, pet.getDescription());
        values.put(PetContract.TABLE_PETS_FOTO, pet.getAvatar());


        //clave primaria introducirla
        //Insertar la nueva fila, devolviendo el valor de la clave principal de la nueva fila
        long newRowId = db.insert(PetContract.TABLE_PETS, null, values);
        if (newRowId != -1) {
            Toast.makeText(context, "Bienvenido " + pet.getNom() + " ID: " + newRowId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error" + newRowId, Toast.LENGTH_SHORT).show();
        }
        db.close();


    }

    public void saveLikesPet(Pet pet) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PetContract.TABLE_LIKES_PETS_ID_PET, pet.getId());
        contentValues.put(PetContract.TABLE_LIKES_PETS_NUMERO_LIKES, LIKE);

        long newRowId = db.insert(PetContract.TABLE_LIKES_PETS, null, contentValues);

        db.close();
    }

    public void deleteContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = ContactContract.TABLE_CONTACTS_ID + " LIKE ?";
        String[] selecionArgs = {String.valueOf(id)};
        //int cant = bd.delete("usuario", "dni=" + dni, null);
        int cant = db.delete(ContactContract.TABLE_CONTACTS, selection, selecionArgs);
        if (cant == 1) {
            Toast.makeText(context, "Usuario eliminado", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "No existe usuario", Toast.LENGTH_SHORT).show();

        }
        db.close();

    }

    public void deleteProvider(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = PetContract.TABLE_PETS_ID + " LIKE ?";
        String[] selecionArgs = {String.valueOf(id)};
        //int cant = bd.delete("usuario", "dni=" + dni, null);
        int cant = db.delete(PetContract.TABLE_PETS, selection, selecionArgs);
        if (cant == 1) {
            Toast.makeText(context, "Proveedor eliminado", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "No existe proveedor", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }


    public void deletePet(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = PetContract.TABLE_PETS_ID + " LIKE ?";
        String[] selecionArgs = {String.valueOf(id)};
        //int cant = bd.delete("usuario", "dni=" + dni, null);
        int cant = db.delete(PetContract.TABLE_PETS, selection, selecionArgs);
        if (cant == 1) {
            Toast.makeText(context, "Mascota eliminado", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "Mascota no existe en la base de datos", Toast.LENGTH_SHORT).show();

        }
        db.close();


    }


    public Contact getContact(int id) {

        Contact contact = new Contact();
        SQLiteDatabase db = this.getReadableDatabase();
        String querySearch = "SELECT * FROM " + ContactContract.TABLE_CONTACTS + " WHERE " + ContactContract.TABLE_CONTACTS_ID + "=" + id;
        Cursor cursor = db.rawQuery(querySearch, null);
        if (cursor.moveToFirst()) {

            contact.setId(cursor.getInt(0));
            contact.setNom(cursor.getString(1));
            contact.setPhone(cursor.getString(2));
            contact.setEmail(cursor.getString(3));
            contact.setPassword(cursor.getString(4));


        } else {
            Toast.makeText(context, "No se encontro registo", Toast.LENGTH_LONG).show();
        }
        db.close();

        return contact;
    }

    public Provider getProvider(int id) {

        Provider provider = new Provider();
        SQLiteDatabase db = this.getReadableDatabase();
        String querySearch = "SELECT * FROM " + ProviderContract.TABLE_PROVIDERS + " WHERE " +ProviderContract.TABLE_PROVIDERS_ID + "=" + id;
        Cursor cursor = db.rawQuery(querySearch, null);
        if (cursor.moveToFirst()) {

            provider.setId(cursor.getInt(0));
            provider.setNomBusiness(cursor.getString(1));
            provider.setPhone(cursor.getString(2));
            provider.setEmail(cursor.getString(3));
            provider.setTurn(cursor.getString(4));
            provider.setRazonSocial(cursor.getString(5));
            provider.setAddress(cursor.getString(6));


        } else {
            Toast.makeText(context, "No se encontro registo", Toast.LENGTH_LONG).show();
        }
        db.close();

        return provider;
    }


    public boolean isAcountExists(String email, String password) {
        String[] columns = {
               ContactContract.TABLE_CONTACTS_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = ContactContract.TABLE_CONTACTS_EMAIL  + " = ?" + " AND " + ContactContract.TABLE_CONTACTS_PASSWORD + " = ?";

    // selection arguments
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(ContactContract.TABLE_CONTACTS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            Toast.makeText(context, "Bienvenido", Toast.LENGTH_LONG).show();
            return true;
        }else{
            Toast.makeText(context, "No se encontro registo", Toast.LENGTH_LONG).show();
            return false;
        }




    }


    public Pet getPet(int id) {


        Pet pet = new Pet();
        SQLiteDatabase db = this.getReadableDatabase();
        String querySearch = "SELECT * FROM " + PetContract.TABLE_PETS + " WHERE " + PetContract.TABLE_PETS_ID + "=" + id;
        Cursor cursor = db.rawQuery(querySearch, null);
        if (cursor.moveToFirst()) {

            pet.setId(cursor.getInt(0));
            pet.setNom(cursor.getString(1));
            pet.setSex(cursor.getString(2));
            pet.setAge(cursor.getString(3));
            pet.setDescription(cursor.getString(4));
            pet.setAvatar(cursor.getInt(5));


        } else {
            Toast.makeText(context, "No se encontro registo", Toast.LENGTH_LONG).show();
        }
        db.close();

        return pet;
    }

    public void updateContact(Contact contact) {

        SQLiteDatabase db = this.getWritableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ContactContract.TABLE_CONTACTS_NOMBRE, contact.getNom());
        values.put(ContactContract.TABLE_CONTACTS_EMAIL, contact.getEmail());
        values.put(ContactContract.TABLE_CONTACTS_TELEFONO, contact.getPhone());
        values.put(ContactContract.TABLE_CONTACTS_PASSWORD, contact.getPassword());


// Which row to update, based on the title
        String selection = ContactContract.TABLE_CONTACTS_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(contact.getId())};

        int count = db.update(
                ContactContract.TABLE_CONTACTS,
                values,
                selection,
                selectionArgs);

        if (count == 1) {
            Toast.makeText(context, "Registro actualizado", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "No Registro actualizado", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }

    public void updateProvider(Provider provider) {

        SQLiteDatabase db = this.getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(ProviderContract.TABLE_PROVIDERS_NOMBRE_EMPRESA, provider.getNomBusiness());
        values.put(ProviderContract.TABLE_PROVIDERS_EMAIL, provider.getEmail());
        values.put(ProviderContract.TABLE_PROVIDERS_GIRO, provider.getPhone());
        values.put(ProviderContract.TABLE_PROVIDERS_RAZONSOCIAL, provider.getRazonSocial());
        values.put(ProviderContract.TABLE_PROVIDERS_TELEFONO, provider.getPhone());
        values.put(ProviderContract.TABLE_PROVIDERS_DIRECCION, provider.getAddress());

        // Which row to update, based on the title
        String selection = ProviderContract.TABLE_PROVIDERS_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(provider.getId())};

        int count = db.update(
                ProviderContract.TABLE_PROVIDERS,
                values,
                selection,
                selectionArgs);

        if (count == 1) {
            Toast.makeText(context, "Registro actualizado", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "No Registro actualizado", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }
    public void updatePet(Pet pet) {

        SQLiteDatabase db = this.getWritableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(PetContract.TABLE_PETS_NOMBRE, pet.getNom());
        values.put(PetContract.TABLE_PETS_SEXO, pet.getSex());
        values.put(PetContract.TABLE_PETS_AGE, pet.getAge());
        values.put(PetContract.TABLE_PETS_DESCRIPCION, pet.getDescription());
        //values.put(PetContract.TABLE_PETS_FOTO, pet.getAvatar());


// Which row to update, based on the title
        String selection = PetContract.TABLE_PETS_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(pet.getId())};

        int count = db.update(
                PetContract.TABLE_PETS,
                values,
                selection,
                selectionArgs);

        if (count == 1) {
            Toast.makeText(context, "Registro actualizado", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "No Registro actualizado", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }

    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM " + ContactContract.TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);//segundo argumento filtro

        while (cursor.moveToNext()) {
            Contact contact = new Contact();

            contact.setId(cursor.getInt(0));
            contact.setNom(cursor.getString(1));
            contact.setPhone(cursor.getString(2));
            contact.setEmail(cursor.getString(3));
            contact.setPassword(cursor.getString(4));


            contacts.add(contact);
        }

        db.close();
        return contacts;
    }

    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM " + PetContract.TABLE_PETS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);//segundo argumento filtro

        while (cursor.moveToNext()) {
            Pet pet = new Pet();

            pet.setId(cursor.getInt(0));
            pet.setNom(cursor.getString(1));
            pet.setSex(cursor.getString(2));
            pet.setAge(cursor.getString(3));
            pet.setDescription(cursor.getString(4));
            pet.setAvatar(cursor.getInt(5));

            String queryLikes = "SELECT COUNT(" + PetContract.TABLE_LIKES_PETS_NUMERO_LIKES + ") as likes " +
                    " FROM " + PetContract.TABLE_LIKES_PETS +
                    " WHERE " + PetContract.TABLE_LIKES_PETS_ID_PET + "=" + pet.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()) {
                pet.setLikes(registrosLikes.getInt(0));
            } else {
                pet.setLikes(0);
            }

            pets.add(pet);
        }

        db.close();
        return pets;
    }


    public int getLikesPet(Pet pet) {
        int likes = 0;

        String query = "SELECT COUNT(" + PetContract.TABLE_LIKES_PETS_NUMERO_LIKES + ")" +
                " FROM " + PetContract.TABLE_LIKES_PETS +
                " WHERE " + PetContract.TABLE_LIKES_PETS_ID_PET + "=" + pet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToNext()) {
            likes = cursor.getInt(0);
        }

        db.close();

        return likes;
    }

}
