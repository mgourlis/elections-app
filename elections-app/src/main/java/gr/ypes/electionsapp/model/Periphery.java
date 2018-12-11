package gr.ypes.electionsapp.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "periphery")
@AttributeOverride(name = "id", column = @Column(name = "periphery_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Periphery extends BaseEntity{

	@Column(name = "name")
	@NotNull(message = "*Please provide a name for the category")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Periphery))
			return false;
		if (!super.equals(o))
			return false;

		Periphery that = (Periphery) o;

		return getName().equals(that.getName());
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + getName().hashCode();
		return result;
	}
}
