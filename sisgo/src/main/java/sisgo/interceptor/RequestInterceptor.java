package sisgo.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import sisgo.util.ESexo;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;


@Intercepts
@RequestScoped
public class RequestInterceptor {
	
	@Inject
	private Result result;
	//@Inject
	//private ApplicationProperties applicationProperties;
	
    @BeforeCall
    public void before() {
        result.include("rootPath", "http://localhost:8080/sisgo");
        result.include("MASCULINO", ESexo.MASCULINO.getAsciiCode());
        result.include("FEMININO", ESexo.FEMININO.getAsciiCode());
    }
    
}