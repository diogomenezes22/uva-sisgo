package sisgo.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import sisgo.controller.IndexController;
import sisgo.controller.LoginController;
import sisgo.util.Permissao;
import sisgo.util.SessaoUsuario;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;


@Intercepts
@RequestScoped
@AcceptsWithAnnotations(ValidaSessao.class)
public class LoginInterceptor {
	
	@Inject
	private Result result;
	@Inject
	private SessaoUsuario sessaoUsuario;	
	
    @AroundCall
    public void around(SimpleInterceptorStack stack, ControllerMethod method) {
    	
    	if(sessaoUsuario.logado()) {
    		if(temPermissao(method.getMethod().getAnnotation(ValidaSessao.class).value()))
    			stack.next();
    		else {
        		result.include("erro", "Voce nao tem permissao para acessar este recurso!");
        		result.redirectTo(IndexController.class).index();
    		}    			
    	}
    	else {
    		result.include("erro", "Voce deve estar logado para acessar o sistema!");
    		result.redirectTo(LoginController.class).login();
    	}
    }

	private boolean temPermissao(Permissao permissao) {
		return sessaoUsuario.getNivelPermissao().getNivel() >= permissao.getNivel(); 
	}
    
}