package academy.belhard;

import academy.belhard.db.FullInfoConnector;
import academy.belhard.db.PupilConnector;
import academy.belhard.db.SchoolConnector;
import academy.belhard.entity.Pupil;
import academy.belhard.entity.School;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        School s = School.createItemForSaving("title", "city");
        SchoolConnector.add(s);
        System.out.println(SchoolConnector.getAll());

        Pupil p = new Pupil("j", "kk", 15, "fsfdfs", 1);
        PupilConnector.add(p);
        List<Pupil> pupils = PupilConnector.getAll();
        System.out.println(pupils);

//        FullInfoConnector.getAll();
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
