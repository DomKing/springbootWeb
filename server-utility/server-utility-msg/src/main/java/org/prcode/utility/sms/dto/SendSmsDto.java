package org.prcode.utility.sms.dto;

import java.util.List;

/**
 * @ClassName: SendSmsDto
 * @Date: 2017-03-24 17:37
 * @Auther: kangduo
 * @Description: (发送短信对象)
 */
public class SendSmsDto {

    /**
     * 发送内容
     */
    private String content;

    /**
     * 需要发送的手机号列表
     */
    private List<String> phones;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
