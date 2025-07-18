package com.mksss.cummins.bookStoreSystem.Controller;

import com.mksss.cummins.bookStoreSystem.dao.Worker;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
public class WorkersController {

    @PostMapping("/register")
    public String workerInfoRegister(@Valid @RequestBody Worker workerData){

        return "worker data register";
    }
}
