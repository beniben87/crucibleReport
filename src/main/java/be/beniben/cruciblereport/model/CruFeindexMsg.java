package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_FEINDEX_MSG database table.
 * 
 */
@Entity
@Table(name="CRU_FEINDEX_MSG")
@NamedQuery(name="CruFeindexMsg.findAll", query="SELECT c FROM CruFeindexMsg c")
public class CruFeindexMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_ID")
	private long cruId;

	@Column(name="CRU_REVIEW_ID")
	private BigDecimal cruReviewId;

	//bi-directional many-to-one association to CruRevision
	@ManyToOne
	@JoinColumn(name="CRU_FR_ID")
	private CruRevision cruRevision;

	public CruFeindexMsg() {
	}

	public long getCruId() {
		return this.cruId;
	}

	public void setCruId(long cruId) {
		this.cruId = cruId;
	}

	public BigDecimal getCruReviewId() {
		return this.cruReviewId;
	}

	public void setCruReviewId(BigDecimal cruReviewId) {
		this.cruReviewId = cruReviewId;
	}

	public CruRevision getCruRevision() {
		return this.cruRevision;
	}

	public void setCruRevision(CruRevision cruRevision) {
		this.cruRevision = cruRevision;
	}

}