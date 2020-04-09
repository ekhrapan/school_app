package academy.belhard.entity;

import java.util.Date;

public class Pupil {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private int schoolId;

    public Pupil(int id, String firstName, String lastName, int age, String email, Date createdAt, Date updatedAt, int schoolId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.schoolId = schoolId;
    }

    public Pupil(String firstName, String lastName, int age, String email, String genderType, int schoolId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.schoolId = schoolId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public static Pupil createItemForSaving(String firstName, String lastName, int age, String email, String genderType, int schoolId) {
        return new Pupil(firstName, lastName, age, email, genderType, schoolId);
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", schoolId=" + schoolId +
                '}';
    }
}
