import java.util.ArrayList;
import java.util.Iterator;

public class DataObjectCollection implements Iterable<DataObject> {

	private ArrayList<DataObject> m_lstObjectList;
	
	@Override
	public Iterator<DataObject> iterator() {
		return m_lstObjectList.iterator();
	}
	
	public DataObjectCollection()
	{
		m_lstObjectList = new ArrayList<DataObject>();
	}
	
	
	public void add(DataObject newObject) {
		m_lstObjectList.add(newObject);
	}
	
	public boolean contains(DataObject objToSearch) {
		
		for (DataObject objCurrent : m_lstObjectList) {
			if ( Integer.parseInt(objCurrent.toString(), 2) == Integer.parseInt(objToSearch.toString(), 2)) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getSize() {
		return m_lstObjectList.size();
	}
	
	public DataObject getObject(int index) {
		return m_lstObjectList.get(index);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (DataObject obj : m_lstObjectList) {
			sb.append(obj + "\n");
		}
		
		return sb.toString();
	}
	
}
