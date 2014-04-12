import java.util.ArrayList;
import java.util.BitSet;
import java.util.Hashtable;


public class FindBorder {

	private SystemParameters parameters = null;
	
	public FindBorder(SystemParameters params) {
		this.parameters = params;
	}
	
	private DataObjectCollection m_inputData = null;
	private DataObjectCollection m_setOfObjects = null;
	private DataObjectCollection m_setOfObjectsComplement = null;
	private ArrayList<Integer> m_attributeIndexList = null;

	private DataObjectCollection m_positiveBorder = null;
	private DataObjectCollection m_negativeBorder = null;

	
	public void run() {
		
		loadData();

		parseAttributeIndexList();
		
		boolean bEqual = true;
		m_positiveBorder = new DataObjectCollection();
		m_negativeBorder = new DataObjectCollection();
		
		for (DataObject objInSet : m_setOfObjects) {
		
			for (DataObject objOutSet : m_setOfObjectsComplement) {
				
				bEqual = true;
				
				for (int index : m_attributeIndexList) {
					if (objInSet.get(index) != objOutSet.get(index)) {
						bEqual = false;
						break;
					}
				}
				
				if (bEqual) {
					if (!m_positiveBorder.contains(objInSet)) {
						m_positiveBorder.add(objInSet);
					}
					
					if (!m_negativeBorder.contains(objInSet)) {
						m_negativeBorder.add(objOutSet);
					}
				}
			}
		}
		
		Logger.logMessage("Positive border items: ");
		Logger.logMessage(m_positiveBorder.toString());
		
		Logger.logMessage("Negative border items: ");
		Logger.logMessage(m_negativeBorder.toString());
	}

	
	private void loadData() {
		// Load database
		Database db = new TextFileDatabase();
		m_inputData = db.loadData(parameters.getDatabase());
		Logger.logMessage("Dataset:");
		Logger.logMessage(m_inputData.toString());
		
		parseSetOfObjects();
		Logger.logMessage("Set of objects:");
		Logger.logMessage((m_setOfObjects.toString()));
		
		Logger.logMessage("Complement of set of objects (The rest of the dataset):");
		Logger.logMessage((m_setOfObjectsComplement.toString()));
	}
	
	private void parseSetOfObjects() {
		
		m_setOfObjects = new DataObjectCollection();
		m_setOfObjectsComplement = new DataObjectCollection();
		String strObjectIndexList = parameters.getObjectIndexList();
		String[] strIndexArray = strObjectIndexList.split(",");
		
		boolean bInSet = false;
		for (int i = 0; i < m_inputData.getSize(); i++) {
			
			bInSet = false;
			
			// Search the object in the set of objects, if index matches add it to the list
			for (String strIndex : strIndexArray) {
				if (i == Integer.parseInt(strIndex.trim())) {
					m_setOfObjects.add(m_inputData.getObject(i));
					bInSet = true;
					break;
				}
			}
			
			// .. if it's not in the set, add it's complement.
			if (!bInSet) {
				m_setOfObjectsComplement.add(m_inputData.getObject(i));
			}
		}
	}

	private void parseAttributeIndexList() {

		m_attributeIndexList = new ArrayList<Integer>();
		String strAttributeIndexList = parameters.getAttributeIndexList();
		String[] strIndexArray = strAttributeIndexList.split(",");
		for (String strIndex : strIndexArray) {
			m_attributeIndexList.add(Integer.parseInt(strIndex.trim()));
		}
		
	}
	
}
