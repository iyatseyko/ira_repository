import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
	public class Employers {

		private int id;
		private String name;
		private int salary;
	

		@JsonCreator
		public Employers(@JsonProperty("id") int id,
				@JsonProperty("name") String name, @JsonProperty("salary") int salary ) {
			this.id = id;
			this.name = name;
			this.salary = salary;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getSalary() {
			return salary;
		}

		@Override
		public String toString() {
			return "Employers [id=" + id + ", name=" + name + ", salary=" + salary + " ]";
		}
}
