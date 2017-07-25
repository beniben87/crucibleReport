package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_REPOSITORY_PROPERTY database table.
 * 
 */
@Entity
@Table(name="CRU_REPOSITORY_PROPERTY")
@NamedQuery(name="CruRepositoryProperty.findAll", query="SELECT c FROM CruRepositoryProperty c")
public class CruRepositoryProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_REPO_PROP_ID")
	private long cruRepoPropId;

	@Column(name="CRU_PROPERTY_NAME")
	private String cruPropertyName;

	@Column(name="CRU_REPO_PROP_HASH")
	private String cruRepoPropHash;

	@Column(name="CRU_REPOSITORY")
	private String cruRepository;

	@Lob
	@Column(name="CRU_VALUE")
	private String cruValue;

	public CruRepositoryProperty() {
	}

	public long getCruRepoPropId() {
		return this.cruRepoPropId;
	}

	public void setCruRepoPropId(long cruRepoPropId) {
		this.cruRepoPropId = cruRepoPropId;
	}

	public String getCruPropertyName() {
		return this.cruPropertyName;
	}

	public void setCruPropertyName(String cruPropertyName) {
		this.cruPropertyName = cruPropertyName;
	}

	public String getCruRepoPropHash() {
		return this.cruRepoPropHash;
	}

	public void setCruRepoPropHash(String cruRepoPropHash) {
		this.cruRepoPropHash = cruRepoPropHash;
	}

	public String getCruRepository() {
		return this.cruRepository;
	}

	public void setCruRepository(String cruRepository) {
		this.cruRepository = cruRepository;
	}

	public String getCruValue() {
		return this.cruValue;
	}

	public void setCruValue(String cruValue) {
		this.cruValue = cruValue;
	}

}