public class Teacher {
    private String name;
    private String surname;
    private int salary;
    private String district;
    private String position;

    public Teacher(String name, String surname, int salary, String district, String position) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.district = district;
        this.position = position;
    }

    public Teacher() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(name)
                .append(" ")
                .append(surname)
                .append(", ")
                .append(salary)
                .append(", ")
                .append(district)
                .append(", ")
                .append(position);

        return stringBuilder.toString();
    }//end of toString

    public boolean withHigherSalaryThan(int amount){
        boolean withHigherSalaryThan = false;
        if (getSalary()>amount)
            withHigherSalaryThan=true;
        return withHigherSalaryThan;
    }//end of withHigherSalaryThan

    public boolean withLowerSalaryThan(int amount){
        boolean withLowerSalaryThan = false;
        if (getSalary()<amount)
            withLowerSalaryThan=true;
        return withLowerSalaryThan;
    }//end of withLowerSalaryThan
}//end of class
