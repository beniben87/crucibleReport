package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_USER_REPO_PROPERTY database table.
 * 
 */
@Embeddable
public class CruUserRepoPropertyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_USER_ID", insertable=false, updatable=false)
	private long cruUserId;

	@Column(name="CRU_REPOSITORY")
	private String cruRepository;

	@Column(name="CRU_PROPERTY_NAME")
	private String cruPropertyName;

	public CruUserRepoPropertyPK() {
	}
	public long getCruUserId() {
		return this.cruUserId;
	}
	public void setCruUserId(long cruUserId) {
		this.cruUserId = cruUserId;
	}
	public String getCruRepository() {
		return this.cruRepository;
	}
	public void setCruRepository(String cruRepository) {
		this.cruRepository = cruRepository;
	}
	public String getCruPropertyName() {
		return this.cruPropertyName;
	}
	public void setCruPropertyName(String cruPropertyName) {
		this.cruPropertyName = cruPropertyName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruUserRepoPropertyPK)) {
			return false;
		}
		CruUserRepoPropertyPK castOther = (CruUserRepoPropertyPK)other;
		return 
			(this.cruUserId == castOther.cruUserId)
			&& this.cruRepository.equals(castOther.cruRepository)
			&& this.cruPropertyName.equals(castOther.cruPropertyName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruUserId ^ (this.cruUserId >>> 32)));
		hash = hash * prime + this.cruRepository.hashCode();
		hash = hash * prime + this.cruPropertyName.hashCode();
		
		return hash;
	}
}