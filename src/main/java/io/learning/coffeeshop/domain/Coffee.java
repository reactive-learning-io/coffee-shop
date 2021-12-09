package io.learning.coffeeshop.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("coffees")
public class Coffee {

	@Id
	@JsonIgnore
	@Column("ID")
	private Long id;
	@Column("NAME")
	private String name;
	@Column("PRICE")
	private float price;
	@Column("SERVING_TYPE")
	private String servingType;

}
