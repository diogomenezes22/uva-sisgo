package sisgo.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import sisgo.util.Sexo;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;


@Intercepts
@RequestScoped
public class RequestInterceptor {
	
	@Inject
	private Result result;
	
    @BeforeCall
    public void before() {
        result.include("rootPath", "http://localhost:8080/sisgo");
        result.include("MASCULINO", Sexo.MASCULINO.getAsciiCode());
        result.include("FEMININO", Sexo.FEMININO.getAsciiCode());
    }
    
}