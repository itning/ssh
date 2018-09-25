package sl.itcast.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;
import sl.itcast.service.UserService;

import javax.annotation.Resource;
@Controller
public class UserAction extends ActionSupport {
    @Resource
    private UserService userService;
    @Override
    public String execute(){
        userService.save();
        return SUCCESS;
    }
}
