package com.huseyinsacikay.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	@NotEmpty(message = "First name alanı boş bırakılamaz!")
	@Min(value = 3)
	@Max(value = 20)
	private String firstName;
	
	@Size(min = 2, max = 30)
	private String lastName;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date birthOfDate;
}
