package com.ondo.persistence.dal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ondo.document.DashboardDOC;
import com.ondo.document.WearerDOC;
import com.ondo.document.WearerDashboardResultDOC;
import com.ondo.model.OndoResponse;
import com.ondo.model.ondoGraphPlot;
import com.ondo.utils.OndoDateUtil;

@Repository
public class DashboardDALImpl implements DashboardDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<DashboardDOC> getDashboard(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("bandId").is(userId));
		// return (List<DashboardDOC>) mongoTemplate.find(query,
		// DashboardDOC.class);
		return (List<DashboardDOC>) mongoTemplate.findAll(DashboardDOC.class);
	}

	@Override
	public DashboardDOC createDashboard(DashboardDOC dashboard) {
		mongoTemplate.save(dashboard);
		return dashboard;
	}

	@Override
	public DashboardDOC deleteLiveData(String userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("bandId").is(userId));
		mongoTemplate.remove(query, DashboardDOC.class);
		return null;
	}

	@Override
	public WearerDOC createWearer(WearerDOC wearer) {
		mongoTemplate.save(wearer);
		return wearer;
	}

	@Override
	public List<OndoResponse> getWearer(String facilityId) {
		// Associate with another collection as its property
		// mongoTemplate.dropCollection(WearerDOC.class);
	List<WearerDOC> wearerList= mongoTemplate.findAll(WearerDOC.class);
	
		Map<String, List<WearerDOC>> hm = populateSegregattedWearerList(wearerList);
		List<Date> last48Hrs = OndoDateUtil.getLast48Hours();
		List<OndoResponse> finalRes = new ArrayList<OndoResponse>();
		for (Entry<String, List<WearerDOC>> entry : hm.entrySet()) {
			OndoResponse ondoDash = new OndoResponse();
			List<ondoGraphPlot> graphList = new ArrayList<ondoGraphPlot>();
			for (int i = 0; i < last48Hrs.size() - 1; i++) {
				Integer timeSlot = 0;
				ondoGraphPlot graph = new ondoGraphPlot();
				Map<Date, List<WearerDOC>> tm = new HashMap<Date, List<WearerDOC>>();
				for (WearerDOC wearer : entry.getValue()) {
					Date currentVal = (Date) last48Hrs.get(i);
					Date previousVal = (Date) last48Hrs.get(i + 1);
					timeSlot = last48Hrs.size() - 1 - i;
					if ((wearer.getCreationDate().compareTo(currentVal) < 0)
							&& (wearer.getCreationDate().compareTo(previousVal) > 0)) {
						populateAverageSegregated(tm, wearer, previousVal);
					} else {
						tm.put(previousVal, null);
					}
					ondoDash.setFacilityId(wearer.getFacilityId());
					ondoDash.setBatteryVal(wearer.getBatteryLevel());
					ondoDash.setWearerId(wearer.getWearerId());
				}
				graph.setName(String.valueOf(timeSlot));
				graph.setValue(calculateAvgTrendGraph(tm));

				graphList.add(graph);
			}
			ondoDash.setGraphDisplay(graphList);
			finalRes.add(ondoDash);
			System.out.println(finalRes);

			
		}

		//mongoTemplate.dropCollection(WearerDOC.class);
		LookupOperation lookup = Aggregation.lookup("wearer", // Join Table
				"bandId",    // Query table fields
				"bandIdVal", // Join fields in tables foreign key
				"wearer");// The name of the property in which the data is returned
							

		MatchOperation match = Aggregation.match(Criteria.where("wearer.bandIdVal").is("234557"));

		Aggregation noRepeatAggregation3 = Aggregation.newAggregation(lookup,match);

		AggregationResults<WearerDashboardResultDOC> noRepeatDataInfoVos3 = mongoTemplate.aggregate(noRepeatAggregation3,
				DashboardDOC.class, WearerDashboardResultDOC.class);

		//return	noRepeatDataInfoVos3.getMappedResults();
	
		return finalRes;

		
	}

	private String calculateAvgTrendGraph(Map<Date, List<WearerDOC>> tm) {
		Integer calcAvg = 0;
		Integer totalCnt = 0;
		for (Entry<Date, List<WearerDOC>> entry : tm.entrySet()) {
			if (null != entry && null != entry.getValue()) {
				totalCnt = entry.getValue().size();
				for (WearerDOC wearer : entry.getValue())
					calcAvg = Integer.valueOf(wearer.getSkinTemp()) + calcAvg;
			}
		}
		return totalCnt == 0 ? String.valueOf(totalCnt) : String.valueOf(calcAvg / totalCnt);
	}

	private Map<Date, List<WearerDOC>> populateAverageSegregated(Map<Date, List<WearerDOC>> tm, WearerDOC wearer,
			Date previousVal) {
		if (tm.containsKey(previousVal)) {
			List<WearerDOC> alp = (List<WearerDOC>) tm.get(previousVal);
			tm.put(previousVal, populateList1(alp, wearer));
		} else {
			tm.put(previousVal, populateList1(new ArrayList<WearerDOC>(), wearer));
		}
		return tm;
	}

	@Override
	public Address createAddress(Address address) {
		mongoTemplate.save(address);
		return address;
	}

	@Override
	public UserInfo createUserInfo(UserInfo userInfo) {
		mongoTemplate.save(userInfo);
		return userInfo;
	}
	
	
	private Map<String, List<WearerDOC>> populateSegregattedWearerList(List<WearerDOC> wearerList) {
		Map<String, List<WearerDOC>> hm = new HashMap<String, List<WearerDOC>>();
		for (WearerDOC wearer : wearerList)
			if (hm.containsKey(wearer.getWearerId())) {
				List<WearerDOC> alp = (List<WearerDOC>) hm.get(wearer.getWearerId());
				hm.put(wearer.getWearerId(), populateList(alp, wearer));
			} else {
				hm.put(wearer.getWearerId(), populateList(new ArrayList<WearerDOC>(), wearer));
			}
		return hm;
	}
	
	

	private List<WearerDOC> populateList(List<WearerDOC> alp, WearerDOC load) {
		alp.add(load);
		return alp;
	}
	
	private List<WearerDOC> populateList1(List<WearerDOC> alp, WearerDOC wearer) {
		alp.add(wearer);
		return alp;
	}
public static void main(String... args){
			
			Date date = new Date();
		    date.setHours(23);
		    Calendar c1 = new GregorianCalendar();
	        c1.setTime(new Date());
	        c1.add(Calendar.HOUR, 0);
	        c1.set(Calendar.MINUTE, 0);
	        c1.set(Calendar.SECOND, 0);
	        c1.set(Calendar.MILLISECOND, 0);
	      
		    
	       for(int i=0;i<47;i++){
	        Calendar c = new GregorianCalendar();
	        c.setTime(new Date());
	        c.add(Calendar.HOUR, -i);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	        c.set(Calendar.MILLISECOND, 0);
	       System.out.println(c.getTime());
	       }
	       long millis1 = 1602221426024L;
	       long millis = 1602221826024L;
	       Date date1 = new Date(millis);
	       DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	       String formatted = format.format(date1);
	       System.out.println(formatted);
	    }


}
	
	

