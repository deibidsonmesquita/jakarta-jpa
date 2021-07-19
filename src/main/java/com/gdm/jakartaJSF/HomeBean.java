package com.gdm.jakartaJSF;

import com.gdm.jakartaJSF.dao.ClienteDao;
import com.gdm.jakartaJSF.models.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@RequestScoped
@Named
public class HomeBean {

    @Inject
    private ClienteDao clienteDao;

    @Inject
    private Cliente cliente;

    @Getter
    private List<Cliente> listagem = new ArrayList<>();

    public HomeBean() {
    }

    @PostConstruct
    public void init() {
        try {
            listagem = clienteDao.getClientes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hello() {
        try {
            clienteDao.add(new Cliente(cliente.getNome()));
            listagem = clienteDao.getClientes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
