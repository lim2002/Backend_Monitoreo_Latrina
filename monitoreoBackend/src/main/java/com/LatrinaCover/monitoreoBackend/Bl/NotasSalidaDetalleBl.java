package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Repository.NotasSalidaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotasSalidaDetalleBl {

    @Autowired
    private NotasSalidaDetalleRepository notasSalidaDetalleRepository;
}
