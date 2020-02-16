package com.parking.service;

import com.parking.dao.ParkingDao;
import com.parking.entity.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParkingService {

	private final ParkingDao parkingDao;

	@Autowired
	public ParkingService(ParkingDao parkingDao) {
		this.parkingDao = parkingDao;
	}

	public List<Parking> findParkingList(Double latitude, Double longitude) {
		double threshold = 1.0;
		return parkingDao.findParkingList(latitude, longitude, threshold);
	}

}
