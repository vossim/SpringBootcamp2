package com.tvh.bootcamp;

public class EmployeeApplication {

    private final EmployeeService employeeService;

    public EmployeeApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void run(String... args) {
        System.out.println("-------------------------------------------");
        System.out.println("Listing all developers:");
        employeeService.getEmployeesWithRole(Role.DEVELOPER).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        System.out.println("Listing all employees in AIR:");
        employeeService.getEmployeesInWorkplace("AIR").forEach(System.out::println);
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        EmployeeApplication applicationTvh = applicationFTvh();
        applicationTvh.run(args);

        EmployeeApplication applicationTvhUsa = applicationTvhUsa();
        applicationTvhUsa.run(args);
    }

    public static EmployeeApplication applicationFTvh() {
        EmployeeRepository repository = new TvhEmployeeRepository();
        EmployeeService service = new EmployeeService(repository);
        return new EmployeeApplication(service);
    }

    public static EmployeeApplication applicationTvhUsa() {
        EmployeeRepository repository = new TvhUsaEmployeeRepository();
        EmployeeService service = new EmployeeService(repository);
        return new EmployeeApplication(service);
    }
}
