package com.lti.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bus;

@Repository 
public class SearchDao extends GenericDao  {
		
	public List<Bus> SearchResult(String source, String destination) {
		String query = "select b from Bus b where b.source =: src and b.destination =: dest";
		Query q=entityManager.createQuery(query);
		q.setParameter("src", source);
		q.setParameter("dest", destination);
		return q.getResultList();
	}
}
