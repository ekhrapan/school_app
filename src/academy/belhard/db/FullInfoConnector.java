package academy.belhard.db;

import academy.belhard.entity.Pupil;
import academy.belhard.util.PupilUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullInfoConnector {

    private static final String SELECT_ALL = "SELECT title, city, first_name FROM schools s JOIN pupils p ON s.id=p.school_id";

    public static void getAll() throws SQLException {
        List<Pupil> result = new ArrayList<>();

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title") + " - " + resultSet.getString("city") + " - " + resultSet.getString("first_name"));
            }
        }
    }
}
