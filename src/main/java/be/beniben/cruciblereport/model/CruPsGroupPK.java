package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_PS_GROUP database table.
 * 
 */
@Embeddable
public class CruPsGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_PS", insertable=false, updatable=false)
	private long cruPs;

	@Column(name="CRU_PID")
	private String cruPid;

	@Column(name="CRU_ACTION_NAME")
	private String cruActionName;

	public CruPsGroupPK() {
	}
	public long getCruPs() {
		return this.cruPs;
	}
	public void setCruPs(long cruPs) {
		this.cruPs = cruPs;
	}
	public String getCruPid() {
		return this.cruPid;
	}
	public void setCruPid(String cruPid) {
		this.cruPid = cruPid;
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
		if (!(other instanceof CruPsGroupPK)) {
			return false;
		}
		CruPsGroupPK castOther = (CruPsGroupPK)other;
		return 
			(this.cruPs == castOther.cruPs)
			&& this.cruPid.equals(castOther.cruPid)
			&& this.cruActionName.equals(castOther.cruActionName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruPs ^ (this.cruPs >>> 32)));
		hash = hash * prime + this.cruPid.hashCode();
		hash = hash * prime + this.cruActionName.hashCode();
		
		return hash;
	}
}