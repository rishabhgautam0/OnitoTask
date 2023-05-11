package com.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.entity.Movies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GenreMoviesWithSubtotals {
	
	private String genres;
	
	private String primaryTitles;
	
	private long numVotes;
	
	private long total;

}
