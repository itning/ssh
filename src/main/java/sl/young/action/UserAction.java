package sl.young.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sl.young.entity.User;
import sl.young.service.UserService;

import java.util.Map;
import java.util.Optional;

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
           User user = userService.findOne(userId).get();
           if('1'==user.getUserType()){
               return SUCCESS;
           }else {
               return "admin";
           }

       }
       return ERROR;
    }
}
