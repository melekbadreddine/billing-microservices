package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.example.demo.beans.CustomerBean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date billingdate;

	private Long customerID;

	@Transient
	CustomerBean customer;

	@OneToMany(mappedBy = "bill")
	private Collection<ProductItem> items;
}
