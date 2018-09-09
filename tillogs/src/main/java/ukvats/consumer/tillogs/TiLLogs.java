package ukvats.consumer.tillogs;

public class TiLLogs {
	
	private long MSISDN;
	private String jmsCorrelationID;
	private String systemTimestamp;
	private String soapAction;
	private String body;
	
	public long getMSISDN() {
		return MSISDN;
	}
	public void setMSISDN(long mSISDN) {
		MSISDN = mSISDN;
	}
	public String getJmsCorrelationID() {
		return jmsCorrelationID;
	}
	public void setJmsCorrelationID(String jmsCorrelationID) {
		this.jmsCorrelationID = jmsCorrelationID;
	}
	public String getSystemTimestamp() {
		return systemTimestamp;
	}
	public void setSystemTimestamp(String systemTimestamp) {
		this.systemTimestamp = systemTimestamp;
	}

	public String getSoapAction() {
		return soapAction;
	}
	public void setSoapAction(String soapAction) {
		this.soapAction = soapAction;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (MSISDN ^ (MSISDN >>> 32));
		result = prime * result + ((jmsCorrelationID == null) ? 0 : jmsCorrelationID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiLLogs other = (TiLLogs) obj;
		if (MSISDN != other.MSISDN)
			return false;
		if (jmsCorrelationID == null) {
			if (other.jmsCorrelationID != null)
				return false;
		} else if (!jmsCorrelationID.equals(other.jmsCorrelationID))
			return false;
		return true;
	}
	public TiLLogs(long mSISDN, String jmsCorrelationID, String systemTimestamp,
			String soapAction, String body) {
		super();
		MSISDN = mSISDN;
		this.jmsCorrelationID = jmsCorrelationID;
		this.systemTimestamp = systemTimestamp;
		this.soapAction = soapAction;
		this.body = body;
	}
	public TiLLogs() {
		
	}
	@Override
	public String toString() {
		return "TiLLogs [MSISDN=" + MSISDN + ", jmsCorrelationID=" + jmsCorrelationID + ", systemTimestamp="
				+ systemTimestamp + ", soapAction=" + soapAction
				+ ", body=" + body + "]";
	}
	
	
	
}