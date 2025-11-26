package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.ClientesDto;
import com.LatrinaCover.monitoreoBackend.Dto.NotaSalidaMasterDto;
import com.LatrinaCover.monitoreoBackend.Dto.UbicacionClientesDto;
import com.LatrinaCover.monitoreoBackend.Entity.Clientes;
import com.LatrinaCover.monitoreoBackend.Entity.NotasSalidas;
import com.LatrinaCover.monitoreoBackend.Entity.UbicacionClientes;
import com.LatrinaCover.monitoreoBackend.Repository.ClientesRepository;
import com.LatrinaCover.monitoreoBackend.Repository.NotasSalidasRepository;
import com.LatrinaCover.monitoreoBackend.Repository.UbicacionClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// import java.util.Optional; // si usas findById

@Service
public class NotasSalidasBl {

    @Autowired
    private NotasSalidasRepository notasSalidasRepository;

    @Autowired
    private UbicacionClientesRepository ubicacionClientesRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    /**
     * Selecciona todas las notas de salida desde 01/08/2025 que NO tengan
     * registro en SalidasProgramadas. Tolera nulos en ubicación y
     * SIEMPRE llena los datos del cliente.
     */
    @Transactional(readOnly = true)
    public Page<NotaSalidaMasterDto> seleccionarNotasSalidas(Integer page, Integer size) {

        // ⏱ Desde qué fecha quieres filtrar
        LocalDateTime from = LocalDateTime.of(2025, 8, 22, 0, 0, 0);

        // 📄 Configuración de paginación + orden
        Pageable pageable = PageRequest.of(page, size, Sort.by("fechaSalida").ascending());

        // 🔍 Consulta paginada a la BD
        Page<NotasSalidas> notas = notasSalidasRepository
                .findAllNotasSalidasWithoutSalidasProgramadas(from, pageable);

        // 🔁 Convertimos cada NotasSalidas en tu NotaSalidaMasterDto
        List<NotaSalidaMasterDto> resultado = new ArrayList<>(notas.getContent().size());

        for (NotasSalidas n : notas.getContent()) {

            Clientes cli = n.getCliente();

            // --- Cliente (igual que tu lógica original)
            ClientesDto cliDto = null;
            Short idCliente = null;

            if (cli != null) {
                idCliente = cli.getIdCliente();

                cliDto = new ClientesDto();
                cliDto.setIdCliente(idCliente);
                cliDto.setNombre(cli.getNombre());
                cliDto.setRepresentante(cli.getRepresentante());
                cliDto.setTelefono(cli.getTelefono());
                cliDto.setCelular(cli.getCelular());
                cliDto.setFax(cli.getFax());
                cliDto.setEmail(cli.getEmail());
            }

            // --- Ubicaciones (tu misma lógica, sin cambiar nada)
            List<UbicacionClientesDto> ubicacionesDto = new ArrayList<>();

            if (idCliente != null) {

                List<UbicacionClientes> ubicaciones =
                        ubicacionClientesRepository.findUbicacionByIdCliente(idCliente);

                for (UbicacionClientes u : ubicaciones) {

                    UbicacionClientesDto udto = new UbicacionClientesDto();
                    udto.setIdUbicacionCliente(u.getIdUbicacionCliente());
                    udto.setUbicacion(u.getUbicacion());
                    udto.setNombreDireccion(u.getNombreDireccion());
                    udto.setStatus(u.getStatus());

                    ubicacionesDto.add(udto);
                }
            }

            // --- DTO final (incluye ubicacionesDto como antes)
            NotaSalidaMasterDto dto = new NotaSalidaMasterDto(
                    n.getIdNotaSalida(),
                    cliDto,
                    ubicacionesDto,
                    n.getNroSalida(),
                    n.getCodigoPedido(),
                    n.getFechaSalidaAprobada(),
                    n.getFechaSalida()
            );

            resultado.add(dto);
        }

        // 📦 Devolvemos la página, pero ahora de DTOs (con ubicaciones incluidas)
        return new PageImpl<>(resultado, pageable, notas.getTotalElements());
    }

}
