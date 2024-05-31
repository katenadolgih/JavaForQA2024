package ru.shop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.shop.exception.BadOrderCountException;
import ru.shop.model.*;
import ru.shop.repository.ProductRepository;
import ru.shop.repository.ProductReturnRepository;

import java.util.UUID;

public class ProductReturnServiceTest {

    private final ProductReturnRepository repository = Mockito.mock();
    private final ProductReturnService productReturnService = new ProductReturnService(repository);

    @Test
    public void shouldAddProductReturn(){
        //given
        var order=new Order(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),2,11);
        var count=10;

        //when
        productReturnService.add(order, count);

        //then
        ArgumentCaptor<ProductReturn> productReturnArgumentCaptor =ArgumentCaptor.captor();

        Mockito.verify(repository).save(productReturnArgumentCaptor.capture());
        ProductReturn savedProductReturn=productReturnArgumentCaptor.getValue();

        Assertions.assertEquals(10,savedProductReturn.getQuantity());
        Assertions.assertEquals(order.getId(),savedProductReturn.getOrderId());

    }

    @Test
    public void shouldThrowBadProductReturnCountException(){
        //given
        var order=new Order(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),2,11);

        //then
        Assertions.assertThrows(
                BadOrderCountException.class,
                () -> productReturnService.add(order, 0)
        );
    }
}
