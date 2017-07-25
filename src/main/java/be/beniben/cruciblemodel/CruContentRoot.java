package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_CONTENT_ROOT database table.
 * 
 */
@Entity
@Table(name="CRU_CONTENT_ROOT")
@NamedQuery(name="CruContentRoot.findAll", query="SELECT c FROM CruContentRoot c")
public class CruContentRoot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_CONTENT_ROOT_ID")
	private long cruContentRootId;

	@Column(name="CRU_CONTENT_ROOT_PATH")
	private String cruContentRootPath;

	@Column(name="CRU_CONTENT_ROOT_REP")
	private String cruContentRootRep;

	//bi-directional many-to-one association to CruProject
	@ManyToOne
	@JoinColumn(name="CRU_PROJECT")
	private CruProject cruProjectBean;

	public CruContentRoot() {
	}

	public long getCruContentRootId() {
		return this.cruContentRootId;
	}

	public void setCruContentRootId(long cruContentRootId) {
		this.cruContentRootId = cruContentRootId;
	}

	public String getCruContentRootPath() {
		return this.cruContentRootPath;
	}

	public void setCruContentRootPath(String cruContentRootPath) {
		this.cruContentRootPath = cruContentRootPath;
	}

	public String getCruContentRootRep() {
		return this.cruContentRootRep;
	}

	public void setCruContentRootRep(String cruContentRootRep) {
		this.cruContentRootRep = cruContentRootRep;
	}

	public CruProject getCruProjectBean() {
		return this.cruProjectBean;
	}

	public void setCruProjectBean(CruProject cruProjectBean) {
		this.cruProjectBean = cruProjectBean;
	}

}