package com.placetopay.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placetopay.apirest.dao.IAnswerDao;
import com.placetopay.apirest.entity.Answer;
import com.placetopay.apirest.service.IAnswerService;

@RestController
@RequestMapping("/api")
public class AnswerController {

	@Autowired
	private IAnswerService answerService;
	
	@Autowired
	private IAnswerDao answerDao;
	
	@GetMapping("/answer")
	public List<Answer> all(){
		return answerService.findAll();
	}
	
	@PostMapping("/answer")
	public Answer newAnswer(@RequestBody Answer answer) {
		return answerService.create(answer);
	}
	
	@PostMapping("/answer/{id}")
	public Answer updateAnswer(@RequestBody Answer newAnswer, @PathVariable Long id) {
		return answerDao.findById(id)
				.map(answer -> {
					answer.setStatus(newAnswer.getStatus());
					answer.setMessage(newAnswer.getMessage());
					answer.setDate(newAnswer.getDate());
					return answerDao.save(answer);
				})
				.orElseGet(()-> {
					newAnswer.setRequestId(id);
					return answerDao.save(newAnswer);
				});
	}
}

















