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
    public List<NotaSalidaMasterDto> seleccionarNotasSalidas() {

        LocalDateTime from = LocalDateTime.of(2025, 8, 22, 0, 0, 0);

        List<NotasSalidas> notas = notasSalidasRepository
                .findAllNotasSalidasWithoutSalidasProgramadas(from);

        List<NotaSalidaMasterDto> resultado = new ArrayList<>(notas.size());

        for (NotasSalidas n : notas) {
            Clientes cli = n.getCliente();

            // --- Cliente (Short)
            ClientesDto cliDto = null;
            Short idCliente = null;
            if (cli != null) {
                idCliente = cli.getIdCliente(); // <-- Short
                cliDto = new ClientesDto();
                // Asegúrate que ClientesDto.idCliente sea Short; si fuera Integer, usa:
                // cliDto.setIdCliente(idCliente != null ? idCliente.intValue() : null);
                cliDto.setIdCliente(idCliente);
                cliDto.setNombre(cli.getNombre());
                cliDto.setRepresentante(cli.getRepresentante());
                cliDto.setTelefono(cli.getTelefono());
                cliDto.setCelular(cli.getCelular());
                cliDto.setFax(cli.getFax());
                cliDto.setEmail(cli.getEmail());
            }

            // --- Ubicaciones (lista)
            List<UbicacionClientesDto> ubicacionesDto = new ArrayList<>();
            if (idCliente != null) {
                List<UbicacionClientes> ubicaciones =
                        ubicacionClientesRepository.findUbicacionByIdCliente(idCliente);

                for (UbicacionClientes u : ubicaciones) {
                    UbicacionClientesDto udto = new UbicacionClientesDto();
                    udto.setIdUbicacionCliente(u.getIdUbicacionCliente()); // tipo según tu entidad (Short/Integer)
                    // Para evitar ciclos, no seteamos el cliente dentro de cada ubicación
                    // udto.setIdCliente(cliDto);
                    udto.setUbicacion(u.getUbicacion());
                    udto.setNombreDireccion(u.getNombreDireccion());
                    udto.setStatus(u.getStatus());
                    ubicacionesDto.add(udto);
                }
            }

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

        return resultado;
    }
}
