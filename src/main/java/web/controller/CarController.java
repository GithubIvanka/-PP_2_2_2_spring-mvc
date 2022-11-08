package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String printCar(ModelMap model, @RequestParam(value = "count", required = false) String count) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "model1", "color1"));
        cars.add(new Car(2, "model2", "color2"));
        cars.add(new Car(3, "model3", "color3"));
        cars.add(new Car(4, "model4", "color4"));
        cars.add(new Car(5, "model5", "color5"));
        cars.add(new Car(6, "model6", "color6"));


        if (count != null && 0 < Integer.parseInt(count) && Integer.parseInt(count) < 5) {
            model.addAttribute("cars", cars.stream().limit(Integer.parseInt(count)).toList());
        } else {
            model.addAttribute("cars", cars);
        }
        return "cars";
    }
}
