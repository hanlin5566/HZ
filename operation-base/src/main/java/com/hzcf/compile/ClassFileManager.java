package com.hzcf.compile;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * user: xushanshan
 * date: 17/10/24
 * email: 1337220620@qq.com
 * <p>
 * 类文件管理器
 * 用于JavaCompiler将编译好后的class，保存到JavaClassObject中
 */
public class ClassFileManager extends ForwardingJavaFileManager {

    /**
     * 保存编译后Class文件的对象
     */
    //private JavaClassObject javaclassObject
    //add by rayming 单个java文件，编译出多个class时候,全部要保存
    private LinkedHashMap<String, JavaClassObject> jcoMap = new LinkedHashMap<String, JavaClassObject>();

    /**
     * 调用父类构造器
     *
     * @param standardManager
     */
    public ClassFileManager(StandardJavaFileManager standardManager) {
        super(standardManager);
    }

    /**
     * 将JavaFileObject对象的引用交给JavaCompiler，让它将编译好后的Class文件装载进来
     *
     * @param location
     * @param className
     * @param kind
     * @param sibling
     * @return
     * @throws IOException
     */
    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling)
            throws IOException {
        //if (javaclassObject == null) {
        JavaClassObject jco = new JavaClassObject(className, kind);
        jcoMap.put(className,jco);
        //}
        return jco;
    }

    public LinkedHashMap<String, JavaClassObject> getJcoMap() {
        return jcoMap;
    }
}
