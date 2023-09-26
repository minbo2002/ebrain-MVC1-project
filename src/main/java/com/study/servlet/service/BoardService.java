package com.study.servlet.service;

import com.study.servlet.dto.BoardDto;
import com.study.servlet.dto.BoardPage;

public interface BoardService {

    public BoardPage getBoard(int pageNo, int rowSize, String searchOption, String searchWord);

    public int createBoard(BoardDto createBoard);



}
