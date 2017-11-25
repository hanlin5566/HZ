package com.hzcf.operation.gen.entity;

/**
 * derived_var 变量管理表
 * @author huhanlin 2017-11-25
 */
public class DerivedVariableWithBLOBs extends DerivedVariable {
    /**
     * 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     */
    private byte[] classFile;

    /**
     * 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     */
    private byte[] clazzPath;

    /**
     * 测试用例
     */
    private String testDemo;

    /**
     * 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     * @return class_file 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     */
    public byte[] getClassFile() {
        return classFile;
    }

    /**
     * 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     * @param classFile 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     */
    public void setClassFile(byte[] classFile) {
        this.classFile = classFile;
    }

    /**
     * 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     * @return clazz_path 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     */
    public byte[] getClazzPath() {
        return clazzPath;
    }

    /**
     * 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     * @param clazzPath 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     */
    public void setClazzPath(byte[] clazzPath) {
        this.clazzPath = clazzPath;
    }

    /**
     * 测试用例
     * @return test_demo 测试用例
     */
    public String getTestDemo() {
        return testDemo;
    }

    /**
     * 测试用例
     * @param testDemo 测试用例
     */
    public void setTestDemo(String testDemo) {
        this.testDemo = testDemo == null ? null : testDemo.trim();
    }
}