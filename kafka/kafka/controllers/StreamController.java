package com.prasad.scm.springapplication.kafka.controllers;

import java.util.ArrayList;
import java.util.List;

import com.prasad.scm.springapplication.models.Stream;
import com.prasad.scm.springapplication.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/stream")
public class StreamController {

	@Autowired
	StreamRepository streamRepository;

	@CrossOrigin
	@RequestMapping("/device")

	public ResponseEntity<List<Stream>> home(Model model) {

		System.out.println(model.addAttribute("DeviceData", streamRepository.findAll()));
		List<Stream> arrayList = new ArrayList<>();
		Iterable<Stream> findAll = streamRepository.findAll();
		for (Stream s : findAll)
			arrayList.add(s);
		return new ResponseEntity<>(arrayList, HttpStatus.OK);
	}
}