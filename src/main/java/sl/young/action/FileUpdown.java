package sl.young.action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sl.young.entity.Work;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import sl.young.entity.HomeWork;
import sl.young.entity.User;
import sl.young.service.HomeWorkService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Controller
public class FileUpdown extends ActionSupport {
    @Autowired
    private HomeWorkService homeWorkService;
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
        User user = new User();
        user.setUserName("111");
        user.setUserPwd("123");
        user.setUserId(UUID.randomUUID().toString());
        user.setUserType('1');
        user.setUserStatus('1');
        user.setFirstLogin(true);
        Work work = new Work();
        work.setTypeName("5");
        HomeWork homeWork = new HomeWork();
        homeWork.setIdExt(user.getUserId());
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
        File file = new File(path, fileFileName);
        /*
         * 把上传的文件，拷贝到目标文件中
         */
        FileUtils.copyFile(this.file, file);
        return SUCCESS;
    }
}
