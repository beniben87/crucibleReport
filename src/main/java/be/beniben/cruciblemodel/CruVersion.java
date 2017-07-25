package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_VERSION database table.
 * 
 */
@Entity
@Table(name="CRU_VERSION")
@NamedQuery(name="CruVersion.findAll", query="SELECT c FROM CruVersion c")
public class CruVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_VERSION_ID")
	private long cruVersionId;

	@Column(name="CRU_VERSION")
	private BigDecimal cruVersion;

	public CruVersion() {
	}

	public long getCruVersionId() {
		return this.cruVersionId;
	}

	public void setCruVersionId(long cruVersionId) {
		this.cruVersionId = cruVersionId;
	}

	public BigDecimal getCruVersion() {
		return this.cruVersion;
	}

	public void setCruVersion(BigDecimal cruVersion) {
		this.cruVersion = cruVersion;
	}

}