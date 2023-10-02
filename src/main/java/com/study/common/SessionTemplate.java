package com.study.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Getter
@Slf4j
public class SessionTemplate {

    public static SqlSession getSession() {

        SqlSession session=null;

        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            log.info("builder : {}", builder);
            InputStream is= Resources.getResourceAsStream("/mybatis-config.xml");
            log.info("is : {}", is);
            SqlSessionFactory factory = builder.build(is);
            log.info("factory : {}", factory);
            session = factory.openSession(false);

        }catch(IOException e) {
            e.printStackTrace();
        }

        return session;
    }
}
