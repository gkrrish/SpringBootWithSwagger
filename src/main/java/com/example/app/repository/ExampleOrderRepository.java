package com.example.app.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.model.Orders;

public interface ExampleOrderRepository extends CrudRepository<Orders, Integer> {

	@Transactional
	@Modifying
	@Query("update Orders orders SET orders.numberOfOrdersToday=:quantityGiven ,orders.creationDate=:dateGiven where orders.itemName = :itemNamegiven")
	void order(@Param("itemNamegiven") String itemNamegiven,
			@Param("quantityGiven") int quantityGiven,
			@Param("dateGiven") Date dateGiven);

	@Query("select orders.numberOfOrdersToday From Orders orders where orders.itemName=:itemNameGiven")
	int findTotalOrders(@Param("itemNameGiven") String itemNameGiven);

	@Query("select orders.creationDate From Orders orders where orders.itemName=:itemNameGiven")
	Date findTimeOrderedLast(@Param("itemNameGiven") String itemNameGiven);

}
