package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_REVIEW_FIELD database table.
 * 
 */
@Entity
@Table(name="CRU_REVIEW_FIELD")
@NamedQuery(name="CruReviewField.findAll", query="SELECT c FROM CruReviewField c")
public class CruReviewField implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruReviewFieldPK id;

	//bi-directional many-to-one association to CruField
	@ManyToOne
	@JoinColumn(name="CRU_FIELD_ID")
	private CruField cruField;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	public CruReviewField() {
	}

	public CruReviewFieldPK getId() {
		return this.id;
	}

	public void setId(CruReviewFieldPK id) {
		this.id = id;
	}

	public CruField getCruField() {
		return this.cruField;
	}

	public void setCruField(CruField cruField) {
		this.cruField = cruField;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

}