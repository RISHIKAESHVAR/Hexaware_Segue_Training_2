package Dao;

import model.Chemist;

public interface DaoInter {

	boolean addDetails(Chemist c);
	void showAllMed();
	boolean removeMed(Chemist c);
	void searchMed(Chemist c);
	boolean updateName(Chemist c);
	boolean updatePrice(Chemist c);
	boolean updateStock(Chemist c);
	void order(Chemist c);
	
	
}