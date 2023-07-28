package com.prasad.scm.springapplication.repository;

import java.util.List;

import com.prasad.scm.springapplication.models.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String> {
    //	Shipment findByEmail(String email);
    List<Shipment> findByShipmentNumber(int shipmentNumber);

    boolean existsByShipmentNumber(int shipmentNumber);
    List<Shipment> findByEmail(String email);

}