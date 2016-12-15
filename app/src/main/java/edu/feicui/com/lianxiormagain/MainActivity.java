package edu.feicui.com.lianxiormagain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OrmHelp ormHelp = OrmHelp.getInstance(this);
        Student student = new Student();
        OrmHelpDao ormHelpDao = new OrmHelpDao(ormHelp);
        for (int i = 0; i < 10; i++) {
            student.setAge(i);
            student.setName("name" + i);
            student.setId(i);
            ormHelpDao.createOrUpdate(student);
            Log.e("===", student.toString());
            List<Student> students = ormHelpDao.queryForAll();
            for (Student studen : students) {
                Log.e("===", "student" + studen);
            }
            Student student1 = ormHelpDao.queryForId(2);
            Log.e("===", "student" + student1);
        }
    }
}
