package com.chinmay.relationship.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "City")
public class City {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long cId;
		private String cName;
		
		public City(String cName) {
			this.cName = cName;
		}
		
}
