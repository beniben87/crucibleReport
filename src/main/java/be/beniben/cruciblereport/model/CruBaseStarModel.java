package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_BASE_STAR_MODEL database table.
 * 
 */
@Entity
@Table(name="CRU_BASE_STAR_MODEL")
@NamedQuery(name="CruBaseStarModel.findAll", query="SELECT c FROM CruBaseStarModel c")
public class CruBaseStarModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_STAR_ID")
	private long cruStarId;

	@Column(name="CRU_DATE_CREATED")
	private BigDecimal cruDateCreated;

	@Column(name="CRU_INT_KEY1")
	private BigDecimal cruIntKey1;

	@Column(name="CRU_INT_KEY2")
	private BigDecimal cruIntKey2;

	@Column(name="CRU_INT_KEY3")
	private BigDecimal cruIntKey3;

	@Column(name="CRU_INT_KEY4")
	private BigDecimal cruIntKey4;

	@Column(name="CRU_INT_KEY5")
	private BigDecimal cruIntKey5;

	@Column(name="CRU_ITEM_TYPE")
	private String cruItemType;

	@Column(name="CRU_LABEL")
	private String cruLabel;

	@Column(name="CRU_STRING_KEY1")
	private String cruStringKey1;

	@Column(name="CRU_STRING_KEY2")
	private String cruStringKey2;

	@Column(name="CRU_STRING_KEY3")
	private String cruStringKey3;

	@Column(name="CRU_STRING_KEY4")
	private String cruStringKey4;

	@Column(name="CRU_STRING_KEY5")
	private String cruStringKey5;

	@Lob
	@Column(name="CRU_TEXT_KEY1")
	private String cruTextKey1;

	@Lob
	@Column(name="CRU_TEXT_KEY2")
	private String cruTextKey2;

	@Column(name="CRU_USER_NAME")
	private String cruUserName;

	public CruBaseStarModel() {
	}

	public long getCruStarId() {
		return this.cruStarId;
	}

	public void setCruStarId(long cruStarId) {
		this.cruStarId = cruStarId;
	}

	public BigDecimal getCruDateCreated() {
		return this.cruDateCreated;
	}

	public void setCruDateCreated(BigDecimal cruDateCreated) {
		this.cruDateCreated = cruDateCreated;
	}

	public BigDecimal getCruIntKey1() {
		return this.cruIntKey1;
	}

	public void setCruIntKey1(BigDecimal cruIntKey1) {
		this.cruIntKey1 = cruIntKey1;
	}

	public BigDecimal getCruIntKey2() {
		return this.cruIntKey2;
	}

	public void setCruIntKey2(BigDecimal cruIntKey2) {
		this.cruIntKey2 = cruIntKey2;
	}

	public BigDecimal getCruIntKey3() {
		return this.cruIntKey3;
	}

	public void setCruIntKey3(BigDecimal cruIntKey3) {
		this.cruIntKey3 = cruIntKey3;
	}

	public BigDecimal getCruIntKey4() {
		return this.cruIntKey4;
	}

	public void setCruIntKey4(BigDecimal cruIntKey4) {
		this.cruIntKey4 = cruIntKey4;
	}

	public BigDecimal getCruIntKey5() {
		return this.cruIntKey5;
	}

	public void setCruIntKey5(BigDecimal cruIntKey5) {
		this.cruIntKey5 = cruIntKey5;
	}

	public String getCruItemType() {
		return this.cruItemType;
	}

	public void setCruItemType(String cruItemType) {
		this.cruItemType = cruItemType;
	}

	public String getCruLabel() {
		return this.cruLabel;
	}

	public void setCruLabel(String cruLabel) {
		this.cruLabel = cruLabel;
	}

	public String getCruStringKey1() {
		return this.cruStringKey1;
	}

	public void setCruStringKey1(String cruStringKey1) {
		this.cruStringKey1 = cruStringKey1;
	}

	public String getCruStringKey2() {
		return this.cruStringKey2;
	}

	public void setCruStringKey2(String cruStringKey2) {
		this.cruStringKey2 = cruStringKey2;
	}

	public String getCruStringKey3() {
		return this.cruStringKey3;
	}

	public void setCruStringKey3(String cruStringKey3) {
		this.cruStringKey3 = cruStringKey3;
	}

	public String getCruStringKey4() {
		return this.cruStringKey4;
	}

	public void setCruStringKey4(String cruStringKey4) {
		this.cruStringKey4 = cruStringKey4;
	}

	public String getCruStringKey5() {
		return this.cruStringKey5;
	}

	public void setCruStringKey5(String cruStringKey5) {
		this.cruStringKey5 = cruStringKey5;
	}

	public String getCruTextKey1() {
		return this.cruTextKey1;
	}

	public void setCruTextKey1(String cruTextKey1) {
		this.cruTextKey1 = cruTextKey1;
	}

	public String getCruTextKey2() {
		return this.cruTextKey2;
	}

	public void setCruTextKey2(String cruTextKey2) {
		this.cruTextKey2 = cruTextKey2;
	}

	public String getCruUserName() {
		return this.cruUserName;
	}

	public void setCruUserName(String cruUserName) {
		this.cruUserName = cruUserName;
	}

}