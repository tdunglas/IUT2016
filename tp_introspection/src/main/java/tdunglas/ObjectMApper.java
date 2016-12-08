package tdunglas;

import java.lang.reflect.Field;

public class ObjectMApper {
	
	public String objectToJSON(Object b){
		
		if(b == null){
			return null;
		}
		if(b instanceof String){
			return "\"" + b.toString() + "\"";
		}
		else if(b instanceof Number){
			return b.toString();
		}
		else if(b instanceof Boolean){
			return b.toString();
		}
		else{
			
			// vars
			Class<? extends Object> c = b.getClass();
			String res = "";
			Object value = new Object();
			
			//JSON START
			res += "{\"" + c.getSimpleName() + "\":[";
			
			// RECUP FIELDS
			Field[] fields = c.getFields();

			for(int i=0; i<fields.length; i++){
				try {

					//System.out.print(fields[i].getName() + "-");
					res += "\"" + fields[i].getName() + "\":";
					value = fields[i].get(b);
					
					if(value instanceof String){
						res += objectToJSON(value);
					}
					else if(value instanceof Object){
						res += objectToJSON(value);
					}
					else if(value instanceof Integer){
						res += objectToJSON(value);
					}
					
					if(i<fields.length-1){
						res +=",";
					}
					
					//System.out.println(value);
					
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
			//JSON END
			res += "]}";
			
			
			//System.out.println(res);
			return res;
		}
	}
	
	public static void main(String[]args){
		System.out.println(new ObjectMApper().objectToJSON(true));
	}
}
