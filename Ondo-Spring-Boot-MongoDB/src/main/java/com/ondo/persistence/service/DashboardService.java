package com.ondo.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondo.document.DashboardDOC;
import com.ondo.document.WearerDOC;
import com.ondo.document.WearerDashboardResultDOC;
import com.ondo.model.OndoResponse;
import com.ondo.persistence.dal.Address;
import com.ondo.persistence.dal.DashboardDAL;
import com.ondo.persistence.dal.UserInfo;

@Service
public class DashboardService {

	@Autowired
	DashboardDAL dashBoardDAL;

	public List<DashboardDOC> getDashboard(String userId) {
		return dashBoardDAL.getDashboard(userId);

	}

	public DashboardDOC createDashboard(DashboardDOC dashboard) {
		return dashBoardDAL.createDashboard(dashboard);

	}

	public DashboardDOC deleteLiveData(String userId) {
		return dashBoardDAL.deleteLiveData(userId);
	}

	public WearerDOC createWearer(WearerDOC wearer) {
		return dashBoardDAL.createWearer(wearer);
	}

	public List<OndoResponse> getWearer(String facilityId) {
		return dashBoardDAL.getWearer(facilityId);
	}

	public Address createAddress(Address address) {
		return dashBoardDAL.createAddress(address);
	}

	public UserInfo createUserInfo(UserInfo userInfo) {
		return dashBoardDAL.createUserInfo(userInfo);
	}
}
