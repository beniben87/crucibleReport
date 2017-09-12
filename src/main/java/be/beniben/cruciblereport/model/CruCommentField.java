package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_COMMENT_FIELD database table.
 * 
 */
@Entity
@Table(name="CRU_COMMENT_FIELD")
@NamedQuery(name="CruCommentField.findAll", query="SELECT c FROM CruCommentField c")
public class CruCommentField implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruCommentFieldPK id;

	//bi-directional many-to-one association to CruComment
	@ManyToOne
	@JoinColumn(name="CRU_COMMENT_ID")
	private CruComment cruComment;

	//bi-directional many-to-one association to CruField
	@ManyToOne
	@JoinColumn(name="CRU_FIELD_ID")
	private CruField cruField;

	public CruCommentField() {
	}

	public CruCommentFieldPK getId() {
		return this.id;
	}

	public void setId(CruCommentFieldPK id) {
		this.id = id;
	}

	public CruComment getCruComment() {
		return this.cruComment;
	}

	public void setCruComment(CruComment cruComment) {
		this.cruComment = cruComment;
	}

	public CruField getCruField() {
		return this.cruField;
	}

	public void setCruField(CruField cruField) {
		this.cruField = cruField;
	}

}