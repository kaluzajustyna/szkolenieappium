package Steps;

import Framework.ComplexPerson;
import Framework.TestHooks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;

public class DataTest extends TestHooks{
    @Test
    public void dataTest() throws FileNotFoundException {
        Gson g = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
       Person person1 = g.fromJson("{\"name\":\"John\"}",Person.class);
        Person person2 = g.fromJson("{\"name\":\"John\"}", Person.class);

        System.out.println(person1.getName());
        System.out.println(g.toJson(person1));
        System.out.println(gson.toJson(person2));

        BufferedReader br = new BufferedReader(new FileReader("./src/test/resources/data.jason"));
        ComplexPerson complexPerson = g.fromJson(br, ComplexPerson.class);
        System.out.println(complexPerson.getPersonal().getAge());

    }

    public class Person {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

