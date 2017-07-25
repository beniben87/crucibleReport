package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_RECENTLY_VISITED database table.
 * 
 */
@Embeddable
public class CruRecentlyVisitedPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_USER_NAME")
	private String cruUserName;

	@Column(name="CRU_ITEM_TYPE")
	private String cruItemType;

	@Column(name="CRU_ENTITY_ID")
	private String cruEntityId;

	public CruRecentlyVisitedPK() {
	}
	public String getCruUserName() {
		return this.cruUserName;
	}
	public void setCruUserName(String cruUserName) {
		this.cruUserName = cruUserName;
	}
	public String getCruItemType() {
		return this.cruItemType;
	}
	public void setCruItemType(String cruItemType) {
		this.cruItemType = cruItemType;
	}
	public String getCruEntityId() {
		return this.cruEntityId;
	}
	public void setCruEntityId(String cruEntityId) {
		this.cruEntityId = cruEntityId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruRecentlyVisitedPK)) {
			return false;
		}
		CruRecentlyVisitedPK castOther = (CruRecentlyVisitedPK)other;
		return 
			this.cruUserName.equals(castOther.cruUserName)
			&& this.cruItemType.equals(castOther.cruItemType)
			&& this.cruEntityId.equals(castOther.cruEntityId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cruUserName.hashCode();
		hash = hash * prime + this.cruItemType.hashCode();
		hash = hash * prime + this.cruEntityId.hashCode();
		
		return hash;
	}
}