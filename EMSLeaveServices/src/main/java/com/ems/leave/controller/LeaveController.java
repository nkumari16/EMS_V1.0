package com.ems.leave.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.leave.constant.LeaveConstants;
import com.ems.leave.model.LeaveData;
import com.ems.leave.model.Response;
import com.ems.leave.service.LeaveServiceImpl;

/**
 * 
 * @author yogesh.patil
 *
 */
@RestController
public class LeaveController implements LeaveConstants {

	@Autowired
	LeaveServiceImpl leaveService;

	@RequestMapping("/getLeaveDataForAllEmployees")
	public JSONObject getLeaveDataForAllEmployees() {
		JSONObject jsonObject = leaveService.getLeaveDataForAllEmployees();
		return jsonObject;
	}

	@RequestMapping("/getLeaveDataByEmployeeId/{empid}")
	public JSONObject getLeaveData(@PathVariable String empid) {
		JSONObject jsonObject = leaveService.getLeaveDataByEmployeeId(empid);
		return jsonObject;
	}

	@RequestMapping(value = "/applyLeave", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Response submitLeave(@RequestBody LeaveData leaveData) {
		Response responseMessage = leaveService.applyLeave(leaveData);
		return responseMessage;
	}
}
