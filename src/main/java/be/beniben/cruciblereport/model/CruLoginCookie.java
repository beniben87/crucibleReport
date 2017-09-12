package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_LOGIN_COOKIE database table.
 * 
 */
@Entity
@Table(name="CRU_LOGIN_COOKIE")
@NamedQuery(name="CruLoginCookie.findAll", query="SELECT c FROM CruLoginCookie c")
public class CruLoginCookie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_LOGIN_COOKIE_ID")
	private long cruLoginCookieId;

	@Column(name="CRU_CREATE_DATE")
	private BigDecimal cruCreateDate;

	@Column(name="CRU_RECURSIVE_URL")
	private BigDecimal cruRecursiveUrl;

	@Column(name="CRU_RND")
	private String cruRnd;

	@Column(name="CRU_TYPE")
	private BigDecimal cruType;

	@Column(name="CRU_URL")
	private String cruUrl;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruLoginCookie() {
	}

	public long getCruLoginCookieId() {
		return this.cruLoginCookieId;
	}

	public void setCruLoginCookieId(long cruLoginCookieId) {
		this.cruLoginCookieId = cruLoginCookieId;
	}

	public BigDecimal getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(BigDecimal cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public BigDecimal getCruRecursiveUrl() {
		return this.cruRecursiveUrl;
	}

	public void setCruRecursiveUrl(BigDecimal cruRecursiveUrl) {
		this.cruRecursiveUrl = cruRecursiveUrl;
	}

	public String getCruRnd() {
		return this.cruRnd;
	}

	public void setCruRnd(String cruRnd) {
		this.cruRnd = cruRnd;
	}

	public BigDecimal getCruType() {
		return this.cruType;
	}

	public void setCruType(BigDecimal cruType) {
		this.cruType = cruType;
	}

	public String getCruUrl() {
		return this.cruUrl;
	}

	public void setCruUrl(String cruUrl) {
		this.cruUrl = cruUrl;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}