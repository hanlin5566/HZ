package com.hzcf.compile;

import java.io.IOException;
import java.net.URLClassLoader;
import java.util.*;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;

/**
 * In-memory compile Java source code as String.
 * 
 * @author michael
 */
public class JavaStringCompiler {

	JavaCompiler compiler;
	StandardJavaFileManager stdManager;
	private URLClassLoader parentClassLoader;

	public JavaStringCompiler() {
		this.compiler = ToolProvider.getSystemJavaCompiler();
		this.parentClassLoader = (URLClassLoader) this.getClass().getClassLoader();
		this.stdManager = compiler.getStandardFileManager(null, null, null);
	}

	/**
	 * Compile a Java source file in memory.
	 * 
	 * @param fullClassName
	 *            Java file name, e.g. "Test.java"
	 * @param source
	 *            The source code as String.
	 * @return The compiled results as Map that contains class name as key,
	 *         class binary as value.
	 * @throws IOException
	 *             If compile error.
	 */
	public Object compile(String javaName ,String fullClassName, String source,final Map<String,byte[]> classBytes) throws Exception {
		MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager);
			Object instance = null;
			DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
			JavaFileObject javaFileObject = manager.makeStringSource(javaName+".java", source);
			List<String> options = new ArrayList<String>();
			options.add("-encoding");
			options.add("UTF-8");
			options.add("-classpath");
			options.add(new StringBuilder().toString());
			CompilationTask task = compiler.getTask(null, manager, null, null, null, Arrays.asList(javaFileObject));
			Boolean success = task.call();
			if (success) {
				//如果编译成功，用类加载器加载该类
				MemoryClassLoader memoryClassLoader = new MemoryClassLoader(manager.getClassBytes());
				classBytes.putAll(manager.getClassBytes());
				Class clazz = memoryClassLoader.loadClass(fullClassName);
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
	/**
	 * Load class from compiled classes.
	 * 
	 * @param name
	 *            Full class name.
	 * @param classBytes
	 *            Compiled results as a Map.
	 * @return The Class instance.
	 * @throws ClassNotFoundException
	 *             If class not found.
	 * @throws IOException
	 *             If load error.
	 */
	public Class<?> loadClass(String name, Map<String, byte[]> classBytes) throws ClassNotFoundException, IOException {
		try (MemoryClassLoader classLoader = new MemoryClassLoader(classBytes)) {
			return classLoader.loadClass(name);
		}
	}
}
