package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_REVPERMAID database table.
 * 
 */
@Embeddable
public class CruRevpermaidPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_PROJ_KEY")
	private String cruProjKey;

	@Column(name="CRU_NUMBER")
	private long cruNumber;

	public CruRevpermaidPK() {
	}
	public String getCruProjKey() {
		return this.cruProjKey;
	}
	public void setCruProjKey(String cruProjKey) {
		this.cruProjKey = cruProjKey;
	}
	public long getCruNumber() {
		return this.cruNumber;
	}
	public void setCruNumber(long cruNumber) {
		this.cruNumber = cruNumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruRevpermaidPK)) {
			return false;
		}
		CruRevpermaidPK castOther = (CruRevpermaidPK)other;
		return 
			this.cruProjKey.equals(castOther.cruProjKey)
			&& (this.cruNumber == castOther.cruNumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cruProjKey.hashCode();
		hash = hash * prime + ((int) (this.cruNumber ^ (this.cruNumber >>> 32)));
		
		return hash;
	}
}