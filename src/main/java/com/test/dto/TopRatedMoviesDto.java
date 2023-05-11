package com.test.dto;

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
public class TopRatedMoviesDto {


	private String tconst;
		
	private String primaryTitle;
		
	private String genres;
	
	private double averageRating;
}
