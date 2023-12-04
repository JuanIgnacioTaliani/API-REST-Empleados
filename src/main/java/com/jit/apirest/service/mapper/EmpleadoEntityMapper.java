package com.jit.apirest.service.mapper;

import com.jit.apirest.model.dao.ILocalidadDao;
import com.jit.apirest.model.dao.IPuestoDao;
import com.jit.apirest.model.dao.ITipoDocumentoDao;
import com.jit.apirest.model.dto.EmpleadoDto;
import com.jit.apirest.model.entity.Empleado;
import com.jit.apirest.model.entity.Localidad;
import com.jit.apirest.model.entity.Puesto;
import com.jit.apirest.model.entity.TipoDocumento;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmpleadoEntityMapper implements Function<EmpleadoDto, Empleado> {
    private final ITipoDocumentoDao tipoDocumentoDao;
    private final ILocalidadDao localidadDao;
    private final IPuestoDao puestoDao;

    public EmpleadoEntityMapper(ITipoDocumentoDao tipoDocumentoDao,
                                ILocalidadDao localidadDao,
                                IPuestoDao puestoDao) {
        this.tipoDocumentoDao = tipoDocumentoDao;
        this.localidadDao = localidadDao;
        this.puestoDao = puestoDao;
    }

    @Override
    public Empleado apply(EmpleadoDto empleadoDto) {

        String nomTipoDoc = empleadoDto.getTipoDocumento();
        String nomLocalidad = empleadoDto.getLocalidad();
        String nomPuesto = empleadoDto.getPuesto();

        TipoDocumento tipoDocumento = tipoDocumentoDao.findByName(nomTipoDoc);
        Localidad localidad = localidadDao.findByName(nomLocalidad);
        Puesto puesto = puestoDao.findByName(nomPuesto);

        return new Empleado(
                empleadoDto.getLegajo(),
                tipoDocumento,
                empleadoDto.getNroDocumento(),
                empleadoDto.getNombre(),
                empleadoDto.getApellido(),
                empleadoDto.getEmail(),
                empleadoDto.getTelefono(),
                empleadoDto.getCalle(),
                empleadoDto.getNumeroCalle(),
                localidad,
                empleadoDto.getFechaNacimiento(),
                empleadoDto.getFechaContratacion(),
                empleadoDto.getSalario(),
                puesto
        );
    }
}
