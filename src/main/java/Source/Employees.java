package Source;

import com.beust.ah.A;

public class Employees {
    private String F_Name;
    private String L_Name;
    private int Age;

//    public Employees(String F_name, String L_name, int Age, String city, String jobtype, String job_Title) {
//
//    }

    public Employees(String F_name, String L_name, int Age, String city, String jobtype, String job_Title) {
        setF_Name(F_name);
        setL_Name(L_name);
        setAge(Age);
        setCity(city);
        setJob_Title(job_Title);
        setJobtype(jobtype);
    }

    public  Employees(int id, String F_name, String L_name, int Age, String city, String jobtype, String job_Title) {
        setF_Name(F_name);
        setL_Name(L_name);
        setAge(Age);
        setCity(city);
        setJob_Title(job_Title);
        setJobtype(jobtype);
        setId(id);
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setJob_Title(String job_Title) {
        Job_Title = job_Title;
    }

    public void setJobtype(String jobtype) {
        Jobtype = jobtype;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String City;
    private String Job_Title;
    private String Jobtype;
    private int Phone;
    private int id;


}
