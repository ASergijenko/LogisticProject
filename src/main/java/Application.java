import com.logisticproject.SortingMain;
import com.logisticproject.services.excelService.validations.ValidationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {

        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
            SortingMain main = applicationContext.getBean(SortingMain.class);
            main.execute();
        }catch (ValidationException e){
            System.out.println("Smotri ctro pishesh" + e.getMessage());
        }
    }
}