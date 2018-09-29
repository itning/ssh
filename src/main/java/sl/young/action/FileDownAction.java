package sl.young.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import java.net.URLEncoder;

public class FileDownAction extends ActionSupport {
    private String id;

    /**
     * 从GET方法提交的请求封装给fileName属性
     *
     * @param id 传入的文件名
     */
    public void setId(String id) {
        // 把处理好的文件名，赋值
        this.id = id;

    }

    /**
     * @return result name
     */
    public String download() {
        try {
            new FileInputStream("D:\\temp\\"+id);
        } catch (FileNotFoundException e) {
            return ERROR;
        }
        return "download";
    }

    /**
     * 在file.xml中 param name="inputName">attrInputStream
     *
     * @return 文件流
     */
    public InputStream getAttrInputStream() throws FileNotFoundException {
        return new FileInputStream("D:\\temp\\"+id);
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
        return id;
    }
}
