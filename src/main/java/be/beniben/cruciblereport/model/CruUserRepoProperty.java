package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_USER_REPO_PROPERTY database table.
 * 
 */
@Entity
@Table(name="CRU_USER_REPO_PROPERTY")
@NamedQuery(name="CruUserRepoProperty.findAll", query="SELECT c FROM CruUserRepoProperty c")
public class CruUserRepoProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruUserRepoPropertyPK id;

	@Lob
	@Column(name="CRU_VALUE")
	private String cruValue;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruUserRepoProperty() {
	}

	public CruUserRepoPropertyPK getId() {
		return this.id;
	}

	public void setId(CruUserRepoPropertyPK id) {
		this.id = id;
	}

	public String getCruValue() {
		return this.cruValue;
	}

	public void setCruValue(String cruValue) {
		this.cruValue = cruValue;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}