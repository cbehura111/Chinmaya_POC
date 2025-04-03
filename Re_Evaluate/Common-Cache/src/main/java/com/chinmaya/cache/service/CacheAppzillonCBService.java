package com.chinmaya.cache.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinmaya.cache.appzillon.model.WorkflowDetail;
import com.chinmaya.cache.appzillon.model.WorkflowMaster;
import com.chinmaya.cache.appzillon.repository.WorkflowDetailRepository;
import com.chinmaya.cache.appzillon.repository.WorkflowMasterRepository;

@Service
public class CacheAppzillonCBService {

	@Autowired
	private WorkflowDetailRepository workflowDetailRepository;

	@Autowired
	private WorkflowMasterRepository workflowMasterRepository;

	protected static Map<String, WorkflowMaster> workflowMasterProperties = new HashMap<>();

	protected static Map<String, List<WorkflowDetail>> workflowDetailProperties = new HashMap<>();

	public void initializeWorkflowMasterProperties() {
		workflowMasterProperties = new HashMap<>();
		workflowMasterRepository.findAll().forEach(data -> workflowMasterProperties
				.put(data.getWorkflowId().concat(".").concat(data.getInterfaceId()), data));
	}

	public void initializeWorkflowDetailProperties() {

		/*
		 * workflowDetailRepository.findAll() .forEach(data ->
		 * workflowDetailProperties.put(
		 * data.getWorkflowId().concat(".").concat(data.getInterfaceId()).concat("." +
		 * data.getStepNo()), data));
		 */
		workflowDetailProperties = new HashMap<>();
		List<WorkflowDetail> workflowDetails = new ArrayList<>();
		workflowDetailRepository.findAll().forEach(workflowDetails::add);
		for (WorkflowDetail workflowDetail : workflowDetails) {
			String key = workflowDetail.getWorkflowId().concat(".").concat(workflowDetail.getInterfaceId());
			if (workflowDetailProperties.containsKey(key)) {
				List<WorkflowDetail> selectedList = workflowDetailProperties.get(key);
				selectedList.add(workflowDetail);
			} else {
				List<WorkflowDetail> newWorkflowDetailList = new ArrayList<>();
				newWorkflowDetailList.add(workflowDetail);
				workflowDetailProperties.put(key, newWorkflowDetailList);
			}
		}
	}

	public static Map<String, WorkflowMaster> getWorkflowMasterProperties() {
		return workflowMasterProperties;
	}

	public static Map<String, List<WorkflowDetail>> getWorkflowDetailProperties() {
		return workflowDetailProperties;
	}
}