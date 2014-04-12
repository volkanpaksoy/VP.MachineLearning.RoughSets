
public class SystemParameters {

	private String m_strLogPath = "";
	
	private String m_strDatabase = "";
	
	private String m_strObjectIndexList = "";

	private String m_strAttributeIndexList = "";
	
	
	public String getObjectIndexList() {
		return m_strObjectIndexList;
	}

	public void setObjectIndexList(String mStrObjectIndexList) {
		m_strObjectIndexList = mStrObjectIndexList;
	}

	public String getAttributeIndexList() {
		return m_strAttributeIndexList;
	}

	public void setAttributeIndexList(String mStrAttributeIndexList) {
		m_strAttributeIndexList = mStrAttributeIndexList;
	}

	public String getDatabase() {
		return m_strDatabase;
	}

	public void setDatabase(String mStrDatabase) {
		m_strDatabase = mStrDatabase;
	}
	

	public void setLogPath(String m_strLogPath) {
		this.m_strLogPath = m_strLogPath;
	}

	public String getLogPath() {
		return m_strLogPath;
	}

	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" ------ System Parameters ------ "  + "\n");
		sb.append("Log Path ..............:" + this.getLogPath() + "\n");
		sb.append("Database Path .........:" + this.getDatabase() + "\n");
		sb.append("Object Index List .....:" + this.getObjectIndexList() + "\n");
		sb.append("Attribute Index List ..:" + this.getAttributeIndexList() + "\n");
		sb.append(" ------------------------------- "  + "\n");
		return sb.toString();
		
	}
	
}
