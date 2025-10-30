package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.ConfirmarEntregasDto;
import com.LatrinaCover.monitoreoBackend.Dto.SalidasProgramadasDetalleDto;
import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadas;
import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadasDetalle;
import com.LatrinaCover.monitoreoBackend.Repository.SalidasProgramadasDetalleRepository;
import com.LatrinaCover.monitoreoBackend.Repository.SalidasProgramadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalidasProgramadasDetalleBl {

    @Autowired
    private SalidasProgramadasDetalleRepository salidasProgramadasDetalleRepository;

    @Autowired
    private SalidasProgramadasRepository salidasProgramadasRepository;

    //obtener las salida programadas detalle por idSalidaProgramada
    public List<SalidasProgramadasDetalleDto> getByIdSalidaProgramada(Integer idSalidaProgramada){
        List<SalidasProgramadasDetalle> detalles = salidasProgramadasDetalleRepository.findByIdSalidaProgramada(idSalidaProgramada);
        return detalles.stream().map(detalle -> new SalidasProgramadasDetalleDto(
                detalle.getIdSalidaProgramadaDetalle(),
                detalle.getSalidaProgramada().getIdSalidaProgramada(),
                detalle.getNotaSalida().getIdNotaSalida(),
                detalle.getNotaSalidaDetalle().getIdNotaSalidaDetalle(),
                detalle.getProductoNombre(),
                detalle.getProductoCodigo(),
                detalle.getCantidad(),
                detalle.getDescripcion(),
                detalle.getPrecioUnitario(),
                detalle.getEstadoObservacion(),
                detalle.getEstadoEntrega(),
                detalle.getStatus()
        )).toList();
    }

    //confirmar salidas porgramadas detalle por idSalidaProgramada
    public void confirmarSalidasProgramadasDetalle(Integer idSalidaProgramada, List<ConfirmarEntregasDto> confirmarEntregasDto){
        //cambiar estados de las salidas programadas detalle
        SalidasProgramadasDetalle salidasProgramadasDetalle = new SalidasProgramadasDetalle();
        //verificar si el dto es nulo
        if (confirmarEntregasDto == null ) {
            //modificar el estado de la salida programada a 2=entregado
            SalidasProgramadas salidasProgramadas = salidasProgramadasRepository.findByIdSalidaProgramada(idSalidaProgramada);
            salidasProgramadas.setEstadoEntrega(2);
            //modificar la fecha de entrega
            LocalDateTime now = LocalDateTime.now();
            salidasProgramadas.setFechaEntregaConfirmada(now);
            salidasProgramadasRepository.save(salidasProgramadas);
        }else {
            //leer la lista de confirmarEntregasDto
            for (ConfirmarEntregasDto confirmar : confirmarEntregasDto) {
                salidasProgramadasDetalle = salidasProgramadasDetalleRepository.findByIdSalidaProgramadaDetalle(confirmar.getIdSalidaProgramadaDetalle());
                salidasProgramadasDetalle.setEstadoEntrega(2); //2=entregado
                salidasProgramadasDetalleRepository.save(salidasProgramadasDetalle);
            }
            //modificar el estado de la salida programada a 2=entregado
            SalidasProgramadas salidasProgramadas = salidasProgramadasRepository.findByIdSalidaProgramada(idSalidaProgramada);
            salidasProgramadas.setEstadoEntrega(2);
            //modificar la fecha de entrega
            LocalDateTime now = LocalDateTime.now();
            salidasProgramadas.setFechaEntregaConfirmada(now);
            salidasProgramadasRepository.save(salidasProgramadas);
        }

    }
}
