package hu.weekly.kaloriedata.weeklykalorie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel implements Serializable {
    private static final long serialVersionUID = -7193720370720850448L;

    private Long id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        BaseModel other = (BaseModel) obj;
        if (id == null)
            if (other.id != null) return false;
            else return hashCode() == obj.hashCode();
        else return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        if (id == null) return super.hashCode();
        final int prime = 31;
        int result = 1;
        result = prime * result + id.hashCode();
        return result;
    }
}
