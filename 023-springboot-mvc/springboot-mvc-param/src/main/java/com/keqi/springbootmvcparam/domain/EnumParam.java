package com.keqi.springbootmvcparam.domain;

import com.keqi.springbootmvcparam.emums.InspectionWorkStatusEnum;

public class EnumParam {

	private String name;

	private InspectionWorkStatusEnum inspectionWorkStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InspectionWorkStatusEnum getInspectionWorkStatus() {
		return inspectionWorkStatus;
	}

	public void setInspectionWorkStatus(InspectionWorkStatusEnum inspectionWorkStatus) {
		this.inspectionWorkStatus = inspectionWorkStatus;
	}
}
