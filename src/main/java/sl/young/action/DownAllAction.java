package sl.young.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sl.young.entity.HomeWork;
import sl.young.service.HomeWorkService;
import sl.young.service.WorkService;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
public class DownAllAction extends ActionSupport {
    private final HomeWorkService homeWorkService;
    private final WorkService workService;
    private String id;

    @Autowired
    public DownAllAction(HomeWorkService homeWorkService, WorkService workService) {
        this.homeWorkService = homeWorkService;
        this.workService = workService;
    }

    /**
     * 从GET方法提交的请求封装给fileName属性
     *
     * @param id 传入的文件名
     */
    public void setId(String id) {
        // 把处理好的文件名，赋值
        if (StringUtils.isBlank(id) || "undefined".equals(id)) {
            id = workService.findAll().get(0).getTypeId();
        }
        this.id = id;

    }

    /**
     * @return result name
     */
    public String byTypeIdDownAll() {
        List<HomeWork> homeWorkList = homeWorkService.findByWorkId(id);
        if (homeWorkList.isEmpty()) {
            return ERROR;
        }
        return "download";
    }

    /**
     * 在file.xml中 param name="inputName">attrInputStream
     *
     * @return 文件流
     */
    public InputStream getAttrInputStream() throws Exception {
        return downAll();
    }

    /**
     * 下载显示的文件名（浏览器显示的文件名）
     *
     * @return 文件名
     */
    public String getDownFileName() {
        // 需要进行中文编码
        try {
            id = URLEncoder.encode(id, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return id + ".zip";
    }

    private InputStream downAll() throws IOException {
        List<String> list = new ArrayList<>();
        List<HomeWork> homeWorkList = homeWorkService.findByWorkId(id);
        homeWorkList.forEach(homeWork -> list.add(homeWork.getIdExt()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(baos);
        for (String filesname : list) {
            File file = new File("D:\\temp\\" + filesname);
            InputStream inputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            IOUtils.copy(inputStream, zipOutputStream);
            inputStream.close();
        }
        zipOutputStream.close();
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
