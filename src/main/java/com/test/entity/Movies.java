package com.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="movies")
public class Movies {
	
	@Id
	private String tconst;
	
	@NotNull
	private String titleType;
	
	@NotNull
	private String primaryTitle;
	
	@NotNull
	private int runtimeMinutes;
	
	@NotNull
	private String genres;
	
	@OneToOne(mappedBy = "movies", fetch = FetchType.EAGER)
	private Ratings ratings;
	
	
	

}
