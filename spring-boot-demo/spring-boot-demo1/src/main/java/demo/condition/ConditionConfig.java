package demo.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowCondition.class)   //符合Windows条件实例化windowsListService
    public ListService windowsListService() {
        return new WindowListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)    //符合Linux条件实例化linuxListService
    public ListService linuxListService() {
        return new LinuxListService();
    }

    @Bean
    @Conditional(MacCondition.class)   //符合Mac条件实例化macListService
    public ListService macListService() {
        return new MacListService();
    }
}
