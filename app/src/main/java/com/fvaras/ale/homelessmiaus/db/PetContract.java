package com.fvaras.ale.homelessmiaus.db;

/**
 * Created by Alejandro on 29-10-2017.
 */

public class PetContract {


    private PetContract() {
    }

    public static final String TABLE_PETS          = "mascota";
    public static final String TABLE_PETS_ID        = "id";
    public static final String TABLE_PETS_NOMBRE    = "nombre";
    public static final String TABLE_PETS_SEXO  = "sexo";
    public static final String TABLE_PETS_AGE    = "edad";
    public static final String TABLE_PETS_DESCRIPCION    = "descripcion";
    public static final String TABLE_PETS_FOTO      = "foto";

    public static final String TABLE_LIKES_PETS = "mascota_likes";
    public static final String TABLE_LIKES_PETS_ID = "id";
    public static final String TABLE_LIKES_PETS_ID_PET = "id_mascota";
    public static final String TABLE_LIKES_PETS_NUMERO_LIKES = "numero_likes";



    public static final String SQL_CREATE_ENTRIES_PETS = "CREATE TABLE " + TABLE_PETS  + "(" +
            TABLE_PETS_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_PETS_NOMBRE + " TEXT, " +
            TABLE_PETS_SEXO  + " TEXT, " +
            TABLE_PETS_AGE  + " TEXT, " +
            TABLE_PETS_DESCRIPCION+ " TEXT, " +
            TABLE_PETS_FOTO  + " INTEGER" +
            ")";

    public static final String SQL_CREATE_ENTRIES_LIKES_PETS = "CREATE TABLE " + TABLE_LIKES_PETS + "(" +
            TABLE_LIKES_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_LIKES_PETS_ID_PET + " INTEGER, " +
            TABLE_LIKES_PETS_NUMERO_LIKES+ " INTEGER, " +
            "FOREIGN KEY (" + TABLE_LIKES_PETS_ID_PET + ") " +
            "REFERENCES " + TABLE_PETS    + "(" + TABLE_PETS_ID  + ")" +
            ")";

    public static final String SQL_DELETE_TABLE_PETS="DROP TABLE IF EXIST"+TABLE_PETS;
    public static final String SQL_DELETE_TABLE_LIKES_PETS="DROP TABLE IF EXIST"+TABLE_LIKES_PETS;
}
