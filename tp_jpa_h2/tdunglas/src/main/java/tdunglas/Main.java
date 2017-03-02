package tdunglas;

/**
 * 
 * @author Thomas
 *
 */

//import javax.persistence.EntityManager;
//
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootApplication
//public class Main {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Main.class, args);
//
//
//	}
//}
//	@Component class BatchRunner implements CommandLineRunner{
//		@Autowired DataSource ds;
//		@Autowired JdbcTemplate jdbcTemplate;
//		@Autowired EntityManager em;
//		@Autowired SimpleJpaRepository repo;
//	
//	}
//	
//	@Override
//	@Transactional
//	public void run(String...arg0)throws Exception{
//		String res= jdbcTemplate.execute("select Hello",(PrepareStatement));
//		ResultSet rs =start.executeQuery();
//		rs.next();
//		return rs.getString(1);
//	}
//	Systeme.out.println(res);
//	
//	String jpaQl ="select e from Simple where e.name";
//	List<Simple> ls =em.createQuery(jpaQl).setPArameter(1,"john").getResultList();
//	
//	}
//}

//import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class Main implements CommandLineRunner{
	
//	private DataSource dataSource;
	
	public void run(String... args) throws Exception{
//		try(Connection cx = dataSource.getConnection()){
//			try(PreparedStatement stmt = cx.prepareStatement("select 'Hello'")){
//				ResultSet rs = cx.prepareStatement("select 1").executeQuery(); 
//				rs.next();
//				String res = rs.getString(1);
////				Assert.assertEquals("Hello",res);
//				
//				System.out.println("res : " + res);
//				assertEquals("Hello",res);
//			}
//		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		Main.testJdbcH2();
	}
	
	@Autowired
    private static JdbcTemplate jdbcTemplate;

//    @Autowired
//    private static EntityManager entityManager;
	
	public static void testJdbcH2(){
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			ResultSet rs = conn.prepareStatement("select 1").executeQuery(); 
			
			if(rs.next()){
				int check = rs.getInt(1);
				System.out.println("OK " + check);
			}
			
			conn.close();
			
			System.out.println("WELL WELL WELL h2 work");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
	   if(jdbcTemplate != null){
		   String resultat = jdbcTemplate.execute("SELECT 'hello'", (PreparedStatement statement)->{
	            ResultSet resultSet = statement.executeQuery();
	            resultSet.next();
	            return resultSet.getString(1);
	        });

	        System.out.println("\nResultat JDBC : " + resultat);
	   }
	   else{
		   System.out.println("jdbcTemplate is null fuck");
	   }
		
	   /* done with the fire, you lay down with the victim*/
	   
       Zob z1 = new Zob();
       Zob z2 = new Zob();
       Zob z3 = new Zob();

       z2.setName("Brou");
       z2.setMsg("by all the mean possible");
       
       z3.setName("Holala");
       z3.setMsg("************");

//       if(DriverManager.getDrivers() != null){
//    	   java.sql.Driver driver = DriverManager.getDrivers().nextElement();
//           while(driver != null){
//        	   System.out.println(driver);
//        	   driver = DriverManager.getDrivers().nextElement();
//           }
//       }
       
		
       try
       {

    	   EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("zobPeristence");
//    	   EntityManagerFactory entityFactory = 
//    			   Persistence.createEntityManagerFactory(
//    					   "jdbc:h2:~/test;drop");
    	   
//			Map properties = new HashMap();
//			java.sql.Driver driver = DriverManager.getDrivers().nextElement();
			
//
//			properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
//			properties.put("javax.persistence.jdbc.url", "jdbc:h2:~/test");
//			properties.put("javax.persistence.jdbc.user", "sa");
//			properties.put("javax.persistence.jdbc.password", "");
//
//			EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("unit-name", properties);
    	   
    	   EntityManager em = entityFactory.createEntityManager();

    	   
           em.getTransaction().begin();
           em.persist(z1);
           em.persist(z2);
           em.persist(z3);
           

           System.out.println("Persisted " + em);
           
           @SuppressWarnings("unchecked")
           List<Zob> zs = em.createQuery("from Zob").getResultList();
           for (Iterator<Zob> iterator = zs.iterator(); iterator.hasNext();) {
             Zob zob = (Zob) iterator.next();
             System.out.println(zob.getId() + " - " + zob.getName() + " - " + zob.getMsg());
           }
           
//           Class.forName("org.h2.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//			ResultSet rs = conn.prepareStatement("select * from Zob").executeQuery(); 
//			
//			if(rs.next()){
//				int check = rs.getInt(1);
//				System.out.println("OK " + check);
//			}
//			
//			conn.close();
           
//           PreparedStatement statement;
//           ResultSet rs = statement.executeQuery("select * from Professor");
			/*
           ResultSetMetaData metadata = rs.getMetaData();

           for (int i = 0; i < metadata.getColumnCount(); i++) {
             System.out.print("\t"+ metadata.getColumnLabel(i + 1)); 
           }
           System.out.println("\n----------------------------------");

           while (rs.next()) {
             for (int i = 0; i < metadata.getColumnCount(); i++) {
               Object value = rs.getObject(i + 1);
               if (value == null) {
                 System.out.print("\t       ");
               } else {
                 System.out.print("\t"+value.toString().trim());
               }
             }
             System.out.println("");
           }*/

           em.getTransaction().commit();

           em.close();
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       
       /*easiaaaaaaa !!! */
       System.out.println("the end my friend");

	}
}
