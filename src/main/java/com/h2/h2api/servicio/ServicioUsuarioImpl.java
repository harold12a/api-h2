package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Usuario;
import com.h2.h2api.repositorio.RespositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServicioUsuarioImpl implements ServicioUsuario{

    private final RespositorioUsuario respositorioUsuario;



    @Override
    public Usuario guardarUsuario(Usuario usuario) {

        return respositorioUsuario.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {

        return respositorioUsuario.findById(idUsuario).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Usuario usuarioAModificar(Long id, Usuario usuarioAModificar) {
        Usuario usuarioBuscado = respositorioUsuario.findById(id).get();
        usuarioBuscado.setDireccion(usuarioAModificar.getDireccion());
        usuarioBuscado.setTelefono(usuarioAModificar.getTelefono());
        return respositorioUsuario.save(usuarioBuscado);
    }

    @Override
    public boolean elimnarUsuario(Long id) {

        try{
            respositorioUsuario.deleteById(id);
            return true;

        }catch (Exception e) {
            return false;
        }
    }
}
