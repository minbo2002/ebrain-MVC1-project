//package com.study.mvc1.dao;
//
//import com.study.connection.ConnectionTest;
//import com.study.connection.JdbcUtil;
//import com.study.servlet.vo.Board;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//public class BoardDao extends ConnectionTest {
//
//    Connection conn = null;
//    ResultSet rs = null;
//
//    public BoardDao() {
//        try {
//            String DB_URL = "jdbc:mysql://localhost:3306/ebrainsoft_study";
//            String USER = "root";
//            String PASS = "cos1234";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 현재날짜 가져오기
//    public String getDate() {
//        String SQL = "SELECT NOW()";
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(SQL);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                return rs.getString(1);  // 현재날짜 반환
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ""; // 데이터베이스 오류
//    }
//
//    // 다음 글 번호  ex) 만약 조회된 글 번호가 5개면 6출력
//    public int getNext() {
//
//        String SQL = "SELECT board_id FROM board ORDER BY board_id DESC"; // 내림차순으로 가장 마지막에 쓰인 글번호를 가져온다.
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(SQL);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                return rs.getInt(1) + 1;  // 글번호+1 --> 즉 다음 글번호를 반환.
//            }
//            return 1;   // 첫 번째 게시물인 경우 1 반환
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return -1;  // 데이터베이스 오류
//    }
//
//    // 다음 페이지
//    public boolean nextPage(int pageNumber) {
//
//        String SQL = "SELECT * FROM board WHERE board_id < ?";
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(SQL);
//            pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//    // 게시판 목록
//    public ArrayList<Board> getList(int pageNumber) {
//
//        // String SQL = "SELECT * FROM board WHERE board_id < ? ORDER BY board_id DESC LIMIT 10";
//        String SQL = "SELECT a.board_id, b.category_id, a.writer, a.title, a.content, a.count, a.board_pw, a.board_repw, a.created_at, a.modified_at \n" +
//                "FROM board a JOIN category b ON a.category_id=b.category_id WHERE board_id < ? ORDER BY board_id DESC LIMIT 10";
//
//        ArrayList<Board> list = new ArrayList<Board>();
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(SQL);
//            pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                Board board = new Board();
//                board.setBoardId(rs.getLong("board_id"));
//                board.getCategoryId(rs.getLong("category_id"));
//                board.setWriter(rs.getString("writer"));
//                board.setTitle(rs.getString("title"));
//                board.setContent(rs.getString("content"));
//                board.setCount(rs.getInt("count"));
//                board.setBoardPw(rs.getString("board_pw"));
//                board.setBoardRePw(rs.getString("board_repw"));
//                // board.setCreatedAt() 를 LocalDateTime 타입으로 만들어야해.
//                board.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
//                board.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
//                list.add(board);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//        return list;
//    }
//
//    // 카테고리  작성자  제목  내용  조회수  비밀번호  작성일  수정일
//    public int write(Long categoryId, String writer, String title, String content, int count, String boardPw, String boardRePw, String createdAt, String modifiedAt) {
//
//        String SQL = "INSERT INTO board(category_id, writer, title, content, count, board_pw, board_repw, created_at, modified_at) " +
//                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//            conn.setAutoCommit(false);
//
//            PreparedStatement pstmt = conn.prepareStatement(SQL);
//
//            pstmt.setLong(1, categoryId);
//            pstmt.setString(2, writer);
//            pstmt.setString(3, title);
//            pstmt.setString(4, content);
//            pstmt.setInt(5, 0); // 기본 조회수 0
//            pstmt.setString(6, boardPw);
//            pstmt.setString(7, boardRePw);
//            pstmt.setString(8, createdAt);
//            pstmt.setString(8, modifiedAt);
////            pstmt.setTimestamp(8, Timestamp.valueOf(createdAt));
////            pstmt.setTimestamp(9, Timestamp.valueOf(modifiedAt));
//
//            rs = pstmt.executeQuery();
//            conn.commit();
//
//            return pstmt.executeUpdate();
//
//        }catch (Exception e) {
//
//            if(conn != null) {
//                try {
//                    JdbcUtil.rollback(conn);
//                }catch (Exception e2) {
//                    e2.printStackTrace();
//                }
//            }
//
//        }
//
//        return -1;  // 데이터베이스 오류
//    }
//}
