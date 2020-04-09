package academy.belhard.db;

import academy.belhard.entity.School;
import academy.belhard.util.CurrentDateUtil;
import academy.belhard.util.SchoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolConnector {

    private static final String SELECT_ALL = "SELECT * FROM schools ORDER BY id ASC";
    private static final String SELECT_BY_ID = "SELECT * FROM schools WHERE id = ?";
    private static final String ADD = "INSERT INTO schools (title, city) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE schools SET title = ?, city = ?, updated_at = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM schools WHERE id = ?";

    public static List<School> getAll() throws SQLException {
        List<School> result = new ArrayList<>();

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
                ) {

            while (resultSet.next()) {
                School school = SchoolUtil.toObject(resultSet);
                result.add(school);
            }
        }

        return result;
    }

    public static void add(School school) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD)
        ) {

            String title = school.getTitle();
            String city = school.getCity();

            statement.setString(1, title);
            statement.setString(2, city);

            statement.executeUpdate();
        }
    }

    public static School getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            School school = SchoolUtil.toObject(resultSet);

            resultSet.close();

            return school;
        }
    }

    public static void update(School school) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, school.getTitle());
            statement.setString(2, school.getCity());
            statement.setDate(3, new Date(CurrentDateUtil.currentUnixTimestamp()));
            statement.setInt(4, school.getId());

            statement.executeUpdate();
        }
    }

    public static void deleteById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ) {

            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
