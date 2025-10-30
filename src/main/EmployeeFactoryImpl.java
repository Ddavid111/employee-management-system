package main;

public class EmployeeFactoryImpl implements EmployeeFactory {
    @Override
    public Employee createEmployee(String workplace) {
        if(workplace == null) {
            return null;
        }
        workplace = workplace.toLowerCase();
        if(workplace.contains("uni") || workplace.contains("egyetem")) {
            return new UniEmployee();
        } else if (workplace.contains("soft")) {
            return new ITEmployee();
        }
        else {
            return null;
        }
    }
}
