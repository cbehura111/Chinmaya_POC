package com.chinmaya.cache.appzillon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ABMI_WORKFLOW_MASTER")
@IdClass(WorkflowMasterId.class)
public class WorkflowMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String workflowId;

	@Id
	private String interfaceId;

	@Column(name = "STEPS")
	private int steps;

	@Column(name = "WORKFLOW_PARAMETER")
	private String workflowParameter;

	@Column(name = "SEQUENCE_NUMBER")
	private int sequenceNo;

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

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public String getWorkflowParameter() {
		return workflowParameter;
	}

	public void setWorkflowParameter(String workflowParameter) {
		this.workflowParameter = workflowParameter;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	@Override
	public String toString() {
		return "WorkflowMaster [workflowId=" + workflowId + ", interfaceId=" + interfaceId + ", steps=" + steps
				+ ", workflowParameter=" + workflowParameter + ", sequenceNo=" + sequenceNo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkflowMaster other = (WorkflowMaster) obj;
		return Objects.equals(interfaceId, other.interfaceId) && sequenceNo == other.sequenceNo && steps == other.steps
				&& Objects.equals(workflowId, other.workflowId)
				&& Objects.equals(workflowParameter, other.workflowParameter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(interfaceId, sequenceNo, steps, workflowId, workflowParameter);
	}
}
