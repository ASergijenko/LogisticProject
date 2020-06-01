import com.logisticproject.LogisticExecute;
import com.logisticproject.services.validations.ValidationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {

        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
            LogisticExecute ui = applicationContext.getBean(LogisticExecute.class);
            ui.execute();
        }catch (ValidationException e){
            System.out.println("Smotri ctro pishesh" + e.getMessage());
        }
    }

}
