package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_STATE_CHANGE database table.
 * 
 */
@Entity
@Table(name="CRU_STATE_CHANGE")
@NamedQuery(name="CruStateChange.findAll", query="SELECT c FROM CruStateChange c")
public class CruStateChange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_ID")
	private long cruId;

	@Column(name="CRU_NEW_STATE")
	private String cruNewState;

	@Column(name="CRU_REVIEW_ID")
	private BigDecimal cruReviewId;

	@Column(name="CRU_SUPERSEDED")
	private BigDecimal cruSuperseded;

	@Column(name="CRU_TIME_STAMP")
	private BigDecimal cruTimeStamp;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER")
	private CruUser cruUserBean;

	public CruStateChange() {
	}

	public long getCruId() {
		return this.cruId;
	}

	public void setCruId(long cruId) {
		this.cruId = cruId;
	}

	public String getCruNewState() {
		return this.cruNewState;
	}

	public void setCruNewState(String cruNewState) {
		this.cruNewState = cruNewState;
	}

	public BigDecimal getCruReviewId() {
		return this.cruReviewId;
	}

	public void setCruReviewId(BigDecimal cruReviewId) {
		this.cruReviewId = cruReviewId;
	}

	public BigDecimal getCruSuperseded() {
		return this.cruSuperseded;
	}

	public void setCruSuperseded(BigDecimal cruSuperseded) {
		this.cruSuperseded = cruSuperseded;
	}

	public BigDecimal getCruTimeStamp() {
		return this.cruTimeStamp;
	}

	public void setCruTimeStamp(BigDecimal cruTimeStamp) {
		this.cruTimeStamp = cruTimeStamp;
	}

	public CruUser getCruUserBean() {
		return this.cruUserBean;
	}

	public void setCruUserBean(CruUser cruUserBean) {
		this.cruUserBean = cruUserBean;
	}

}