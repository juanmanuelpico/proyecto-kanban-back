package com.proyecto.infinitTask.app.services.implementations;

import com.proyecto.infinitTask.app.dtos.request.Tarea.TareaDTORequest;
import com.proyecto.infinitTask.app.dtos.response.Tarea.TareaDTOResponse;
import com.proyecto.infinitTask.app.dtos.response.Usuario.UsuarioDTOResponse;
import com.proyecto.infinitTask.app.entities.Proyecto;
import com.proyecto.infinitTask.app.entities.Tarea;
import com.proyecto.infinitTask.app.entities.Usuario;
import com.proyecto.infinitTask.app.repositories.ProyectoRepository;
import com.proyecto.infinitTask.app.repositories.TareaRepository;
import com.proyecto.infinitTask.app.services.ITareaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("tareaService")
public class TareaService implements ITareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired(required = true)
    private ModelMapper modelMapper;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public boolean crearTarea(TareaDTORequest dto) throws Exception { //FALTA VALIDAR
        Proyecto proyecto = proyectoRepository.findById(dto.getIdProyecto());
        Tarea tarea = new Tarea();

        tarea.setTitulo(dto.getTitulo());
        tarea.setActivo(true);
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setDificultad(1);
        tarea.setEstado("PARA HACER");
        tarea.setFechaCreacion(LocalDate.now());
        tarea.setFechaInicio(LocalDate.now());
        tarea.setProyecto(proyecto);
        
        tareaRepository.save(tarea);

        return true;
    }

    public List<TareaDTOResponse> traerTareas(int idProyecto) throws Exception {

        List<TareaDTOResponse> tareasDto = new ArrayList<>();
        List<Tarea> tareas = tareaRepository.findByIdProyecto(idProyecto);

        for (Tarea t : tareas) {
            tareasDto.add(modelMapper.map(t, TareaDTOResponse.class));
        }
        return tareasDto;

    }

    @Override
    public List<TareaDTOResponse> buscarTareasIdNombre(int idProyecto, String nombre) throws Exception {
        List<TareaDTOResponse> tareasDto = new ArrayList<>();
        List<Tarea> tareas = tareaRepository.findByIdProyectoNombreTarea(idProyecto, nombre);

        for (Tarea t : tareas) {
            tareasDto.add(modelMapper.map(t, TareaDTOResponse.class));
        }
        return tareasDto;
    }
}
