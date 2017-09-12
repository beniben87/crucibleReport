package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_COMMITTER_USER_MAPPING database table.
 * 
 */
@Entity
@Table(name="CRU_COMMITTER_USER_MAPPING")
@NamedQuery(name="CruCommitterUserMapping.findAll", query="SELECT c FROM CruCommitterUserMapping c")
public class CruCommitterUserMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruCommitterUserMappingPK id;

	@Column(name="CRU_USER_NAME")
	private String cruUserName;

	public CruCommitterUserMapping() {
	}

	public CruCommitterUserMappingPK getId() {
		return this.id;
	}

	public void setId(CruCommitterUserMappingPK id) {
		this.id = id;
	}

	public String getCruUserName() {
		return this.cruUserName;
	}

	public void setCruUserName(String cruUserName) {
		this.cruUserName = cruUserName;
	}

}