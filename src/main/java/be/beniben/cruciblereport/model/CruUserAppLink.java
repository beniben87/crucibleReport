package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_USER_APP_LINK database table.
 * 
 */
@Entity
@Table(name="CRU_USER_APP_LINK")
@NamedQuery(name="CruUserAppLink.findAll", query="SELECT c FROM CruUserAppLink c")
public class CruUserAppLink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_USER_APP_LINK_ID")
	private long cruUserAppLinkId;

	@Column(name="CRU_APP_LINK_ID")
	private String cruAppLinkId;

	@Column(name="CRU_IGNORE")
	private BigDecimal cruIgnore;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER")
	private CruUser cruUserBean;

	public CruUserAppLink() {
	}

	public long getCruUserAppLinkId() {
		return this.cruUserAppLinkId;
	}

	public void setCruUserAppLinkId(long cruUserAppLinkId) {
		this.cruUserAppLinkId = cruUserAppLinkId;
	}

	public String getCruAppLinkId() {
		return this.cruAppLinkId;
	}

	public void setCruAppLinkId(String cruAppLinkId) {
		this.cruAppLinkId = cruAppLinkId;
	}

	public BigDecimal getCruIgnore() {
		return this.cruIgnore;
	}

	public void setCruIgnore(BigDecimal cruIgnore) {
		this.cruIgnore = cruIgnore;
	}

	public CruUser getCruUserBean() {
		return this.cruUserBean;
	}

	public void setCruUserBean(CruUser cruUserBean) {
		this.cruUserBean = cruUserBean;
	}

}