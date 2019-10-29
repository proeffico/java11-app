package com.springboot.ibiza.surveyapp.dao.jdbc.answer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.jdbc.beans.AnswerBean;

@Repository
public class AnswerDaoImpl implements AnswerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public boolean isAnswerExist(AnswerBean answer) {
		return false;
	}

	@Override
	public int insertNewAnswer(List<AnswerBean> answers) {
		return 0;
	}

	@Override
	public List<AnswerBean> findAllAnswers() {
		String sql = "SELECT * FROM answer";
		RowMapper<AnswerBean> rm = new AnswerRowMapper();
		try {
			List<AnswerBean> list = jdbcTemplate.query(sql, rm);
			return (list != null && list.size() > 0)? list : null;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
