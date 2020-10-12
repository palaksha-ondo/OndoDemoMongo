package com.ondo.persistence.dal;

import java.util.List;

import com.ondo.document.DashboardDOC;
import com.ondo.document.WearerDOC;
import com.ondo.document.WearerDashboardResultDOC;
import com.ondo.model.OndoResponse;

public interface DashboardDAL {

	List<DashboardDOC> getDashboard(String userId);

	DashboardDOC createDashboard(DashboardDOC dashboard);

	DashboardDOC deleteLiveData(String userId);

	WearerDOC createWearer(WearerDOC wearer);

	List<OndoResponse> getWearer(String facilityId);

	Address createAddress(Address address);

	UserInfo createUserInfo(UserInfo userInfo);

	
}