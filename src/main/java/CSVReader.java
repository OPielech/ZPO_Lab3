import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import javax.crypto.spec.PSource;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVReader {

    public static void main(String[] args) throws IOException {
        giveList();
        System.out.println();
        numberOfTeachersWithHigherSalaryThan(120000);
        numberOfTeachersWithLowerSalaryThan(120000);
        averageSalaryWithStandardDeviation();
        numberOfDistrictsInCounty();
        averageSalaryWithStandardDeviationForPosition("Elementary Teacher");
    }//end of main


    public static void giveList() throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        ArrayList list = new ArrayList();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};
            int n = 0;

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();
            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    System.out.println(teacher.toString());
                }
            }//end of while
        }//end of try
    }//end of giveList

    public static void numberOfTeachersWithHigherSalaryThan(int amount) throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        int counter = 0;
        ArrayList list = new ArrayList();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();


            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    if (teacher.withHigherSalaryThan(amount) == true)
                        counter++;
                }

            }//end of while
        }//end of try
        System.out.println("Number of teachers with higher salary than " + amount + ": " + counter);
    }//end of numberOfTeachersWithHigherSalaryThan

    public static void numberOfTeachersWithLowerSalaryThan(int amount) throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        ArrayList list = new ArrayList();
        int counter = 0;

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();


            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    if (teacher.withLowerSalaryThan(amount) == true)
                        counter++;
                }

            }//end of while
        }//end of try
        System.out.println("Number of teachers with lower salary than " + amount + ": " + counter);
    }//end of numberOfTeachersWithLowerSalaryThan

    public static double average() throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        ArrayList list = new ArrayList();
        int n = 0;
        long sum = 0;
        double average = 0;

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();


            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    n++;
                    if (teacher.getSalary() != 0) {
                        sum += teacher.getSalary();
                    }//end of if
                }//end of while
                average = sum / n;
            }


        }//end of try
        return average;

    }//end of average

    public static void averageSalaryWithStandardDeviation() throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        ArrayList list = new ArrayList();
        int n = 0;
        long sum = 0;
        double standardDeviation = 0;
        double average = average();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();


            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    n++;

                    if (teacher.getSalary() != 0) {
                        sum += Math.pow(teacher.getSalary() - average, 2);
                    }//end of if
                }

            }//end of while

            standardDeviation = Math.sqrt(sum / n);

        }//end of try

        System.out.printf("Average salary: %.2f\n", average());
        System.out.printf("Standard deviation: %.2f\n", standardDeviation);
    }//end of averageSalaryWithStandardDeviation

    public static void numberOfDistrictsInCounty() throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        ArrayList list = new ArrayList();
        ArrayList districts = new ArrayList();
        int counter = 0;

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();


            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    if (districts.contains(teacher.getDistrict())) {
                    } else {
                        districts.add(teacher.getDistrict());
                        counter++;
                    }
                }

            }//end of if
        }//end of while

        System.out.println("Number of districts in county: " + counter);
    }//end of numberOfDistrictsInCounty

    public static double averageForPosition(String position) throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        ArrayList list = new ArrayList();
        int n = 0;
        long sum = 0;
        double average = 0;

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();


            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    if (teacher.getPosition().equalsIgnoreCase(position)) {
                        n++;
                        if (teacher.getSalary() != 0) {
                            sum += teacher.getSalary();
                        }//end of if
                    }//end of if
                }//end of else
            }//end of while
            average = sum / n;
        }//end of try
        return average;

    }//end of average

    public static void averageSalaryWithStandardDeviationForPosition(String position) throws IOException {
        String filePath = "src\\main\\resources\\Lancaster_County_School_Salaries.csv";
        ArrayList list = new ArrayList();
        int n = 0;
        long sum = 0;
        double standardDeviation = 0;
        double average = averageForPosition(position);

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            String[] memberFieldsToBindTo = {"name", "surname", "salary", "district", "position"};

            strategy.setType(Teacher.class);
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Teacher> teacherIterator = csvToBean.iterator();


            while (teacherIterator.hasNext()) {
                Teacher teacher = teacherIterator.next();
                if (list.contains(teacher.toString())) {
                } else {
                    list.add(teacher.toString());
                    if (teacher.getPosition().equalsIgnoreCase(position))
                        n++;

                    if (teacher.getSalary() != 0) {
                        sum += Math.pow(teacher.getSalary() - average, 2);
                    }//end of if
                }

            }//end of while
            standardDeviation = Math.sqrt(sum / n);
        }//end of try
        System.out.printf("Average salary for position %s: %.2f\n", position, averageForPosition(position));
        System.out.printf("Standard deviation for position %s: %.2f\n", position, standardDeviation);
    }//end of averageSalaryWithStandardDeviation
}//end of class

