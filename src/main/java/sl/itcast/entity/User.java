package sl.itcast.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author 舒露
 */
@Entity
public class User implements Serializable {
    @Id
    private String user_id;
    private char user_type;
    private char user_status;
    private byte first_login;
    private String user_name;
    private String user_pwd;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public char getUser_type() {
        return user_type;
    }

    public void setUser_type(char user_type) {
        this.user_type = user_type;
    }

    public char getUser_status() {
        return user_status;
    }

    public void setUser_status(char user_status) {
        this.user_status = user_status;
    }

    public byte getFirst_login() {
        return first_login;
    }

    public void setFirst_login(byte first_login) {
        this.first_login = first_login;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_type=" + user_type +
                ", user_status=" + user_status +
                ", first_login=" + first_login +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}
