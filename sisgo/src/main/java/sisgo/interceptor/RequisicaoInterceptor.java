package sisgo.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;


@Intercepts
@RequestScoped
public class RequisicaoInterceptor {
	
	@Inject
	private Result result;
	//@Inject
	//private ApplicationProperties applicationProperties;
	
    @BeforeCall
    public void before() {
        result.include("rootPath", "http://localhost:8080/sisgo");
    }
    
}