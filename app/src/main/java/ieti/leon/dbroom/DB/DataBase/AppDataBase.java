package ieti.leon.dbroom.DB.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ieti.leon.dbroom.DB.DAO.UserDAO;
import ieti.leon.dbroom.DB.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDAO userDao();
    private static AppDataBase instance = null;

    public static AppDataBase getInstance(final Context context){
        if(instance == null){
            synchronized (AppDataBase.class){
                instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "captureDB")
                        .allowMainThreadQueries()
                        .setJournalMode(JournalMode.TRUNCATE)
                        .build();
            }
        }
        return instance;
    }
}
