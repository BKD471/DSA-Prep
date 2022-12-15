import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Developer{

     private  String name;
      private String techStack;
      private  Double salary;
      Developer(String name,String techStack,Double salary){
          this.name=name;
          this.techStack=techStack;
          this.salary=salary;
      }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
          return this.name+" "+this.techStack+" "+this.salary;
    }
}


public class IteratorTest {

    public static void main(String[] args) {
        Developer d1=new Developer("Bhaskar","Spring Boot",1500000d);
        Developer d2=new Developer("Lionel Messi","Angular",1000000d);
        Developer d3=new Developer("Christiano Ronaldo","React",2000000d);

        Map<String,Developer> mp=new HashMap<>();
        mp.put("123",d1);
        mp.put("456",d2);
        mp.put("789",d3);

        Set s=mp.entrySet();
        Iterator itr=s.iterator();
        while(itr.hasNext()){
            Map.Entry data= (Map.Entry) itr.next();
            System.out.println(data.getKey()+"->"+data.getValue());
        }


    }
}
