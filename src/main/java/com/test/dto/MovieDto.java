package com.test.dto;

import com.test.entity.Ratings;

import jakarta.validation.constraints.NotNull;
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
public class MovieDto {
	
	private String tconst;
	
	private String primaryTitle;
	
	private int runtimeMinutes;
	
	private String genres;
	

}
