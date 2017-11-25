package com.hzcf.compile;

/**
 * user: xushanshan
 * date: 17/10/24
 * email: 1337220620@qq.com
 */

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

/**
 * 用于将java源码保存在content属性中
 */
public class CharSequenceJavaFileObject extends SimpleJavaFileObject {

    /**
     * 保存java code
     */
    private String javaCode;


    /**
     * 调用父类构造器，并设置content
     *
     * @param className
     * @param javaCode
     */
    public CharSequenceJavaFileObject(String className, String javaCode) {
        super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.javaCode = javaCode;
    }

    /**
     * 实现getCharContent，使得JavaCompiler可以从content获取java源码
     *
     * @param ignoreEncodingErrors
     * @return
     */
    @Override
    public String getCharContent(boolean ignoreEncodingErrors) {
        return javaCode;
    }
}
