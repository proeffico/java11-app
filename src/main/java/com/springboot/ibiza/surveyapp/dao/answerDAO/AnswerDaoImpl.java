package com.springboot.ibiza.surveyapp.dao.answerDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.domain.AnswerDomain;

@Repository
public class AnswerDaoImpl implements AnswerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public boolean isAnswerExist(AnswerDomain answer) {
		return false;
	}

	@Override
	public int insertNewAnswer(List<AnswerDomain> answers) {
		return 0;
	}

	@Override
	public List<AnswerDomain> findAllAnswers() {
		String sql = "SELECT * FROM answers";
		RowMapper<AnswerDomain> rm = new AnswerRowMapper();
		try {
			List<AnswerDomain> list = jdbcTemplate.query(sql, rm);
			return (list != null && list.size() > 0)? list : null;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
