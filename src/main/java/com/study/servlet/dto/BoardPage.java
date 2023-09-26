package com.study.servlet.dto;

import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class BoardPage {

    private int total;			 //전체게시물수
    private int currentPage;	 //현재 페이지(요청페이지)
    private List<BoardListDto> list;    //게시글목록정보(글번호,제목,작성자,조회수,최초작성일,마지막수정일,노출여부)
    private int totalPages;		 //총페이지수
    private int startPage;		 //시작페이지번호
    private int endPage;		 //끝페이지번호

    public BoardPage(int total, int currentPage, int size, List<BoardListDto> list) {

        this.total = total;
        this.currentPage = currentPage;
        this.list = list;

        if (total == 0) { //게시물이 존재하지 않는 경우
            totalPages = 0;
            startPage = 0;
            endPage = 0;

        }else { //게시물이 존재하는 경우
            totalPages = total/size; //총페이지수=전체게시물수/1page당 보여줄 게시물수

            if (total%size>0) {      //나머지가 0보다 크면
                totalPages++;        //전체페이수를 1씩증가
            }
            int modVal=currentPage%5;  //user가 보려하는 요청페이지를 5로 나눈 나머지를 저장
            // 요청페이지가 1-> modVal은 1
            // 요청페이지가 2-> modVal은 2
            // 요청페이지가 3-> modVal은 3
            // 요청페이지가 4-> modVal은 4
            // 요청페이지가 5-> modVal은 0

            startPage =currentPage/5*5 + 1;
            // 요청페이지가 1-> startPage는 1
            // 요청페이지가 2-> startPage는 1
            // 요청페이지가 3-> startPage는 1
            // 요청페이지가 4-> startPage는 1
            // 요청페이지가 5-> startPage는 6

            //modVal==0은 요청페이지가 5의배수인 5 10 15....
            if (modVal==0) startPage-=5;//startPage=startPage-5;

            endPage = startPage + 4;
            //endPage가 전체페이수보다크면  endPage값을 전체페이수로 적용해라
            if(endPage>totalPages) endPage=totalPages;
        }
    }

    // 게시글없니? 게시글없으면 true리턴
    public boolean hasNoBoards() {
        return total == 0;
    }

    //게시글이 존재하니? 게시글 있으면 true
    public boolean hasBoards() {
        return total > 0;
    }
}
