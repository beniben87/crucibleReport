package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_USER_SETTING database table.
 * 
 */
@Embeddable
public class CruUserSettingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_USER_ID", insertable=false, updatable=false)
	private long cruUserId;

	@Column(name="CRU_KEY")
	private String cruKey;

	public CruUserSettingPK() {
	}
	public long getCruUserId() {
		return this.cruUserId;
	}
	public void setCruUserId(long cruUserId) {
		this.cruUserId = cruUserId;
	}
	public String getCruKey() {
		return this.cruKey;
	}
	public void setCruKey(String cruKey) {
		this.cruKey = cruKey;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruUserSettingPK)) {
			return false;
		}
		CruUserSettingPK castOther = (CruUserSettingPK)other;
		return 
			(this.cruUserId == castOther.cruUserId)
			&& this.cruKey.equals(castOther.cruKey);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruUserId ^ (this.cruUserId >>> 32)));
		hash = hash * prime + this.cruKey.hashCode();
		
		return hash;
	}
}