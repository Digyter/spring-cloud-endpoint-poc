package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.CustomerDTO;
import com.cloudsherpas.poc.dto.CustomerListDTO;
import com.cloudsherpas.poc.service.CustomerService;
import com.cloudsherpas.poc.util.GenericEndpointErrorResponse;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Api(
        name = "poc",
        version = "1"
)
public class CustomerResource {

    @Autowired
    @Qualifier("customerService")
    @Lazy
    private CustomerService customerService;

    @ApiMethod(
            name = "getCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public CustomerDTO getCustomer(@Named("customerKey") final String key) throws NotFoundException {

        final CustomerDTO customer = customerService.getCustomer(key);

        if (customer == null) {
            GenericEndpointErrorResponse.entityNotFound();
        }

        return customer;
    }

    @ApiMethod(
            name = "getAllCustomers",
            path = "customers/all",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiMethod(
            name = "addCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addCustomer(final CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
    }

    @ApiMethod(
            name = "addCustomers",
            path = "customers",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addCustomers(final CustomerListDTO customerList) {
        customerService.addCustomers(customerList.getItems());
    }

    @ApiMethod(
            name = "updateCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateCustomer(final CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
    }

    @ApiMethod(
            name = "updateAllCustomers",
            path = "customers/all",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateCustomers(final CustomerListDTO customerList) {
        customerService.updateAllCustomers(customerList.getItems());
    }

    @ApiMethod(
            name = "deleteCustomer",
            path = "customer/{key}",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteCustomer(@Named("key") final String key) {
        customerService.deleteCustomer(key);
    }
}
