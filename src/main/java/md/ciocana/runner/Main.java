package md.ciocana.runner;

import md.ciocana.config.PersistenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    }
}
