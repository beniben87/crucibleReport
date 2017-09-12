package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_REVIEW_PROPERTY database table.
 * 
 */
@Entity
@Table(name="CRU_REVIEW_PROPERTY")
@NamedQuery(name="CruReviewProperty.findAll", query="SELECT c FROM CruReviewProperty c")
public class CruReviewProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_REVIEW_PROPERTY_ID")
	private long cruReviewPropertyId;

	@Column(name="CRU_NAME")
	private String cruName;

	@Lob
	@Column(name="CRU_VALUE")
	private String cruValue;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	public CruReviewProperty() {
	}

	public long getCruReviewPropertyId() {
		return this.cruReviewPropertyId;
	}

	public void setCruReviewPropertyId(long cruReviewPropertyId) {
		this.cruReviewPropertyId = cruReviewPropertyId;
	}

	public String getCruName() {
		return this.cruName;
	}

	public void setCruName(String cruName) {
		this.cruName = cruName;
	}

	public String getCruValue() {
		return this.cruValue;
	}

	public void setCruValue(String cruValue) {
		this.cruValue = cruValue;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

}