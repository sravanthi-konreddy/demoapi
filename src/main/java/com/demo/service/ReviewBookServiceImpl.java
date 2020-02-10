package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ReviewBookDao;
import com.demo.model.ReviewBook;

@Service
public class ReviewBookServiceImpl implements ReviewBookService {
	
	@Autowired
	ReviewBookDao reviewBookDAO;

	@Override
	@Transactional
	public int insertReviewBook(ReviewBook reviewBook) {
		return reviewBookDAO.insertReviewBook(reviewBook);
		//return 0;
	}

	@Override
	@Transactional
	public boolean checkReviewExists(ReviewBook reviewBook) {
		// TODO Auto-generated method stub
		return reviewBookDAO.checkReviewExists(reviewBook);
		//return false;
	}

	@Override
	@Transactional
	public int updateReviewBook(ReviewBook reviewBook) {
		// TODO Auto-generated method stub
		return reviewBookDAO.updateReviewBook(reviewBook);
		//return 0;
	}

}
