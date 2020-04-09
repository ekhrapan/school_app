package academy.belhard.util;

import academy.belhard.entity.School;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SchoolUtil {

    public static School toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String city = resultSet.getString("city");
        Date createdAt = resultSet.getDate("created_at");
        Date updatedAt = resultSet.getDate("updated_at");

        return new School(id, title, city, createdAt, updatedAt);
    }
}
