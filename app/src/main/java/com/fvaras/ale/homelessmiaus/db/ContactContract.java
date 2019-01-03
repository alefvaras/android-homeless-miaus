package com.fvaras.ale.homelessmiaus.db;

/**
 * Created by Alejandro on 18-10-2017.
 */

public final class ContactContract {
    public static final String TABLE_CONTACTS           = "contacto";
    public static final String TABLE_CONTACTS_ID        = "id";
    public static final String TABLE_CONTACTS_NOMBRE    = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO  = "telefono";
    public static final String TABLE_CONTACTS_EMAIL     = "email";
    public static final String TABLE_CONTACTS_PASSWORD  = "contraseña";



    private ContactContract() {
    }

    public static final String SQL_CREATE_ENTRIES_CONTACTS= "CREATE TABLE " + TABLE_CONTACTS + "(" +
            TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_CONTACTS_NOMBRE + " TEXT, " +
            TABLE_CONTACTS_TELEFONO + " TEXT, " +
            TABLE_CONTACTS_EMAIL + " TEXT, " +
            TABLE_CONTACTS_PASSWORD + " TEXT" +
            ")";




    public static final String SQL_DELETE_TABLE_CONTACTS="DROP TABLE IF EXIST"+TABLE_CONTACTS;




}
