package com.springboot.ibiza.surveyapp.dao.jdbc.answer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.ibiza.surveyapp.jdbc.beans.AnswerBean;

public class AnswerRowMapper implements RowMapper<AnswerBean>{

	@Override
	public AnswerBean mapRow(ResultSet rs, int row) throws SQLException {
		AnswerBean answer = new AnswerBean();
		answer.setAnswerId(rs.getInt("id"));
		answer.setAnswer(rs.getString("answer"));
		return answer;
	}

}
