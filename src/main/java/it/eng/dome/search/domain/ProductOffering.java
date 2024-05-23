package it.eng.dome.search.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOffering {
	
	protected String id;

    private String href;
    private String description;
	private Boolean isBundle;
    
	private String lastUpdate;
    private String lifecycleStatus;
    private String name;
	private String version;
	private ProductOfferingTerm[] productOfferingTerm;
	private ProductSpecification productSpecification;
	private ProductOfferingPrice[] productOfferingPrice;
	private ValidFor validFor;
	private Category[] category;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsBundle() {
		return isBundle;
	}
	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getLifecycleStatus() {
		return lifecycleStatus;
	}
	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public ProductSpecification getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(ProductSpecification productSpecification) {
		this.productSpecification = productSpecification;
	}

	
	public ProductOfferingPrice[] getProductOfferingPrice() {
		return productOfferingPrice;
	}
	public void setProductOfferingPrice(ProductOfferingPrice[] productOfferingPrice) {
		this.productOfferingPrice = productOfferingPrice;
	}
	

	public ProductOfferingTerm[] getProductOfferingTerm() {
		return productOfferingTerm;
	}
	public void setProductOfferingTerm(ProductOfferingTerm[] productOfferingTerm) {
		this.productOfferingTerm = productOfferingTerm;
	}
	public ValidFor getValidFor() {
		return validFor;
	}
	
	public void setValidFor(ValidFor validFor) {
		this.validFor = validFor;
	}
	
	public Category[] getCategory() {
		return category;
	}
	public void setCategory(Category[] category) {
		this.category = category;
	}
	
}
