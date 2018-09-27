package sl.young.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sl.young.entity.HomeWork;
import sl.young.entity.Work;
import sl.young.service.HomeWorkService;
import sl.young.service.WorkService;

import java.util.List;
import java.util.Map;

@Controller
public class HomeWorkAction extends ActionSupport {

    private final HomeWorkService homeWorkService;
    private final WorkService workService;
    private String id;

    @Autowired
    public HomeWorkAction(HomeWorkService homeWorkService, WorkService workService) {
        this.homeWorkService = homeWorkService;
        this.workService = workService;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String select() {
        List<HomeWork> homeWorkList = homeWorkService.select();
        List<Work> workList = workService.findAll();
        Map<String,List<?>> request = (Map<String,List<?>>) ActionContext.getContext().get("request");
        request.put("homeWorkList",homeWorkList);
        request.put("workList",workList);
        return "success";
    }
    public String delete(){
        homeWorkService.delet(id);
        return SUCCESS;
    }

}
