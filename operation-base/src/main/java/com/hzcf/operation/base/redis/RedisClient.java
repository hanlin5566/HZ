package com.hzcf.operation.base.redis;

import com.hzcf.operation.base.http.PoolingHttpClientHolder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by liqinwen on 2017/8/30.
 */
@Configuration
public class RedisClient {

    private static String  host = "192.168.1.111";
    private static String port = "6379";
    private static String userName;
    private static String password ="123";
    private int timeOut = 5000;
    private static JedisPool jedisPool;

    @Bean
    public JedisPool  init()
    {
        PoolingHttpClientHolder poolingHttpClientHolder = new PoolingHttpClientHolder();
        poolingHttpClientHolder.init();
        PoolConfig poolConfig = new PoolConfig();
//        String[] ports = this.port.split(",");
//        Set<HostAndPort> nodes =  new LinkedHashSet<HostAndPort>();
//        for(int i=0;i<ports.length;i++)
//        {
//            nodes.add(new HostAndPort(host, Integer.valueOf(ports[i])));
//        }
        //集群模式
        //jedisCluster = new JedisCluster(nodes,this.timeOut,poolConfig);
        jedisPool = new JedisPool(poolConfig,this.getHost(),
        this.getPort(),this.timeOut,this.getPassword());
        return jedisPool;
    }

    public static Jedis cache()
    {
        return jedisPool.getResource();
    }
    public void destroy()
    {
        jedisPool.close();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return Integer.valueOf(port);
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
