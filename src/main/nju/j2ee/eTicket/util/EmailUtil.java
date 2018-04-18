package j2ee.eTicket.util;

import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailUtil {

    public EmailUtil(){
        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");// 是否显示调试信息(可选)
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");
        properties.put(" mail.smtp.timeout ", " 25000 ");

//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setJavaMailProperties(properties);
//        javaMailSender.setHost("smtp.163.com");
//        javaMailSender.setUsername("abc"); // 根据自己的情况,设置username
//        javaMailSender.setPassword("abc"); // 根据自己的情况, 设置password
//        javaMailSender.setPort(465);
//        javaMailSender.setDefaultEncoding("UTF-8");
    }
}
