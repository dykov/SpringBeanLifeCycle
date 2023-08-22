# Simple example of Spring Bean Life Cycle

### Output:
```text
### 1: Default Constructor
### 2: @Autowired setters
### 3: @Value setters, java version=17
### 4: BeanNameAware#setBeanName:demoBean
### 5: ApplicationContextAware#setApplicationContext
~~~ 6: DemoBeanBeanPostProcessor#postProcessBeforeInitialization
### 7: @PostConstruct (init method)
### 8: InitializingBean#afterPropertiesSet
~~~ 9: DemoBeanBeanPostProcessor#postProcessAfterInitialization
<application context is closed - beans are removed from the application context>
### 10: @PreDestroy
### 11: DisposableBean#destroy
```