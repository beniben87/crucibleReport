package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_COMMIT_NOTIFICATION database table.
 * 
 */
@Entity
@Table(name="CRU_COMMIT_NOTIFICATION")
@NamedQuery(name="CruCommitNotification.findAll", query="SELECT c FROM CruCommitNotification c")
public class CruCommitNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_COMMIT_NOTIFICATION_ID")
	private long cruCommitNotificationId;

	@Column(name="CRU_CACHE_SERIAL_LAST_REV")
	private BigDecimal cruCacheSerialLastRev;

	@Column(name="CRU_CHANGESET_IDX_SERIAL")
	private BigDecimal cruChangesetIdxSerial;

	@Column(name="CRU_LAST_CHECKED")
	private BigDecimal cruLastChecked;

	@Column(name="CRU_REPOSITORY_NAME")
	private String cruRepositoryName;

	public CruCommitNotification() {
	}

	public long getCruCommitNotificationId() {
		return this.cruCommitNotificationId;
	}

	public void setCruCommitNotificationId(long cruCommitNotificationId) {
		this.cruCommitNotificationId = cruCommitNotificationId;
	}

	public BigDecimal getCruCacheSerialLastRev() {
		return this.cruCacheSerialLastRev;
	}

	public void setCruCacheSerialLastRev(BigDecimal cruCacheSerialLastRev) {
		this.cruCacheSerialLastRev = cruCacheSerialLastRev;
	}

	public BigDecimal getCruChangesetIdxSerial() {
		return this.cruChangesetIdxSerial;
	}

	public void setCruChangesetIdxSerial(BigDecimal cruChangesetIdxSerial) {
		this.cruChangesetIdxSerial = cruChangesetIdxSerial;
	}

	public BigDecimal getCruLastChecked() {
		return this.cruLastChecked;
	}

	public void setCruLastChecked(BigDecimal cruLastChecked) {
		this.cruLastChecked = cruLastChecked;
	}

	public String getCruRepositoryName() {
		return this.cruRepositoryName;
	}

	public void setCruRepositoryName(String cruRepositoryName) {
		this.cruRepositoryName = cruRepositoryName;
	}

}