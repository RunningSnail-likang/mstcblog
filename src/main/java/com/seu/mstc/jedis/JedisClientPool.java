package com.seu.mstc.jedis;

import com.seu.mstc.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * Created by lk on 2018/4/21.
 */
@Component
public class JedisClientPool implements JedisClient ,InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private JedisPool jedisPool;


    @Override
    public void afterPropertiesSet() throws Exception {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1000);//设置最大连接池数量
        jedisPool = new JedisPool("redis://localhost:6379/11");
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis=null;
        String result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.set(key, value);
        }catch (Exception e){
            logger.error("redis的set操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String get(String key) {
        Jedis jedis=null;
        String result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.get(key);
        }catch (Exception e){
            logger.error("redis的get操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis=null;
        Boolean result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.exists(key);
        }catch (Exception e){
            logger.error("redis的exists操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis=null;
        Long result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.expire(key, seconds);
        }catch (Exception e){
            logger.error("redis的expire操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long ttl(String key) {
        Jedis jedis=null;
        Long result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.ttl(key);
        }catch (Exception e){
            logger.error("redis的ttl操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long incr(String key) {
        Jedis jedis=null;
        Long result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.incr(key);
        }catch (Exception e){
            logger.error("redis的incr操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis=null;
        Long result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.hset(key, field, value);
        }catch (Exception e){
            logger.error("redis的hset操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis=null;
        String result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.hget(key, field);
        }catch (Exception e){
            logger.error("redis的hget操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        Jedis jedis=null;
        Long result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.hdel(key, field);
        }catch (Exception e){
            logger.error("redis的hdel操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean hexists(String key, String field) {
        Jedis jedis=null;
        Boolean result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.hexists(key, field);
        }catch (Exception e){
            logger.error("redis的hexists操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> hvals(String key) {
        Jedis jedis=null;
        List<String> result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.hvals(key);
        }catch (Exception e){
            logger.error("redis的hvals操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long del(String key) {
        Jedis jedis=null;
        Long result=null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.del(key);
        }catch (Exception e){
            logger.error("redis的del操作发生异常"+e.getMessage());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }

}
