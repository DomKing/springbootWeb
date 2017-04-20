package org.prcode.utility.util;

import org.apache.log4j.Logger;
import org.prcode.utility.basic.CharsetConstant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @ClassName: JaxbXMLUtil
 * @Date: 2017-03-24 16:59
 * @Auther: kangduo
 * @Description: (xml与javaBean转换工具)
 */
public class JaxbXMLUtil {

    private static final Logger logger = Logger.getLogger(JaxbXMLUtil.class);
    /**
     * JavaBean转换成xml，默认编码UTF-8
     *
     * @param obj 待转换对象
     * @return 转换后的xml
     */
    public static String convertToXml(Object obj) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, CharsetConstant.UTF_8);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            logger.error(ExceptionUtil.parseException(e));
        }

        return result;
    }


    /**
     * xml转换成JavaBean
     *
     * @param xml xml字符串
     * @param c   转换成的类，如User.class
     * @return 转换后的对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToJavaBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            logger.error(ExceptionUtil.parseException(e));
        }

        return t;
    }
}
