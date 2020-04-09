package academy.belhard.entity;

import java.util.Date;

public class School {
    private int id;
    private String title;
    private String city;
    private Date createdAt;
    private Date updatedAt;

    public School(int id, String title, String city, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private School(String title, String city) {
        this.title = title;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public static School createItemForSaving(String title, String city) {
        return new School(title, city);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
