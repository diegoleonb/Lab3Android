package ieti.leon.dbroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import ieti.leon.dbroom.DB.DAO.UserDAO;
import ieti.leon.dbroom.DB.DataBase.AppDataBase;
import ieti.leon.dbroom.DB.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserDAO userDao = AppDataBase.getInstance(this).userDao();
        if(userDao.getAll().size() == 0 ){
            User user = new User();
            user.firstName = "Pepito";
            user.lastName = "Perez";
            userDao.insertAll(user);
        }
        List<User> users = userDao.getAll();
        TextView textView = findViewById(R.id.textView);
        textView.setText("WELCOME " + users.get(0).firstName.toUpperCase() + " " + users.get(0).lastName.toUpperCase());
    }
}