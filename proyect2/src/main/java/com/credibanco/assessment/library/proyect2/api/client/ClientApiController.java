package com.credibanco.assessment.library.proyect2.api.client;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.credibanco.assessment.library.proyect2.dto.LibroDto;
import com.credibanco.assessment.library.proyect2.service.impl.LibroDtoServiceImpl;


@Controller
public class ClientApiController {
	
	@Autowired
	private LibroDtoServiceImpl serviceImplLibroDto;
	
	@GetMapping("/listar/{es}")
	public  ResponseEntity<List<LibroDto>> listarTodo(@PathVariable String es) {		
		List<LibroDto> listar = serviceImplLibroDto.ListarCleintApi(es);
		return new ResponseEntity<List<LibroDto>>(listar, HttpStatus.OK);
	}
	
	
	
	/*@GetMapping("/listarNormal")
	public String listarM(Model model) {
		List<LibroDto> libro=serviceImplLibroDto.ListarClein();
		model.addAttribute("libro", libro);
		String retornar="libros";
		return retornar;
	}*/
	
	/*@GetMapping("/listarTodo")
	public  ResponseEntity<List<LibroDto>> listarTod() {		
		List<LibroDto> listar = serviceImplLibroDto.ListarClein();
		return new ResponseEntity<List<LibroDto>>(listar, HttpStatus.OK);
	}*/
	
	@GetMapping("/libros")
	public String filtroBusqueda(){
		return "libros";
		
	}
	
	@GetMapping("/")
	public String listar(Model model,@RequestParam(value="clave") String clave) {
		List<LibroDto> libro=serviceImplLibroDto.ListarCleintApi(clave);
		model.addAttribute("listaLibro", libro);
		model.addAttribute("clave", clave);
		
		return "libros";
	}
	

}
