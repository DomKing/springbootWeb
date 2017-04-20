package org.prcode.utility.basic;

import org.prcode.utility.basic.support.ResponseStatus;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: JsonResponse
 * @Date: 2017-03-30 16:39
 * @Auther: kangduo
 * @Description: (返回结果)
 */
public class JsonResponse {
    // 状态
    private String status;
    // 提示内容
    private String message;
    // 业务结果数据
    private Map<String, Object> dataValue;
    // 错误码，错误信息国际化时用
    private String errcode;

    /**
     * 构造方法
     */
    public JsonResponse() {
        status = ResponseStatus.SUCCESS;
        dataValue = new LinkedHashMap<>();
    }

    public void putData(String key, Object value) {
        dataValue.put(key, value);
    }

    public void putDataAll(Map<String, Object> map) {
        dataValue.putAll(map);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDataValue() {
        return dataValue;
    }

    public void setDataValue(Map<String, Object> dataValue) {
        this.dataValue = dataValue;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

}
