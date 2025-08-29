package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Repository.SalidasProgramadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalidasProgramadasBl {

    @Autowired
    private SalidasProgramadasRepository salidasProgramadasRepository;

}
