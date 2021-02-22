package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CarDao {
    private static int createId = 0;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++createId,"Genesis", "G90", 2019));
        cars.add(new Car(++createId, "Audi", "SQ8", 2019));
        cars.add(new Car(++createId, "Kia", "K5", 2020));
        cars.add(new Car(++createId, "Tesla", "S", 2016));
        cars.add(new Car(++createId, "Kia", "Rio", 2020));
    }

    public List<Car> carList() {
        return cars;
    }

    public List<Car> getCars(int limit) {
        try (Stream<Car> streamOfCar = cars.stream();) {
            return streamOfCar.limit(limit).collect(Collectors.toList());
        }
    }
}