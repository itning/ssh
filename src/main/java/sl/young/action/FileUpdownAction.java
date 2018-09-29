package sl.young.action;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sl.young.entity.Work;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import sl.young.entity.HomeWork;
import sl.young.entity.User;
import sl.young.service.HomeWorkService;
import sl.young.service.UserService;
import sl.young.service.WorkService;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Controller
public class FileUpdownAction extends ActionSupport {
    @Autowired
    private UserService userService;
    @Autowired
    private HomeWorkService homeWorkService;
    @Autowired
    private WorkService workService;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    /**
     * <input type="file" name="files">
     */
    private File file;
    /**
     * 文件名
     */
    private String fileFileName;
    /**
     * 文件类型（MIME）
     */
    private String FileContentType;

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public void setFileContentType(String fileContentType) {
        FileContentType = fileContentType;
    }

    @Override
    public String execute() throws IOException {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String userInfo = (String) session.get("userInfo");
        Optional<User> one = userService.findOne(userInfo);
        User user = one.orElseThrow(() -> new RuntimeException("获取用户失败"));
        Optional<Work> workOptional = workService.findAll().stream().filter(x -> type.equals(x.getTypeId())).findFirst();
        Work work = workOptional.orElseThrow(() -> new RuntimeException("类别不存在"));
        HomeWork homeWork = new HomeWork();
        String s =user.getUserId()+work.getTypeName()+fileFileName.substring(fileFileName.lastIndexOf("."));
        homeWork.setIdExt(s);
        homeWork.setUser(user);
        homeWork.setWork(work);
        homeWork.setMemi(FileContentType);
        homeWork.setSize(String.valueOf(this.file.length()));
        homeWorkService.save(homeWork);
        /*
         * 获取上传的目录路径
         */
        String path = "D://temp";
        /*
         * 创建目标文件对象
         */

        File file = new File(path, s);
        /*
         * 把上传的文件，拷贝到目标文件中
         */
        FileUtils.copyFile(this.file, file);
        return SUCCESS;
    }
}
