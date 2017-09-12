package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_FIELD database table.
 * 
 */
@Entity
@Table(name="CRU_FIELD")
@NamedQuery(name="CruField.findAll", query="SELECT c FROM CruField c")
public class CruField implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_FIELD_ID")
	private long cruFieldId;

	@Column(name="CRU_BOOLEAN_VAL")
	private BigDecimal cruBooleanVal;

	@Column(name="CRU_CONFIG_VERSION")
	private BigDecimal cruConfigVersion;

	@Column(name="CRU_DATE")
	private BigDecimal cruDate;

	@Column(name="CRU_FIELD_SCOPE")
	private String cruFieldScope;

	@Column(name="CRU_INT_VAL")
	private BigDecimal cruIntVal;

	@Column(name="CRU_NAME")
	private String cruName;

	@Column(name="CRU_STRING_VAL")
	private String cruStringVal;

	//bi-directional many-to-one association to CruCommentField
	@OneToMany(mappedBy="cruField")
	private List<CruCommentField> cruCommentFields;

	//bi-directional many-to-one association to CruReviewField
	@OneToMany(mappedBy="cruField")
	private List<CruReviewField> cruReviewFields;

	public CruField() {
	}

	public long getCruFieldId() {
		return this.cruFieldId;
	}

	public void setCruFieldId(long cruFieldId) {
		this.cruFieldId = cruFieldId;
	}

	public BigDecimal getCruBooleanVal() {
		return this.cruBooleanVal;
	}

	public void setCruBooleanVal(BigDecimal cruBooleanVal) {
		this.cruBooleanVal = cruBooleanVal;
	}

	public BigDecimal getCruConfigVersion() {
		return this.cruConfigVersion;
	}

	public void setCruConfigVersion(BigDecimal cruConfigVersion) {
		this.cruConfigVersion = cruConfigVersion;
	}

	public BigDecimal getCruDate() {
		return this.cruDate;
	}

	public void setCruDate(BigDecimal cruDate) {
		this.cruDate = cruDate;
	}

	public String getCruFieldScope() {
		return this.cruFieldScope;
	}

	public void setCruFieldScope(String cruFieldScope) {
		this.cruFieldScope = cruFieldScope;
	}

	public BigDecimal getCruIntVal() {
		return this.cruIntVal;
	}

	public void setCruIntVal(BigDecimal cruIntVal) {
		this.cruIntVal = cruIntVal;
	}

	public String getCruName() {
		return this.cruName;
	}

	public void setCruName(String cruName) {
		this.cruName = cruName;
	}

	public String getCruStringVal() {
		return this.cruStringVal;
	}

	public void setCruStringVal(String cruStringVal) {
		this.cruStringVal = cruStringVal;
	}

	public List<CruCommentField> getCruCommentFields() {
		return this.cruCommentFields;
	}

	public void setCruCommentFields(List<CruCommentField> cruCommentFields) {
		this.cruCommentFields = cruCommentFields;
	}

	public CruCommentField addCruCommentField(CruCommentField cruCommentField) {
		getCruCommentFields().add(cruCommentField);
		cruCommentField.setCruField(this);

		return cruCommentField;
	}

	public CruCommentField removeCruCommentField(CruCommentField cruCommentField) {
		getCruCommentFields().remove(cruCommentField);
		cruCommentField.setCruField(null);

		return cruCommentField;
	}

	public List<CruReviewField> getCruReviewFields() {
		return this.cruReviewFields;
	}

	public void setCruReviewFields(List<CruReviewField> cruReviewFields) {
		this.cruReviewFields = cruReviewFields;
	}

	public CruReviewField addCruReviewField(CruReviewField cruReviewField) {
		getCruReviewFields().add(cruReviewField);
		cruReviewField.setCruField(this);

		return cruReviewField;
	}

	public CruReviewField removeCruReviewField(CruReviewField cruReviewField) {
		getCruReviewFields().remove(cruReviewField);
		cruReviewField.setCruField(null);

		return cruReviewField;
	}

}