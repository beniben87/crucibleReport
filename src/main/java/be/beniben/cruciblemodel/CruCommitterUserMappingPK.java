package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_COMMITTER_USER_MAPPING database table.
 * 
 */
@Embeddable
public class CruCommitterUserMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_COMMITTER_NAME")
	private String cruCommitterName;

	@Column(name="CRU_REPOSITORY_NAME")
	private String cruRepositoryName;

	public CruCommitterUserMappingPK() {
	}
	public String getCruCommitterName() {
		return this.cruCommitterName;
	}
	public void setCruCommitterName(String cruCommitterName) {
		this.cruCommitterName = cruCommitterName;
	}
	public String getCruRepositoryName() {
		return this.cruRepositoryName;
	}
	public void setCruRepositoryName(String cruRepositoryName) {
		this.cruRepositoryName = cruRepositoryName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruCommitterUserMappingPK)) {
			return false;
		}
		CruCommitterUserMappingPK castOther = (CruCommitterUserMappingPK)other;
		return 
			this.cruCommitterName.equals(castOther.cruCommitterName)
			&& this.cruRepositoryName.equals(castOther.cruRepositoryName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cruCommitterName.hashCode();
		hash = hash * prime + this.cruRepositoryName.hashCode();
		
		return hash;
	}
}