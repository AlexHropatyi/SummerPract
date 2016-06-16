package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.DataBaseModel;

public class JPAController {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupportProject");
	
	public java.util.List<? extends DataBaseModel> getObjectList(Class<? extends DataBaseModel> clazz){
		EntityManager em = emf.createEntityManager();
		String queryName = clazz.getSimpleName() + "." + "findAll";
		@SuppressWarnings("unchecked")
		java.util.List<DataBaseModel> list = em.createNamedQuery(queryName).getResultList();
		em.close();
		return list;
	}
	
	public TableModel getTableModel(Class<? extends DataBaseModel> clazs){
		List<? extends DataBaseModel> list = getObjectList(clazs);
		if (list == null || list.size() == 0)
			return null;
		String[] header = list.get(0).getTableHeaders();
		Object[][] array = new Object[list.size()][header.length];
		int i = 0;
		for (DataBaseModel s : list)
			array[i++] = s.getTableRowData();
		return new DefaultTableModel(array, header);
	}
	
	public boolean ifExist(Class<? extends DataBaseModel> clazz, DataBaseModel obj){
		List<? extends DataBaseModel> list = getObjectList(clazz);
		if (list != null && list.size() != 0)
			for (Object current : list)
				if (current.equals(obj))
					return true;
		return false;
	}
	
	public void operateObject(DataBaseModel obj, int mode){
	}
	
}
