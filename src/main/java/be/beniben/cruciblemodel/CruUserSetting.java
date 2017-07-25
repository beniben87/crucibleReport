package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_USER_SETTING database table.
 * 
 */
@Entity
@Table(name="CRU_USER_SETTING")
@NamedQuery(name="CruUserSetting.findAll", query="SELECT c FROM CruUserSetting c")
public class CruUserSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruUserSettingPK id;

	@Column(name="CRU_TYPE")
	private BigDecimal cruType;

	@Lob
	@Column(name="CRU_VALUE")
	private String cruValue;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruUserSetting() {
	}

	public CruUserSettingPK getId() {
		return this.id;
	}

	public void setId(CruUserSettingPK id) {
		this.id = id;
	}

	public BigDecimal getCruType() {
		return this.cruType;
	}

	public void setCruType(BigDecimal cruType) {
		this.cruType = cruType;
	}

	public String getCruValue() {
		return this.cruValue;
	}

	public void setCruValue(String cruValue) {
		this.cruValue = cruValue;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}