package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import web.config.WebConfig;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao {
    private final ApplicationContext context;

    public CarDaoImpl(ApplicationContext context) {
        this.context = context;
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Car car = context.getBean("carBean", Car.class);
            car.setSeries(i);
            car.setModel("model" + i);
            car.setColor("color" + i);
            cars.add(car);
        }
        return cars;
    }
}
