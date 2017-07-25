package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_REPO_GROUP_PERM database table.
 * 
 */
@Embeddable
public class CruRepoGroupPermPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_REPOSITORY_NAME")
	private String cruRepositoryName;

	@Column(name="CRU_REPOSITORY_PERMISSION")
	private String cruRepositoryPermission;

	@Column(name="CRU_GROUP_NAME")
	private String cruGroupName;

	public CruRepoGroupPermPK() {
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
	public String getCruGroupName() {
		return this.cruGroupName;
	}
	public void setCruGroupName(String cruGroupName) {
		this.cruGroupName = cruGroupName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruRepoGroupPermPK)) {
			return false;
		}
		CruRepoGroupPermPK castOther = (CruRepoGroupPermPK)other;
		return 
			this.cruRepositoryName.equals(castOther.cruRepositoryName)
			&& this.cruRepositoryPermission.equals(castOther.cruRepositoryPermission)
			&& this.cruGroupName.equals(castOther.cruGroupName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cruRepositoryName.hashCode();
		hash = hash * prime + this.cruRepositoryPermission.hashCode();
		hash = hash * prime + this.cruGroupName.hashCode();
		
		return hash;
	}
}