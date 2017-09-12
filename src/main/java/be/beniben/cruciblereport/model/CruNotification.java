package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_NOTIFICATION database table.
 * 
 */
@Entity
@Table(name="CRU_NOTIFICATION")
@NamedQuery(name="CruNotification.findAll", query="SELECT c FROM CruNotification c")
public class CruNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_NOTIFICATION_ID")
	private long cruNotificationId;

	@Column(name="CRU_CREATE_DATE")
	private BigDecimal cruCreateDate;

	@Lob
	@Column(name="CRU_NOTE")
	private String cruNote;

	@Column(name="CRU_NOTE_TYPE")
	private String cruNoteType;

	@Column(name="CRU_OBJECT_ID")
	private String cruObjectId;

	@Column(name="CRU_OBJECT_NAME")
	private String cruObjectName;

	@Column(name="CRU_OBJECT_REPOSITORY")
	private String cruObjectRepository;

	@Lob
	@Column(name="CRU_OBJECT_URL")
	private String cruObjectUrl;

	@Column(name="CRU_REF1")
	private BigDecimal cruRef1;

	@Column(name="CRU_REF2")
	private BigDecimal cruRef2;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW")
	private CruReview cruReviewBean;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_ACTIONER")
	private CruUser cruUser;

	//bi-directional many-to-one association to CruRecipient
	@OneToMany(mappedBy="cruNotification")
	private List<CruRecipient> cruRecipients;

	public CruNotification() {
	}

	public long getCruNotificationId() {
		return this.cruNotificationId;
	}

	public void setCruNotificationId(long cruNotificationId) {
		this.cruNotificationId = cruNotificationId;
	}

	public BigDecimal getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(BigDecimal cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public String getCruNote() {
		return this.cruNote;
	}

	public void setCruNote(String cruNote) {
		this.cruNote = cruNote;
	}

	public String getCruNoteType() {
		return this.cruNoteType;
	}

	public void setCruNoteType(String cruNoteType) {
		this.cruNoteType = cruNoteType;
	}

	public String getCruObjectId() {
		return this.cruObjectId;
	}

	public void setCruObjectId(String cruObjectId) {
		this.cruObjectId = cruObjectId;
	}

	public String getCruObjectName() {
		return this.cruObjectName;
	}

	public void setCruObjectName(String cruObjectName) {
		this.cruObjectName = cruObjectName;
	}

	public String getCruObjectRepository() {
		return this.cruObjectRepository;
	}

	public void setCruObjectRepository(String cruObjectRepository) {
		this.cruObjectRepository = cruObjectRepository;
	}

	public String getCruObjectUrl() {
		return this.cruObjectUrl;
	}

	public void setCruObjectUrl(String cruObjectUrl) {
		this.cruObjectUrl = cruObjectUrl;
	}

	public BigDecimal getCruRef1() {
		return this.cruRef1;
	}

	public void setCruRef1(BigDecimal cruRef1) {
		this.cruRef1 = cruRef1;
	}

	public BigDecimal getCruRef2() {
		return this.cruRef2;
	}

	public void setCruRef2(BigDecimal cruRef2) {
		this.cruRef2 = cruRef2;
	}

	public CruReview getCruReviewBean() {
		return this.cruReviewBean;
	}

	public void setCruReviewBean(CruReview cruReviewBean) {
		this.cruReviewBean = cruReviewBean;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

	public List<CruRecipient> getCruRecipients() {
		return this.cruRecipients;
	}

	public void setCruRecipients(List<CruRecipient> cruRecipients) {
		this.cruRecipients = cruRecipients;
	}

	public CruRecipient addCruRecipient(CruRecipient cruRecipient) {
		getCruRecipients().add(cruRecipient);
		cruRecipient.setCruNotification(this);

		return cruRecipient;
	}

	public CruRecipient removeCruRecipient(CruRecipient cruRecipient) {
		getCruRecipients().remove(cruRecipient);
		cruRecipient.setCruNotification(null);

		return cruRecipient;
	}

}