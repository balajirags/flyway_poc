package com.poc.repository;

import com.poc.models.Post;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    @Autowired
    protected JdbcTemplate jdbc;

    public List<Post> getPosts() {
        return jdbc.queryForObject("SELECT * FROM post", POST_MAPPER);
    }

    private static final RowMapper<List<Post>> POST_MAPPER = new RowMapper<List<Post>>() {
        public List<Post> mapRow(ResultSet rs, int rowNum) throws SQLException {
            List<Post> postArrayList = new ArrayList<Post>();
            while(rs.next()){
                Post post = new Post(rs.getInt("id"), rs.getString("name"));
                postArrayList.add(post);
            }

            return postArrayList;
        }
    };
}