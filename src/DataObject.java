import java.util.BitSet;

public class DataObject extends BitSet {

	private int m_nLength = -1;
	
	public DataObject(int length) {
		super(length);
		
		m_nLength = length;
	}
	
	public boolean getAttribute(int index) {
		return this.get(index);
	}
	
	
	public static DataObject parseDataObject(String s) {
		
		DataObject obj = new DataObject(s.length());
		
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) == '1')
				obj.set(i, true);
			
		}
		
		return obj;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m_nLength; i++) {
			if (this.get(i) == true)
				sb.append("1");
			else
				sb.append("0");
		}
		
		return sb.toString();
	}
}
