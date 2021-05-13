package restcontroller;


import Service1.TimeTable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeTableController {

    // Просто http://localhost:8080/api/timetable
    @GetMapping("/timetable")
    public List<TimeTable> getTimeTable() {
        List<TimeTable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(new TimeTable());
        return list;
    }

    // ПРИМЕР ССЫЛКИ http://localhost:8080/api/timetable
    // И в BODY пишешь непосредственно JSON обхект
    //{
    //"name": "782FinlandBay",
    //"time": "21:58:16",
    //"day": "12/11/2020",
    //"type": "CONTAINER",
    //"weight": 40399.252990944464,
    //"unload": 6.733208831824077
    //}
    @PostMapping("/timetable")
    public TimeTable postTimeTable(@RequestBody TimeTable timeTable) {
        System.out.println(timeTable);
        return timeTable;
    }

    // ПРИМЕР ССЫЛКИ http://localhost:8080/api/timetable/15
    @GetMapping("/timetable/{id}")
    public Integer getTimeTable(@PathVariable int id) {
        System.out.println(id);

        if (id == 13)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        return id;
    }



// ПРИМЕР ССЫЛКИ http://localhost:8080/api/timetable/test?name=heeelllooo
    @GetMapping("/timetable/test")
    public Integer testMethod(@RequestParam(defaultValue = "0") String name){

        System.out.println(name);
        return name.length();

    }


}
