package com.chinmaya.cache.appzillon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chinmaya.cache.appzillon.model.WorkflowDetail;
import com.chinmaya.cache.appzillon.model.WorkflowDetailId;

@Repository
public interface WorkflowDetailRepository extends CrudRepository<WorkflowDetail, WorkflowDetailId> {
}
