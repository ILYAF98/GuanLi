package com.prj.server.exam;

import com.prj.entity.Exam;
import com.prj.server.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;


import java.sql.PreparedStatement;
import java.util.List;

public class Exam_Function {
        private JdbcTemplate template = new JdbcTemplate (JDBCUtil.getDs ());
        private String sql;
        private PreparedStatement stem;

    /**
     * 查询功能
     * @param id int
     * @return list List
     */
    public List < Exam > Find(int id) {

        return template.query (connection -> {
            sql = "select * from exam where id = ?";
            stem = connection.prepareStatement (sql);
            stem.setInt (1,id);
            return stem;
        }, new BeanPropertyRowMapper <> (Exam.class));
    }

    /**
     * 删除功能
     * @param id int
     */
    public void Delete(int id) {

        template.execute (connection -> {
            sql = "Delete from exam where id =?";
            stem = connection.prepareStatement (sql);
            stem.setInt (1, id);
            return stem;
        }, (PreparedStatementCallback < Object >) preparedStatement -> {
            preparedStatement.execute ();
            return null;
        });
    }

    /**
     * 增加功能
     * @param exam Exam
     */
    public void Add(Exam exam) {

        template.update (connection -> {
            sql = "insert into exam values (?,?,?,?,?,?);";
            stem = connection.prepareStatement (sql);
            stem.setInt (1, exam.getId ( ) );
            stem.setString (2,exam.getTitle ( ) );
            stem.setString (3,exam.getInfo ( ) );
            stem.setString (4,exam.getAnswer ( ) );
            stem.setInt (5, exam.getMid ( ));
            stem.setString (6,exam.getImageUrl ( ) );
            return stem;
        });
    }

    /**
     * 更新方法
     * @param id int
     * @param title String
     */
    public void UpdateTitle(int id, String title){

         template.update(connection -> {
             sql = "update exam set title = ? where id = ?;";
             stem = connection.prepareStatement (sql);
             stem.setString (1,title);
             stem.setInt (2,id);
             return stem;
         });
    }

    public void UpdateInfo(int id, String info) {

         template.update (connection -> {
             sql = "update exam set info =? where id = ?;";
             stem = connection.prepareStatement (sql);
             stem.setString (1, info);
             stem.setInt (2, id);
             return stem;
         });
    }

    public void UpdateAnswer(int id, String answer){

         template.update(connection -> {
             sql = "update exam set answer =? where id = ?;";
             stem = connection.prepareStatement (sql);
             stem.setString (1,answer);
             stem.setInt (2,id);
             return stem;
         });

    }

    public void UpdateMid(int id, int mid){

        template.update(connection -> {
            sql = "update exam set mid =? where id = ?;";
            stem = connection.prepareStatement (sql);
            stem.setInt (1,mid);
            stem.setInt (2,id);
            return stem;
        });

    }

    public void UpdateImageUrl(int id, String imageUrl){

        template.update(connection -> {
            sql = "update exam set imageUrl = ? where id = ?;";
            stem = connection.prepareStatement (sql);
            stem.setString (1,imageUrl);
            stem.setInt (2,id);
            return stem;
        });

    }

}
