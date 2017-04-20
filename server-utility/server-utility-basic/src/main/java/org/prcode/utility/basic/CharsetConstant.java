package org.prcode.utility.basic;

import java.nio.charset.Charset;

/**
 * @ClassName: CharsetConstant
 * @Date: 2017-03-24 17:01
 * @Auther: kangduo
 * @Description: (编码集合类)
 */
public class CharsetConstant {
    public static final Charset UTF_8 = Charset.forName("utf-8");
    public static final Charset GBK = Charset.forName("GBK");
    public static final Charset DOT_NET_DEFAULT = Charset.forName("UnicodeLittleUnmarked");

    public static final String UTF_8_STR = "utf-8";
    public static final String GBK_STR = "GBK";
    public static final String DOT_NET_DEFAULT_STR = "UnicodeLittleUnmarked";
}
