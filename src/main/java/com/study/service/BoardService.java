package com.study.service;

import com.study.dto.BoardPage;

public interface BoardService {

    public BoardPage getBoard(int pageNo, int rowSize, String searchOption, String searchWord);

}
