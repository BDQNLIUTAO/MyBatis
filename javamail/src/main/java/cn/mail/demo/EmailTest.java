package cn.mail.demo;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by Administrator on 2017/11/30.
 */
public class EmailTest {
    public static void main(String[] args) {
        // 不要使用SimpleEmail,会出现乱码问题
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：，普通qq号只能是smtp.qq.com ；smtp.exmail.qq.com没测试成功
            email.setHostName("smtp.qq.com");
            //设置需要鉴权端口
            email.setSmtpPort(465);
            //开启 SSL 加密
            email.setSSLOnConnect(true);
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱
            email.addTo("1538286083@qq.com");
            // 发送人的邮箱
            email.setFrom("1538286083@qq.com", "岭利达");
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和得到的授权码
            email.setAuthentication("1538286083@qq.com", "xtqyyavwnfxziaca");
            email.setSubject("下午3：00会议室讨论，请准时参加");
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            int count=(int)((Math.random()*9+1)*1000);
            email.setMsg("【岭利达】您的验证码是"+count+"，千万不可泄露于他人！");
            // 发送
            email.send();
            System.out.println ( "邮件发送成功!" );
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println ( "邮件发送失败!" );
        }

    }
}
