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

    public String saveShipment(Shipment shipment) {
        boolean shipmentExists = shipmentRepository.existsByShipmentNumber(shipment.getShipmentNumber());

        if (!shipmentExists) {
            shipmentRepository.save(shipment);
            return shipment.getEmail() + " " + shipment.getShipmentNumber() + " is created successfully.";
        } else {
            return shipment.getShipmentNumber() + " already exists!";
        }
    }

    public List<Shipment> getShipmentsByEmail(String email) {
        List<Shipment> shipments = shipmentRepository.findByEmail(email);
        if (shipments.isEmpty()) {
            return Collections.emptyList();
        }
        return shipments;
    }
}
