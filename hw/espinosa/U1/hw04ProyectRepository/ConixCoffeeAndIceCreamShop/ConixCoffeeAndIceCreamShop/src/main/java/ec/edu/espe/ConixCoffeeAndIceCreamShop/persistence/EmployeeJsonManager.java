package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Employee;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJsonManager {

    private final Path filePath;
    private final Gson gson;
    private final Type employeeListType;

    public EmployeeJsonManager() {
        filePath = Paths.get("data", "employees.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        employeeListType =
                new TypeToken<ArrayList<EmployeeData>>() {}.getType();
    }

    public void saveEmployees(List<Employee> employees)
            throws IOException {

        if (employees == null) {
            throw new IllegalArgumentException(
                    "Employees list cannot be null.");
        }

        List<EmployeeData> data = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee == null) {
                throw new IllegalArgumentException(
                        "An employee cannot be null.");
            }

            EmployeeData item = new EmployeeData();
            item.username = employee.getUsername();
            item.password = employee.getPassword();
            item.clockedIn = employee.isClockedIn();

            data.add(item);
        }

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(data),
                StandardCharsets.UTF_8
        );
    }

    public List<Employee> loadEmployees() throws IOException {

        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }

        String json = Files.readString(
                filePath, StandardCharsets.UTF_8);

        try {
            List<EmployeeData> data =
                    gson.fromJson(json, employeeListType);

            List<Employee> employees = new ArrayList<>();

            if (data == null) {
                return employees;
            }

            for (EmployeeData item : data) {
                if (item == null) {
                    throw new IllegalArgumentException(
                            "Invalid employee data.");
                }

                employees.add(new Employee(
                        item.username,
                        item.password,
                        item.clockedIn
                ));
            }

            return employees;

        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read employees.json.", e);
        }
    }

    private class EmployeeData {
        private String username;
        private String password;
        private boolean clockedIn;
    }
}
