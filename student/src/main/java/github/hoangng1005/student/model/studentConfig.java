package github.hoangng1005.student.model;

import github.hoangng1005.student.repository.studentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner( studentRepository repository){
        return args -> {
            student s1 = new student(
                    "Nguyễn Việt Hoàng",
                    LocalDate.of(1998,5,10),
                    "Hà Nội",
                    "hoang123@gmail.com"
            );
            student s2 = new student(
                    "Vũ Kiên",
                    LocalDate.of(1999,1,21),
                    "Hà Nội",
                    "kien123@gmail.com"
            );

            repository.saveAll(
                    List.of(s1,s2)
            );
        };
    }
}
