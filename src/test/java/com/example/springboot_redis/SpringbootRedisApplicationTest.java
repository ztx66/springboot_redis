package com.example.springboot_redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

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

    /*@Test
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




    }*/

    /*@Test
    public void listTest(){

        ListOperations listOperations = redisTemplate.opsForList();

        //LPUSH key value1 [value2] :将一个或多个值插入集合列表
        *//*listOperations.leftPush("listkey1","a"); //listPush 方法只能一次插入一个值*//*
        *//*listOperations.leftPushAll("listkey1","b","c","d");*//* // 这个方法可以一次性向list集合中储存多个元素值

        //LRANGE key start stop :获取list集合列表中的元素
        *//*List list=  listOperations.range("listkey1",0,-1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*//*

        //LLen key:获取列表长度
        Long size= listOperations.size("listkey1");
        System.out.println(size);

        *//**
         *  对应的命令：BRPOP key1 [key2 ] timeout ：移除并获取列表的最后一个元素，如果该list列表中没有元素了，
         *  那么就会阻塞列表直到列表中有了新的元素即可，阻塞多久是可以设定的。
         *//*
        Object object=  listOperations.leftPop("listkey1");
        System.out.println(object);

    }*/

    @Test
    public void ZSet(){

        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

        zSetOperations.add("zSetKey1","小一",1.0);
        zSetOperations.add("zSetKey1","小二",2.0);
        zSetOperations.add("zSetKey1","小三",3.0);

       Set zSet=  zSetOperations.range("zSetKey1",0,-1);
       for (Object set : zSet) {
           System.out.println(set);
       }

       //为集合中的元素增加分数:ZINCRBY KSY INCREMENT member
        zSetOperations.incrementScore("zSetKey1","小一",4.0);
        Set zSet2=zSetOperations.range("zSetKey1",0,-1);
        for (Object set : zSet2) {
            System.out.println(set);
        }


    }



}
