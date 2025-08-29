package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Repository.ObservacionEntregasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservacionEntregasBl {

    @Autowired
    private ObservacionEntregasRepository observacionEntregasRepository;

}
