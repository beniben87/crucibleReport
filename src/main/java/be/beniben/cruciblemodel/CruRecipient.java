package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_RECIPIENT database table.
 * 
 */
@Entity
@Table(name="CRU_RECIPIENT")
@NamedQuery(name="CruRecipient.findAll", query="SELECT c FROM CruRecipient c")
public class CruRecipient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_RECIPIENT_ID")
	private long cruRecipientId;

	@Column(name="CRU_EMAIL")
	private BigDecimal cruEmail;

	@Column(name="CRU_EMAIL_ADDRESS")
	private String cruEmailAddress;

	@Column(name="CRU_RSS")
	private BigDecimal cruRss;

	@Column(name="CRU_UI_ACK")
	private BigDecimal cruUiAck;

	@Column(name="CRU_USER_NOTIFICATION_FLAG")
	private BigDecimal cruUserNotificationFlag;

	//bi-directional many-to-one association to CruNotification
	@ManyToOne
	@JoinColumn(name="CRU_NOTIFICATION_ID")
	private CruNotification cruNotification;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER")
	private CruUser cruUserBean;

	public CruRecipient() {
	}

	public long getCruRecipientId() {
		return this.cruRecipientId;
	}

	public void setCruRecipientId(long cruRecipientId) {
		this.cruRecipientId = cruRecipientId;
	}

	public BigDecimal getCruEmail() {
		return this.cruEmail;
	}

	public void setCruEmail(BigDecimal cruEmail) {
		this.cruEmail = cruEmail;
	}

	public String getCruEmailAddress() {
		return this.cruEmailAddress;
	}

	public void setCruEmailAddress(String cruEmailAddress) {
		this.cruEmailAddress = cruEmailAddress;
	}

	public BigDecimal getCruRss() {
		return this.cruRss;
	}

	public void setCruRss(BigDecimal cruRss) {
		this.cruRss = cruRss;
	}

	public BigDecimal getCruUiAck() {
		return this.cruUiAck;
	}

	public void setCruUiAck(BigDecimal cruUiAck) {
		this.cruUiAck = cruUiAck;
	}

	public BigDecimal getCruUserNotificationFlag() {
		return this.cruUserNotificationFlag;
	}

	public void setCruUserNotificationFlag(BigDecimal cruUserNotificationFlag) {
		this.cruUserNotificationFlag = cruUserNotificationFlag;
	}

	public CruNotification getCruNotification() {
		return this.cruNotification;
	}

	public void setCruNotification(CruNotification cruNotification) {
		this.cruNotification = cruNotification;
	}

	public CruUser getCruUserBean() {
		return this.cruUserBean;
	}

	public void setCruUserBean(CruUser cruUserBean) {
		this.cruUserBean = cruUserBean;
	}

}