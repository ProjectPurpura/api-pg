package org.purpura.apipg.controller.pedido;

import org.purpura.apipg.controller.pedido.oas.PedidoContract;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResponseDTO;
import org.purpura.apipg.service.pedido.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController implements PedidoContract {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public PedidoResponseDTO getPedidoById(Long id) {
        return pedidoService.findByIdResponse(id);
    }

    @Override
    public List<PedidoResponseDTO> getAllByVendedorId(String vendedorId) {
        return pedidoService.findAllByVendedor(vendedorId);
    }

    @Override
    public List<PedidoResponseDTO> getAllByCompradorId(String compradorId) {
        return pedidoService.findAllByComprador(compradorId);
    }

    @Override
    public List<PedidoResponseDTO> getAll() {
        return pedidoService.findAll();
    }

    @Override
    public PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO) {
        return pedidoService.save(pedidoRequestDTO);
    }

    @Override
    public PedidoResponseDTO update(Long id, PedidoRequestDTO pedidoRequestDTO) {
        return pedidoService.update(id, pedidoRequestDTO);
    }

    @Override
    public void deleteById(Long id) {
        pedidoService.deleteById(id);
    }
}
