package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao {
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "model1", "color1"));
        cars.add(new Car(2, "model2", "color2"));
        cars.add(new Car(3, "model3", "color3"));
        cars.add(new Car(4, "model4", "color4"));
        cars.add(new Car(5, "model5", "color5"));
        cars.add(new Car(6, "model6", "color6"));

        return cars;
    }
}
