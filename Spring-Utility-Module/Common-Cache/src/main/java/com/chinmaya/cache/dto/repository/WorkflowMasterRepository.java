package com.chinmaya.cache.appzillon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chinmaya.cache.appzillon.model.WorkflowMaster;
import com.chinmaya.cache.appzillon.model.WorkflowMasterId;

@Repository
public interface WorkflowMasterRepository extends CrudRepository<WorkflowMaster, WorkflowMasterId> {
}
