import com.logisticproject.LogisticExecute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        LogisticExecute ui = applicationContext.getBean(LogisticExecute.class);
        ui.execute();
    }

}
