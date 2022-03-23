package com.chinmay.relationship.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bId;
	private String bName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book-id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "catagory_id")
	private List<Catagory> catagory;

	public Book(String bName, List<Author> authors, List<Catagory> catagory) {
		this.bName = bName;
		this.authors = authors;
		this.catagory = catagory;
	}
	
	public void addAuthor(Author author) {
		authors.add(author);
	}
	
	public void removeAuthor(Author author) {
		authors.remove(author);
	}

}
