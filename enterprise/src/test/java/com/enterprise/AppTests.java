package com.enterprise;

import com.enterprise.mail.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/24 11:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    @Autowired
    MailService mailService;

    String from = "";
    String to = "";
    String cc = "";
    String subject = "Test Subject";
    String text = "Test Text";

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail(from, to, cc, subject, text);
    }

    @Test
    public void sendMimeMail() {
        mailService.sendAttachFileMail(from, to, cc, subject, text
                , new File("C:\\Users\\agony\\Documents\\Workspace\\spring-boot-demo\\enterprise\\src\\main\\resources\\file"));
    }

    @Test
    public void sendMailWithImg() {
        mailService.sendMailWithImg(from, to, cc, subject
                , "<img src='cid:i1'/>"
                , new String[]{"C:\\Users\\agony\\Documents\\Workspace\\spring-boot-demo\\enterprise\\src\\main\\resources\\image.png"}
                , new String[]{"i1"});
    }

    @Test
    public void sendHtmlMailFreemarker() {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
            ClassLoader loader = App.class.getClassLoader();
            configuration.setClassLoaderForTemplateLoading(loader, "ftl");
            Template template = configuration.getTemplate("mailtemplate.ftl");
            StringWriter mail = new StringWriter();
            com.enterprise.mail.Test test = new com.enterprise.mail.Test();
            test.setTest("test");
            template.process(test, mail);
            mailService.sendHtmlMail(from, to, cc, subject, mail.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void sendHtmlThymeleaf() {
        Context context = new Context();
        context.setVariable("test", "test");
        String mail = templateEngine.process("mailtemplate.html", context);
        mailService.sendHtmlMail(from, to, cc, subject, mail);
    }

    @Test
    public void classpath(){
        try {
            System.out.println(new ClassPathResource(".").getFile().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
