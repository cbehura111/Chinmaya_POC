package com.chinmay.relationship.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Catagory")
public class Catagory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long catId;
	private String catName;
	
	@OneToMany(mappedBy = "catagory", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Book> books = new ArrayList<>();

	public Catagory(String catName, List<Book> books) {
		this.catName = catName;
		this.books = books;
	}
	
	
}
