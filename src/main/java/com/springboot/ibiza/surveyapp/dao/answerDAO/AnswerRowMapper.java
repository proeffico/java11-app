package com.springboot.ibiza.surveyapp.dao.answerDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.ibiza.surveyapp.domain.AnswerDomain;

public class AnswerRowMapper implements RowMapper<AnswerDomain>{

	@Override
	public AnswerDomain mapRow(ResultSet rs, int row) throws SQLException {
		AnswerDomain answer = new AnswerDomain();
		answer.setAnswerId(rs.getInt("id"));
		answer.setAnswer(rs.getString("answer"));
		return answer;
	}

}
