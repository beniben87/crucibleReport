package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CRU_INLINE_COMMENT database table.
 * 
 */
@Entity
@Table(name="CRU_INLINE_COMMENT")
@NamedQuery(name="CruInlineComment.findAll", query="SELECT c FROM CruInlineComment c")
public class CruInlineComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_COMMENT_ID")
	private long cruCommentId;

	//bi-directional one-to-one association to CruComment
	@OneToOne
	@PrimaryKeyJoinColumn(name="CRU_COMMENT_ID")
	private CruComment cruComment;

	//bi-directional many-to-one association to CruFrx
	@ManyToOne
	@JoinColumn(name="CRU_FRX_ID")
	private CruFrx cruFrx;

	//bi-directional many-to-one association to CruInlineCommentToFrxRev
	@OneToMany(mappedBy="cruInlineComment")
	private List<CruInlineCommentToFrxRev> cruInlineCommentToFrxRevs;

	public CruInlineComment() {
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

	public List<CruInlineCommentToFrxRev> getCruInlineCommentToFrxRevs() {
		return this.cruInlineCommentToFrxRevs;
	}

	public void setCruInlineCommentToFrxRevs(List<CruInlineCommentToFrxRev> cruInlineCommentToFrxRevs) {
		this.cruInlineCommentToFrxRevs = cruInlineCommentToFrxRevs;
	}

	public CruInlineCommentToFrxRev addCruInlineCommentToFrxRev(CruInlineCommentToFrxRev cruInlineCommentToFrxRev) {
		getCruInlineCommentToFrxRevs().add(cruInlineCommentToFrxRev);
		cruInlineCommentToFrxRev.setCruInlineComment(this);

		return cruInlineCommentToFrxRev;
	}

	public CruInlineCommentToFrxRev removeCruInlineCommentToFrxRev(CruInlineCommentToFrxRev cruInlineCommentToFrxRev) {
		getCruInlineCommentToFrxRevs().remove(cruInlineCommentToFrxRev);
		cruInlineCommentToFrxRev.setCruInlineComment(null);

		return cruInlineCommentToFrxRev;
	}

}