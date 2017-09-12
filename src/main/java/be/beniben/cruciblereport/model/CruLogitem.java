package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_LOGITEM database table.
 * 
 */
@Entity
@Table(name="CRU_LOGITEM")
@NamedQuery(name="CruLogitem.findAll", query="SELECT c FROM CruLogitem c")
public class CruLogitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_LOGITEM_ID")
	private long cruLogitemId;

	@Column(name="CRU_ACTION")
	private String cruAction;

	@Column(name="CRU_CREATE_DATE")
	private BigDecimal cruCreateDate;

	@Lob
	@Column(name="CRU_DESCRIPTION")
	private String cruDescription;

	@Column(name="CRU_ENTITY_ID")
	private BigDecimal cruEntityId;

	@Column(name="CRU_ENTITY_ID_2")
	private BigDecimal cruEntityId2;

	@Lob
	@Column(name="CRU_ENTITY_STRING")
	private String cruEntityString;

	@Lob
	@Column(name="CRU_NEW_VALUE")
	private String cruNewValue;

	@Lob
	@Column(name="CRU_OLD_VALUE")
	private String cruOldValue;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruLogitem() {
	}

	public long getCruLogitemId() {
		return this.cruLogitemId;
	}

	public void setCruLogitemId(long cruLogitemId) {
		this.cruLogitemId = cruLogitemId;
	}

	public String getCruAction() {
		return this.cruAction;
	}

	public void setCruAction(String cruAction) {
		this.cruAction = cruAction;
	}

	public BigDecimal getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(BigDecimal cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public String getCruDescription() {
		return this.cruDescription;
	}

	public void setCruDescription(String cruDescription) {
		this.cruDescription = cruDescription;
	}

	public BigDecimal getCruEntityId() {
		return this.cruEntityId;
	}

	public void setCruEntityId(BigDecimal cruEntityId) {
		this.cruEntityId = cruEntityId;
	}

	public BigDecimal getCruEntityId2() {
		return this.cruEntityId2;
	}

	public void setCruEntityId2(BigDecimal cruEntityId2) {
		this.cruEntityId2 = cruEntityId2;
	}

	public String getCruEntityString() {
		return this.cruEntityString;
	}

	public void setCruEntityString(String cruEntityString) {
		this.cruEntityString = cruEntityString;
	}

	public String getCruNewValue() {
		return this.cruNewValue;
	}

	public void setCruNewValue(String cruNewValue) {
		this.cruNewValue = cruNewValue;
	}

	public String getCruOldValue() {
		return this.cruOldValue;
	}

	public void setCruOldValue(String cruOldValue) {
		this.cruOldValue = cruOldValue;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}