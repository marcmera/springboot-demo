package com.monlau.springbootdemo01.controller;

import com.monlau.springbootdemo01.model.Pedido;
import com.monlau.springbootdemo01.service.NotFoundException;
import com.monlau.springbootdemo01.service.PedidoService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<Pedido> listPedidos() {
        return pedidoService.listPedidos();
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable Integer id) {
        try {
            Pedido pedido = pedidoService.findPedidoById(id);
            return ResponseEntity.ok(pedido);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/pedidos")
    public void newPedido(@RequestBody Pedido pedido) {
        pedidoService.savePedido(pedido);
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<?> editPedido(@RequestBody Pedido pedido, @PathVariable Integer id) {
        try {
            Pedido pedidoDB = pedidoService.findPedidoById(id);
            pedidoDB.setFecha_pedido(pedido.getFecha_pedido());
            pedidoService.savePedido(pedidoDB);
            return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pedidos/{id}")
    public void deletePedido(@PathVariable Integer id) {
        pedidoService.deletePedido(id);
    }
}
