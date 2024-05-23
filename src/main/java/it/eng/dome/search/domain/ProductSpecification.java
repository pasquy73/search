package it.eng.dome.search.domain;



import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductSpecification {

	
	@Id
	protected String id;
	
	private String href;
	private String brand;
	private String description;
	private Boolean isBundle;
	private String lastUpdate;
    private String lifecycleStatus;
    private String name;
	private String version;
	
	private Attachment[] attachment; 
	
	private ProductSpecCharacteristic[] productSpecCharacteristic; 
	private RelatedParty[] relatedParty; 
	private ResourceSpecification[] resourceSpecification;

	private ServiceSpecification[] serviceSpecification;

	
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public void setAttachment(Attachment[] attachment) {
		this.attachment = attachment;
	}

	public Attachment[] getAttachment() {
		return attachment;
	}

	public ProductSpecCharacteristic[] getProductSpecCharacteristic() {
		return productSpecCharacteristic;
	}

	public void setProductSpecCharacteristic(ProductSpecCharacteristic[] productSpecCharacteristic) {
		this.productSpecCharacteristic = productSpecCharacteristic;
	}

	public RelatedParty[] getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(RelatedParty[] relatedParty) {
		this.relatedParty = relatedParty;
	}



	public ResourceSpecification[] getResourceSpecification() {
		return resourceSpecification;
	}

	public void setResourceSpecification(ResourceSpecification[] resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
	}

	public ServiceSpecification[] getServiceSpecification() {
		return serviceSpecification;
	}

	public void setServiceSpecification(ServiceSpecification[] serviceSpecification) {
		this.serviceSpecification = serviceSpecification;
	}




}
