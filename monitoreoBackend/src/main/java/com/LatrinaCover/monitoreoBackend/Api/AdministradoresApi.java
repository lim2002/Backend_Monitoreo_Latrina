package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AdministradoresBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/administradores")
public class AdministradoresApi {

    @Autowired
    private AdministradoresBl administradoresBl;
}
