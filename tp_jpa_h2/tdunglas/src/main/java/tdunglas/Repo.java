package tdunglas;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * 
 * @author Thomas
 *
 */

public interface Repo extends JpaRepository<Zob, Integer>{
	
    List<Zob> findAllByOrderByIdAsc();
    
}