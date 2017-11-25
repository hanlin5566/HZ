package com.hzcf.compile;

import javax.tools.JavaFileObject;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * user: xushanshan
 * date: 17/10/24
 * email: 1337220620@qq.com
 * <p>
 * 自定义类加载器
 */
public class DynamicClassLoader extends URLClassLoader {
    public DynamicClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }

    public Class findClassByClassName(String className) throws ClassNotFoundException {
        return this.findClass(className);
    }

    public Class loadClass(String fullName, JavaClassObject jco) {
        byte[] classData = jco.getBytes();
        return this.defineClass(fullName, classData, 0, classData.length);
    }


}
