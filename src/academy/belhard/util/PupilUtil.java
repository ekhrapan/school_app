package academy.belhard.util;

import academy.belhard.entity.Pupil;
import academy.belhard.entity.School;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PupilUtil {

    public static Pupil toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");
        Date createdAt = resultSet.getDate("created_at");
        Date updatedAt = resultSet.getDate("updated_at");
        int schoolId = resultSet.getInt("school_id");

        return new Pupil(id, firstName, lastName, age, email, createdAt, updatedAt, schoolId);
    }
}
