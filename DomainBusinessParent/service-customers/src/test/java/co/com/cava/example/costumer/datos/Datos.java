package co.com.cava.example.costumer.datos;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import co.com.cava.example.costumer.entities.CustomerProduct;
import co.com.cava.example.costumer.entities.Custumer;

public class Datos {
	
	public static final Iterable<Custumer> LIST_COSTUMERS = Arrays.asList(new Custumer(1L,"A","001","001","prueba","111","1",null,null));
	public static final Iterable<Custumer> LIST_COSTUMERS_VACIA = Arrays.asList();
	public static final List<CustomerProduct> LIST_PRODUCTS = Arrays.asList(new CustomerProduct(1L,1L,"Prueba",null));
	public static final Optional<Custumer> CUSTOMER = Optional.of(new Custumer(1l, "prueba", "001", "1022", "Pruebas","111", "111", LIST_PRODUCTS, LIST_PRODUCTS)) ; 
}
