package tdunglas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Thomas
 *
 */

@Entity
@Table
public class Zob {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    private String name;
	    private String msg;

	    public Zob(String n, String s) {
	        this.name = n;
	        this.msg = s;
	    }

	    public Zob() {
	        this.name = "the beast";
	        this.msg = "654";
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o){
	        	return true;
	        }
	        
	        if (o == null 
	        		|| getClass() != o.getClass()){
	        	return false;
	        }

	        Zob zob = (Zob) o;

	        if (id != null ? !id.equals(zob.id) : zob.id != null){
	        	return false;
	        }
	        if (name != null ? !name.equals(zob.name) : zob.name != null){
	        	return false;
	        }
	        
	        return msg != null ? msg.equals(zob.msg) : zob.msg == null;
	    }

	    @Override
	    public int hashCode() {
	        int result = id != null ? id.hashCode() : 0;
	        result = 31 * result + (name != null ? name.hashCode() : 0);
	        result = 31 * result + (msg != null ? msg.hashCode() : 0);
	        return result;
	    }

	    @Override
	    public String toString() {
	        return "Zob {id=" + id + ", name='" + name + "\', msg='" + msg + "\'}";
	    }
	    
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String n) {
	        this.name = n;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String s) {
	        this.msg = s;
	    }
}
