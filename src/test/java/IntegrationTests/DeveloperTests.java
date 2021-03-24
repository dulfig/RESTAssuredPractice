package IntegrationTests;

import models.Developer;
import java.io.IOException;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class DeveloperTests {

    Developer developer;
    Developer devToBeModified;
    String baseURL = "https://tech-services-1000201953.uc.r.appspot.com/";
    String id;

    @BeforeSuite
    public void setup(){
        developer = new Developer("Don","Ulfig","C++",2013);//update me
        devToBeModified = new Developer("Waffles","Pancakes","FrenchToast", 9999);
    }

    @Test
    public void postDeveloper_postsDeveloper() throws IOException {
        // create a client
        Response response =  given()
                .header("Content-type", "application/json")
                .and()
                .body(developer)
                .when()
                .post(baseURL+"developer")
                .then()
                .extract().response();

        developer = response.getBody().as(Developer.class);
        id = developer.getId();
        System.out.println(id);
        assertEquals(response.statusCode(),200);
        assertEquals(developer.getFirstName(),"Don");//update me
        assertNotNull(developer.getId());

    }
    
    @Test
    public void postDeveloper_toBeDeleted() throws IOException {
        // create a client
        Response response =  given()
                .header("Content-type", "application/json")
                .and()
                .body(devToBeModified)
                .when()
                .post(baseURL+"developer")
                .then()
                .extract().response();

        devToBeModified = response.getBody().as(Developer.class);
        System.out.println(devToBeModified.getId());
        assertEquals(response.statusCode(),200);
        assertEquals(devToBeModified.getFirstName(),"Waffles");//update me
        assertNotNull(devToBeModified.getId());

    }

    @Test(dependsOnMethods= {"postDeveloper_postsDeveloper"})
    public void getDeveloper_getDeveloperById() throws IOException {
        // create a client
        Response response =  given()
                .when()
                .get(baseURL+"developer/"+id)
                .then()
                .extract().response();

        developer = response.getBody().as(Developer.class);
        assertEquals(response.statusCode(),200);
        assertEquals(developer.getFirstName(),"Don");//update me
        assertEquals(developer.getId(), id);

    }
    @Test(dependsOnMethods={"postDeveloper_postsDeveloper"})
    public void getDevelopers() throws IOException {
        // create a client
    	Developer[] developers;
        Response response =  given()
                .when()
                .get(baseURL+"developers")
                .then()
                .extract().response();

        developers = response.getBody().as(Developer[].class);
        assertEquals(response.statusCode(),200);
        assertEquals(developers[developers.length-2].getFirstName(),"Don");//update me
        assertEquals(developers[developers.length-2].getId(), id);

    }
    
    @Test
    public void putDeveloper() throws IOException {
        // create a client
    	developer.setFavoriteLanguage("C");
        Response response =  given()
                .header("Content-type", "application/json")
                .and()
                .body(developer)
                .when()
                .put(baseURL+"developer")
                .then()
                .extract().response();

        developer = response.getBody().as(Developer.class);
        id = developer.getId();
        assertEquals(response.statusCode(),200);
        assertEquals(developer.getFavoriteLanguage(),"C");//update me
        assertNotNull(developer.getId());

    }
    
    @Test(dependsOnMethods={"postDeveloper_toBeDeleted"})
    public void deleteDeveloper() throws IOException {
        // create a client
        Response response =  given()
                .when()
                .delete(baseURL+"developer/"+ devToBeModified.getId())
                .then()
                .extract().response();
        System.out.println(devToBeModified.getId());
        String res = response.getBody().as(String.class);
        id = developer.getId();
        assertEquals(response.statusCode(),200);
        assertEquals(res,"OK");//update me

    }
    
}
