package com.prasad.scm.springapplication.kafka.controllers;

import java.util.ArrayList;
import java.util.List;

import com.prasad.scm.springapplication.models.Stream;
import com.prasad.scm.springapplication.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    StreamRepository streamRepository;

    @CrossOrigin
    @RequestMapping("/device")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Stream>> home(Model model) {

        System.out.println(model.addAttribute("DeviceData", streamRepository.findAll()));
        List<Stream> arrayList = new ArrayList<>();
        Iterable<Stream> findAll = streamRepository.findAll();
        for (Stream s : findAll)
            arrayList.add(s);
        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }




}