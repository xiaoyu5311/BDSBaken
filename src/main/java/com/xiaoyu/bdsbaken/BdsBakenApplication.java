package com.xiaoyu.bdsbaken;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.xiaoyu.bdsbaken.mapper")
public class BdsBakenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BdsBakenApplication.class, args);
    }
}
