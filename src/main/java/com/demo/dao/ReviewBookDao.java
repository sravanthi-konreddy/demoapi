package com.demo.dao;

import com.demo.model.ReviewBook;

public interface ReviewBookDao {
	
	public int insertReviewBook(ReviewBook reviewBook);
	
	public boolean checkReviewExists(ReviewBook reviewBook);
	
	public int updateReviewBook(ReviewBook reviewBook);
	
	

}
