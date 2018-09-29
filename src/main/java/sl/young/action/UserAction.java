package sl.young.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sl.young.service.UserService;

import java.util.Map;

/**
 * @author 舒露
 */
@Controller
public class UserAction extends ActionSupport {
    @Autowired
    private UserService userService;
    private String userId;
    private String userPwd;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String login() {
       if(userService.login(userId,userPwd)) {
           Map<String, Object> session = ActionContext.getContext().getSession();
           session.put("userInfo",userId);
           return SUCCESS;
       }
       return ERROR;
    }
}
