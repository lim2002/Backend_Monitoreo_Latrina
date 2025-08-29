package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Repository.SalidasProgramadasDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalidasProgramadasDetalleBl {

    @Autowired
    private SalidasProgramadasDetalleRepository salidasProgramadasDetalleRepository;
}
