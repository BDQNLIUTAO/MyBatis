package cn.happy.day13upload;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/11/7.
 */
@Controller
public class FirstController {
    //多文件上传
    @RequestMapping("/first")
    public String doFirst(MultipartFile[] upload, HttpSession session){
        for (MultipartFile item:upload){
            if (item.getSize()>0){
                //已经选择文件
                //upload是客户端浏览器上传的文件对象
                String childPath = item.getOriginalFilename();  //文件的短名称
                if (childPath.endsWith("jpg") || childPath.endsWith("gif") || childPath.endsWith("png")){
                    //绝对路径
                    String parentPath = session.getServletContext().getRealPath("/upload");
                    File file=new File(parentPath,childPath);
                    try {
                        item.transferTo(file);
                        // uploadFile("ftp.accp.com",21,"anonymous","yymqqc/126.com","/ACCP6.0/S2/S2219",childPath,upload.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "/upload.jsp";
                    }
                }else {
                    return "/upload.jsp";
                }

            }else {
                return "/upload.jsp";
            }
        }
        return "/first.jsp";
    }

    @RequestMapping("/first2")
    public String doFirst2(MultipartFile upload, HttpSession session){
        if (upload.getSize()>0){
            //已经选择文件
            //upload是客户端浏览器上传的文件对象
            String childPath = upload.getOriginalFilename();  //文件的短名称
            if (childPath.endsWith("jpg") || childPath.endsWith("gif") || childPath.endsWith("png")){
                //绝对路径
                String parentPath = session.getServletContext().getRealPath("/upload");
                File file=new File(parentPath,childPath);
                try {
                    upload.transferTo(file);
                    //uploadFile("ftp.accp.com",21,"anonymous","yymqqc/126.com","/ACCP6.0/S2/S2219",childPath,upload.getInputStream());
                    return "/first.jsp";
                } catch (IOException e) {
                    e.printStackTrace();
                    return "/upload.jsp";
                }
            }else {
                return "/upload.jsp";
            }

        }else {
            return "/upload.jsp";
        }
    }
    /**
     *
     * @param url :远程ftp的域名 ftp.accp.com
     * @param port :端口号  21
     * @param username ：anonymous
     * @param password  ：yymqqc/126.com
     * @param path     /ACCP6.0/S2/S2219
     * @param filename   name
     * @param input    FileInputStream
     * @return
     */
    public  boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);//连接FTP服务器
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);//登录

            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setBufferSize(1024);
            ftp.setControlEncoding("GBK");
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);

            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

}
