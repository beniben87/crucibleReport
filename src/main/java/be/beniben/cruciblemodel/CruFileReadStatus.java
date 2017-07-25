package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_FILE_READ_STATUS database table.
 * 
 */
@Entity
@Table(name="CRU_FILE_READ_STATUS")
@NamedQuery(name="CruFileReadStatus.findAll", query="SELECT c FROM CruFileReadStatus c")
public class CruFileReadStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_FILE_READ_STATUS_ID")
	private long cruFileReadStatusId;

	@Column(name="CRU_LAST_UNREAD_DATE")
	private BigDecimal cruLastUnreadDate;

	@Column(name="CRU_READ")
	private BigDecimal cruRead;

	//bi-directional many-to-one association to CruFrx
	@ManyToOne
	@JoinColumn(name="CRU_FRX")
	private CruFrx cruFrxBean;

	//bi-directional many-to-one association to CruReviewParticipant
	@ManyToOne
	@JoinColumn(name="CRU_PARTICIPANT")
	private CruReviewParticipant cruReviewParticipant;

	public CruFileReadStatus() {
	}

	public long getCruFileReadStatusId() {
		return this.cruFileReadStatusId;
	}

	public void setCruFileReadStatusId(long cruFileReadStatusId) {
		this.cruFileReadStatusId = cruFileReadStatusId;
	}

	public BigDecimal getCruLastUnreadDate() {
		return this.cruLastUnreadDate;
	}

	public void setCruLastUnreadDate(BigDecimal cruLastUnreadDate) {
		this.cruLastUnreadDate = cruLastUnreadDate;
	}

	public BigDecimal getCruRead() {
		return this.cruRead;
	}

	public void setCruRead(BigDecimal cruRead) {
		this.cruRead = cruRead;
	}

	public CruFrx getCruFrxBean() {
		return this.cruFrxBean;
	}

	public void setCruFrxBean(CruFrx cruFrxBean) {
		this.cruFrxBean = cruFrxBean;
	}

	public CruReviewParticipant getCruReviewParticipant() {
		return this.cruReviewParticipant;
	}

	public void setCruReviewParticipant(CruReviewParticipant cruReviewParticipant) {
		this.cruReviewParticipant = cruReviewParticipant;
	}

}