package com.chinmay.relationship.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Author")
public class Author {

		@Id
		@GeneratedValue
		private Long aId;
		private String aName;
		
		@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JoinColumn(name = "Zipcode_aId")
		private Zipcode zipcode;
		
		@ManyToMany(mappedBy = "catagory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<Book> books = new ArrayList<>();
		
		public Author(String aName, Zipcode zipcode, List<Book> books) {
			this.aName = aName;
			this.zipcode = zipcode;
			this.books = books;
		}
		public void addBook(Book book) {
			books.add(book);
		}
		
		public void removeBook(Book book) {
			books.remove(book);
		}
		
}
