package com.chinmaya.cache.appzillon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ABMI_WORKFLOW_DETAIL")
@IdClass(WorkflowDetailId.class)
public class WorkflowDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String workflowId;

	@Id
	private String interfaceId;

	@Id
	private int stepNo;

	@Column(name = "SERVICE_TYPE")
	private String serviceType;

	@Column(name = "SERVICE_ACTION")
	private String serviceAction;

	@Column(name = "SERVICE_FORMAT")
	private String serviceFormat;

	@Column(name = "VALIDATION_REQUIRED")
	private String validationRequired;

	@Column(name = "VALIDATION_ARGUMENT")
	private String validationArgument;

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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceAction() {
		return serviceAction;
	}

	public void setServiceAction(String serviceAction) {
		this.serviceAction = serviceAction;
	}

	public String getServiceFormat() {
		return serviceFormat;
	}

	public void setServiceFormat(String serviceFormat) {
		this.serviceFormat = serviceFormat;
	}

	public String getValidationRequired() {
		return validationRequired;
	}

	public void setValidationRequired(String validationRequired) {
		this.validationRequired = validationRequired;
	}

	public String getValidationArgument() {
		return validationArgument;
	}

	public void setValidationArgument(String validationArgument) {
		this.validationArgument = validationArgument;
	}

	@Override
	public String toString() {
		return "WorkflowDetail [workflowId=" + workflowId + ", interfaceId=" + interfaceId + ", stepNo=" + stepNo
				+ ", serviceType=" + serviceType + ", serviceAction=" + serviceAction + ", serviceFormat="
				+ serviceFormat + ", validationRequired=" + validationRequired + ", validationArgument="
				+ validationArgument + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkflowDetail other = (WorkflowDetail) obj;
		return Objects.equals(interfaceId, other.interfaceId) && Objects.equals(serviceAction, other.serviceAction)
				&& Objects.equals(serviceFormat, other.serviceFormat) && Objects.equals(serviceType, other.serviceType)
				&& stepNo == other.stepNo && Objects.equals(validationArgument, other.validationArgument)
				&& Objects.equals(validationRequired, other.validationRequired)
				&& Objects.equals(workflowId, other.workflowId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(interfaceId, serviceAction, serviceFormat, serviceType, stepNo, validationArgument,
				validationRequired, workflowId);
	}
}