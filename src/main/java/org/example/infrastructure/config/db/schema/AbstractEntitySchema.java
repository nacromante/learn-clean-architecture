package org.example.infrastructure.config.db.schema;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AbstractEntitySchema<I extends Serializable> implements Serializable {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private I id;

	@Column(name = "create_date")
	@CreationTimestamp
	private LocalDateTime createDate;


	@Override
	public String toString() {
		return "id=" + id;
	}
	
	
	
}