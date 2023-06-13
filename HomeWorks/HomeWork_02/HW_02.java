package HomeWorks.HomeWork_02;

public class HW_02 {
    public static void main(String[] args) {
        Student firstStudent = new Student("Alex", "Russian", "Moscow", 18);
        Student secondStudent = new Student("", "Germany", "", 0);
        Student thirdStudent = new Student();
        Student[] students = new Student[]{firstStudent, secondStudent, thirdStudent};

        String request = "select * from students where ";

        for (int i = 0; i < students.length; i++) {
            System.out.println(requestFormation(students[i], request) + "\n");
        }
    }

    public static String requestFormation(Student stud, String basePath){
        StringBuilder sb = new StringBuilder(basePath);
        
        if( stud.getName() != null && stud.getName() != "")
            sb.append("name=" + stud.getName());
        if( stud.getCountry() != null && stud.getCountry() != "")
            sb.append(", country=" + stud.getCountry());
        if( stud.getCity() != null && stud.getCity() != "")
            sb.append(", city=" + stud.getCity());
        if( stud.getAge() != 0)
            sb.append(", age=" + stud.getAge());

        return sb.toString();
    }
}
