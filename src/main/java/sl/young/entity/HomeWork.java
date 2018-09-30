package sl.young.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class HomeWork implements Serializable {
    @Id
    private String idExt;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "work")
    private Work work;
    private String memi;
    private String size;

    public String getIdExt() {
        return idExt;
    }

    public void setIdExt(String idExt) {
        this.idExt = idExt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
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
                "user_id='" + user + '\'' +
                ", type_id='" + work + '\'' +
                ", memi='" + memi + '\'' +
                ", size='" + size + '\'' +
                ", idExt='" + idExt + '\'' +
                '}';
    }
}
