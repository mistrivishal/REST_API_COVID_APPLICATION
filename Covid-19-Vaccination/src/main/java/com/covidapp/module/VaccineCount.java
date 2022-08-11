package com.covidapp.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCount {
	
<<<<<<< HEAD
	@Id
	private Integer vaccount;
	
=======
	@Pattern(regexp="^[0-9]*", message = "Invalid Quantity - should not contain any Number.")
>>>>>>> d81ea913e7159de54b19e16cc4b9e3f36339dcaf
	private int quantity;
	
	@Pattern(regexp="^[0-9]*", message = "Invalid Price - should not contain any Number.")
	private double price;
	
	@OneToOne
	private VaccineInventory vi;
}
