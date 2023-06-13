package HomeWorks.HomeWork_02;

public class Student {
    private String _name;
    private String _country;
    private String _city;
    private int _age = 0;

    public Student(String name, String country, String city, int age){
        if(name == ""){
            _name = "Unknow";
        }
        else{
            _name = name;
        }
        _country = country;
        _city = city;
        
        if(age > 0){
            _age = age;
        }
    }
    public Student(){

    }

    public String getName(){
        return _name;
    }

    public String getCountry(){
        return _country;
    }

    public String getCity(){
        return _city;
    }

    public int getAge(){
        return _age;
    }

}
