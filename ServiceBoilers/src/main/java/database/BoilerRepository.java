package database;

import entity.Boiler;

public interface BoilerRepository {
	void addBoiler(Boiler boiler);
	void updateBoiler(Boiler boiler);
	Boiler findById(Long id);
}
