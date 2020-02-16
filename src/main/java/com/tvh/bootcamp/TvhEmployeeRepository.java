package com.tvh.bootcamp;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class TvhEmployeeRepository implements EmployeeRepository {
    @Override
    public List<Employee> getEmployees() {
        return List.of(
                new Employee("Chao", Role.SYSTEM_ENABLER, "AIR"),
                new Employee("Simon", Role.DEVELOPER, "AIR"),
                new Employee("Gwijde", Role.DEVELOPER, "WB3"),
                new Employee("Vishal", Role.TESTER, "AIR"));
    }
}
