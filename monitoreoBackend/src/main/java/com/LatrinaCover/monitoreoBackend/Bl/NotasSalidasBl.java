package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Repository.NotasSalidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotasSalidasBl {

    @Autowired
    private NotasSalidasRepository notasSalidasRepository;
}
