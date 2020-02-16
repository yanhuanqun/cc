package com.parking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_parking")
@Data
public class Parking {

	@Id
	@Column(name = "parkingId")
	private Integer parkingId;

	@Column(name = "parkingName")
	private String parkingName;

	@Column(name = "totalSpace")
	private Integer totalSpace;

	@Column(name = "spareSpace")
	private Integer spareSpace;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "latitude")
	private Double latitude;

}
