package academy.belhard.db;

import academy.belhard.entity.Pupil;
import academy.belhard.util.CurrentDateUtil;
import academy.belhard.util.PupilUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PupilConnector {

    private static final String SELECT_ALL = "SELECT * FROM pupils ORDER BY id ASC";
    private static final String SELECT_BY_ID = "SELECT * FROM pupils WHERE id = ?";
    private static final String ADD = "INSERT INTO pupils (first_name, last_name, age, email, school_id) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pupils SET first_name = ?, last_name = ?, age = ?, email = ?, updated_at = ?, school_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM pupils WHERE id = ?";

    public static List<Pupil> getAll() throws SQLException {
        List<Pupil> result = new ArrayList<>();

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
                ) {

            while (resultSet.next()) {
                Pupil pupil = PupilUtil.toObject(resultSet);
                result.add(pupil);
            }
        }

        return result;
    }

    public static void add(Pupil pupil) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD)
        ) {

            String firstName = pupil.getFirstName();
            String lastName = pupil.getLastName();
            int age = pupil.getAge();
            String email = pupil.getEmail();
            int schoolId = pupil.getSchoolId();

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setString(4, email);
            statement.setInt(5, schoolId);

            statement.executeUpdate();
        }
    }

    public static Pupil getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            Pupil pupil = PupilUtil.toObject(resultSet);

            resultSet.close();

            return pupil;
        }
    }

    public static void update(Pupil pupil) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, pupil.getFirstName());
            statement.setString(2, pupil.getLastName());
            statement.setInt(3, pupil.getAge());
            statement.setString(4, pupil.getEmail());
            statement.setDate(5, new Date(CurrentDateUtil.currentUnixTimestamp()));
            statement.setInt(6, pupil.getSchoolId());
            statement.setInt(7, pupil.getId());

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
