package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.model.MasterItems;

@Repository
public interface ExampleRepository extends CrudRepository<MasterItems, Integer> {

	@Query("SELECT masterItems FROM MasterItems masterItems where masterItems.itemName = :itemNamegiven")
	List<MasterItems> findMenuItemName(
			@Param("itemNamegiven") String itemNamegiven);

	@Transactional
	@Modifying
	@Query("UPDATE MasterItems masterItems SET masterItems.price=:newCostOfItemgiven where masterItems.itemName = :itemNamegiven")
	void updatePriceOfItem(
			@Param("itemNamegiven") String itemNamegiven,
			@Param("newCostOfItemgiven") int newCostOfItemgiven);

	
	


}
