package com.example.springboot_redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhantianxin
 * @version 1.0
 * @date 2022/12/27 10:38
 */
@SpringBootTest
class SpringbootRedisApplicationTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /*@Test
    public void String(){

        ValueOperations valueOperations = redisTemplate.opsForValue();

        valueOperations.set("gg","小三");

        Object object  = valueOperations.get("gg");
        System.out.println(object);

        //设置超时key
        valueOperations.set("key1","小霞",5l, TimeUnit.SECONDS);

        //setnx key value key不存在就设置key的值
        Boolean flag = valueOperations.setIfAbsent("name1","小");
        System.out.println("key不存在就设置key的值:"+flag);

    }*/

    @Test
    public void HashSet(){

        HashOperations hashOperations = redisTemplate.opsForHash();

        //HSET key FILDID value:： 将哈希表key中的字段field字段的值设为value
         hashOperations.put("hashKey1","nameH","valueH1");
         hashOperations.put("hashKey1","sexH","valueH2");
         hashOperations.put("hashKey1","ageH","valueH3");

         //HGET KEY FILDID :获取存储在哈希表指定字段的值
        Object object =hashOperations.get("hashkey1","nameH");
        System.out.println(object);

        //HDEL key FIDLDID :删除存储在哈希表的指定字段的值
        hashOperations.delete("hashKey1","nameH");

        //HKEYS Ksy :获取指定key的哈希表中所有数据
        System.out.println("---------------------HKEYS Ksy :获取指定key的哈希表中所有数据");
        Set keys = hashOperations.keys("hashkey1");
        for (Object data:keys) {
            System.out.println(data);
        }
        //HVALS key:获取哈希表所有值
        System.out.println("---------------------HVALS key:获取哈希表所有值");
        List values = hashOperations.values("hashKey1");
        for (Object data:values) {
            System.out.println(data);
        }




    }

}
