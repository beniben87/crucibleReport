package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_REVPERMAID database table.
 * 
 */
@Entity
@Table(name="CRU_REVPERMAID")
@NamedQuery(name="CruRevpermaid.findAll", query="SELECT c FROM CruRevpermaid c")
public class CruRevpermaid implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruRevpermaidPK id;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	public CruRevpermaid() {
	}

	public CruRevpermaidPK getId() {
		return this.id;
	}

	public void setId(CruRevpermaidPK id) {
		this.id = id;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

}