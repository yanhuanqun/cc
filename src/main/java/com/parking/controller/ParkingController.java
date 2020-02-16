package com.parking.controller;

import com.parking.entity.Parking;
import com.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("parking")
public class ParkingController {

	private final ParkingService parkingService;

	@Autowired
	public ParkingController(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@RequestMapping(value = "/parkingList", method = RequestMethod.POST)
	public Map<String, Object> parkingList(@Param("latitude") Double latitude,
									 @Param("longitude") Double longitude) {
		Map<String, Object> result = new HashMap<>(1);
		List<Parking> parkingList = parkingService.findParkingList(latitude, longitude);
		result.put("parkingList", parkingList);
		return result;
	}

}
