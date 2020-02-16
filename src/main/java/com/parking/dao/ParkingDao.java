package com.parking.dao;

import com.parking.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingDao extends JpaRepository<Parking,Integer>,
		JpaSpecificationExecutor<Parking> {

	/**
	 * find parking list
	 * @param latitude latitude
	 * @param longitude longitude
	 * @param threshold threshold
	 * @return list
	 */
	@Query(nativeQuery = true, value = "select * from tb_parking where " +
			":latitude - :threshold <= latitude < :latitude + :threshold " +
			"and :longitude - :threshold <= longitude < :longitude + :threshold")
	List<Parking> findParkingList(@Param("latitude") Double latitude,
								  @Param("longitude") Double longitude,
								  @Param("threshold") Double threshold);

}
