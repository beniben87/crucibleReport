package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_FRX_COMMENT database table.
 * 
 */
@Entity
@Table(name="CRU_FRX_COMMENT")
@NamedQuery(name="CruFrxComment.findAll", query="SELECT c FROM CruFrxComment c")
public class CruFrxComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_COMMENT_ID")
	private long cruCommentId;

	//bi-directional one-to-one association to CruComment
	@OneToOne
	@JoinColumn(name="CRU_COMMENT_ID")
	private CruComment cruComment;

	//bi-directional many-to-one association to CruFrx
	@ManyToOne
	@JoinColumn(name="CRU_FRX_ID")
	private CruFrx cruFrx;

	public CruFrxComment() {
	}

	public long getCruCommentId() {
		return this.cruCommentId;
	}

	public void setCruCommentId(long cruCommentId) {
		this.cruCommentId = cruCommentId;
	}

	public CruComment getCruComment() {
		return this.cruComment;
	}

	public void setCruComment(CruComment cruComment) {
		this.cruComment = cruComment;
	}

	public CruFrx getCruFrx() {
		return this.cruFrx;
	}

	public void setCruFrx(CruFrx cruFrx) {
		this.cruFrx = cruFrx;
	}

}