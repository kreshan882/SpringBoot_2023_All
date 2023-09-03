package com.kre.springfull.entity;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Db_table 
@Entity  
@Data  // getter + setters+ toString + RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder  // builder pattern added (builder / build) - constractor with given variable only
public class Department {
	 
		@Id  
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long departmentId; // primary key

		 //departmentName can not blank on req msg (hibernate validation added)
		/*
			{ 
		    "departmentAddress":"colombo44",
		    "departmentCode":"00144"
			}
		*/
		
		 @NotBlank(message = "Please Add Department Name,msg from hibernate k.....")
		    /*
		    @Length(max = 5,min =1)
		    @Size(max = 10, min = 0)
		    @Email
		    @Positive
		    @Negative
		    @PositiveOrZero
		    @NegativeOrZero
		    @Future  				// date is feature
		    @FutureOrPresent
		    @Past
		    @PastOrPresent
		    */
	    private String departmentName;
	    private String departmentAddress;
	    private String departmentCode;
}
