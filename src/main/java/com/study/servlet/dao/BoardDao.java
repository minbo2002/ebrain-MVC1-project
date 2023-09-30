package com.study.servlet.dao;

import com.study.servlet.dto.response.BoardListDto;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDao {

    static final Logger log = LoggerFactory.getLogger(BoardDao.class);

    public List<BoardListDto> boardList(SqlSession session, int startRow , int rowSize, String searchOption, String searchWord) {

        Map<String, Object> boardList = new HashMap<String, Object>();
        boardList.put("startRow", startRow);
        boardList.put("rowSize", rowSize);
        boardList.put("searchOption", searchOption);
        boardList.put("searchWord", searchWord);

        return session.selectList("board.list", boardList);

    }

    public int boardCount(SqlSession session, String searchOption, String searchWord) {

        Map<String, Object> boardCount = new HashMap<String, Object>();
        boardCount.put("searchOption", searchOption);
        boardCount.put("searchWord", searchWord);

        return session.selectOne("board.count", boardCount);

    }

//    public int createBoard(SqlSession session, Board board) {
//
//        return session.insert("board.create", board);
//
//    }

}
