package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Repository.ProgramacionDistribucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramacionDistribucionBl {

    @Autowired
    private ProgramacionDistribucionRepository programacionDistribucionRepository;

}
