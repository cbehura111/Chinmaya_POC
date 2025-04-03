package com.chinmaya.cache.appzillon.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class WorkflowMasterId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "WORKFLOW_ID")
	private String workflowId;

	@Column(name = "INTERFACE_ID")
	private String interfaceId;

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

	@Override
	public String toString() {
		return "WorkflowMasterId [workflowId=" + workflowId + ", interfaceId=" + interfaceId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkflowMasterId other = (WorkflowMasterId) obj;
		return Objects.equals(interfaceId, other.interfaceId) && Objects.equals(workflowId, other.workflowId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(interfaceId, workflowId);
	}
}
