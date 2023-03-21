package co.com.cava.example.costumer.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "Custumers")
@Data
public class Custumer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String code;
	private String iban;
	private String surname;
	private String phone;
	private String address;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CustomerProduct> products;
	@Transient
	private List<?> transactions;
	
	public Custumer() {
		products = new ArrayList<>();
	}
	
	
	public Custumer(Long id, String name, String code, String iban,  String surname, String phone,
			String address, List<CustomerProduct> products, List<?> transactions) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.iban = iban;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
		this.products = products;
		this.transactions = transactions;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<CustomerProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CustomerProduct> products) {
		this.products = products;
	}

	public List<?> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<?> transactions) {
		this.transactions = transactions;
	}

}
