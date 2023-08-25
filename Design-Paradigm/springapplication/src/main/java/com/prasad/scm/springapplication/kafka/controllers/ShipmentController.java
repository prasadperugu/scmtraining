package com.prasad.scm.springapplication.kafka.controllers;


import java.util.List;

import com.prasad.scm.springapplication.models.Shipment;
import com.prasad.scm.springapplication.security.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/shipment")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET ,RequestMethod.POST })
public class ShipmentController {

    @Autowired
    ShipmentService shipmentservice;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Shipment shipment) {
        try {
            String result = shipmentservice.saveShipment(shipment);
            // Return a success response with HTTP status code 200
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            // Handle the exception here  and return an error response with appropriate HTTP status code

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> getShipmentsByEmail(@RequestParam("email") String email) {

        System.out.println(email);
        try {
            List<Shipment> shipments = shipmentservice.getShipmentsByEmail(email);
            System.out.println(shipments);
            if (shipments.isEmpty()) {
                String errorMessage="No records found";
                return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(shipments, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("invalid details to fetch", HttpStatus.BAD_REQUEST);
        }
    }




}
