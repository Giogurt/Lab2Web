package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * sku Entity class
 * @author giogurt
 */
@Entity
public class Sku implements Serializable {
	/**
	 * sku serial code 
	 */
	private static final long serialVersionUID = -6185764898853598449L;
	
	@Id
	@GeneratedValue
	private long id;
	private String color;
	private String size;
	private double listPrice;
	private double salePrice;
	private long quantityOnHand;
	private String smallImageUrl;
	private String mediumImageUrl;
	private String largeImageUrl;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product parentProduct;

	/** * No arguments constructor */
	public Sku() {
	}

	/**
	 * Constructor including all the properties 
	 * @since 2.0 
	 * @param id Sku id
	 * @param color Sku color 
	 * @param size Sku size 
	 * @param listPrice The list price 
	 * @param salePrice The sale price 
	 * @param quantityOnHand The quantity on hand 
	 * @param smallImageUrl The small Image URL 
	 * @param mediumImageUrl The medium Image URL 
	 * @param largeImageUrl The large Image URL
	 */
	public Sku(long id, String color, String size, double listPrice, double salePrice, long quantityOnHand,
			String smallImageUrl, String mediumImageUrl, String largeImageUrl) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImageUrl = smallImageUrl;
		this.mediumImageUrl = mediumImageUrl;
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the listPrice
	 */
	public double getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}

	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @return the quantityOnHand
	 */
	public long getQuantityOnHand() {
		return quantityOnHand;
	}

	/**
	 * @param quantityOnHand the quantityOnHand to set
	 */
	public void setQuantityOnHand(long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	/**
	 * @return the smallImageUrl
	 */
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	/**
	 * @param smallImageUrl the smallImageUrl to set
	 */
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	/**
	 * @return the mediumImageUrl
	 */
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}

	/**
	 * @param mediumImageUrl the mediumImageUrl to set
	 */
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}

	/**
	 * @return the largeImageUrl
	 */
	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	/**
	 * @param largeImageUrl the largeImageUrl to set
	 */
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * @return the parentProduct
	 */
	public Product getParentProduct() {
		return parentProduct;
	}

	/**
	 * @param parentProduct the parentProduct to set
	 */
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}

	/**
	 * hashCode of product
	 * @return returns the hash of the sku
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * compare this object to another object
	 * @param obj object to compare with
	 * @return returns if the objects are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sku other = (Sku) obj;
		return id == other.id;
	}

	/**
	 * Print the Sku entity
	 * @return the string representation of the sku
	 */
	@Override
	public String toString() {
		return "Sku [id=" + id + ", color=" + color + ", size=" + size + ", listPrice=" + listPrice + ", salePrice="
				+ salePrice + ", quantityOnHand=" + quantityOnHand + ", smallImageUrl=" + smallImageUrl
				+ ", mediumImageUrl=" + mediumImageUrl + ", largeImageUrl=" + largeImageUrl + ", parentProduct="
				+ parentProduct + "]";
	}

}
