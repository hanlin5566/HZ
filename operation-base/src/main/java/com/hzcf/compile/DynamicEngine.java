package com.hzcf.compile;

/**
 * user: xushanshan
 * date: 17/10/24
 * email: 1337220620@qq.com
 */

import javax.tools.*;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;


/**
 * 在Java SE6中最好的方法是使用StandardJavaFileManager类。
 * 这个类可以很好地控制输入、输出，并且可以通过DiagnosticListener得到诊断信息，
 * 而DiagnosticCollector类就是listener的实现。
 * 使用StandardJavaFileManager需要两步。
 * 首先建立一个DiagnosticCollector实例以及通过JavaCompiler的getStandardFileManager()方法得到一个StandardFileManager对象。
 * 最后通过CompilationTask中的call方法编译源程序。
 */
public class DynamicEngine {
    //单例
    private static DynamicEngine ourInstance = new DynamicEngine();

    public static DynamicEngine getInstance() {
        return ourInstance;
    }

    private URLClassLoader parentClassLoader;
    private String classpath;

    private DynamicEngine() {
        //获取类加载器
        this.parentClassLoader = (URLClassLoader) this.getClass().getClassLoader();

        //创建classpath
        this.buildClassPath();
    }


    /**
     * @MethodName : 创建classpath
     */
    private void buildClassPath() {
        this.classpath = null;
        StringBuilder stringBuilder = new StringBuilder();
        for (URL url : this.parentClassLoader.getURLs()) {
            String p = url.getFile();
            stringBuilder.append(p).append(File.pathSeparator);
        }
        this.classpath = stringBuilder.toString();
    }

    /**
     * @param fullClassName 类名
     * @param javaCode      类代码
     * @return Object
     * @throws Exception
     * @MethodName : 编译java代码到Object
     * @Description : TODO
     */
    public Object javaCodeToObject(String fullClassName, String javaCode,final Map<String,Byte[]> classBytes) throws Exception {

        Object instance = null;
        //获取系统编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 建立DiagnosticCollector对象
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        // 建立用于保存被编译文件名的对象
        // 每个文件被保存在一个从JavaFileObject继承的类中
        ClassFileManager fileManager = new ClassFileManager(
                compiler.getStandardFileManager(diagnostics, null, null));

        //创建javacode对象
        List<JavaFileObject> javaFileObjectList = new ArrayList<JavaFileObject>();
        javaFileObjectList.add(new CharSequenceJavaFileObject(fullClassName, javaCode));

        //使用编译选项可以改变默认编译行为。编译选项是一个元素为String类型的Iterable集合
        List<String> options = new ArrayList<String>();
        options.add("-encoding");
        options.add("UTF-8");
        options.add("-classpath");
        options.add(this.classpath);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, options, null, javaFileObjectList);

        // 编译源程序
        boolean success = task.call();
        if (success) {
            //如果编译成功，用类加载器加载该类
            // JavaClassObject javaClassObject = fileManager.getJavaClassObject();
            //add by rayming 单个java文件编译出多个class时候，所有的class文件均加载，并且有序
            DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(this.parentClassLoader);

            LinkedHashMap<String, JavaClassObject> jcoMap = fileManager.getJcoMap();
            Set<Map.Entry<String, JavaClassObject>> entries = jcoMap.entrySet();
            for (Map.Entry<String, JavaClassObject> entry : entries) {
                dynamicClassLoader.loadClass(entry.getKey(), entry.getValue());
            }
            // Class clazz = dynamicClassLoader.loadClass(fullClassName, jcoMap.get(fullClassName));
            Class clazz = dynamicClassLoader.loadClass(fullClassName);
            instance = clazz.newInstance();
        } else {
            //如果想得到具体的编译错误，可以对Diagnostics进行扫描
            Object error = "";
            for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
                error += getCompileInfo(diagnostic);
            }
            return error;
        }

        return instance;
    }


    //获取编译失败原因
    private String getCompileInfo(Diagnostic diagnostic) {
        StringBuffer errorLog = new StringBuffer();
        errorLog.append("Code:[" + diagnostic.getCode() + "]\n");
        errorLog.append("Kind:[" + diagnostic.getKind() + "]\n");
        errorLog.append("Position:[" + diagnostic.getPosition() + "]\n");
        errorLog.append("Start Position:[" + diagnostic.getStartPosition() + "]\n");
        errorLog.append("End Position:[" + diagnostic.getEndPosition() + "]\n");
        errorLog.append("Source:[" + diagnostic.getSource() + "]\n");
        errorLog.append("Message:[" + diagnostic.getMessage(null) + "]\n");
        errorLog.append("LineNumber:[" + diagnostic.getLineNumber() + "]\n");
        errorLog.append("ColumnNumber:[" + diagnostic.getColumnNumber() + "]\n");
        return errorLog.toString();
    }
}
