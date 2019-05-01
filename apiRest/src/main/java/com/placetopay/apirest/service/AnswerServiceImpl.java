package com.placetopay.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placetopay.apirest.dao.IAnswerDao;
import com.placetopay.apirest.entity.Answer;

@Service
public class AnswerServiceImpl implements IAnswerService {

	@Autowired
	private IAnswerDao answerDao;
	
	@Override
	public List<Answer> findAll() {
		return (List<Answer>) answerDao.findAll();
	}

	@Override
	public Answer create(Answer answer) {
		// TODO Auto-generated method stub
		return answerDao.save(answer);
	}

	@Override
	public Answer update(Answer answer) {
		// TODO Auto-generated method stub
		return answerDao.save(answer);
	}

	@Override
	public Optional<Answer> findById(Long id) {
		// TODO Auto-generated method stub
		return answerDao.findById(id);
	}

}
