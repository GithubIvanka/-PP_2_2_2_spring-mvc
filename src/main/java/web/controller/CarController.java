package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String printCar(ModelMap model, @RequestParam(value = "count", required = false) String count) {
        List<Car> cars = new CarServiceImpl().getCars();

        if (count != null && 0 < Integer.parseInt(count) && Integer.parseInt(count) < 5) {
            model.addAttribute("cars", cars.stream().limit(Integer.parseInt(count)).toList());
        } else {
            model.addAttribute("cars", cars);
        }
        return "cars";
    }
}
