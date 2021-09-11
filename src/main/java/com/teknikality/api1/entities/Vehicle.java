package com.teknikality.api1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vehicle")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(name="registrationNumber", unique=true)

	private String registrationNumber;

	@Column(name = "mileage")

	private String mileage;
	
	@Column(name = "plateYear")

	private String plateYear;
	
	@Column(name = "valuationTime")

	private String valuationTime;

	@Column(name = "vehicleDescription")

	private String vehicleDescription;
	
	@Column(name = "date")

	private LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));

	
	@SuppressWarnings("unchecked")
	@JsonProperty("Response")
	private void unpackNested(Map<String, Object> response) {
		// this.BillingAccountAccountType = (String)Response.get("StatusCode");
		Map<String, String> dataItems = (Map<String, String>) response.get("DataItems");
		this.registrationNumber = dataItems.get("Vrm");
		this.mileage = dataItems.get("Mileage");
		this.plateYear = dataItems.get("PlateYear");
		this.valuationTime = dataItems.get("ValuationTime");
		this.vehicleDescription = dataItems.get("VehicleDescription");

	}
	

}
