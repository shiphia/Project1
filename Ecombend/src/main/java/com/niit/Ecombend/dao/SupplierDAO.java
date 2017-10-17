package com.niit.Ecombend.dao;
import java.util.List;

import com.niit.Ecombend.models.Supplier;



public interface SupplierDAO {
	void saveSupplier(Supplier s);
	List<Supplier> getAllSupplier();
    Supplier getSupplierById(int id);
    public void deletesupplier(int id);
	public void updatesupplier(Supplier s);
	public void saveupdatesupplier(Supplier s);
}



