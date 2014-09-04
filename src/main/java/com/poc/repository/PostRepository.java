package com.poc.repository;

import com.poc.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PostRepository {

    @Autowired
    protected JdbcTemplate jdbc;

    public Post getPosts() {
        return jdbc.queryForObject("SELECT * FROM post", itemMapper);
    }

    private static final RowMapper<Post> itemMapper = new RowMapper<Post>() {
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post(rs.getInt("id"), rs.getString("name"));
            return post;
        }
    };
}