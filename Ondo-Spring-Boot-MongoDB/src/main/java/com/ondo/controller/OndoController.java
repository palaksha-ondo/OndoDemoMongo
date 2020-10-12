package com.ondo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ondo.document.DashboardDOC;
import com.ondo.document.WearerDOC;
import com.ondo.document.WearerDashboardResultDOC;
import com.ondo.model.OndoResponse;
import com.ondo.persistence.dal.Address;
import com.ondo.persistence.dal.DashboardDAL;
import com.ondo.persistence.dal.OndoRepository;
import com.ondo.persistence.dal.UserInfo;
import com.ondo.persistence.service.DashboardService;

@RestController
@RequestMapping(value = "/")
public class OndoController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final OndoRepository ondoRepository;

	private final DashboardDAL ondoDAL;

	@Autowired
	private DashboardService dashBoardService;

	public OndoController(OndoRepository ondoRepository, DashboardDAL ondoDAL, DashboardService dashBoardService) {
		this.ondoRepository = ondoRepository;
		this.ondoDAL = ondoDAL;
		this.dashBoardService = dashBoardService;
	}

	@RequestMapping(value = "/getDashboard/{userId}", method = RequestMethod.GET)
	public List<DashboardDOC> getDashboard(@PathVariable String userId) {
		LOG.info("Saving user.");
		return dashBoardService.getDashboard(userId);

	}

	@RequestMapping(value = "/createDashboard", method = RequestMethod.POST)
	public DashboardDOC createDashboard(@RequestBody DashboardDOC dashboard) {
		LOG.info("Saving user.");
		return dashBoardService.createDashboard(dashboard);
	}

	@RequestMapping(value = "/createWearer", method = RequestMethod.POST)
	public WearerDOC createWearer(@RequestBody WearerDOC wearer) {
		LOG.info("Saving user.");
		return dashBoardService.createWearer(wearer);
	}

	@RequestMapping(value = "/createAddress", method = RequestMethod.POST)
	public Address createAddress(@RequestBody Address address) {
		LOG.info("Saving user.");
		return dashBoardService.createAddress(address);
	}

	@RequestMapping(value = "/createUserInfo", method = RequestMethod.POST)
	public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
		LOG.info("Saving user.");
		return dashBoardService.createUserInfo(userInfo);
	}

	@RequestMapping(value = "/getWearer/{facilityId}", method = RequestMethod.GET)
	public List<OndoResponse> getWearer(@PathVariable String facilityId) {
		LOG.info("Saving user.");
		return dashBoardService.getWearer(facilityId);

	}

	@RequestMapping(value = "/deleteLiveData/{userId}", method = RequestMethod.POST)
	public DashboardDOC deleteLiveData(@PathVariable String userId) {
		LOG.info("Saving user.");
		return dashBoardService.deleteLiveData(userId);

	}

}