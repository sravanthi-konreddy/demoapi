package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.ReviewBook;

@Repository
public class ReviewBookDaoImpl implements ReviewBookDao {
	
	@Autowired
	SessionFactory session;

	@Override
	public int insertReviewBook(ReviewBook reviewBook) {
		// TODO Auto-generated method stub
		System.out.println("uname::"+reviewBook.getUsername());
		System.out.println("id"+reviewBook.getId());
		System.out.println("review"+reviewBook.getReview());
		System.out.println("rating"+reviewBook.getRating());
		if(session.getCurrentSession().save(reviewBook)!=null)
		{
			System.out.println("success insert");
			return 1;
			
		}
			
		return 0;
	}

	@Override
	public  boolean checkReviewExists(ReviewBook reviewBook) {
		// TODO Auto-generated method stub
		Query query=session.getCurrentSession().createQuery("SELECT COUNT(*) FROM ReviewBook WHERE username=:uname AND id=:id");
		query.setParameter("uname", reviewBook.getUsername());
		query.setParameter("id", reviewBook.getId());
		List result=query.getResultList();
		System.out.println("result:::"+result.get(0).toString());
		if(!(result.get(0).toString().equals("1")))
			return true;
		return false;
		//return 0;
	}

	@Override
	public int updateReviewBook(ReviewBook reviewBook) {
		// TODO Auto-generated method stub
		Query query=session.getCurrentSession().createQuery("UPDATE ReviewBook SET rating=:rating WHERE username=:uname AND id=:id");
		
		query.setParameter("rating", reviewBook.getRating());
		query.setParameter("uname", reviewBook.getUsername());
		query.setParameter("id", reviewBook.getId());
		return query.executeUpdate();
		
	}

}
