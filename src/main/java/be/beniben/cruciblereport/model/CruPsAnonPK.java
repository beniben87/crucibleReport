package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_PS_ANON database table.
 * 
 */
@Embeddable
public class CruPsAnonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_PS", insertable=false, updatable=false)
	private long cruPs;

	@Column(name="CRU_ACTION_NAME")
	private String cruActionName;

	public CruPsAnonPK() {
	}
	public long getCruPs() {
		return this.cruPs;
	}
	public void setCruPs(long cruPs) {
		this.cruPs = cruPs;
	}
	public String getCruActionName() {
		return this.cruActionName;
	}
	public void setCruActionName(String cruActionName) {
		this.cruActionName = cruActionName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruPsAnonPK)) {
			return false;
		}
		CruPsAnonPK castOther = (CruPsAnonPK)other;
		return 
			(this.cruPs == castOther.cruPs)
			&& this.cruActionName.equals(castOther.cruActionName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruPs ^ (this.cruPs >>> 32)));
		hash = hash * prime + this.cruActionName.hashCode();
		
		return hash;
	}
}