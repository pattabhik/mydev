package com.practice.unittesting.dao;

import java.util.List;

import com.practice.unittesting.service.DataService;

/**
 * @author Pattabhi
 *
 */
public class DAOImpl {
	DataService dataSrvc;

	public int calculateSum(List<Integer> data) {
		return data.stream().reduce(0, Integer::sum);
	}

	public int calculateSum() {
		List<Integer> data = this.dataSrvc.retriveData();
		if (data != null)
		return data.stream().reduce(0, Integer::sum);
		else
			return 0;
	}

	/**
	 * @param dataSrvc the dataSrvc to set
	 */
	public void setDataSrvc(DataService dataSrvc) {
		this.dataSrvc = dataSrvc;
	}

}
