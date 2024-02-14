package com.monlau.springbootdemo01.repository;
import com.monlau.springbootdemo01.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
