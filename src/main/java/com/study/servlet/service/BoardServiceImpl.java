package com.study.servlet.service;

import com.study.common.SessionTemplate;
import com.study.servlet.dao.BoardDao;
import com.study.servlet.dao.FileDao;
import com.study.servlet.dto.request.BoardDto;
import com.study.servlet.dto.response.BoardListDto;
import com.study.servlet.dto.response.BoardPage;
import com.study.servlet.vo.Board;
import com.study.servlet.vo.BoardFile;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao = new BoardDao();
    private final FileDao fileDAO = new FileDao();
    static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Override
    public BoardPage getBoard(int pageNo, int rowSize, String searchOption, String searchWord) {
        log.info("getBoard() 실행");

        SqlSession session = null;
        BoardPage boardPage;

        try {

            session = SessionTemplate.getSession();
            log.info("session : {}", session);

            int boardCount = boardDao.boardCount(session, searchOption, searchWord);
            List<BoardListDto> boardList = boardDao.boardList(session, (pageNo - 1) * rowSize, rowSize, searchOption, searchWord);
            log.info("게시판 개수 : {}", boardCount);
            log.info("게시판 리스트 : {}", boardList);

            boardPage = new BoardPage(boardCount, pageNo, rowSize, boardList);

        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return boardPage;
    }

    @Override
    public int createBoard(BoardDto boardDto) {

        SqlSession session = null;
        int cnt = 0;

        Board board = Board.builder()
                .categoryId(boardDto.getCategoryId())
                .writer(boardDto.getWriter())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .count(0)
                .boardPw(boardDto.getBoardPw())
                .boardRePw(boardDto.getBoardRePw())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        try {
            session = SessionTemplate.getSession();

            int createBoardCount = boardDao.createBoard(session, board);
            log.info("생성된 게시판 개수 : {}", createBoardCount);

            // 생성된 게시판의 id를 가져옴
            Long boardId = board.getBoardId();

            // 저장할 이미지의 이름이 있다면
            if(boardDto.getBoardFile().getFileOriName()!=null) {

                // 입력한 이미지 파일 데이터를 갖는 파일객체 생성
                BoardFile boardFile = BoardFile.builder()
                        .fileOriName(boardDto.getBoardFile().getFileOriName())
                        .fileName(boardDto.getBoardFile().getFileName())
                        .boardId(boardId)
                        .build();

                // 파일 DB에 저장
                fileDAO.createFile(session, boardFile);
            }

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if(session!=null) {
                session.rollback();
            }

        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return board.getBoardId().intValue();
    }

}
