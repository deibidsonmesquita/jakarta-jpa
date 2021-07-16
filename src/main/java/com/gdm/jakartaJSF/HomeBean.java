package com.gdm.jakartaJSF;

import com.gdm.jakartaJSF.dao.ClienteDao;
import com.gdm.jakartaJSF.models.Cliente;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.*;

@RequestScoped
@Named
public class HomeBean {

    @Inject
    private ClienteDao clienteDao;
    private String nome = "";

    public HomeBean() {
    }

    public void hello() {
        nome = "Olá " + nome;
        try {
            clienteDao.add(new Cliente(nome));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
