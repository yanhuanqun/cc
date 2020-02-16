package com.parking.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_order")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "orderId")
	private Integer orderId;

	@Column(name = "userId")
	private Integer userId;

	@Column(name = "parkingId")
	private Integer parkingId;

	@Column(name = "startTime")
	private Timestamp startTime;

	@Column(name = "endTime")
	private Timestamp endTime;

	@Column(name = "useTime")
	private Timestamp useTime;

	@Column(name = "money")
	private Double money;

	@Column(name = "pay")
	private Integer pay;

}
