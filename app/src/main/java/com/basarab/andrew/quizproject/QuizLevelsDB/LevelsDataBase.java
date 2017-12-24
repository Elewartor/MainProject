package com.basarab.andrew.quizproject.QuizLevelsDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LevelsDataBase extends SQLiteOpenHelper {
    // Ім'я БД
    public static final String DATABASE_NAME = "LevelsDB";
    // Назва таблиці
    public static final String LEVELS_TABLE_NAME = "levels";
    // Стовпці таблиці
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMOJI_1 = "emoji_1";
    public static final String COLUMN_EMOJI_2 = "emoji_2";
    public static final String COLUMN_EMOJI_3 = "emoji_3";
    public static final String COLUMN_TRUE_ANSWER = "trueAnswer";
    public static final String COLUMN_FALSE_ANSWER_1 = "falseAnswer_1";
    public static final String COLUMN_FALSE_ANSWER_2 = "falseAnswer_2";
    public static final String COLUMN_FALSE_ANSWER_3 = "falseAnswer_3";
    public static final String COLUMN_LEVELSTATUS = "levelStatus";

    // Конструктор
    public LevelsDataBase(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*Форма таблиці:
        * ID | Емодж 1 | Емоджі 2 | Емоджі 3 | Правильна відповідь | Неправильна відповідь 1 | Неправильна відповідь 2 | Неправильна відповідь 3 | Статус рівня (Пройдений/Непройдений)
        * Назва талиці - LEVELS_TABLE_NAME - levels*/
        sqLiteDatabase.execSQL(
                "create table "+LEVELS_TABLE_NAME+
                        "("+COLUMN_ID+" integer, "
                        +COLUMN_EMOJI_1+" integer, "+COLUMN_EMOJI_2+" integer,"+COLUMN_EMOJI_3+" integer, "
                        +COLUMN_TRUE_ANSWER+" text, "
                        +COLUMN_FALSE_ANSWER_1+" text, "+COLUMN_FALSE_ANSWER_2+" text, "+COLUMN_FALSE_ANSWER_3+" text, "
                        +COLUMN_LEVELSTATUS+" integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }

    // Метод повертає курсор зі всіма даними викликаними по id
    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+COLUMN_ID+"", null );
        return res;
    }
}
