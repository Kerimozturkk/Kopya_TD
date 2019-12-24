# Kopya_TD
![Kopya_TD_classD](https://user-images.githubusercontent.com/49280604/71390048-c9c95000-260f-11ea-89f1-0d4e2bedfb54.png)


Prototype tasarım paterni, büyük veri hacmine sahip nesneleri 
new operatörü kullanmaksızın, 'klonlama' yöntemi ile oluşturan 
bir tasarım desenidir. Bellekte sahip olduğu veri miktarı büyük, 
maliyetli ve zaman alıcı nesnelerin oluşturulması için kullanılan 
Prototype, bir abstract sınıf veya interface'den oluşturulabilmektedir. 

	public abstract class DatabasePrototype implements Cloneable {

	   private String corporate;
	   private String name;
	   private int port;

	   public String getCorporate() {
	      return corporate;
	   }
	   public void setCorporate(String corporate) {
	      this.corporate = corporate;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public int getPort() {
	      return port;
	   }
	   public void setPort(int port) {
	      this.port = port;
	   }
	   public Object clone() throws CloneNotSupportedException {
	      return super.clone();
	   }
	   public String toString() {
	      return "[Corporate=" + getCorporate() + ",Name=" + getName() + ",Port=" + getPort() + "]";
	   }
	} 
Prototype sınıfında, veritabanı adı, şirketi ve hangi port üzerinde 
çalışacağı bilgileri yer almaktadır. Bu verilerin getter()/setter() 
metotları dışında tanımlanan clone() metodu ise, Java Object sınıfı 
tarafından tanımlanan üst sınıf metodunu çağırır.Bu sayede tanımlanan bir nesnenin
klonu oluşturulabilir. Object clone() metodu ise olusturulan yeni metodun ana özellikleri
desteklememesi durumunda hata fırlatıcatır. toString metodu ise tüm özelliklerin nasıl
yazdırılacağını bize gösterir.

	public class DB2 extends DatabasePrototype {

	   public DB2() {
	      setCorporate("IBM");
	      setName("DB2");
	      setPort(1233);
	   }
	}
DatabasePrototype sınıfından türetilen bu 3 sınıf, aldıkları bu özellikleri bünyelerinde 
tutacakları değer ile set etmektedirler.Üç sınıfında yapısı aynıdır.

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
Test sınıfında ilk olarak bir sql nesnesi klasik olarak oluşturulmaktadır. 
Akabinde ise bu nesnenin bir kopyası olan oracle nesnesi clone() metodu yardımıyla kopyası oluşturulmaktadır. 
Kopya nesne artık yeni bir nesnedir ve sql'den farklıdır. Bu da nesnelerin hash kodlarının farklı 
olmasından anlaşılabilir. Klonlanan oracle nesnesi, daha sonra setter() 
metotları ile özellikleri verilerek yeni nesneler oluşturulmuş olur.
