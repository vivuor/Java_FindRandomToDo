package database;

import java.util.List;

import model.Tekeminen;

public interface TekeminenDAO {
	
	public List<Tekeminen> findAll();
	
	public boolean addTekeminen(Tekeminen tekeminen);
	
	public boolean removeTekeminen(int tekeminenId);
	
	public boolean editTekeminen(Tekeminen tekeminen);
	
	public List<Tekeminen> haeRandomTekeminen();
	
	public Tekeminen findById(int id);
	
}
