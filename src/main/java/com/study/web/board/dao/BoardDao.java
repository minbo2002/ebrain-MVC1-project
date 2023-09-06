package com.study.web.board.dao;

import com.study.connection.ConnectionTest;
import com.study.web.board.entity.Board;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao extends ConnectionTest {

    private Connection conn = null;
    private ResultSet rs = null;

    public BoardDao() {
        try {
            String DB_URL = "jdbc:mysql://localhost:3306/ebrainsoft_study";
            String USER = "root";
            String PASS = "cos1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 현재날짜 가져오기
    public String getDate() {
        String SQL = "SELECT NOW()";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ""; // 데이터베이스 오류
    }

    // 다음 글 번호  ex)만약 조회된 글 번호가 5개면 6출력
    public int getNext() {

        String SQL = "SELECT board_id FROM board ORDER BY board_id DESC";

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getInt(1) + 1;  // 컬럼번호+1 --> 즉 다음 글 번호 출력
            }
            return 1;   // 첫 번째 게시물인 경우

        }catch (Exception e) {
            e.printStackTrace();
        }
        return -1;  // 데이터베이스 오류
    }

    public ArrayList<Board> getList(int pageNumber) {

        // String SQL = "SELECT * FROM board WHERE board_id < ? ORDER BY board_id DESC LIMIT 10";
        String SQL = "SELECT a.board_id, b.category_name, a.writer, a.title, a.content, a.count, a.board_pw, a.created_at, a.modified_at \n" +
                     "FROM board a JOIN category b ON a.category_id=b.category_id WHERE board_id < ? ORDER BY board_id DESC LIMIT 10";

        ArrayList<Board> list = new ArrayList<Board>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Board board = new Board();
                board.setBoardId(rs.getLong("board_id"));
                board.setCategory_name(rs.getString("category_name"));
                board.setWriter(rs.getString("writer"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setCount(rs.getInt("count"));
                board.setBoardPw(rs.getString("board_pw"));
                board.setCreatedAt(rs.getString("created_at"));
                board.setModifiedAt(rs.getString("modified_at"));
                list.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean nextPage(int pageNumber) {

        String SQL = "SELECT * FROM board WHERE board_id < ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
