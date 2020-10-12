package com.ondo.persistence.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ondo.document.DashboardDOC;

@Repository
public interface OndoRepository extends MongoRepository<DashboardDOC, String> {
	
	
}
