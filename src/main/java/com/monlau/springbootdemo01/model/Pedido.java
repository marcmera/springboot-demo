package com.monlau.springbootdemo01.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PEDIDOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_gen")
    @SequenceGenerator(name = "product_gen", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Integer id_pedido;

    @Column(name = "FECHA_PEDIDO")
    private LocalDate fecha_pedido;

    @ManyToMany
    @JoinTable(
            name = "DETALLE_PEDIDO",
            joinColumns = @JoinColumn(name = "ID_PEDIDO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO")
    )
    private Set<products> products = new HashSet<>();
}

