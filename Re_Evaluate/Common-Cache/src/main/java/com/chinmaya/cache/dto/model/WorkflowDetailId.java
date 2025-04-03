package com.chinmaya.cache.appzillon.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class WorkflowDetailId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "WORKFLOW_ID")
	private String workflowId;

	@Column(name = "INTERFACE_ID")
	private String interfaceId;

	@Column(name = "STEP_NUMBER")
	private int stepNo;

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public int getStepNo() {
		return stepNo;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	@Override
	public String toString() {
		return "WorkflowDetailId [workflowId=" + workflowId + ", interfaceId=" + interfaceId + ", stepNo=" + stepNo
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkflowDetailId other = (WorkflowDetailId) obj;
		return Objects.equals(interfaceId, other.interfaceId) && stepNo == other.stepNo
				&& Objects.equals(workflowId, other.workflowId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(interfaceId, stepNo, workflowId);
	}
}
