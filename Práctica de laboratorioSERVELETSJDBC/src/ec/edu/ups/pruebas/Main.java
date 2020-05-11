package ec.edu.ups.pruebas;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.telefonoDao;
import ec.edu.ups.dao.userDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
//		userDao usuarioDAO= DAOfactory.getFactory().getUsuarioDAO();
//		
//		Telefono telefono1,telefono2,telefono3,telefono4,telefono5,telefono6;
//		
//		telefono1=new Telefono(0,"0102309182","movil","cnt");
//		telefono2=new Telefono(0,"0102309183","movil","cnt");
//		telefono3=new Telefono(0,"0102309184","fijo","movistar");
//		
//		telefono4=new Telefono(0,"0102309185","movil","claro");
//		telefono5=new Telefono(0,"0102309186","fijo","tuenti");
//		telefono6=new Telefono(0,"0102309187","movil","movistar");
//		
//		
		//Usuario u1 =new Usuario("0106655517","pedro","illaisaca","pedro@illaisaca","pedrin");
		//Usuario u2 =new Usuario("3050459621","naty","deleg","natu@illaisaca","pedrinynatu");
		
//		t1.setUsuario(u1);
//		t2.setUsuario(u1);
//		t3.setUsuario(u1);
//	
//		t4.setUsuario(u2);
//		t5.setUsuario(u2);
//		t6.setUsuario(u2);
//		
//		Set<Telefono> lisTels1 =new HashSet<Telefono>();
//		Set<Telefono> lisTels2 =new HashSet<Telefono>();
//		
//		lisTels1.add(t1);
//		lisTels1.add(t2);
//		lisTels1.add(t3);
//		
//		lisTels2.add(t4);
//		lisTels2.add(t5);
//		lisTels2.add(t6);
//		
//		
//		u1.setTelefonos(lisTels1);
//		u2.setTelefonos(lisTels2);
//		
//		
//		usuarioDAO.create(u1);
//		usuarioDAO.create(u2);
	
		
//		System.out.println("buscar un el telefono en base al numero de cedula del usuario");
//		
//		telefonoDao telefonoDAO=DAOfactory.getFactory().getTelefonoDAO();				
//		Set<Telefono> tels=telefonoDAO.findbyPersonaCed("3050459621");	
//		for (Telefono telefono : tels) {
//			System.out.println("numero: "+telefono.getNumero());
//			System.out.println("operadora: "+telefono.getOperadora());
//			System.out.println("id: "+telefono.getCodigo());
//		}
		System.out.println("---------------------------------------------------------------");
		
//		
//		userDao usuarioDAO=DAOfactory.getFactory().getUsuarioDAO();
//		
//		for (Usuario usuario : usuarioDAO.find()) {
//			System.out.println("usuario: "+usuario.getNombre());
//			Set<Telefono> tls=usuario.getTelefonos();
//			for (Telefono telefono : tls) {
//				System.out.println("-----------operadora: "+telefono.getOperadora()+" num: "+telefono.getNumero()+" id: "+telefono.getCodigo());
//			}
//			
//		}
//		
//		System.out.println("---------------------------------------------------------------");
//		
						
			
			
//		for (Telefono telefono : telefonoDAO.find()) {
//			System.out.println("numero: "+telefono.getNumero()+" operadora: "+telefono.getOperadora()+" id: "+telefono.getCodigo());					
//			System.out.println("--------------------nombre de usuario: "+ telefono.getUsuario().getNombre());
//		}
//		
////		
//		System.out.println("---------------------------------------------------------------");
//		telefonoDao telefonoDao=DAOfactory.getFactory().getTelefonoDAO();
//		Telefono tt=telefonoDAO.findbyTelefonoId(5);
		
		userDao usuarioDAO=DAOfactory.getFactory().getUsuarioDAO();
		//Usuario usuario= usuarioDAO.findByCorreo("pedro@illaisaca");
		Usuario usuario= usuarioDAO.read("0102863693");
		Set<Telefono> tels=usuario.getTelefonos();
		System.out.println(usuario.getNombre());
		for (Telefono telefono : tels) {
			System.out.println("-Telefonos: "+ telefono.getNumero());
		}
	}

}
