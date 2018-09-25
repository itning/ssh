package sl.itcast.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class HomeWork implements Serializable {
    @Id
    private String id_ext;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "type_id")
    private Work type_id;
    private String memi;
    private String size;

    public String getId_ext() {
        return id_ext;
    }

    public void setId_ext(String id_ext) {
        this.id_ext = id_ext;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Work getType_id() {
        return type_id;
    }

    public void setType_id(Work type_id) {
        this.type_id = type_id;
    }

    public String getMemi() {
        return memi;
    }

    public void setMemi(String memi) {
        this.memi = memi;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "user_id='" + user_id + '\'' +
                ", type_id='" + type_id + '\'' +
                ", memi='" + memi + '\'' +
                ", size='" + size + '\'' +
                ", id_ext='" + id_ext + '\'' +
                '}';
    }
}
