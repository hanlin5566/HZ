/**
 * 
 */
package com.hzcf.operation.base.http;


public abstract class HttpStatics {

	public static final String LOCAL_IP = "127.0.0.1";

	/**
	 * <pre>
	 * 判断是否本机
	 * </pre>
	 * @param ip
	 * @return
	 */
	public static boolean isLocalIp(String ip) {

		return ip==null || ip.isEmpty() || ip.contains(LOCAL_IP);
	}
}
