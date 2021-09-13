package com.melihsen.studentCourseManagementApi.repository;

import com.melihsen.studentCourseManagementApi.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class StudentRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Student> getAll(){
        String sql = "Select * from \"OBS\".\"OGRENCI\"";
        return namedParameterJdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Student(resultSet.getInt("OGR_ID"),resultSet.getInt("OGR_NUM"),resultSet.getString("OGR_NAME"));
            }
        });
    }

}
