/**
 * 
 */
package com.placetopay.apirest.service;

import java.util.List;
import java.util.Optional;

import com.placetopay.apirest.entity.Answer;

/**
 * @author CUSPIDE4
 *
 */
public interface IAnswerService {

	public List<Answer> findAll();
	
	public Optional<Answer> findById(Long id);
	
	public Answer create(Answer answer);
	
	public Answer update(Answer answer);
	
}
