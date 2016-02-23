
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Instructor;

@Local
public interface InstructorFacadeLocal {

    void create(Instructor instructor);

    void edit(Instructor instructor);

    void remove(Instructor instructor);

    Instructor find(Object id);

    List<Instructor> findAll();

    List<Instructor> findRange(int[] range);

    int count();
    
}
