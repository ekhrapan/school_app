package academy.belhard;

import academy.belhard.db.FullInfoConnector;
import academy.belhard.db.PupilConnector;
import academy.belhard.entity.Pupil;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        FullInfoConnector.getAll();

    }

    public static void showAll() throws SQLException {
        List<Pupil> result = PupilConnector.getAll();

        for (Pupil pupil : result) {
            System.out.println(pupil);
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }
}
