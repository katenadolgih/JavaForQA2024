package ru.shop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

class CustomerServiceTest {

    private final CustomerRepository repository = Mockito.mock();
    private final CustomerService customerService = new CustomerService(repository);

    @Test
    public void shouldGetCustomer() {
        // given
        UUID customerId=UUID.randomUUID();
        Customer mockedCustomer=new Customer();
        Mockito.when(repository.findById(customerId)).thenReturn(Optional.of(mockedCustomer));

        // when
        Customer customer=customerService.getById(customerId);
        // then
        Assertions.assertEquals(mockedCustomer,customer);
    }

    @Test
    public void shouldSaveCustomer() {
        // given
        Customer customer=new Customer();

        // when
        customerService.save(customer);
        // then
        Mockito.verify(repository).save(customer);
        //Mockito.verify(repository,Mockito.times(1)).save(customer);
    }

//    @Test
//    public void shouldUserRepositoryFindAllWhenCallFindAllCustomer() {
//        // given
//        Mockito.when(repository.findAll()).thenReturn(
//                List.of(
//                        new Customer(UUID.randomUUID(),"name","phone",11);
//                )
//        )
//
//        // when
//        customerService.save(customer);
//        // then
//        Mockito.verify(repository).save(customer);
//        //Mockito.verify(repository,Mockito.times(1)).save(customer);
//    }

    @Test
    public void shouldThrowWhenCustomerNotFound() {
        // then
        Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> customerService.getById(UUID.randomUUID())
        );
    }
}