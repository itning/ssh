package sl.young.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sl.young.entity.HomeWork;
import sl.young.entity.User;
import sl.young.entity.Work;
import sl.young.service.HomeWorkService;
import sl.young.service.UserService;
import sl.young.service.WorkService;

import java.util.List;
import java.util.Map;

@Controller
public class AdminAction extends ActionSupport {
    private final HomeWorkService homeWorkService;
    private final WorkService workService;
    private final UserService userService;

    @Autowired
    public AdminAction(HomeWorkService homeWorkService, WorkService workService, UserService userService) {
        this.homeWorkService = homeWorkService;
        this.workService = workService;
        this.userService = userService;
    }

    private String id;

    public void setId(String id) {
        this.id = id;
    }


    public String select() {
        User user = userService.findOne(ActionContext.getContext().getSession().get("userInfo").toString()).orElseThrow(() -> new RuntimeException(""));
        if (user.getUserType() == '1') {
            return "error";
        }
        List<Work> workList = workService.findAll();
        Map<String, List<?>> request = (Map<String, List<?>>) ActionContext.getContext().get("request");
        request.put("workList", workList);
        return SUCCESS;
    }

    public String getData() {
        List<HomeWork> homeWorkList;
        if (id == null) {
            homeWorkList = homeWorkService.findByWorkId(workService.findAll().get(0).getTypeId());
        }else {
            homeWorkList = homeWorkService.findByWorkId(id);
        }
        Map<String, List<?>> request = (Map<String, List<?>>) ActionContext.getContext().get("request");
        request.put("homeWorkList", homeWorkList);
        return "data";
    }
}
