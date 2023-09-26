package com.study.servlet.service;

import com.study.common.SessionTemplate;
import com.study.servlet.dao.BoardDao;
import com.study.servlet.dto.BoardPage;
import com.study.servlet.vo.Board;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao = new BoardDao();
    static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Override
    public BoardPage getBoard(int pageNo, int rowSize, String searchOption, String searchWord) {

        SqlSession session = null;
        BoardPage boardPage;

        try {
            session = SessionTemplate.getSession();

            int boardCount = boardDao.boardCount(session, searchOption, searchWord);
            List<Board> list = boardDao.boardList(session, (pageNo-1)*rowSize, rowSize, searchOption, searchWord);
            boardPage = new BoardPage(boardCount, pageNo, rowSize, list);

        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return boardPage;
    }

}
