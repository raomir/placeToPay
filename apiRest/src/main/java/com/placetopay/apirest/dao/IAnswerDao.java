/**
 * 
 */
package com.placetopay.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placetopay.apirest.entity.Answer;

/**
 * @author CUSPIDE4
 *
 */

public interface IAnswerDao extends JpaRepository<Answer, Long>{

}
