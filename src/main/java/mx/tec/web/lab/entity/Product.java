package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * product Entity class
 * 
 * @author giogurt
 *
 */
@Entity
public class Product implements Serializable {
	/**
	 * Product serial id
	 */
	private static final long serialVersionUID = 1940424686731950240L;
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL)
	private List<Sku> childSkus;

	/**
	 * Product constructor
	 */
	public Product() {

	}

	/**
	 * Product constructor with variables id
	 * 
	 * @param id          name
	 * @param name        description
	 * @param description child sku
	 * @param childSkus   sku
	 */
	public Product(long id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the childSkus
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}

	/**
	 * @param childSkus the childSkus to set
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}
	
	/**
	 * hashCode of product
	 * @return returns the hash of product
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
		Product other = (Product) obj;
		return id == other.id;
	}

	/**
	 * Print the product entity
	 * @return the string representation of the object
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", childSkus=" + childSkus
				+ "]";
	}

}
