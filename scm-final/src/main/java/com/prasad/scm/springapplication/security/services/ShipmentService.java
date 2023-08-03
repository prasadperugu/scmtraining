package com.prasad.scm.springapplication.security.services;

import java.util.Collections;
import java.util.List;

import com.prasad.scm.springapplication.models.Shipment;
import com.prasad.scm.springapplication.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    /**
     * Saves a shipment.
     *
     * @param shipment The Shipment object to save
     * @return A string indicating the result of the save operation
     */
    public String saveShipment(Shipment shipment) {
        boolean shipmentExists = shipmentRepository.existsByShipmentNumber(shipment.getShipmentNumber());

        if (!shipmentExists) {
            shipmentRepository.save(shipment);
            return shipment.getEmail() + " " + shipment.getShipmentNumber() + " is created successfully.";
        } else {
            return shipment.getShipmentNumber() + " already exists!";
        }
    }

    /**
     * Retrieves shipments by email.
     *
     * @param email The email address
     * @return A list of shipments associated with the email address, or an empty list if no shipments are found
     */
    public List<Shipment> getShipmentsByEmail(String email) {
        List<Shipment> shipments = shipmentRepository.findByEmail(email);
        if (shipments.isEmpty()) {
            return Collections.emptyList();
        }
        return shipments;
    }
}
