package com.monlau.springbootdemo01.service;

import com.monlau.springbootdemo01.model.Pedido;
import com.monlau.springbootdemo01.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listPedidos() {
        return repository.findAll();
    }

    public void savePedido(Pedido pedido) {
        repository.save(pedido);
    }

    public Pedido findPedidoById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido no encontrado con ID: " + id));
    }

    public void deletePedido(Integer id) {
        repository.deleteById(id);
    }
}
