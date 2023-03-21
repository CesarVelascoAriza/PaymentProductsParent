package co.com.cava.example.costumer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "CustomerProducts")
public class CustomerProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long productId;
	@Transient
	private String productName;
	@JsonIgnore // it is necesary for avoid infinite recursion
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Custumer.class)
	@JoinColumn(name = "customerId", nullable = true)
	private Custumer customer;

	public CustomerProduct() {
	}

	public CustomerProduct(long id, long productId, String productName, Custumer customer) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Custumer getCustomer() {
		return customer;
	}

	public void setCustomer(Custumer customer) {
		this.customer = customer;
	}

}
