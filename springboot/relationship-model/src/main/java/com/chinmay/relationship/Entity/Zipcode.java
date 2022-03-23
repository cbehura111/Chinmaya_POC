package com.chinmay.relationship.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Zipcode")
public class Zipcode {
	
	@Id
	@GeneratedValue
	private Long zId;
	private String zName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_zId")
	private City city;

	public Zipcode(String zName, City city) {
		this.zName = zName;
		this.city = city;
	}
}
