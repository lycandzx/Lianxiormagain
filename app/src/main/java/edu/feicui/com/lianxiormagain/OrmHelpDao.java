package edu.feicui.com.lianxiormagain;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/12/14.
 */

public class OrmHelpDao {
    public Dao<Student, Long> dao;

    public OrmHelpDao(OrmHelp ormHelp) {
        try {
            dao = ormHelp.getDao(Student.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createOrUpdate(Student student) {
        try {
            dao.createOrUpdate(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Student> queryForAll() {

        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student queryForId(long id) {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
