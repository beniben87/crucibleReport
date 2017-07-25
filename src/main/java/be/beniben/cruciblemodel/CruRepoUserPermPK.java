package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_REPO_USER_PERM database table.
 * 
 */
@Embeddable
public class CruRepoUserPermPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_REPOSITORY_NAME")
	private String cruRepositoryName;

	@Column(name="CRU_REPOSITORY_PERMISSION")
	private String cruRepositoryPermission;

	@Column(name="CRU_USER_ID", insertable=false, updatable=false)
	private long cruUserId;

	public CruRepoUserPermPK() {
	}
	public String getCruRepositoryName() {
		return this.cruRepositoryName;
	}
	public void setCruRepositoryName(String cruRepositoryName) {
		this.cruRepositoryName = cruRepositoryName;
	}
	public String getCruRepositoryPermission() {
		return this.cruRepositoryPermission;
	}
	public void setCruRepositoryPermission(String cruRepositoryPermission) {
		this.cruRepositoryPermission = cruRepositoryPermission;
	}
	public long getCruUserId() {
		return this.cruUserId;
	}
	public void setCruUserId(long cruUserId) {
		this.cruUserId = cruUserId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruRepoUserPermPK)) {
			return false;
		}
		CruRepoUserPermPK castOther = (CruRepoUserPermPK)other;
		return 
			this.cruRepositoryName.equals(castOther.cruRepositoryName)
			&& this.cruRepositoryPermission.equals(castOther.cruRepositoryPermission)
			&& (this.cruUserId == castOther.cruUserId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cruRepositoryName.hashCode();
		hash = hash * prime + this.cruRepositoryPermission.hashCode();
		hash = hash * prime + ((int) (this.cruUserId ^ (this.cruUserId >>> 32)));
		
		return hash;
	}
}