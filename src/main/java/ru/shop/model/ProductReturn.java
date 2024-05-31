package ru.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_return")
public class ProductReturn {

    // первичный ключ
    @Id
    UUID id;
    UUID orderId;
    LocalDate date;
    long quantity;

}
