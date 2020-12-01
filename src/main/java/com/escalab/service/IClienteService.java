package com.escalab.service;

import com.escalab.dto.FiltroDTO;
import com.escalab.model.Cliente;

import java.util.List;

public interface IClienteService extends ICRUD<Cliente>{

    List<Cliente> buscarPorNombreCliente(FiltroDTO filtro);
}
