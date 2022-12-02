package Source;


public class Employees {
    private String F_Name;
    private String L_Name;
    private int Age;
    private String City;
    private String Job_Title;
    private String Jobtype;
    private int Phone;
    private int id;


    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getJob_Title() {
        return Job_Title;
    }

    public void setJob_Title(String job_Title) {
        Job_Title = job_Title;
    }

    public String getJobtype() {
        return Jobtype;
    }

    public void setJobtype(String jobtype) {
        Jobtype = jobtype;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Employees(){

    }


    //For Create a new Resource
    public Employees(String F_name, String L_name, int Age, String city, String jobtype, String job_Title) {
        setF_Name(F_name);
        setL_Name(L_name);
        setAge(Age);
        setCity(city);
        setJob_Title(job_Title);
        setJobtype(jobtype);
    }
       //For Get response , update (Put , Patch Methods)
    public Employees(int id, String F_name, String L_name, int Age, String city, String jobtype, String job_Title) {
        setF_Name(F_name);
        setL_Name(L_name);
        setAge(Age);
        setCity(city);
        setJob_Title(job_Title);
        setJobtype(jobtype);
        setId(id);
    }


}
