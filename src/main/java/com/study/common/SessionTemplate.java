package com.study.common;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Getter
public class SessionTemplate {

    public static SqlSession getSession() {

        SqlSession session=null;

        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

            InputStream is= Resources.getResourceAsStream("/mybatis-config.xml");

            SqlSessionFactory factory = builder.build(is);

            session = factory.openSession(false);

        }catch(IOException e) {
            e.printStackTrace();
        }

        return session;
    }
}
