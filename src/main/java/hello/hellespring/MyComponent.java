package hello.hellespring;

import org.springframework.context.ApplicationContext; // 이 부분이 중요합니다!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private final ApplicationContext applicationContext;

    @Autowired
    public MyComponent(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void displayBeanNames() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }
}
