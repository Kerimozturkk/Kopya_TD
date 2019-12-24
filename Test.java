
public class Test {

	public static void main(String[] args) {
		 DatabasePrototype sql = new SqlServer();
	      System.out.println(sql.toString());
	      System.out.println(sql.hashCode());

	      try {
	         DatabasePrototype oracle = (DatabasePrototype) sql.clone();
	         oracle.setCorporate("Oracle");
	         oracle.setName("Oracle");
	         oracle.setPort(1521);
	         System.out.println(oracle.toString());
	         System.out.println(oracle.hashCode());
	         
	         DatabasePrototype db2 = (DatabasePrototype) sql.clone();
	         db2.setCorporate("IBM");
	         db2.setName("DB2");
	         db2.setPort(1233);
	         System.out.println(db2.toString());
	         System.out.println(db2.hashCode());
	      }
	      catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }

	}

}
