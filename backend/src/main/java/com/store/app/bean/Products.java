package com.store.app.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products {

    @Id
    private int productid;
    private String productname;
    private String category;
    private double price;
    private String description;
    private String offer;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "image_file_id")
    private ImageFile imageFile;
    
    private int quantity;
    

    @ElementCollection
    @CollectionTable(name = "product_colors",joinColumns = @JoinColumn(referencedColumnName = "productid"))
    @Column(name = "color") // Added this annotation to specify the column name
    private List<String> colors;

    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(referencedColumnName = "productid"))
    @Column(name = "size") // Added this annotation to specify the column name
    private List<String> sizes;
    
    @ManyToOne
    @JoinColumn(name="vendorid")
    @JsonBackReference
    private Vendor vendor;
    
   

    public Products() {
        super();
    }

    public Products(int productid, String productname, String category, double price, String description, String offer,
                    ImageFile imageFile, int quantity, List<String> sizes, List<String> colors) {
        super();
        this.productid = productid;
        this.productname = productname;
        this.category = category;
        this.price = price;
        this.description = description;
        this.offer = offer;
        this.imageFile = imageFile;
        this.quantity = quantity;
        this.sizes = sizes;
        this.colors = colors;
    }

    public Products(int productid, String productname, String category, double price, String description, String offer,
			int quantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.category = category;
		this.price = price;
		this.description = description;
		this.offer = offer;
		this.quantity = quantity;
	}
    
	

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }


    public ImageFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(ImageFile imageFile) {
		this.imageFile = imageFile;
	}

	public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

	@Override
	public String toString() {
		return "Products [productid=" + productid + ", productname=" + productname + ", category=" + category
				+ ", price=" + price + ", description=" + description + ", offer=" + offer + ", imageFile=" + imageFile
				+ ", quantity=" + quantity + ", colors=" + colors + ", sizes=" + sizes + "]";
	}	

}
