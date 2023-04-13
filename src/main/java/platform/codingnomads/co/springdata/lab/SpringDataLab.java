package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().isEmpty()) {
            final List<Area> areas = areaRepository.saveAll(Arrays.asList(Area.builder().code("G").build(), Area.builder().code("H").build(), Area.builder().code("Y").build(), Area.builder().code("Z").build(), Area.builder().code("Q").build(), Area.builder().code("J").build(), Area.builder().code("F").build(), Area.builder().code("X").build()));
        }

        if (routeRepository.findAll().isEmpty()) {
            routeRepository.save(Route.builder().origin(areaRepository.findByCode("G")).destination(areaRepository.findByCode("H")).build());
            routeRepository.save(Route.builder().origin(areaRepository.findByCode("H")).destination(areaRepository.findByCode("X")).build());
            routeRepository.save(Route.builder().origin(areaRepository.findByCode("G")).destination(areaRepository.findByCode("Q")).build());
            routeRepository.save(Route.builder().origin(areaRepository.findByCode("Y")).destination(areaRepository.findByCode("F")).build());
            routeRepository.save(Route.builder().origin(areaRepository.findByCode("J")).destination(areaRepository.findByCode("Z")).build());
            routeRepository.save(Route.builder().origin(areaRepository.findByCode("Q")).destination(areaRepository.findByCode("Q")).build());
        }

        System.out.println("Routes starting at 'G'");
        System.out.println("----------------------");
        System.out.println(routeRepository.findByOrigin_code("G"));

        System.out.println("\nRoutes ending at 'Q");
        System.out.println("----------------------");
        System.out.println(routeRepository.findByDestination_code("Q"));

        System.out.println("\nRoutes through 'H");
        System.out.println("----------------------");
        System.out.println(routeRepository.findByCodeContaining("H"));


    }
}
