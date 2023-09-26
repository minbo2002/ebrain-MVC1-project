package com.study.servlet.dao;

import com.study.servlet.vo.BoardFile;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDao {

    static final Logger log = LoggerFactory.getLogger(FileDao.class);

    public int createFile(SqlSession session, BoardFile boardFile) {

        return session.insert("file.create", boardFile);

    }
}
