package org.prcode.business.support.basic.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;
import org.prcode.business.support.basic.busiSupportCache.constant.OmsCommSysParaCode;
import org.prcode.business.support.basic.busiSupportCache.service.IBusiSupportCacheService;
import org.prcode.utility.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: SimpleMailSender
 * @Date: 2017-03-31 15:17
 * @Auther: kangduo
 * @Description: (邮件发送工具)
 */
@Component
public class SimpleMailSender {

    private static final Logger logger = Logger.getLogger(SimpleMailSender.class);

    @Value("${my.mail.from}")
    private String mailFrom;

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private Configuration configuration;

    @Resource
    private IBusiSupportCacheService busiSupportCacheService;

    /**
     * 异步发送邮件
     *
     * @param subject      主题
     * @param sendToMails  发送人员列表 没有则不发
     * @param copyToMails  抄送人员列表
     * @param templateName freeMarker 模版位置 如：mail/demo.ftl
     * @param param        模版参数
     */
    @Async
    public void sendTemplateMail(String subject,
                                 List<String> sendToMails,
                                 List<String> copyToMails,
                                 String templateName,
                                 HashMap param) throws BusinessException {

        //没收件人，则不发邮件
        if (sendToMails == null || sendToMails.size() == 0) {
            return;
        }

        //如果没开启邮件发送，则不发邮件
        String emailSwitch = busiSupportCacheService.getCommSysParaValue(OmsCommSysParaCode.Email_Switch);
        if (!"1".equals(emailSwitch)) {
            return;
        }

        logger.debug("发送邮件开始......");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            //邮件设置
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(mailFrom);
            helper.setSubject(subject);
            helper.setTo(sendToMails.toArray(new String[sendToMails.size()]));
            if (copyToMails != null && copyToMails.size() > 0) {
                helper.setCc(copyToMails.toArray(new String[copyToMails.size()]));
            }

            //转模版
            Template template = configuration.getTemplate(templateName);
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, param);
            helper.setText(text, true);

            logger.debug("发送邮件进行中......");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error("邮件发送初始化失败：" + e.getMessage());
        } catch (IOException e) {
            logger.error("邮件发送获取模版失败：" + e.getMessage());
        } catch (TemplateException e) {
            logger.error("邮件发送格式化模版失败：" + e.getMessage());
        }

        logger.debug("发送邮件结束......");
    }
}
