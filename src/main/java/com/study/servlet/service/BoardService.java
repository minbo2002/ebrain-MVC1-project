package com.study.servlet.service;

import com.study.servlet.dto.request.BoardDto;
import com.study.servlet.dto.response.BoardPage;

public interface BoardService {

    BoardPage getBoard(int pageNo, int rowSize, String searchOption, String searchWord);

    int createBoard(BoardDto createBoard);



}
