package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_PROJ_DEFAULT_GRP database table.
 * 
 */
@Entity
@Table(name="CRU_PROJ_DEFAULT_GRP")
@NamedQuery(name="CruProjDefaultGrp.findAll", query="SELECT c FROM CruProjDefaultGrp c")
public class CruProjDefaultGrp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_GROUP_NAME")
	private String cruGroupName;

	//bi-directional many-to-one association to CruProject
	@ManyToOne
	@JoinColumn(name="CRU_PROJECT_ID")
	private CruProject cruProject;

	public CruProjDefaultGrp() {
	}

	public String getCruGroupName() {
		return this.cruGroupName;
	}

	public void setCruGroupName(String cruGroupName) {
		this.cruGroupName = cruGroupName;
	}

	public CruProject getCruProject() {
		return this.cruProject;
	}

	public void setCruProject(CruProject cruProject) {
		this.cruProject = cruProject;
	}

}