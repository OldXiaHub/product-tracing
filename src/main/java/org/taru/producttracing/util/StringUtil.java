package org.taru.producttracing.util;

public class StringUtil {


    /**
     * 把对象转换成字符串
     */
    public static String valueof(Object obj) {
        if(obj!=null) {
            return obj.toString();
        }else{
            return null;
        }
    }

}
